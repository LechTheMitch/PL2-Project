package UserTypes;

import javax.swing.*;
import DataStorage.FileHandler;
import ExamModule.Exam;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LecturerForm extends JFrame {

    private JTabbedPane tabbedPane;
    private JPanel examManagementPanel;
    private JPanel gradesPanel;
    private JTable gradesTable;
    private JTextField examNameField;
    private ButtonGroup correctAnswerGroup;
    private JRadioButton optionA;
    private JRadioButton optionB;
    private JRadioButton optionC;
    private JRadioButton optionD;
    private JButton createExamButton;

    public LecturerForm() {
        setTitle("Lecturer Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        // Exam Management Panel
        examManagementPanel = new JPanel();
        examManagementPanel.setLayout(new BorderLayout());
        examManagementPanel.add(new JLabel("Exam Management"), BorderLayout.NORTH);

        // Add input fields and button for creating exams
        JPanel createExamPanel = new JPanel(new GridLayout(4, 2));
        createExamPanel.add(new JLabel("Question:"));
        examNameField = new JTextField();
        createExamPanel.add(examNameField);

        createExamPanel.add(new JLabel("Correct Answer:"));

        correctAnswerGroup = new ButtonGroup();
        optionA = new JRadioButton("A");
        optionB = new JRadioButton("B");
        optionC = new JRadioButton("C");
        optionD = new JRadioButton("D");

        correctAnswerGroup.add(optionA);
        correctAnswerGroup.add(optionB);
        correctAnswerGroup.add(optionC);
        correctAnswerGroup.add(optionD);

        JPanel radioPanel = new JPanel(new GridLayout(1, 4));
        radioPanel.add(optionA);
        radioPanel.add(optionB);
        radioPanel.add(optionC);
        radioPanel.add(optionD);

        createExamPanel.add(radioPanel);

        createExamButton = new JButton("Create Exam");
        createExamPanel.add(createExamButton);
        examManagementPanel.add(createExamPanel, BorderLayout.CENTER);

        // Add action listener for the create exam button
        createExamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String question = examNameField.getText();
                char correctAnswer = ' ';
                if (optionA.isSelected()) {
                    correctAnswer = 'A';
                } else if (optionB.isSelected()) {
                    correctAnswer = 'B';
                } else if (optionC.isSelected()) {
                    correctAnswer = 'C';
                } else if (optionD.isSelected()) {
                    correctAnswer = 'D';
                }
                Exam.createQuestions(Exam.pl2Questions, Exam.pl2, question, correctAnswer);
            }
        });

        // Grades Panel
        gradesPanel = new JPanel();
        gradesPanel.setLayout(new BorderLayout());
        gradesPanel.add(new JLabel("Grades"), BorderLayout.NORTH);
        gradesTable = new JTable();
        gradesPanel.add(new JScrollPane(gradesTable), BorderLayout.CENTER);

        tabbedPane.addTab("Exam Management", examManagementPanel);
        tabbedPane.addTab("Grades", gradesPanel);

        add(tabbedPane);

        // Populate grades table with student data
        populateStudentTable(gradesTable, Student.students);
    }

    private void populateStudentTable(JTable table, ArrayList<Student> students) {
        String[] columnNames = {"Name", "ID", "Grade"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Student student : students) {
            Object[] rowData = new Object[3];
            rowData[0] = student.getName();
            rowData[1] = student.getId();
            rowData[2] = student.getGrades(0); // Assuming subjectIndex is defined
            model.addRow(rowData);
        }

        table.setModel(model);
    }

    public static void main(String[] args) {
        loadUsers();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LecturerForm().setVisible(true);
            }
        });
    }

    private static void loadUsers() {
        FileHandler.readSavedUsersFromFile(Student.studentInformation, Student.students, Student.class);
        FileHandler.readSavedUsersFromFile(Admin.adminInformation, Admin.admins, Admin.class);
        FileHandler.readSavedUsersFromFile(Lecturer.lecturerInformation, Lecturer.lecturers, Lecturer.class);
    }
}