package service;

import database.DbFileReader;
import database.ListDatabase;
import entity.Course;
import entity.Student;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.*;

public class Service {
    Scanner in = new Scanner(System.in);
    private final ListDatabase listDatabase = new ListDatabase();
    private final DbFileReader dbFileReader = new DbFileReader();

    public void lifecycleApp(){
        try {
            listDatabase.setCourses(dbFileReader.dbWriterCourse());
            listDatabase.setStudents(dbFileReader.dbWriterStudent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        do {
            System.out.println("Console application for viewing and changing student information\nFor help enter: help");
            String entered = in.nextLine();
            switch (entered) {
                case ("help"):
                    System.out.println("exit: closing the app\nchoose student: choice of a specific student\ngpa rate: rating of all students according to the average score\nttf rate: ranking of all students by graduation date");
                    break;
                case("exit"):
                    System.out.println("exiting...");
                    System.exit(0);
                    break;
                case("choose student"):
                    System.out.println("Choosing added student");
                    List<Student> students = studentListSelect();
                    if (students == null) {
                        break;
                    }
                    Student student = studentSelect(students);
                    if (student != null) {
                        studentProfileManagement(student);
                    } else {
                        System.out.println("Student not found");
                    }
                    break;
				case("gpa rate"):
					System.out.println("Composing a list of students by average score...");
					writeStudentSortByGpa();
					break;
                case("ttf rate"):
                    System.out.println("Composing a list of students by time to finish...");
                    writeStudentSortByTtf();
                    break;
            }
        } while (true);
    }

    private void studentProfileManagement(Student student) {
        boolean backFlag = false;
        do {
            System.out.println("Viewing student information\nStudent: "+ student.getName() + " " + student.getSurname() + "Course: " + student.getCourse());
            String entered = in.nextLine();
            switch (entered) {
                case ("gpa"):
                    System.out.println("Student's current GPA: " + student.getAverageScore());
                    break;
                case ("ttf"):
                    System.out.println("Time left until the end of the program: " + student.getHoursSummaryThemesRemainder() / 8 + " days " + student.getHoursSummaryThemesRemainder() % 8 + " hours");
                    break;
                case ("poe"):
                    System.out.println("Success rate: " + student.getAverageScore() * 20 + "%");
                    break;
                case ("back"):
                    backFlag = true;
                    break;
            }
        } while (!backFlag);
    }

    private List<Student> studentListSelect(){
        System.out.println("Enter the name and surname student");
        String[] strings = in.nextLine().split(" ");
        if (strings[0] != null && strings[1] != null) {
            return listDatabase.getStudent(strings[0], strings[1]);
        } else {
            System.out.println("The first or last name was not entered, please try again");
        }
        return null;
    }

    private Student studentSelect(List<Student> students) {
        if (students == null) {
            System.out.println("No students with this name and surname were found");
        } else if (students.size() == 0) {
            System.out.println("No students with this name and surname were found");
        } else if (students.size() > 1) {
            return studentSelect(students);
        } else {
            return students.get(0);
        }
        return null;
    }
	
	private void writeStudentSortByGpa() {
        List<Student> sortedStudentsList = listDatabase.getStudents();
        sortedStudentsList.sort(Comparator.comparingDouble(Student::getAverageScore));
        for (Student student: sortedStudentsList) {
            System.out.println(student.toString());
        }
	}

    private void writeStudentSortByTtf() {
        List<Student> sortedStudentsList = listDatabase.getStudents();
        sortedStudentsList.sort(Comparator.comparingLong(Student::getHoursSummaryThemesRemainder));
        for (Student student: sortedStudentsList) {
            System.out.println(student.toString());
        }
    }
}

