package UserTypes;

public class Lecturer extends User{
    public Lecturer() {
    }
    public Lecturer(String name, String pass, int id, String role) {
        super(name, pass, id, role);
    }

    @Override
    public int generateId() {
        return 0;
    }
}
