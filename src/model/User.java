package model;

import java.io.IOException;

public abstract class User extends Model {
    protected int id;
    protected String password;
    protected String userID;
    protected String faculty;

    protected Permission permission;

    protected void changePassword(String oldPassword,String newPassword){
        if(oldPassword.equals(this.password)){
            this.password = newPassword;
        }
    }


    public int getId() {
        return this.id;
    }

    protected abstract void viewQuery();
    protected abstract void viewCamps() throws IOException, ClassNotFoundException;
    protected abstract void generateStudentList();
    protected abstract void filterCamps();

}