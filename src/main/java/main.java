import database.ListDatabase;
import entity.Course;
import entity.Student;
import service.Service;

import java.util.LinkedList;

public class main {
    public static void main(String[] args) {
        ListDatabase database = new ListDatabase(new LinkedList<Student>(), new LinkedList<Course>());

    }
}
