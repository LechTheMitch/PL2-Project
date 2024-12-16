package UserTypes;

import DataStorage.FileHandler;

import java.io.File;
import java.util.ArrayList;

public final class Lecturer extends User{
    public static ArrayList<Lecturer> lecturers = new ArrayList<>();
    private static int idGenerator;
    public final static File lecturerInformation =  new File("src/DataStorage/LecturerInformation.txt");

    public Lecturer() {
        FileHandler.createFile(lecturerInformation);
        idGenerator = getLargestId(lecturers) % idParser;
    }
    public Lecturer(String name, String pass, int id, String role) {
        super(name, pass, id, role);
    }

    @Override
    public int generateId() {
        return Integer.parseInt("2"+ String.format("%04d", ++idGenerator));
    }
    }
