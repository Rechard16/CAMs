package model;

import model.Permission;

public class User {
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
    protected void viewQuery(){}
    protected void viewCamps(){}
    protected void generateStudentList(){}
    protected void filterCamps(){}
}