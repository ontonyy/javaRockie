package com.justony.databaseapplication.scenes;

import com.justony.databaseapplication.HelpUtils;
import com.justony.databaseapplication.MainScene;
import com.justony.databaseapplication.SQLHandler;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.*;

import static java.util.stream.Collectors.joining;

public class TableCreationScene {
    @FXML TextField tableName;
    @FXML TextField length;
    @FXML ComboBox<Node> types;
    @FXML MenuButton indexes;
    @FXML Label wrongLabel;
    @FXML Label numField;
    @FXML TextField defaultField;
    @FXML AnchorPane topPane;
    @FXML BorderPane mainPane;
    @FXML Button createBtn;
    @FXML Button addBtn;
    @FXML Button helpBtn;
    @FXML Button removeButton;

    private Map<Integer, Map<String, Node>> fields = new LinkedHashMap<>();

    private int idField = 1;
    private int yField = 42;
    private Stage stage = MainScene.getSecondary();
    private boolean primaryDef = false;

    private HelpScene helpScene = new HelpScene("""
                Create rows for table, + sign for adding row,
                also can delete row pressing (X) button
                for creating table press button, and
                if errors not exists, then creating.""", 400, 300);

    @FXML public void initialize() {
        defaultField.setVisible(false);
        createBtn.setText(String.format("CREATE(%s)", DatabaseScene.tableName));
        setTypes(types);
        setIndexes(indexes);
        setFirstId();
        addNodesRow(tableName, types, length, indexes, defaultField, wrongLabel, numField, removeButton);
        removeRow(removeButton, numField, length, tableName, types, indexes, wrongLabel, defaultField);

        helpBtn.hoverProperty().addListener(e -> helpScene.showStage());
    }

