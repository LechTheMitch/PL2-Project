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
        Exam.createQuestions(new File(Exam.pl2Questions), Exam.pl2, "What is the capital of France?", 'A');
        Exam.createQuestions(new File(Exam.pl2Questions), Exam.pl2, "What is the capital of France?", 'B');
        Exam.takeExam(Student.students.get(0), Exam.pl2);
    }
    private static void loadUsers(){
        FileHandler.readSavedUsersFromFile(new File(Student.studentInformation), Student.students, Student.class);
        FileHandler.readSavedUsersFromFile(new File(Admin.adminInformation), Admin.admins, Admin.class);
        FileHandler.readSavedUsersFromFile(new File(Lecturer.lecturerInformation), Lecturer.lecturers, Lecturer.class);
    }
}