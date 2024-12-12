package UserTypes;

import java.util.ArrayList;

public abstract class User {
    private int id;
    private String password;
    private String name;
    private String phoneNumber;
    private String role;
    private boolean canTakeExams;
    private static String[] subjects = new String[]{"Data Communications", "Data Structures", "Database", "logic Design", "Programming Languages 2"};
    private static final int currentSchoolYear = 2023 * 10000;

    public User(){
        //TODO
    }
    public User(String name, String pass, int id, String role){
        setName(name);
        setPassword(pass);
        setId(id);
        setRole(role);
    }

    public boolean getCanTakeExams() {
        return canTakeExams;
    }
    public void setCanTakeExams(boolean canTakeExams) {
        this.canTakeExams = canTakeExams;
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
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public int getLargestId(ArrayList<? extends User> users){
        int largestId = 0;
        for (User user : users) {
            if (user.getId() > largestId) {
                largestId = user.getId();
            }
        }
        return Math.max(largestId - currentSchoolYear, 0);
    }

}
