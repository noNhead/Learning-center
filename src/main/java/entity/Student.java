package entity;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Student {
    private String name;
    private String surname;
    private ZonedDateTime startDate;
    private String course;
    private List<Integer> marks;
    private double averageScore;
    private long summaryDurability;

    public Student(String name, String surname, ZonedDateTime startDate, String course, List<Integer> marks, double averageScore, long summaryDurability) {
        this.name = name;
        this.surname = surname;
        this.startDate = startDate;
        this.course = course;
        this.marks = marks;
        this.averageScore = averageScore;
        this.summaryDurability = summaryDurability;
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

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
        firstSetMarks();
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    private void firstSetMarks(){
        this.marks = null;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
	
    public long getHoursSummaryThemesRemainder() {
        ZonedDateTime calculatedZonedTime = this.startDate;
        calculatedZonedTime.plusHours(getSummaryDurability());
        return ChronoUnit.HOURS.between(ZonedDateTime.now(), calculatedZonedTime);
    }

    public long getSummaryDurability() {
        return summaryDurability;
    }

    public void setSummaryDurability(long summaryDurability) {
        this.summaryDurability = summaryDurability;
    }

    @Override
    public String toString() {
        return "GPA: " + getAverageScore() +  " | " + getHoursSummaryThemesRemainder() + "|" + name + " " + surname;
    }
}
