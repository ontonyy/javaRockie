package com.example.studentsuniversity;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DatabaseHandler {
    public static Connection conn;
    private List<Student> students = new LinkedList<>();

    public DatabaseHandler() {
        setConnection();
        initializeStudents();
    }

    public void initializeStudents() {
        try (PreparedStatement studentsQuery = conn.prepareStatement("SELECT * FROM students")) {
            ResultSet rs = studentsQuery.executeQuery();
            List<Student> dbStudents = new LinkedList<>();
            if (rs != null) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    List<String> courses = getStudentCourses(name);
                    dbStudents.add(new Student(name, email, courses));
                }
            }
            students.addAll(dbStudents);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setConnection() {
        try {
            String dbUrl = "jdbc:mysql://localhost:3306/university";
            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(dbUrl, username, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean containsStudent(String name) {
        try {
            PreparedStatement selectAll = conn.prepareStatement("SELECT * FROM students WHERE name = '" + name + "'");
            ResultSet rs = selectAll.executeQuery();
            if (rs.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getLastId() {
        try (PreparedStatement lastId = conn.prepareStatement("SELECT MAX(id) from students")) {
            ResultSet rs = lastId.executeQuery();
            if (rs.next()) return Integer.parseInt(rs.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Student getStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    public void insertStudent(String name, String email, String courseName) {
        if (!containsStudent(name)) {
            try (PreparedStatement insertStudent = conn.prepareStatement("INSERT INTO students(name, email, course) values(?, ?, ?)");) {
                createAndAddStudent(name, email, new LinkedList<>(List.of(courseName)));

                insertStudent.setString(1, name);
                insertStudent.setString(2, email);
                insertStudent.setString(3, courseName);
                insertStudent.executeUpdate();

                insertCourse(courseName, getStudentId(name));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            insertCourse(courseName, getStudentId(name));
            getStudent(name).addCourse(courseName);
        }
    }

    public void createAndAddStudent(String name, String email, List<String> courses) {
        Student student = new Student(name, email, courses);
        students.add(student);
    }

    public void insertCourse(String courseName, int studentId) {
        try (PreparedStatement insertCourse = conn.prepareStatement("INSERT INTO courses(student_id, name) values(?, ?)")) {
            insertCourse.setInt(1, studentId);
            insertCourse.setString(2, courseName);
            insertCourse.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getStudentId(String name) {
        try (PreparedStatement studentIdQuery = conn.prepareStatement("SELECT * FROM students WHERE name= '" + name + "'")){
            ResultSet rs = studentIdQuery.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public List<String> getStudentCourses(String name) {
        if (containsStudent(name)) {
            int id = getStudentId(name);
            List<String> courses = new LinkedList<>();
            try (PreparedStatement coursesQuery = conn.prepareStatement("SELECT * FROM courses WHERE student_id = " + id)) {
                ResultSet rs = coursesQuery.executeQuery();
                while (rs.next()) {
                    courses.add(rs.getString("name"));
                }
                return courses;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void clearDatabase() {
        students.clear();
        try (PreparedStatement clearStudents = conn.prepareStatement("TRUNCATE TABLE students");
            PreparedStatement clearCourses = conn.prepareStatement("TRUNCATE TABLE courses")) {
            clearStudents.executeUpdate();
            clearCourses.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Student> getStudents() {
        return students;
    }
}
