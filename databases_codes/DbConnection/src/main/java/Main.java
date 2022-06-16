import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String password = "";
        try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
            System.out.println("database connected");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
