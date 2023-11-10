package model;

abstract public class User {
    protected String password;
    protected String userID;
    protected String faculty;
    protected int id;
    protected Permission permission;

    protected void changePassword(String oldPassword,String newPassword){
        if(oldPassword.equals(this.password)){
            this.password = newPassword;
        }
    }
    public abstract UserType getType();
    protected abstract void viewQuery();
    protected abstract void viewCamps();
    protected abstract void generateStudentList();
    protected abstract void filterCamps();
}