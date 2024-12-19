package UserTypes;



import DataStorage.FileHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminWindow extends JFrame {

    private JTextField nameField, passField, idField, roleField, searchField;
    private JTextArea outputArea;
    private JButton addButton, deleteButton, listButton, searchButton;

    public AdminWindow() {
        setTitle("Admin Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Password:"));
        passField = new JTextField();
        panel.add(passField);

        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Role:"));
        roleField = new JTextField();
        panel.add(roleField);

        addButton = new JButton("Add User");
        panel.add(addButton);

        deleteButton = new JButton("Delete User");
        panel.add(deleteButton);

        listButton = new JButton("List Users");
        panel.add(listButton);

        searchButton = new JButton("Search User by ID");
        panel.add(searchButton);

        searchField = new JTextField();
        panel.add(searchField);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser();
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listUsers();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchUser();
            }
        });
    }

    private void addUser() {
        String name = nameField.getText();
        String pass = passField.getText();
        int id = Integer.parseInt(idField.getText());
        String role = roleField.getText();

        if (role.equalsIgnoreCase("student")) {
            Student student = new Student(name, pass, id, role);
            Student.students.add(student);
            FileHandler.writeNewUser(Student.studentInformation, student);
        } else if (role.equalsIgnoreCase("lecturer")) {
            Lecturer lecturer = new Lecturer(name, pass, id, role);
            Lecturer.lecturers.add(lecturer);
            FileHandler.writeNewUser(Lecturer.lecturerInformation, lecturer);
        }
        outputArea.setText("User added successfully.");
    }

    private void deleteUser() {
        int id = Integer.parseInt(idField.getText());
        Admin.deleteUser(id);
        outputArea.setText("User deleted successfully.");
    }

    private void listUsers() {
        StringBuilder output = new StringBuilder();
        for (Student student : Student.students) {
            output.append(student.getName()).append(" ").append(student.getId()).append(" ").append(student.getRole()).append("\n");
        }
        for (Lecturer lecturer : Lecturer.lecturers) {
            output.append(lecturer.getName()).append(" ").append(lecturer.getId()).append(" ").append(lecturer.getRole()).append("\n");
        }
        outputArea.setText(output.toString());
    }

    private void searchUser() {
        int id = Integer.parseInt(searchField.getText());
        for (Student student : Student.students) {
            if (student.getId() == id) {
                outputArea.setText(student.getName() + " " + student.getId() + " " + student.getRole());
                return;
            }
        }
        for (Lecturer lecturer : Lecturer.lecturers) {
            if (lecturer.getId() == id) {
                outputArea.setText(lecturer.getName() + " " + lecturer.getId() + " " + lecturer.getRole());
                return;
            }
        }
        outputArea.setText("User not found.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminWindow().setVisible(true);
            }
        });
    }
}