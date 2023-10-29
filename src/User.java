class User{
    private String password;
    private String userID;
    private int id;
    private Permission permission;

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