package manager;

import model.User;
import model.Student;
import model.Staff;
import java.util.List;
import java.util.ArrayList;

public class UserManager {
	
    private List<Staff> staffs;
    private List<Student> students;
    private List<User> users;
    
	
    public UserManager(){
    	staffs = new ArrayList<Staff>();
    	students = new ArrayList<Student>();
    	users = new ArrayList<User>(); //temporary
    }

    //Unable to find out user type currently (Student or Staff)
    //Supposed to find out through enum Permission from the User class?
    //Permission is a protected variable under user, unable to access without a get method
    //For now, using an ArrayList<User> to store the users
    public boolean addUser(User user) {
    	if (user != null && !users.contains(user)) {
    		users.add(user);
    		return true;
    	}
    	
        return false;
    }
    
    
    //Unable to access user's userID, protected variable
    //Requires a getUserID() method from user class
    /* 
     * public String getUserId() {
    	return this.userID;
    }
     */
    public boolean removeUser(String userID) {
    	int i = 0;
    	while (i < users.size()) {
    		if (userID.compareToIgnoreCase((users.get(i).getUserId())) == 0) { // Equals 0 when found, ignores case
    		//	if (userID.compareTo((users.get(i).getUserId())) == 0) { //Case sensitive Version
    			users.remove(i);
    			return true; //Returns true when found and removes
    		}
    		i++;
    	}
    	
        return false; //Returns false if unable to find
    }

    //Unable to access user's userID, protected variable
    //Requires a getUserID() method from user class
    public boolean editUser(User user) {
        int i=0;
        while (i < users.size()) {
        	if (user.getUserId().compareToIgnoreCase((users.get(i).getUserId())) == 0) {
        	// if (user.getUserId().compareTo(users.get(i).getUserId())) == 0) { //Case sensitive Version
        		users.set(i, user);
        		return true;
        	}
        	i++;
        }
        return false;
    }
    
    //Requires a getUserID() method from user class
    public User getUserByID(String userID) {
    	int i = 0;
    	while (i < users.size()) {
    		if (userID.compareToIgnoreCase((users.get(i).getUserId())) == 0) { // Equals 0 when found, ignores case
        	//	if (userID.compareTo((users.get(i).getUserId())) == 0) { //Case sensitive Version
    			return users.get(i); 
    		}
    		i++;
    	}
        return null; //Returns null if unable to find
    }

    public boolean checkCommittee(String studentID) {
        // Implement the method
        return false;
    }

    public boolean checkStaff(String staffID) {
        // Implement the method
        return false;
    }
    
    //Unable to access points variable from Student class as it is private
    //Not able to create an ArrayList of Student objects yet
    public boolean givePoint(Student student, int points) {
    	//To be implemented
        return false;
    }

    //Unable to implement fully, unable to access user Private variable Password from User class
    //getPassword() method as a placeholder for now
    public boolean loginUser(String userID, String password) {
    	int i = 0;
    	while (i < users.size()) {
    		if (userID.compareToIgnoreCase((users.get(i).getUserId())) == 0) { 
    			if (users.get(i).getPassword().compareTo(password) == 0) {
    				return true;
    			}
    			else {
    				return false;
    			}
    		}
    		i++;
    	}
        return false;
    }
}
