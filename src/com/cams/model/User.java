package model;

public abstract class User extends Model {
	private int id;
    private String userID;
    private Faculty faculty;
    private String password;
    
    public User() {}

    public User(int id, String userID, Faculty faculty, String password) {
    	this.id = id;
    	this.userID = userID;
    	this.faculty = faculty;
    	this.password = password;
    }

    protected void changePassword(String oldPassword,String newPassword){
        if(oldPassword.equals(this.password)){
            this.password = newPassword;
        }
    }

    public abstract UserType getType();
    
    @Override
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUserId() { return userID; }
    public void setUserId(String id) { this.userID = id; }
    
    public String getPassword() { return this.password==null?"":password; }
    public void setPassword(String password) { this.password = password; }


    public Faculty getFaculty() { return this.faculty; }
    public void setFaculty(Faculty faculty) { this.faculty = faculty; }
}