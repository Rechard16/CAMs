package manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Camp;
import model.CampInfo;
import database.CampDatabase;

import java.util.Date;


import model.Student;

public class CampManager {
	
	private CampDatabase campdatabase;
	
	public CampManager() throws ClassNotFoundException, IOException {
	    campdatabase = new CampDatabase();
	}
	
    public boolean createCamp(CampInfo campInfo) throws ClassNotFoundException, IOException { //does not check if campInfo contains valid information
    	if (campInfo != null) {
    		Camp tempCamp = new Camp(campInfo);
    		campdatabase.add(tempCamp);
    		return true; //returns true if successful
    	}
    	else {
    		return false; //returns false if campInfo is null
    	}

    }

    //Not the remove() method from the CampDatabase Class, using remove() from java.util
    public boolean deleteCampByObject(Camp campObject) {
        //Iterating through the ArrayList of camp objects 
    	//Finds the index of the camp with the deleteId, calls .remove(index) to remove it
    	
    	int i = 0;
    	while (i < campdatabase.getList().size()) {
    		if (campObject.getId() == campdatabase.getList().get(i).getId()) {
    			campdatabase.getList().remove(i);
    			return true;
    		}
    		i++;
    	}
        return false; //returns false when unable to find the camp to be deleted
    }
    
    public boolean updateCampByObject(Camp oldCamp, Camp newCamp) throws ClassNotFoundException, IOException {
    	campdatabase.update(oldCamp, newCamp);
    	return false;
    }
  
    public void toggleVisibility(int campID, boolean boolValue) throws ClassNotFoundException, IOException {
    	
    	int i = 0;
    	while (i < campdatabase.getAll().size()) {
    		if (campID == campdatabase.getAll().get(i).getId()) {
    			campdatabase.getAll().get(i).setVisibility(boolValue);
    		}
    		i++;
    	}
    	
    	return;
    }

    public Camp getCampById(int campID) throws ClassNotFoundException, IOException {
        
    	int i = 0;
    	while (i < campdatabase.getAll().size()) {
    		if (campID == campdatabase.getAll().get(i).getId()) {
    			return campdatabase.getAll().get(i);
    		}
    	}
    	
        return null; //Returns null if unable to find
    }
    
    /*
    public boolean editCampbyID(int campID, CampInfo campInfo) {
        //Iterates through the ArrayList to find index of the campID to be edited
    	//Uses the .set() method to replace with the new campInfo
    	
    	int i = 0;
    	while (i < campdatabase.getList().size()) {
    		if (campID == campdatabase.getList().get(i).getId()) {
    			Camp tempCamp = new Camp(campInfo);
    			campdatabase.getList().set(i, tempCamp);
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
    */
}
