package service;

import database.ListDatabase;
import entity.Course;
import entity.Student;

import java.sql.Timestamp;
import java.util.*;

public class Service {
    Scanner in = new Scanner(System.in);
    ListDatabase listDatabase = new ListDatabase(new ArrayList<>(), new ArrayList<>());
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
                case("choose student"):
                    System.out.println("Choosing added student");
                    List<Student> students = studentListSelect();
                    Student student = studentSelect(students);
                    if (student == null) {
                        break;
                    }
                    studentProfileManagement(student);
                    break;
				case("gpa rate"):
					System.out.println("Composing a list of students by average score...");
            }
        } while (!exitFlag);
        return 0;
    }

    private void studentProfileManagement(Student student) {
        System.out.println("Viewing student information");
        String entered = in.nextLine();
        switch (entered) {
            case ("gpa"):
                System.out.println("Student's current GPA: " + student.getAverageScore());
				break;
            case ("ttf"):
                System.out.println("Time left until the end of the program: " + student.getHoursSummaryThemesRemainder / 8 + " days " + student.getHoursSummaryThemesRemainder%8 + " hours");
				break;
			case("poe"):
                System.out.println("Success rate: " + student.getAverageScore() * 20 + "\%");
				break;
		}
    }

    private void createAndAddCourse(){
        System.out.println("Enter the name of the course: ");
        String title = in.nextLine();
        Map<String, Integer> themes = new HashMap<>();
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

    private List<Student> studentListSelect(){
        System.out.println("Enter the name and surname student");
        String name = in.next();
        String surname = in.next();
        if (name != null && surname != null) {
            return listDatabase.getStudent(name, surname);
        } else {
            System.out.println("The first or last name was not entered, please try again");
        }
        return null;
    }

    private Student studentSelect(List<Student> students) {
        Student selectedStudent = null;
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
	
	private List<Student> studentSortByGpa() {
		return Collection.sort(database.getStudent() -> new Comparator(Student s1, Student s2) {
			return s1.getAverageScore().compareTo(s2.getAverageScore());
		});
	}
}

