package UserTypes;

import java.util.ArrayList;

public class Student extends User {
    public static ArrayList<Student> students = new ArrayList<>();
    private static int idGenerator;
    public final static String studentInformation =  "src/DataStorage/StudentInformation.txt";
    private static final int idParser = 10000;

    public Student() {
        setCanTakeExams(true);
        idGenerator = getLargestId(students) % idParser;
    }

    public Student(String name, String pass, int id, String role) {
        super(name, pass, id, role);
        setCanTakeExams(true);
    }

    @Override
    public int generateId() {
        return Integer.parseInt("20230"+ String.format("%03d", ++idGenerator));
    }


}
