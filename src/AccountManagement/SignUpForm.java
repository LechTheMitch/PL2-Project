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
    private JFrame frame;

    public SignUpForm() {
        frame = new JFrame("SignUpForm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (studentRadioButton.isSelected()) {
                    try {
                        SignUp.addUser(textField1.getText(), passwordField1.getText(), "Student");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(contentPane, "Error adding user: " + ex.getMessage());
                    }
                } else if (lecturerRadioButton.isSelected()) {
                    try {
                        SignUp.addUser(textField1.getText(), passwordField1.getText(), "Lecturer");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(contentPane, "Error adding user: " + ex.getMessage());
                    }
                } else if (adminRadioButton.isSelected()) {
                    try {
                        SignUp.addUser(textField1.getText(), passwordField1.getText(), "Admin");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(contentPane, "Error adding user: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Please select a role");
                }
            }
        });
    }
    public void show() {
        frame.setVisible(true);
    }
}