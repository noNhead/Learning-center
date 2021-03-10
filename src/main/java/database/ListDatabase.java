package database;

import entity.Course;
import entity.Student;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListDatabase {
    private List<Student> students;
    private List<Course> courses;

    public ListDatabase() {

    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudent(String name, String surname) {
        return this.students.stream().filter(item -> item.getName().equalsIgnoreCase(name) && item.getSurname().equalsIgnoreCase(surname)).collect(Collectors.toList());
    }

    public List<Course> getCourses() {
        return courses;
    }
}
