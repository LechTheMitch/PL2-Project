package AccountManagement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import UserTypes.*;

public class SignUp{
    File userInformation = new File("src/DataStorage/UserInformation.txt");
    FileWriter modifyUser = new FileWriter("src/DataStorage/UserInformation.txt");
    public SignUp() throws IOException {
        userInformation.createNewFile();
        Student student = new Student();
        modifyUser.write(student.generateId() + " " + "password" + " " + "Student" + "\n");
        modifyUser.close();
    }

}
