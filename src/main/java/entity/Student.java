package entity;

import java.sql.Timestamp;
import java.util.Map;
import java.util.Objects;

public class Student {
    private String name;
    private String surname;
    private Timestamp startDate;
    private Course course;
    private Map<String, Integer> marks;

    public Student(String name, String surname, Timestamp startDate, Course course, Map<String, Integer> marks) {
        this.name = name;
        this.surname = surname;
        this.startDate = startDate;
        this.course = course;
        this.marks = marks;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
        firstSetMarks();
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, Integer> marks) {
        this.marks = marks;
    }

    private void firstSetMarks(){
        this.marks = this.course.getThemes();
        for (String key : this.marks.keySet()) {
            this.marks.replace(key, -1);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", startDate=" + startDate +
                ", course=" + course +
                ", marks=" + marks +
                '}';
    }
}