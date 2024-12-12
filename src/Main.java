import AccountManagement.SignUp;
import DataStorage.FileHandler;
import UserTypes.Student;

import java.io.File;
import java.io.IOException;

import static UserTypes.User.getLargestId;

public class Main {
    public static void main(String[] args) throws IOException {
        new FileHandler().readSavedUsersFromFile(new File("src/DataStorage/StudentInformation.txt"), UserTypes.Student.students);
        new SignUp().addUser("Gamal", "password", "Student");
        System.out.println(getLargestId(UserTypes.Student.students));
        System.out.println(Student.idGenerator);
        System.out.println(UserTypes.Student.students.get(0).getName());
        System.out.println(UserTypes.Student.students.get(0).getId());
        System.out.println(UserTypes.Student.students.get(1).getName());
        System.out.println(UserTypes.Student.students.get(1).getId());
    }
}