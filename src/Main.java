import AccountManagement.SignUp;
import DataStorage.FileHandler;
import ExamModule.Exam;
import UserTypes.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        loadUsers();
    }
    private static void loadUsers(){
        FileHandler.readSavedUsersFromFile(Student.studentInformation, Student.students, Student.class);
        FileHandler.readSavedUsersFromFile(Admin.adminInformation, Admin.admins, Admin.class);
        FileHandler.readSavedUsersFromFile(Lecturer.lecturerInformation, Lecturer.lecturers, Lecturer.class);
    }
}