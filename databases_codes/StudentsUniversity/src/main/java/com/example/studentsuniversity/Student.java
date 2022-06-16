package com.example.studentsuniversity;

import java.util.List;

public class Student {
    private String name, email;
    private List<String> courses;

    public Student(String name, String email, List<String> courses) {
        this.name = name;
        this.email = email;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student: " + name +
                "\nemail: " + email +
                "\ncourses: " + courses;
    }

    public String getName() {
        return name;
    }

    public void addCourse(String course) {
        courses.add(course);
    }
}
