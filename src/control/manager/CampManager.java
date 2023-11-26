package control.manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import control.database.CampDatabase;
import entity.Registrable;
import entity.model.Camp;
import entity.model.CampInfo;
import entity.model.Faculty;

/**
 * CampManager is a manager class that manages the camps.
 * It is used to create, update, delete, and get camps.
 * It is also used to get all camps and get camps by eligibility.
 */
public class CampManager implements Savable {

	public CampDatabase campDatabase;

	/**
	 * Constructor for the CampManager class.
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public CampManager() throws ClassNotFoundException, IOException {
		campDatabase = new CampDatabase();
	}

	/**
	 * Creates a camp.
	 * 
	 * @param campInfo The CampInfo object.
	 * @return The Camp object.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public Camp createCamp(CampInfo campInfo) throws ClassNotFoundException, IOException { // does not check if campInfo
																							// contains valid
																							// information
		int id = campDatabase.suggestID();
		campInfo.setID(id);
		Camp camp = new Camp(campInfo);
		campDatabase.add(camp);
		return camp;
	}

	/**
	 * Updates a camp.
	 * 
	 * @param original The original Camp object.
	 * @param modified The modified Camp object.
	 * @return The boolean value of whether the camp is updated.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public boolean updateCamp(Camp original, Camp modified) throws ClassNotFoundException, IOException {
		return campDatabase.update(original, modified);
	}

	/**
	 * Deletes a camp.
	 * 
	 * @param camp The Camp object.
	 * @return The boolean value of whether the camp is deleted.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public boolean deleteCamp(Camp camp) throws ClassNotFoundException, IOException {
		return campDatabase.remove(camp);
	}

	/**
	 * Gets a camp by ID.
	 * 
	 * @param campID The camp ID.
	 * @return The Camp object.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public Camp getCampByID(int campID) throws ClassNotFoundException, IOException {
		return campDatabase.findByID(campID);
	}

	/**
	 * Gets all camps by the user.
	 * 
	 * @param user The Registrable object.
	 * @return The list of Camp objects.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public List<Camp> getRegisteredCamps(Registrable user) throws ClassNotFoundException, IOException {
		List<Camp> res = new ArrayList<>();
		for (Camp camp : campDatabase.getAll())
			if (user.isRegistered(camp))
				res.add(camp);
		return res;
	}

	/**
	 * Gets all camps.
	 * 
	 * @return The list of Camp objects.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public List<Camp> getAllCamps() throws ClassNotFoundException, IOException {
		return campDatabase.getAll();
	}

	/**
	 * Gets all camps by eligibility.
	 * 
	 * @param eligibility The Faculty object.
	 * @return The list of Camp objects.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public List<Camp> getCampsByEligibility(Faculty eligibility) throws ClassNotFoundException, IOException {

		List<Camp> eligibleCampArr = new ArrayList<Camp>();
		for (Camp camp : campDatabase.getAll()) {
			if (!camp.getVisibility())
				continue;
			Faculty fac = camp.getInformation().getEligibility();
			if (fac == eligibility || fac == Faculty.SCHOOL) {
				eligibleCampArr.add(camp);
			}
		}
		return eligibleCampArr;
	}

	@Override

	/**
	 * Saves the camp database.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */

	public void save() throws IOException, FileNotFoundException, ClassNotFoundException {
		this.campDatabase.save();
	}
}
