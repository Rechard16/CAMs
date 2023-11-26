package manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import database.SuggestionDatabase;
import model.CampInfoModifier;
import model.Suggestion;
import model.SuggestionStatus;

/* 
 * SuggestionManager is a manager class that manages the suggestions.
 * It is used to create, update, delete, and get suggestions.
 * It is also used to get suggestions by camp.
 */
public class SuggestionManager implements Savable {
	private SuggestionDatabase suggestionDatabase;

	/*
	 * Constructor for SuggestionManager.
	 * 
	 * @throws ClassNotFoundException
	 * 
	 * @throws IOException
	 */

	public SuggestionManager() throws ClassNotFoundException, IOException {
		suggestionDatabase = new database.SuggestionDatabase();
	}

	/*
	 * Creates a suggestion.
	 * 
	 * @param userID The ID of the user who created the suggestion.
	 * 
	 * @param campID The ID of the camp that the suggestion is for.
	 * 
	 * @param description The description of the suggestion.
	 * 
	 * @param modifier The modifier of the suggestion.
	 * 
	 * @return The suggestion that was created.
	 * 
	 * @throws IOException
	 * 
	 * @throws ClassNotFoundException
	 */

	public Suggestion createSuggestion(int userID, int campID, String description,
			CampInfoModifier modifier) throws IOException, ClassNotFoundException {

		int newSuggestionID = suggestionDatabase.suggestID();

		Suggestion suggestion = new Suggestion(userID, campID, modifier, description, newSuggestionID);
		suggestionDatabase.add(suggestion);
		return suggestion;
	}

	/*
	 * get a suggestion by id
	 * 
	 * @param suggestionID the id of the suggestion
	 * 
	 * @return the suggestion
	 */

	public Suggestion getSuggestion(int suggestionID) throws IOException, ClassNotFoundException {
		return suggestionDatabase.findByID(suggestionID);
	}
	/*
	 * delete a suggestion
	 * 
	 * @param suggestion the suggestion to be deleted
	 * 
	 */

	public boolean deleteSuggestion(Suggestion suggestion) throws ClassNotFoundException, IOException {
		return suggestionDatabase.remove(suggestion);
	}

	/*
	 * delete a suggestion
	 * 
	 * @param id the id of the suggestion to be deleted
	 * 
	 */

	public boolean deleteSuggestion(int id) throws IOException, ClassNotFoundException {
		Suggestion obj = suggestionDatabase.findByID(id);
		if (obj == null)
			return false;
		suggestionDatabase.remove(obj);
		return true;
	}

	/*
	 * get suggestions by camp
	 * 
	 * @param campID the id of the camp
	 * 
	 * @param userID the id of the user
	 * 
	 * @return the list of suggestions
	 * 
	 * @throws ClassNotFoundException
	 * 
	 * @throws IOException
	 * 
	 * @throws FileNotFoundException
	 */

	public List<Suggestion> getSuggestionsByCamp(int campID, int userID) throws ClassNotFoundException, IOException {
		return suggestionDatabase.getAll().stream().filter(i -> i.getCampID() == campID &&
				i.getUserID() == userID).toList();
	}

	/*
	 * get suggestions by camp
	 * 
	 * @param campID the id of the camp
	 * 
	 * @return the list of suggestions
	 * 
	 * @throws ClassNotFoundException
	 * 
	 * @throws IOException
	 * 
	 * @throws FileNotFoundException
	 */

	public List<Suggestion> getSuggestionsByCamp(int campID) throws ClassNotFoundException, IOException {
		return suggestionDatabase.getAll().stream().filter(i -> i.getCampID() == campID &&
				i.getStatus() == SuggestionStatus.OPEN).toList();
	}

	@Override

	/*
	 * Saves the suggestion database.
	 * 
	 * @throws IOException
	 * 
	 * @throws FileNotFoundException
	 * 
	 * @throws ClassNotFoundException
	 */
	public void save() throws IOException, FileNotFoundException, ClassNotFoundException {
		suggestionDatabase.save();
	}

}
