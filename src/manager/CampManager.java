package manager;


import java.util.ArrayList;
import java.util.List;
import model.Camp;
import model.CampInfo;
import java.util.Date;
import java.util.List;

import model.Student;

public class CampManager {
	
	private List<Camp> camps;
	private int totalCamps;
	
	public CampManager() {
	    camps = new ArrayList<Camp>();
	}
	

    
    public boolean createCamp(CampInfo campInfo) { //does not check if campInfo contains valid information
    	//Initializes a temporary Camp(campInfo) object, appends it to the end of the ArrayList camps 
    	
    	if (campInfo != null) {
    		Camp tempCamp = new Camp(campInfo);
    		camps.add(tempCamp);
    		totalCamps++;
    		return true; //returns true if successful
    	}
    	else {
    		return false; //returns false if campInfo is null
    	}

    }

    public boolean deleteCamp(int deleteId) {
        //Iterating through the ArrayList of camp objects 
    	//Finds the index of the camp with the deleteId, calls .remove(index) to remove it
    	
    	int i = 0;
    	while (i < camps.size()) {
    		if (deleteId == camps.get(i).getId()) {
    			camps.remove(i);
    			return true;
    		}
    		i++;
    	}
        return false; //returns false when unable to find the camp to be deleted
    }

    public boolean editCamp(int campID, CampInfo campInfo) {
        //Iterates through the ArrayList to find index of the campID to be edited
    	//Uses the .set() method to replace with the new campInfo
    	
    	int i = 0;
    	while (i < camps.size()) {
    		if (campID == camps.get(i).getId()) {
    			Camp tempCamp = new Camp(campInfo);
    			camps.set(i, tempCamp);
    			return true; //returns true if successful
    		}
    		i++;
    	}
    	
        return false; //returns false when unable to find camp with the inputed campID
    }

    //Should this method be in student class?
    //Unable to access the private List<Integer> camps
    //Alternatively, we could do an occupiedDates variable for the Student class, compare against the dates of camp under camp info (might need another method in Camp/CampInfo Class)
    public boolean checkClash(Student student, Camp camp) {
    	//Checks whether the student is able to go for the camp
    	return false; 
    }
    
    //Not sure what this method is supposed to do
    public boolean updateSlot(int campID, int number) {
        
        return false;
    }

    
    public void toggleVisibility(int campID, boolean boolValue) {
        
    	//In order to add this method, I added another method,setVisibility() into the Camp class
    	//This method might not be reflected in the other branches (Added here just in case)
        /*
         public void setVisbility(boolean visible) {
        	if (visible == true) {
        		this.visibility = true;
        	}
        	else {
        		this.visibility = false;
        	}
        }
         */
    	
    	int i = 0;
    	while (i < camps.size()) {
    		if (campID == camps.get(i).getId()) {
    			camps.get(i).setVisibility(boolValue);
    		}
    		i++;
    	}
    	
    	return;
    }

    public Camp getCampById(int campID) {
        
    	int i = 0;
    	while (i < camps.size()) {
    		if (campID == camps.get(i).getId()) {
    			return camps.get(i);
    		}
    	}
    	
        return null; //Returns null if unable to find
    }
}
