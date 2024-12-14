import DataStorage.FileHandler;
import UserTypes.*;
import java.io.File;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {
        loadUsers();
    }
    private static void loadUsers(){
        FileHandler.readSavedUsersFromFile(new File(Student.studentInformation), Student.students, Student.class);
        FileHandler.readSavedUsersFromFile(new File(Admin.adminInformation), Admin.admins, Admin.class);
        FileHandler.readSavedUsersFromFile(new File(Lecturer.lecturerInformation), Lecturer.lecturers, Lecturer.class);
    }
}