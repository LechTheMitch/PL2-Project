package UserTypes;

import DataStorage.FileHandler;
import ExamModule.Question;

import java.io.File;
import java.util.ArrayList;

import static UserTypes.Lecturer.lecturers;
import static UserTypes.Student.students;

final public class Admin extends User {
    public static ArrayList<Admin> admins = new ArrayList<>();
    private static int idGenerator;
    public final static File adminInformation =  new File("src/DataStorage/AdminInformation.txt");

    public Admin() {
        FileHandler.createFile(adminInformation);
        idGenerator = getLargestId(admins)%idParser;
    }
    public Admin(String name, String pass, int id, String role) {
        super(name, pass, id, role);
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
                setUserFiles(adminInformation, admins);
            }
        }
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getId() == id){
                lecturers.remove(lecturer);
                setUserFiles(Lecturer.lecturerInformation, lecturers);
            }
        }
        for (Student student : students) {
            if (student.getId() == id){
                students.remove(student);
                setUserFiles(Student.studentInformation, students);
            }
        }
    }
    public void changeCredentials(String password){
        this.setPassword(password);
        FileHandler.recreateFile(adminInformation);
        for (Admin admin : admins) {
            FileHandler.writeNewUser(adminInformation, admin);
        }
    }
    public static void setUserFiles(File f, ArrayList<? extends User> userArrayList){
        FileHandler.recreateFile(f);
        for (User u: userArrayList) {
            FileHandler.writeNewUser(f, u);
        }
    }
}
