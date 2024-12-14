package ExamModule;

import DataStorage.FileHandler;
import UserTypes.Student;

import java.io.File;
import java.util.ArrayList;

public class Exam{
    protected static ArrayList<Question> pl2 = new ArrayList<>();
    protected static ArrayList<Question> ds = new ArrayList<>();
    protected static ArrayList<Question> db = new ArrayList<>();
    protected static ArrayList<Question> logic = new ArrayList<>();
    protected static ArrayList<Question> dc = new ArrayList<>();
    protected final static String pl2Questions = "src/DataStorage/PL2Questions.txt";
    protected final static String dsQuestions = "src/DataStorage/DSQuestions.txt";
    protected final static String dbQuestions = "src/DataStorage/DBQuestions.txt";
    protected final static String logicQuestions = "src/DataStorage/LogicQuestions.txt";
    protected final static String dcQuestions = "src/DataStorage/DCQuestions.txt";

    public Exam() {
        //TODO
    }
    public void takeExam(Student student) {
        if (student.getCanTakeExams()) {
            //TODO
        } else {
            System.out.println("Student cannot take exams");
        }
    }
    public static void setQuestionArray(File f, ArrayList<Question> questionArrayList){
        for (Question q: questionArrayList) {
            FileHandler.writeNewQuestion(f, q);
        }
    }
    public static void createQuestions(File f, ArrayList<Question> questionArrayList, String question, char answer, char correctAnswer) {
        Question newQuestion = new Question(question,answer,correctAnswer);
        if (questionArrayList.size()>=5)
            //Cannot Create More than 5 Questions
            throw new ArrayIndexOutOfBoundsException ("Cannot Create More than 5 Questions");

        else {
            FileHandler.writeNewQuestion(f, newQuestion);
            questionArrayList.add(newQuestion);
        }
    }
    public static void deleteQuestion(File f, ArrayList<Question> questionArrayList, int questionIndex) {
        Question q = questionArrayList.get(questionIndex);
        questionArrayList.remove(q);
        setQuestionArray(f, questionArrayList);
    }
    public static void modifyQuestion(File f, ArrayList<Question> questionArrayList, int questionIndex, String newQuestion, char newCorrectAnswer) {
        Question q = questionArrayList.get(questionIndex);
        q.setQuestion(newQuestion);
        q.setCorrectAnswer(newCorrectAnswer);
        questionArrayList.set(questionIndex, q);
        setQuestionArray(f, questionArrayList);
    }
    protected final ArrayList<Integer> checkAnswers(ArrayList<Question> questions, ArrayList<Integer> wrongQuestionIndexes) {
        int correct = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getCorrectAnswer() == questions.get(i).getAnswer()) {
                correct++;
            }
            else
                wrongQuestionIndexes.add(i);
        }
        System.out.println("You got " + correct + " out of " + questions.size() + " questions correct");
        return wrongQuestionIndexes;
    }
    protected final String calculateMarks(ArrayList<Question> questions, Student student, ArrayList<Integer> wrongQuestionIndexes) {
        return "You got " + wrongQuestionIndexes.size() + " out of " + questions.size() + " questions correct";
    }
}
