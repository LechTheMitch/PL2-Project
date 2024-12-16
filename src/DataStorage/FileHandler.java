package DataStorage;

import ExamModule.Question;
import UserTypes.Admin;
import UserTypes.Lecturer;
import UserTypes.Student;
import UserTypes.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    public static void createFile(File f) {
        try {
            if (f.createNewFile()) {
                System.out.println("File created: " + f.getName());
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Error creating file " + f.getName());
        }
    }
    public static void writeNewQuestion(File f, Question newQuestion) {
        try (FileWriter writer = new FileWriter(f, true)) {
            writer.write(newQuestion.getQuestion() + " " + newQuestion.getAnswer() + " " + newQuestion.getCorrectAnswer() + "\n");
        } catch (IOException ex) {
            System.out.println("Error writing to file " + f.getName() + " NOT FOUND" + ex.getMessage());
        }
    }

    public static void readQuestionsFromFile(File f, ArrayList<Question> questions) {
        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                questions.add(new Question(scanner.next(), scanner.next().charAt(0)));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println(" ");
        }
    }
    public static <T extends User> void writeNewUser(File f, T newUser) {
        try (FileWriter writer = new FileWriter(f, true)) {
            writer.write(newUser.getName() + " " + newUser.getPassword() + " " + newUser.getId() + " " + newUser.getRole() + "\n");
        } catch (IOException ex) {
            System.out.println("Error writing to file " + f.getName() + " NOT FOUND" + ex.getMessage());
        }
    }

    public static <T extends User> void readSavedUsersFromFile(File f, ArrayList<T> users, Class<T> userType) {
        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                if (userType == Student.class) {
                    users.add(userType.cast(new Student(scanner.next(), scanner.next(), Integer.parseInt(scanner.next()), scanner.next())));
                } else if (userType == Lecturer.class) {
                    users.add(userType.cast(new Lecturer(scanner.next(), scanner.next(), Integer.parseInt(scanner.next()), scanner.next())));
                } else if (userType == Admin.class) {
                    users.add(userType.cast(new Admin(scanner.next(), scanner.next(), Integer.parseInt(scanner.next()), scanner.next())));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println(" ");
        }
    }

}
