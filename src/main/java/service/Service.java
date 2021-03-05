package service;

import database.ListDatabase;
import entity.Course;
import entity.Student;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Service {
    Scanner in = new Scanner(System.in);
    public int lifecycleApp(){
        System.out.println("Console application for viewing and changing student information\nFor help enter: help");
        String entered = in.nextLine();
        boolean exitFlag = false;
        do {
            switch (entered) {
                case ("help"):
                    System.out.println();
                    break;
                case("exit"):
                    System.out.println("exiting...");
                    exitFlag = true;
                    break;
                case("add student"):
                    System.out.println("Creating student");
                    createAndAddStudent();
                    break;
                case("add course"):
                    System.out.println("Creating course");
                    createAndAddCourse();
                    break;
            }
        } while (!exitFlag);
        return 0;
    }

    private void createAndAddCourse(){
        System.out.println("Enter the name of the course: ");
        String title = in.nextLine();
        Map<String, Integer> themes = new HashMap<String, Integer>();
        int length = 10;
        for (int i = 0; i < length; i++) {
            System.out.println("Enter the title of the topic: ");
            String theme = in.nextLine();
            System.out.println("Enter the duration of the topic: ");
            int duration = in.nextInt();
            themes.put(theme, duration);
        }
        Course course = new Course(title, themes);
    }

    private void createAndAddStudent(){
        Student student = new Student();
        System.out.println("Enter the name student: ");
        student.setName(in.nextLine());
        System.out.println("Enter the surname student: ");
        student.setSurname(in.nextLine());
        student.setStartDate(new Timestamp(System.currentTimeMillis()));
        student.setCourse(new Course());
    }
}

