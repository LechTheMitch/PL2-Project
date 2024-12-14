package UserTypes;

import DataStorage.FileHandler;
import java.io.File;
import java.util.ArrayList;

import static UserTypes.Lecturer.lecturers;
import static UserTypes.Student.students;

final public class Admin extends User {
    public static ArrayList<Admin> admins = new ArrayList<>();
    private static int idGenerator;
    public final static String adminInformation =  "src/DataStorage/AdminInformation.txt";
    private static final int idParser = 100;

    public Admin() {
        FileHandler.createFile(new File(adminInformation));
        idGenerator = getLargestId(admins)%idParser;
    }
    public int generateId() {
        return Integer.parseInt("1"+ String.format("%07d", ++idGenerator));
    }
    public static void listUserInformation(){
        //TODO
        for (Admin admin : admins) {
            System.out.println(admin.getName() + " " + admin.getId() + " " + admin.getRole());
        }
        for (Lecturer lecturer : lecturers) {
            System.out.println(lecturer.getName() + " " + lecturer.getId() + " " + lecturer.getRole());
        }
        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getId() + " " + student.getRole());
        }
    }
    public static void deleteUser(int id){
        //TODO
        for (Admin admin : admins) {
            if (admin.getId() == id){
                admins.remove(admin);
            }
        }
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getId() == id){
                lecturers.remove(lecturer);
            }
        }
        for (Student student : students) {
            if (student.getId() == id){
                students.remove(student);
            }
        }
    }
}
