package UserTypes;

import java.util.ArrayList;

public abstract class User {
    private int id;
    private String password;
    private String name;
    private String role;
    final int idParser = 1000;
    public static final String[] subjects = new String[]{"Data Communications", "Data Structures", "Database", "Logic Design", "Programming Languages 2"};

    public User(){
        //TODO
    }
    public User(String name, String pass, int id, String role){
        setName(name);
        setPassword(pass);
        setId(id);
        setRole(role);
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public abstract int generateId();
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public int getLargestId(ArrayList<? extends User> users){
        int largestId = 0;
        for (User user : users) {
            if (user.getId() > largestId) {
                largestId = user.getId();
            }
        }
        return Math.max(largestId, 0);
    }
    public static User getUserById(int id, ArrayList<? extends User> users){
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

}
