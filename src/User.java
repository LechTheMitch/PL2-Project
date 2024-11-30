public class User {
    private int id;
    private String password;
    private String name;
    private String phoneNumber;
    public boolean canTakeExams;

    public User(int id, String password){
        //TODO
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
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

}
