package database;

import entity.Course;
import entity.Student;

import java.util.List;

public class ListDatabase {
    private List<Student> students;
    private List<Course> courses;

    public ListDatabase(List<Student> students, List<Course> courses) {
        this.students = students;
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }
}
