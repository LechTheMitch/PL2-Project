package ExamModule;

import DataStorage.FileHandler;
import UserTypes.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam{
    public static ArrayList<Question> pl2 = new ArrayList<>();
    public static ArrayList<Question> ds = new ArrayList<>();
    public static ArrayList<Question> db = new ArrayList<>();
    public static ArrayList<Question> logic = new ArrayList<>();
    public static ArrayList<Question> dc = new ArrayList<>();
    public final static File pl2Questions = new File("src/DataStorage/PL2Questions.txt");
    public final static File dsQuestions = new File("src/DataStorage/DSQuestions.txt");
    public final static File dbQuestions = new File("src/DataStorage/DBQuestions.txt");
    public final static File logicQuestions = new File("src/DataStorage/LogicQuestions.txt");
    public final static File dcQuestions = new File("src/DataStorage/DCQuestions.txt");

    public Exam() {
    }
    public Exam(File f, ArrayList<Question> questionArrayList, Student student) {
        FileHandler.readQuestionsFromFile(f, questionArrayList);
        takeExam(student, questionArrayList);
        showWrongAnswers(questionArrayList, checkAnswers(questionArrayList));
    }

    //TODO Exam Taken Before
    public static void takeExam(Student student, ArrayList<Question> questions) {
        //This Scanner will be removed
        Scanner questionAnswer = new Scanner(System.in);
        for (Question question : questions){
            System.out.println(question.getQuestion());
            System.out.println("Enter your answer: ");
            question.setAnswer(Character.toUpperCase(questionAnswer.next().charAt(0)));
        }
        calculateMarks(questions, student, new ArrayList<>());
        student.takenExams.add(String.valueOf(questions));
//        if (questions == pl2) {
//            student.takenExams.add(String.valueOf(pl2));
//        } else if (questions == ds) {
//            student.takenExams.add(String.valueOf(ds));
//        } else if (questions == db) {
//            student.takenExams.add(String.valueOf(db));
//        } else if (questions == logic) {
//            student.takenExams.add(String.valueOf(logic));
//        } else if (questions == dc) {
//            student.takenExams.add(String.valueOf(dc));
//        }
    }
    public static void setQuestionArray(File f, ArrayList<Question> questionArrayList){
        for (Question q: questionArrayList) {
            FileHandler.writeNewQuestion(f, q);
        }
    }
    public static void createQuestions(File f, ArrayList<Question> questionArrayList, String question, char correctAnswer) {
        Question newQuestion = new Question(question,correctAnswer);
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
    public static ArrayList<Integer> checkAnswers(ArrayList<Question> questions) {
        int correct = 0;
        ArrayList<Integer> wrongQuestionIndexes = new ArrayList<>();
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
    public static void showWrongAnswers(ArrayList<Question> questions, ArrayList<Integer> wrongQuestionIndexes) {
        for (int i : wrongQuestionIndexes) {
            System.out.println(questions.get(i).getQuestion() + " Correct Answer: "+questions.get(i).getCorrectAnswer());
        }
    }
    public static String calculateMarks(ArrayList<Question> questions, Student student, ArrayList<Integer> wrongQuestionIndexes) {
        return "You got " + wrongQuestionIndexes.size() + " out of " + questions.size() + " questions correct";
    }
}
