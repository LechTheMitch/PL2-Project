import AccountManagement.SignUp;
import DataStorage.FileHandler;

import java.io.File;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {
        new FileHandler().readSavedUsersFromFile(new File("src/DataStorage/StudentInformation.txt"), UserTypes.Student.students);
        new SignUp().addUser("Gamal", "password", "Student");
    }
}