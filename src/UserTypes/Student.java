package UserTypes;

public class Student extends User {
    private static int idGenerator;
    public Student() {
        setCanTakeExams(true);
    }

    @Override
    public int generateId() {
        return Integer.parseInt("20230"+ String.format("%03d",++idGenerator));
    }


}
