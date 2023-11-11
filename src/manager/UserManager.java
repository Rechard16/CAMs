package manager;

import database.StaffDatabase;
import database.StudentDatabase;
import model.Faculty;
import model.Staff;
import model.Student;
import model.User;

public class UserManager {
	
    private StudentDatabase studentDatabase;
    private StaffDatabase staffDatabase;
    
	
    public UserManager(){
    }

    public boolean addUser(User user) {
    	try {
    		switch(user.getType()) {
			case STAFF:
				staffDatabase.add((Staff) user);
				return true;
			case STUDENT:
				studentDatabase.add((Student) user);
				return true;
			default:
				throw new IllegalArgumentException(user.getType().toString());
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        return false;
    }
    
   
	// TODO
    public User getUserByID(String userID) {
    	return new Student(0, "iwi", Faculty.SCSE, "uwu", 2);
    }
}
