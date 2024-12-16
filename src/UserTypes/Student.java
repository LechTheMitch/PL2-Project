package UserTypes;

import java.io.File;
import java.util.ArrayList;

public final class Student extends User {
    public static ArrayList<Student> students = new ArrayList<>();
    private static int idGenerator;
    private final static String currentYear = "2023";
    public final static File studentInformation =  new File("src/DataStorage/StudentInformation.txt");
    public ArrayList<String> takenExams = new ArrayList<>();

    public Student() {
        idGenerator = getLargestId(students) % idParser;
    }

    public Student(String name, String pass, int id, String role) {
        super(name, pass, id, role);
    }

    @Override
    public int generateId() {
        return Integer.parseInt(currentYear+ String.format("%04d", ++idGenerator));
    }


}
