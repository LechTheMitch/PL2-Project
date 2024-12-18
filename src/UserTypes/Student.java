package UserTypes;

import java.io.File;
import java.util.ArrayList;

public final class Student extends User {
    public static ArrayList<Student> students = new ArrayList<>();
    private static int idGenerator;
    private final static String currentYear = "2023";
    public final static File studentInformation =  new File("src/DataStorage/StudentInformation.txt");
    private ArrayList<String> enrolledCourses = new ArrayList<>();
    private int[] grades = new int[5];
    public ArrayList<String> takenExams = new ArrayList<>();

    public Student() {
        idGenerator = getLargestId(students) % idParser;
    }

    public Student(String name, String pass, int id, String role) {
        super(name, pass, id, role);
    }
    
    public int getGrades(int index) {
        return grades[index];
    }
    public int setGrades(int index, int grade) {
        return grades[index];
    }
    
    @Override
    public int generateId() {
        return Integer.parseInt(currentYear+ String.format("%04d", ++idGenerator));
    }


}
