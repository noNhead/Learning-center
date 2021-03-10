package database;

import entity.Course;
import entity.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DbFileReader {
    ListDatabase listDatabase = new ListDatabase(new ArrayList<>(), new ArrayList<>());

    public List<Course> dbWriterCourse() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/courses.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        List<Course> list = new ArrayList<>();
        while (line != null) {
            Course course = new Course();
            String[] strings = line.split(" ");
            course.setTitle(strings[0]);
            course.setThemes(new HashMap<>());
            for (int j = 2; j <= Integer.parseInt(strings[1]); j+=2) {
                course.getThemes().put(strings[j], Integer.parseInt(strings[j+1]));
            }
            list.add(course);
            line = bufferedReader.readLine();
        }
        return list;
    }

    public List<Student> dbWriterStudent() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/students.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        List<Student> list = new ArrayList<>();
        while (line != null) {
            Student student = new Student();
            String[] strings = line.split(" ");
            student.setName(strings[0]);
            student.setSurname(strings[1]);
            student.setCourse(strings[2]);
            student.setStartDate(ZonedDateTime.of(
                    Integer.parseInt(strings[3]),
                    Integer.parseInt(strings[4]),
                    Integer.parseInt(strings[5]),
                    Integer.parseInt(strings[6]),
                    Integer.parseInt(strings[7]),
                    Integer.parseInt(strings[8]),
                    Integer.parseInt(strings[9]),
                    ZoneId.of("Etc/GMT-4")));
            student.setMarks(new ArrayList<>());
            double averageScore = 0;
            for (int j = 0; j < strings[10].length(); j++) {
                int mark = Integer.parseInt(String.valueOf(strings[10].charAt(j)));
                student.getMarks().add(mark);
                averageScore += mark;
                averageScore /= 2;
            }
            student.setAverageScore(averageScore);
            student.setSummaryDurability(Long.parseLong(strings[11]));
            list.add(student);
            line = bufferedReader.readLine();
        }
        return list;
    }
}
