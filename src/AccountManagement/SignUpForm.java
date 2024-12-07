package AccountManagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SignUpForm {
    private JPanel contentPane;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JRadioButton studentRadioButton;
    private JRadioButton lecturerRadioButton;
    private JRadioButton adminRadioButton;
    private JButton signUpButton;

    public SignUpForm() {
        studentRadioButton.addActionListener(e -> {
            if (studentRadioButton.isSelected()) {
                lecturerRadioButton.setSelected(false);
                adminRadioButton.setSelected(false);
                try {
                    SignUp.addUser(textField1.getText(), passwordField1.getText(), "Student");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(contentPane, "Error adding user: " + ex.getMessage());
                }
            }
        });
    }
}