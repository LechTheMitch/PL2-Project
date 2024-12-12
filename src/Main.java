import AccountManagement.SignUp;
import DataStorage.FileHandler;
import UserTypes.*;
import java.io.File;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {
        new FileHandler().readSavedUsersFromFile(new File(Student.studentInformation), Student.students);
        new SignUp().addUser("Gamal", "password", "Student");
    }
}