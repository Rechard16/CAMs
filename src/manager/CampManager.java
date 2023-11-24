package manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import database.CampDatabase;
import model.Camp;
import model.CampInfo;
import model.Faculty;
import model.Registrable;

public class CampManager implements Savable {
	
	public CampDatabase campDatabase;
	
	
	public CampManager() throws ClassNotFoundException, IOException {
	    campDatabase = new CampDatabase();
	}
	
    public Camp createCamp(CampInfo campInfo) throws ClassNotFoundException, IOException { //does not check if campInfo contains valid information
    	int id = campDatabase.suggestID();
    	campInfo.setID(id);
		Camp camp = new Camp(campInfo);
		campDatabase.add(camp);
		return camp;
    }
    
	public boolean updateCamp(Camp original, Camp modified) throws ClassNotFoundException, IOException {
    	return campDatabase.update(original, modified);
    }
	
	public boolean deleteCamp(Camp camp) throws ClassNotFoundException, IOException {
		return campDatabase.remove(camp);
	}
          
    public Camp getCampByID(int campID) throws ClassNotFoundException, IOException {
    	return campDatabase.findByID(campID);
    }
    
    public List<Camp> getRegisteredCamps(Registrable user) throws ClassNotFoundException, IOException {
    	List<Camp> res = new ArrayList<>();
    	for (Camp camp: campDatabase.getAll())
    		if (user.isRegistered(camp)) res.add(camp);
    	return res;
    }
    
    public List<Camp> getAllCamps() throws ClassNotFoundException, IOException{
    	return campDatabase.getAll();
    }
    
    public List<Camp> getCampsByEligibility(Faculty eligibility) throws ClassNotFoundException, IOException{
    	
    	List <Camp> eligibleCampArr = new ArrayList<Camp>();
    	for (Camp camp: campDatabase.getAll()) {
    		if (!camp.getVisibility()) continue;
    		Faculty fac = camp.getInformation().getEligibility();
    		if (fac == eligibility || fac == Faculty.SCHOOL) {
    			eligibleCampArr.add(camp);
    		}
    	}
		return eligibleCampArr;
    }

	@Override
	public void save() throws IOException, FileNotFoundException, ClassNotFoundException {
		this.campDatabase.save();
	}
}
