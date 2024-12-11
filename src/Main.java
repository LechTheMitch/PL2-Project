import AccountManagement.SignUp;
import DataStorage.FileHandler;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new SignUp().addUser("Gamal", "password", "Student");
        new FileHandler().readId(new File("src/DataStorage/StudentInformation.txt"));
    }
}