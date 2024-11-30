public class Student extends User{
    public Student(int id, String password) {
        super(id, password);
        canTakeExams = false;
    }

}
