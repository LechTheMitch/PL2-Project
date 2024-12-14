package UserTypes;

import java.util.ArrayList;

public class Lecturer extends User{
    public static ArrayList<Lecturer> lecturers = new ArrayList<>();
    private static int idGenerator;
    public final static String lecturerInformation =  "src/DataStorage/LecturerInformation.txt";

    public Lecturer() {
    }
    public Lecturer(String name, String pass, int id, String role) {
        super(name, pass, id, role);
    }

    @Override
    public int generateId() {
        return 0;
    }
}
