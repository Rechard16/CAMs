package manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import database.CampDatabase;
import model.Camp;
import model.CampInfo;
import model.Faculty;

public class CampManager {
	
	public CampDatabase campdatabase;
	
	
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

    public boolean deleteCampByObject(Camp campObject) throws IOException, ClassNotFoundException {
        //Iterating through the ArrayList of camp objects 
    	//Finds the index of the camp with the deleteId, calls .remove(index) to remove it
    	
    	int i = 0;
    	while (i < campdatabase.getAll().size()) {
    		if (campObject.getId() == campdatabase.getAll().get(i).getId()) {
    			campdatabase.getAll().remove(i);
    			return true;
    		}
    		i++;
    	}
        return false; //returns false when unable to find the camp to be deleted
    }
    
    public boolean editCampByObject(Camp oldCamp, Camp newCamp) throws ClassNotFoundException, IOException {
    	campdatabase.update(oldCamp, newCamp);
    	return false;
    }
    
    public boolean deleteCampByID(int campID) throws IOException, ClassNotFoundException {
        //Iterating through the ArrayList of camp objects 
    	//Finds the index of the camp with the deleteId, calls .remove(index) to remove it
    	int i = 0;
    	while (i < campdatabase.getAll().size()) {
    		if (campID == campdatabase.getAll().get(i).getId()) {
    			campdatabase.getAll().remove(i);
    			return true;
    		}
    		i++;
    	}
        return false; //returns false when unable to find the camp to be deleted
    }
    
    public boolean editCampbyID(int campID, CampInfo campInfo) throws IOException, ClassNotFoundException {
        //Iterates through the ArrayList to find index of the campID to be edited
    	//Uses the .set() method to replace with the new campInfo
    	
    	int i = 0;
    	while (i < campdatabase.getAll().size()) {
    		if (campID == campdatabase.getAll().get(i).getId()) {
    			Camp tempCamp = new Camp(campInfo);
    			campdatabase.getAll().set(i, tempCamp);
    			return true; //returns true if successful
    		}
    		i++;
    	}
    	
        return false; //returns false when unable to find camp with the inputed campID
    }
  
    public void toggleVisibilityByID(int campID, boolean boolValue) throws ClassNotFoundException, IOException {
    	
    	int i = 0;
    	while (i < campdatabase.getAll().size()) {
    		if (campID == campdatabase.getAll().get(i).getId()) {
    			campdatabase.getAll().get(i).setVisibility(boolValue);
    		}
    		i++;
    	}
    	
    	return;
    }

    public Camp getCampByID(int campID) throws ClassNotFoundException, IOException {
        
    	int i = 0;
    	while (i < campdatabase.getAll().size()) {
    		if (campID == campdatabase.getAll().get(i).getId()) {
    			return campdatabase.getAll().get(i);
    		}
    		i++;
    	}
    	
        return null; //Returns null if unable to find
    }
    
    
    public List<Camp> getAllCamps() throws ClassNotFoundException, IOException{
    	return campdatabase.getAll();
    }
    
    public List<Camp> getCampsByEligibility(Faculty eligibility) throws ClassNotFoundException, IOException{
    	
    	List <Camp> EligibleCampArr = new ArrayList<Camp>();
    	for (Camp camp: campdatabase.getAll()) {
    		Faculty fac = camp.getInformation().getEligibility();
    		if (fac == eligibility || fac == Faculty.SCHOOL) {
    			EligibleCampArr.add(camp);
    		}
    	}
		return EligibleCampArr;
    }
 
}
