package ExamModule;

import UserTypes.Student;

public class Exam extends Question{
    public Exam(String question, char answer) {
        super(question, answer);
        Question[][] q =  new Question[0][0];
    }
    public void takeExam(Student student) {
        if (student.getCanTakeExams()) {
            //TODO
        } else {
            System.out.println("Student cannot take exams");
        }
    }
}
