package manager;

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

public class SuggestionManager extends SuggestionDatabase implements Savable {
    private SuggestionDatabase suggestionDatabase;

    // linking with suggestion database
    public SuggestionManager() throws ClassNotFoundException, IOException {
        suggestionDatabase = new database.SuggestionDatabase();

    }

    public boolean addSuggestion(Camp camp, Suggestion suggestion, User user)
            throws IOException, ClassNotFoundException {
        if (suggestion != null) {

            // Create a new Suggestion

            int newSuggestionID = suggestionDatabase.generateNewID();

            Suggestion newSuggestion = new Suggestion(user, camp.getID(), suggestion.getDescription(),
                    newSuggestionID);

            // Add the suggestion to the database
            suggestionDatabase.add(newSuggestion);
            suggestionDatabase.save(); // Update the suggestions in the database
            return true;
        }
        return false;
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

}
