package database;

import entity.Course;
import entity.Student;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListDatabase {
    private List<Student> students;
    private List<Course> courses;

    public ListDatabase(List<Student> students, List<Course> courses) {
        this.students = students;
        this.courses = courses;
    }

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

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public List<Student> getStudent(String name, String surname) {
        return this.students.stream().filter(item -> item.getName().equalsIgnoreCase(name) && item.getSurname().equalsIgnoreCase(surname)).collect(Collectors.toList());
    }

    public List<Course> getCourse(String title) {
        return this.courses.stream().filter(item -> item.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }

    public void writeAllTitleCourse() {
        int i = 1;
        for (Course course: this.courses) {
            System.out.println(i + ". " +course.getTitle());
            i++;
        }
    }
}
