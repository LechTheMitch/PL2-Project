package ExamModule;

import java.util.ArrayList;

public class Question {
    private String question;
    private char answer;
    private char correctAnswer;
    public ArrayList<Question> questions = new ArrayList<>();

    //TODO Maybe we could define if student has taken the exam before here using Hashsets
    public Question(String question, char correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public char getAnswer() {
        return answer;
    }
    public void setAnswer(char answer) {
        this.answer = answer;
    }
    public char getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(char correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
