package structural.decorator.source;

import java.io.*;

public class FileDataSource implements DataSource {
    private String filename;

    public FileDataSource(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeData(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String main = "";
            while (reader.ready()) {
                main += reader.readLine();
            }
            return main;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
