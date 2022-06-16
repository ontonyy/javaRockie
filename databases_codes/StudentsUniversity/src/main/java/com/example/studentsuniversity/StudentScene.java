package com.example.studentsuniversity;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StudentScene {
    @FXML public TextField name;
    @FXML public TextField email;
    @FXML public TextField courseName;
    @FXML public ListView<String> students1;
    @FXML public ListView<String> students2;
    @FXML public ListView<String> students3;
    private List<ListView<String>> listViews = new LinkedList<>();
    private DatabaseHandler dbHandler = new DatabaseHandler();

    @FXML public void initialize() {
        listViews = new LinkedList<>(List.of(students1, students2, students3));
        updateStudents();
    }

    public void createStudent() {
        String stuName = name.getText();
        String stuEmail = email.getText();
        String stuCourse = courseName.getText();
        if (!stuName.isEmpty() && !stuEmail.isEmpty() && !stuCourse.isEmpty()) {
            dbHandler.insertStudent(stuName, stuEmail, stuCourse);
        }
        name.clear();
        email.clear();
        courseName.clear();
        updateStudents();
    }

    public void clearDatabase() {
        dbHandler.clearDatabase();
        clearViewLists();
    }

    public void clearViewLists() {
        for (ListView<String> listView : listViews) {
            listView.getItems().clear();
        }
    }

    public void updateStudents() {
        clearViewLists();
        List<Student> students = dbHandler.getStudents();
        if (students.size() > 0) {
            int count = 0;
            for (int i = 0; i < students.size(); i++) {
                listViews.get(count).getItems().add(students.get(i).toString());
                if (i > 2 && i % 3 == 0) {
                    if (count == 2) count = 0;
                    else count++;
                }
            }
        }
    }
}
