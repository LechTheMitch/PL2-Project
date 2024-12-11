package AccountManagement;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import DataStorage.FileHandler;

import UserTypes.*;

public class SignUp{
    private static ArrayList<User> sysUser = new ArrayList<>();
    public SignUp() throws IOException {
        //TODO
//        userInformation.createNewFile();
//        Student student = new Student();
//        modifyUser.write(student.generateId() + " " + "password" + " " + "Student" + "\n");
//        modifyUser.close();
    }
    private static void writeUser(User user) throws IOException {
        FileHandler.writeNewUser(new File("src/DataStorage/StudentInformation.txt"), user);
    }
    public static void addUser(String name, String password, String role) throws IOException {
        UserOperation userAdd = (User user) -> {
            assert user != null;
            try {
                user.setName(name);
                user.setPassword(password);
                user.setRole(role);
            } catch (NullPointerException e) {
                System.out.println("Required Parameters for user creation weren't provided");
            }

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
        userAdd.operate(newUser);
        try {
            switch (newUser.getRole().toLowerCase()){
                case "student":
                    Student student = (Student) newUser;
                    student.setId(student.generateId());
                    writeUser(student);
                    break;
                case "lecturer":
                    Lecturer lecturer = (Lecturer) newUser;
                    lecturer.setId(lecturer.generateId());
                    writeUser(lecturer);
                    break;
                case "admin":
                    Admin admin = (Admin) newUser;
                    admin.setId(admin.generateId());
                    writeUser(admin);
                    break;
                default:
                    System.out.println("Invalid role");
            }
        }catch (NullPointerException e){
            System.out.println("User not created");
        }


    }

}
