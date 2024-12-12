package UserTypes;

import java.util.ArrayList;

public class Student extends User {
    public static ArrayList<Student> students = new ArrayList<>();
    public static int idGenerator;
    static {
        idGenerator = getLargestId(students);
    }
    public Student() {
        setCanTakeExams(true);
    }

    public Student(String name, String pass, int id, String role) {
        setName(name);
        setPassword(pass);
        setId(id);
        setRole(role);
        setCanTakeExams(true);
    }

    @Override
    public int generateId() {
        return Integer.parseInt("20230"+ String.format("%03d",++idGenerator));
    }


}
