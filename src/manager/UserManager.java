package manager;

import java.io.IOException;

import database.StaffDatabase;
import database.StudentDatabase;
import model.Faculty;
import model.Staff;
import model.Student;
import model.User;

public class UserManager {
	
    private StudentDatabase studentDatabase;
    private StaffDatabase staffDatabase;
    
	//
    public UserManager() throws ClassNotFoundException, IOException{
    	studentDatabase = new StudentDatabase();
    	staffDatabase = new StaffDatabase();
    }
    
    //
    public UserManager(StudentDatabase curStudentDatabase, StaffDatabase curStaffdatabase){
    	studentDatabase = curStudentDatabase;
    	staffDatabase = curStaffdatabase;
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
    
    public boolean removeUser(User user) {
    	try {
    		switch(user.getType()) {
			case STAFF:
				staffDatabase.remove((Staff) user);
				return true;
			case STUDENT:
				studentDatabase.remove((Student) user);
				return true;
			default:
				throw new IllegalArgumentException(user.getType().toString());
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        return false;
    }
    
    public boolean editUser(User newUser, User currentUser) {
    	try {
    		switch(currentUser.getType()) {
			case STAFF:
				if (newUser.getType() == currentUser.getType()) {
					staffDatabase.update((Staff)currentUser, (Staff)newUser);
					return true;
				}
			case STUDENT:
				if(newUser.getType() == currentUser.getType()) {
					studentDatabase.update((Student)currentUser,(Student) newUser);;
					return true;
				}
			default:
				throw new IllegalArgumentException(currentUser.getType().toString());
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        return false;
    }
    
    public User getUserByID(int id) {
    	// TODO
    	return new Staff(0, "iwi", Faculty.SCSE, "HEHEHAHA");
    }
    
    public User getUserByID(String userID) throws ClassNotFoundException, IOException {
    	
    	return new Staff(0, "iwi", Faculty.SCSE, "HEHEHAHA");
    	
    	/*
    	int i = 0;
    	
    	while (i < studentDatabase.getAll().size()) {
    		if (userID == studentDatabase.getAll().get(i).getUserId()) {
    			return studentDatabase.getAll().get(i);
    		}
    	}
    	
    	i = 0;
    	
    	while (i < staffDatabase.getAll().size()) {
    		if (userID == staffDatabase.getAll().get(i).getUserId()) {
    			return staffDatabase.getAll().get(i);
    		}
    	}
    	
    	return null;
    	*/

    }
    
}
