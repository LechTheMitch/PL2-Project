package AccountManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginForm extends JFrame {
    private JTextField nameField;
    private JPasswordField passwordField;
    private JRadioButton studentRadioButton;
    private JRadioButton lecturerRadioButton;
    private JRadioButton adminRadioButton;
    private JButton loginButton;

    public LoginForm() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameLabel = new JLabel("Name:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(nameLabel, constraints);

        nameField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(nameField, constraints);

        JLabel passwordLabel = new JLabel("Password:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(passwordLabel, constraints);

        passwordField = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(passwordField, constraints);

        studentRadioButton = new JRadioButton("Student");
        lecturerRadioButton = new JRadioButton("Lecturer");
        adminRadioButton = new JRadioButton("Admin");
        ButtonGroup group = new ButtonGroup();
        group.add(studentRadioButton);
        group.add(lecturerRadioButton);
        group.add(adminRadioButton);

        JPanel rolePanel = new JPanel(new FlowLayout());
        rolePanel.add(studentRadioButton);
        rolePanel.add(lecturerRadioButton);
        rolePanel.add(adminRadioButton);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        panel.add(rolePanel, constraints);

        loginButton = new JButton("Login");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(loginButton, constraints);

        add(panel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String password = new String(passwordField.getPassword());
                String role = studentRadioButton.isSelected() ? "Student" :
                        lecturerRadioButton.isSelected() ? "Lecturer" : "Admin";

                try {
                    SignUp.addUser(name, password, role);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });
    }
}