package AccountManagement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import UserTypes.*;

public class SignUp{
    private static ArrayList<User> sysUser = new ArrayList<>();
    File userInformation = new File("src/DataStorage/UserInformation.txt");
    FileWriter modifyUser = new FileWriter("src/DataStorage/UserInformation.txt");
    public SignUp() throws IOException {
        //TODO
//        userInformation.createNewFile();
//        Student student = new Student();
//        modifyUser.write(student.generateId() + " " + "password" + " " + "Student" + "\n");
//        modifyUser.close();
    }
    public static void addUser(String name, String password, String role) throws IOException {
        UserOperation userOp = (User user) -> {
            user.setName(name);
            user.setPassword(password);
            user.setRole(role);
        };
        User newUser = null;
        switch (role.toLowerCase()){
            case "student":
                newUser = new Student();
                break;
            case "lecturer":
                newUser = new Lecturer();
                break;
            case "admin":
                newUser= new Admin();
                break;
            default:
                System.out.println("Invalid role");
        }
        userOp.operate(newUser);
    }

}
