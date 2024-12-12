import AccountManagement.SignUp;
import AccountManagement.SignUpForm;
import DataStorage.FileHandler;
import UserTypes.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {
        new FileHandler().readSavedUsersFromFile(new File(Student.studentInformation), Student.students);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SignUpForm().show();
            }
        });
    }
}