    @FXML public void createTable() {
        String query = createTableQuery();
        if (!query.equals("")) {
            System.out.println(query);
            try {
                SQLHandler.getInstance().createTable(DatabaseScene.tableName, query);
                stage.close();
                MainScene.setSecondaryNull();
                DatabaseScene.instance.addTable(DatabaseScene.tableName);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public String createTableQuery() {
        String queryMain = "CREATE TABLE " + DatabaseScene.tableName + " (";
        int countCorrect = 0;
        primaryDef = false;
        for (Map.Entry<Integer, Map<String, Node>> entry : fields.entrySet()) {
            Label wrong = (Label) entry.getValue().get("wrong");
            TextField nameField = (TextField) entry.getValue().get("name");
            TextField lenField = (TextField) entry.getValue().get("length");
            TextField defField = (TextField) entry.getValue().get("default");
            Node typeValue = ((ComboBox<Node>) entry.getValue().get("type")).getValue();
            MenuButton indMenuBtn = (MenuButton) entry.getValue().get("indexes");
            String type;
            List<String> indexes;

            if (controlNameField(nameField, wrong) && controlLengthField(lenField, wrong)
                    && (indexes = controlIndexes(indMenuBtn, wrong, typeValue)) != null && controlType(typeValue, wrong)
                    && controlDefaultField(defField, wrong)) {
                type = ((Text) typeValue).getText();
                if (checkTypeLen(type, Integer.parseInt(lenField.getText()))) {
                    if (indexes.contains("DEFAULT")) {
                        queryMain += String.format("%s %s(%s) DEFAULT '%s', ", nameField.getText(), type, lenField.getText(), defField.getText());
                    } else {
                        if (indexes.contains("AUTO INCREMENT")) {
                            indexes.remove("AUTO INCREMENT");
                            indexes.add("AUTO_INCREMENT");
                        }
                        queryMain += String.format("%s %s(%s) %s, ", nameField.getText(), type, lenField.getText(), String.join(" ", indexes));
                    }
                    wrong.setText("");
                    countCorrect++;
                } else {
                    wrong.setText("Length out of range!");
                }
            }
        }

        if (countCorrect == fields.size()) {
            queryMain = queryMain.substring(0, queryMain.length() - 2);
            queryMain += ");";
            return queryMain;
        } else {
            return "";
        }
    }

    private List<String> controlIndexes(MenuButton indexes, Label wrong, Node type) {
        List<String> inds = new LinkedList<>();
        inds.add("NOT NULL");
        boolean correct = true;
        for (MenuItem item : indexes.getItems()) {
            CustomMenuItem cst = (CustomMenuItem) item ;
            CheckBox box = (CheckBox) cst.getContent();
            if (box.isSelected()) {
                if (box.getText().equals("NULL")) {
                    inds.remove(0);
                } else if (box.getText().equals("DEFAULT")) {
                    inds.clear();
                    indexes.getItems().forEach(f -> {
                        CheckBox checkBox = (CheckBox) ((CustomMenuItem) f).getContent();
                        checkBox.setSelected(false);
                    });
                    box.setSelected(true);
                    inds.add(box.getText());
                    break;
                } else if (box.getText().equals("PRIMARY KEY")) {
                    if (!primaryDef) {
                        primaryDef = true;
                    } else {
                        wrong.setText("Multiple primary key!");
                        return null;
                    }
                } else if (box.getText().equals("AUTO INCREMENT") && !((Text) type).getText().equals("INT")) {
                    wrong.setText("Auto increment error!");
                    return null;
                }
                inds.add(box.getText());
            }
        }

        if (inds.size() == 3) {
            if (!inds.contains("AUTO INCREMENT") && (!inds.contains("NOT NULL") || !inds.contains("NULL"))) {
                correct = false;
            }
        } else if (inds.size() == 2) {
            if (!inds.contains("AUTO INCREMENT") && !inds.contains("NOT NULL") && !inds.contains("NULL")) {
                correct = false;
            }
        } else if (inds.size() > 3) {
            correct = false;
        }

        if (!correct) {
            wrong.setText("Incompatible indexes!");
            return null;
        }
        return inds;
    }

    public boolean controlType(Node type, Label wrong) {
        if (type == null) {
            wrong.setText("Type not specified!");
            return false;
        } else {
            return true;
        }
    }

    public boolean controlDefaultField(TextField defField, Label wrong) {
        if (defField.isVisible() && defField.getText().equals("")) {
            wrong.setText("Empty default name");

            defField.textProperty().addListener(e -> {
                if (defField.getText().equals("")) {
                    wrong.setText("Empty default name");
                } else {
                    wrong.setText("");
                }
            });
            return false;
        } else {
            return true;
        }
    }

    public boolean controlNameField(TextField nameField, Label wrong) {
        if (nameField.getText().equals("") || Character.isDigit(nameField.getText().charAt(0))) {
            wrong.setText("Empty name field!");
            nameField.textProperty().addListener(e -> {
                String text = nameField.getText();
                if (text.equals("")) {
                    wrong.setText("Empty name field!");
                } else if (Character.isDigit(nameField.getText().charAt(0))) {
                    wrong.setText("Incorrect name field!");
                } else {
                    wrong.setText("");
                }
            });
            return false;
        } else {
            return true;
        }
    }

    public boolean controlLengthField(TextField lenField, Label wrong) {
        if (lenField.getText().equals("") || !lenField.getText().matches("\\d+")) {
            wrong.setText("Length error!");
            lenField.textProperty().addListener(e -> {
                String text = lenField.getText();
                if (text.equals("")) {
                    wrong.setText("Length not entered");
                } else if (!text.matches("\\d+")) {
                    wrong.setText("Length not digits!");
                } else {
                    wrong.setText("");
                }
            });
            return false;
        } else {
            return true;
        }
    }

    public boolean checkTypeLen(String type, int len) {
        return !type.equalsIgnoreCase("INT") || len <= 255;
    }

    @FXML public void addField() {
        changeScale(1);
        yField += 50;

        Label num = new Label();
        num.setFont(numField.getFont());
        num.setText(String.valueOf(++idField));
        num.setLayoutX(5);
        num.setLayoutY(yField);

        TextField nameField = new TextField();
        nameField.setPromptText("Table name");

        MenuButton menuBtn = new MenuButton();
        setIndexes(menuBtn);

        ComboBox<Node> comboBox = new ComboBox<>();
        setTypes(comboBox);

        TextField lenField = new TextField();
        lenField.setPromptText("Values");

        Label wrong = new Label();
        wrong.setLayoutY(yField);
        wrong.setLayoutX(535);
        wrong.setFont(wrongLabel.getFont());
        wrong.setTextFill(Color.RED);

        setNodePos(nameField, comboBox, lenField, menuBtn);

        TextField defField = new TextField();
        defField.setPromptText("Default");
        defField.setVisible(false);
        defField.setPrefWidth(90);
        defField.setLayoutX(menuBtn.getLayoutX());
        defField.setLayoutY(yField + 15);

        Button removeBtn = new Button("X");
        removeBtn.setFont(removeButton.getFont());
        removeBtn.setStyle(removeButton.getStyle());
        removeBtn.setLayoutX(502);
        removeBtn.setLayoutY(yField);

        topPane.getChildren().addAll(num, nameField, comboBox, lenField, menuBtn, defField, wrong, removeBtn);
        addNodesRow(nameField, comboBox, lenField, menuBtn, defField, wrong, num, removeBtn);

        removeRow(removeBtn, num, lenField, nameField, comboBox, menuBtn, wrong, defField);
    }

    public void removeRow(Button removeBtn, Label num, TextField lenField, TextField nameField, ComboBox<Node> comboBox,
                          MenuButton menuBtn, Label wrong, TextField defField) {
        removeBtn.setOnAction(e -> {
            if (fields.size() == 1) {
                wrong.setText("At least one row will be");
            } else {
                topPane.getChildren().removeAll(removeBtn, num, lenField, nameField, comboBox, menuBtn, wrong, defField);
                fields.remove(Integer.parseInt(num.getText()));

                idField--;
                yField -= 50;
                changeScale(-1);
                changeRowPos(Integer.parseInt(num.getText()));
            }
        });
    }

    public void changeRowPos(int id) {
        Map<Integer, Map<String, Node>> tempMap = new LinkedHashMap<>();
        int lastIndex = (int) fields.keySet().toArray()[fields.size() - 1];
        for (Integer i : fields.keySet()) {
            if (i >= id) {
                tempMap.put(i - 1, fields.get(i));
                Label num = (Label) fields.get(i).get("num");
                num.setText(String.valueOf(Integer.parseInt(num.getText()) - 1));
                for (Map.Entry<String, Node> entry : fields.get(i).entrySet()) {
                    Node node = entry.getValue();
                    node.setLayoutY(node.getLayoutY() - 50);
                }
            } else {
                tempMap.put(i, fields.get(i));
            }
        }

        fields = tempMap;
    }

    public void setNodePos(Control... controls) {
        int x = 20;
        for (Control control : controls) {
            control.setPrefWidth(90);
            control.setLayoutX(x);
            control.setLayoutY(yField);
            x += 125;
        }
    }

    private void addNodesRow(TextField textField, ComboBox<Node> comboBox, TextField lenField,
                             MenuButton indexes, TextField defField, Label wrongField, Label numLabel, Button removeButton) {
        Map<String, Node> nodeMap = new LinkedHashMap<>();
        nodeMap.put("name", textField);
        nodeMap.put("type", comboBox);
        nodeMap.put("length", lenField);
        nodeMap.put("indexes", indexes);
        nodeMap.put("default", defField);
        nodeMap.put("wrong", wrongField);
        nodeMap.put("num", numLabel);
        nodeMap.put("remove", removeButton);
        fields.put(idField, nodeMap);

        checkDefault();
    }

    private void setFirstId() {
        CustomMenuItem notNullItem = (CustomMenuItem) indexes.getItems().get(0);
        ((CheckBox) notNullItem.getContent()).setSelected(true);

        CustomMenuItem aiItem = (CustomMenuItem) indexes.getItems().get(2);
        ((CheckBox) aiItem.getContent()).setSelected(true);

        Text intNode = new Text("INT");
        intNode.setFill(Color.GREEN);
        types.setValue(intNode);
    }

    private void checkDefault() {
        for (Map.Entry<Integer, Map<String, Node>> entry : fields.entrySet()) {
            Map<String, Node> nodeMap = entry.getValue();
            TextField nameField = (TextField) nodeMap.get("name");
            MenuButton inds = (MenuButton) nodeMap.get("indexes");
            TextField defField = (TextField) nodeMap.get("default");
            double yOrdinary = nameField.getLayoutY();

            CustomMenuItem defItem = (CustomMenuItem)inds.getItems().get(1);
            CheckBox defBox = (CheckBox) defItem.getContent();
            defItem.setOnAction(event -> {
                if (defBox.getText().equals("DEFAULT")) {
                    if (defBox.isSelected()) {
                        inds.setText("DEFAULT");
                        defField.setVisible(true);
                        inds.setLayoutY(yOrdinary - 13);
                    } else {
                        inds.setText("");
                        defField.setVisible(false);
                        inds.setLayoutY(yOrdinary);
                    }
                }
            });
        }
    }

    public void setIndexes(MenuButton menuBtn) {
        menuBtn.getItems().clear();
        for (String index : HelpUtils.getIndexes()) {
            CheckBox tempBox = new CheckBox(index);
            CustomMenuItem tempItem = new CustomMenuItem(tempBox);
            menuBtn.getItems().add(tempItem);
        }
    }

    public void setTypes(ComboBox<Node> comboTypes) {
        List<String> typesList = HelpUtils.getTypes();
        for (int i = 0; i < typesList.size(); i++) {
            Text node = new Text(typesList.get(i));
            Paint color = Color.valueOf("#ffbb00");
            if (i < 6) {
                color = Color.GREEN;
            }
            node.setFill(color);
            comboTypes.getItems().add(node);
        }
    }

    public void changeScale(int multiplier) {
        topPane.setMinHeight(topPane.getHeight() + 50 * multiplier);
        stage.setHeight(stage.getHeight() + 50 * multiplier);
        addBtn.setLayoutY(createBtn.getLayoutY() + 50 * multiplier);
        createBtn.setLayoutY(createBtn.getLayoutY() + 50 * multiplier);
    }
}
