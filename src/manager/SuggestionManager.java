package manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import database.SuggestionDatabase;
import model.CampInfoModifier;
import model.Suggestion;

/*
 * A staff can view and approve suggestions to changes to camp details from camp
 * committee
 * A camp committee member can submit suggestions for changes to camp details to
 * staff
 * A camp committee member can view, edit, and delete the details of his/her
 * suggestions before being processed
 */

public class SuggestionManager implements Savable {
    private SuggestionDatabase suggestionDatabase;

    public SuggestionManager() throws ClassNotFoundException, IOException {
        suggestionDatabase = new database.SuggestionDatabase();
    }

    public Suggestion createSuggestion(int userID, int campID, String description,
    		CampInfoModifier modifier) throws IOException, ClassNotFoundException {

		int newSuggestionID = suggestionDatabase.suggestID();

		Suggestion suggestion = new Suggestion(userID, campID, modifier, description, newSuggestionID); 
		suggestionDatabase.add(suggestion);
		return suggestion;
    }

    // delete by sugestionID
    public boolean deleteSuggestion(int id) throws IOException, ClassNotFoundException {
    	Suggestion obj = suggestionDatabase.findByID(id);
    	if (obj == null) return false;
    	suggestionDatabase.remove(obj);
    	return true;
	}
    
    public boolean deleteSuggestion(Suggestion suggestion) throws ClassNotFoundException, IOException {
    	return suggestionDatabase.remove(suggestion);
    }

    public Suggestion getSuggestion(int suggestionID) throws IOException, ClassNotFoundException {
        return suggestionDatabase.findByID(suggestionID);
    }
    
    public List<Suggestion> getSuggestionsByCamp(int campID) throws ClassNotFoundException, IOException {
    	return suggestionDatabase.getAll().stream().filter(i ->
    			i.getCampID() == campID).toList();
    }

	@Override
	public void save() throws IOException, FileNotFoundException, ClassNotFoundException {
		suggestionDatabase.save();
	}

}
