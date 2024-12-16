import AccountManagement.LoginForm;
import DataStorage.FileHandler;
import UserTypes.*;

import javax.swing.*;
import java.io.IOException;


public class Main extends JFrame {
    public static void main(String[] args) throws IOException {
        loadUsers();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
    private static void loadUsers(){
        FileHandler.readSavedUsersFromFile(Student.studentInformation, Student.students, Student.class);
        FileHandler.readSavedUsersFromFile(Admin.adminInformation, Admin.admins, Admin.class);
        FileHandler.readSavedUsersFromFile(Lecturer.lecturerInformation, Lecturer.lecturers, Lecturer.class);
    }
}
