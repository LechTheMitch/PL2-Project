package AccountManagement;

import UserTypes.Admin;
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
            System.out.println("Student exits");
            Student.students.forEach(student -> {
                if (student.getId() == id) {
                    System.out.println("User exists");
                    //Login
                }
            });
        } else if (Pattern.compile("1.......").matcher(String.valueOf(id)).matches()) {
            System.out.println("Admin exists");
            Student.students.forEach(student -> {
                if (student.getId() == id) {
                    System.out.println("User exists");
                    //Login
                }
            });
        } else if (Pattern.compile("2....").matcher(String.valueOf(id)).matches()) {
            System.out.println("Lecturer exists");
            Student.students.forEach(student -> {
                if (student.getId() == id) {
                    System.out.println("User exists");
                    //Login
                }
            });
        }else {
            throw new IllegalArgumentException("Invalid ID");
        }

    }
}
