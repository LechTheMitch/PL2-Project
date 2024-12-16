import AccountManagement.SignUp;
import DataStorage.FileHandler;
import ExamModule.Exam;
import UserTypes.*;
import java.io.File;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {
        loadUsers();
        SignUp.addUser("John", "password", "Student");
        SignUp.addUser("John", "password", "Admin");
        Exam.createQuestions(Exam.pl2Questions, Exam.pl2, "What is the capital of France?", 'A');
        Exam.createQuestions(Exam.pl2Questions, Exam.pl2, "What is the capital of France?", 'B');
        new Exam(Exam.pl2Questions, Exam.pl2, Student.students.get(0));
        System.out.println(Student.students.get(0).takenExams.get(0));
    }
    private static void loadUsers(){
        FileHandler.readSavedUsersFromFile(Student.studentInformation, Student.students, Student.class);
        FileHandler.readSavedUsersFromFile(Admin.adminInformation, Admin.admins, Admin.class);
        FileHandler.readSavedUsersFromFile(Lecturer.lecturerInformation, Lecturer.lecturers, Lecturer.class);
    }
}