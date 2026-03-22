import java.util.ArrayList;

public class StudentsManager {

    public static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(Student s) {
        students.add(s);
    }

    public static void deleteStudent(int index) {
        students.remove(index);
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }
}