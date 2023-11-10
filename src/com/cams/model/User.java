package model;

public abstract class User extends Model {
	private int id;
    private String userID;
    private String faculty;
    private String password;
    
    public User() {}
    public User(String userID, String faculty) {
    	this.userID = userID;
    	this.faculty = faculty;
    }

    protected void changePassword(String oldPassword,String newPassword){
        if(oldPassword.equals(this.password)){
            this.password = newPassword;
        }
    }

    public abstract UserType getType();
    
    @Override
    public int getId() { return id; }
    public String getUserId() { return userID; }
    public void setUserId(String id) { this.userID = id; }
    
    public String getPassword() { return this.password==null?"":password; }
    public void setPassword(String password) { this.password = password; }


    public String getFaculty() { return this.faculty; }
    public void setFaculty(String faculty) { this.faculty = faculty; }
}