package AccountManagement;

import UserTypes.Admin;
import UserTypes.User;
import UserTypes.Lecturer;
import UserTypes.Student;

import java.util.regex.Pattern;

public class Login {
    protected static void checkLogin(int id, String password) {
        //TODO
    }
    protected static void checkIfUserExists(int id) {
        if (Student.students.isEmpty() && Admin.admins.isEmpty() && Lecturer.lecturers.isEmpty()) {
            System.out.println("No users exist");
        } else if (Pattern.compile("2023....").matcher(String.valueOf(id)).matches()) {
            Student.students.forEach(student -> {
                if (student.getId() == id) {
                    //Login
                }
            });
        } else if (Pattern.compile("1.......").matcher(String.valueOf(id)).matches()) {
            Admin.admins.forEach(user -> {
                if (user.getId() == id) {
                    System.out.println("User exists");
                    login(user.getId(), user.getPassword());
                    System.out.println(user.getId());
                    System.out.println(user.getPassword());
                }
            });
        } else if (Pattern.compile("2....").matcher(String.valueOf(id)).matches()) {
            System.out.println("Lecturer exists");
            Lecturer.lecturers.forEach(lecturer -> {
                if (lecturer.getId() == id) {
                    System.out.println("User exists");
                    //Login
                }
            });
        }else {
            throw new IllegalArgumentException("Invalid ID");
        }

    }
    private static void login(int id, String password){
        //TODO
        System.out.println("Successful Login");
    }
}
