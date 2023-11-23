package manager;

import java.io.FileNotFoundException;
import java.io.IOException;

import database.SuggestionDatabase;
import model.Camp;
import model.Suggestion;
import model.User;

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

    public Suggestion addSuggestion(Suggestion suggestion)
            throws IOException, ClassNotFoundException {

		int newSuggestionID = suggestionDatabase.suggestID();

		suggestion.setID(newSuggestionID);
		// Add the suggestion to the database
		suggestionDatabase.add(suggestion);
		return suggestion;
    }

    // delete by sugestionID
    public boolean deleteBySuggestionID(Suggestion suggestion) throws IOException, ClassNotFoundException {
        if (suggestion != null) {
            int i = 0;
            while (i < suggestionDatabase.getAll().size()) {
                if (suggestion.getSuggestionID() == suggestionDatabase.getAll().get(i).getSuggestionID()) {
                    suggestionDatabase.getAll().remove(i);
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    // delete by campID
    public boolean deleteByCampID(Camp camp) throws IOException, ClassNotFoundException {
        if (camp != null) {
            suggestionDatabase.remove(suggestionDatabase.findByID(camp.getID()));
        }
        return false;
    }

    public Suggestion editSuggestion(Camp camp, User user, Suggestion suggestion, String editedSuggest)
            throws ClassNotFoundException, IOException {

        // Create a new Suggestion
        Suggestion newSuggestion = new Suggestion(user, camp.getID(), editedSuggest, suggestion.getSuggestionID());

        return newSuggestion;
    }

    // right now, newSuggest is made to be uploaded in the database only if accessed
    // by staff. (newSuggest == return value of editedSuggestion)
    public boolean approveChange(Suggestion oldSuggest, Suggestion newSuggest)
            throws IOException, ClassNotFoundException {
        if (oldSuggest != null && newSuggest != null) {
            suggestionDatabase.update(oldSuggest, newSuggest);
            return true;
        }
        return false;
    }

    public boolean viewSuggestionByID(int suggestionID) throws IOException, ClassNotFoundException {
        if (suggestionDatabase.findByID(suggestionID) != null)
            System.out.println(suggestionDatabase.findByID(suggestionID).getDescription());
        return false;
    }

    public boolean viewSuggestionChanges(Suggestion suggestion) throws IOException, ClassNotFoundException {
        if (suggestion.getChanges() != null) {

            System.out.println(suggestion.getChanges());
            return true;
        }
        return false;
    }

	@Override
	public void save() throws IOException, FileNotFoundException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
