import AccountManagement.SignUp;
import UserTypes.Student;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Student[] student = new Student[]{new Student()};
        SignUp signUp = new SignUp();
        System.out.println(student[0].generateId());
    }
}