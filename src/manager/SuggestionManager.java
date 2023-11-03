package manager;

import model.Suggestion;
import model.CampCommitteeMember;
import model.Camp;
import model.Change;
import model.Staff;
import java.util.List;

public class SuggestionManager {
    private List<Suggestion> suggestions;

    public Suggestion createSuggestion(CampCommitteeMember user, Camp camp, List<Change> changes) {
        // Implement the method
        return null;
    }

    public boolean deleteSuggestion(int suggestionID) {
        // Implement the method
        return false;
    }

    public boolean editSuggestion(Suggestion suggestion, List<Change> changes) {
        // Implement the method
        return false;
    }

    public Suggestion getSuggestionByID(int suggestionID) {
        // Implement the method
        return null;
    }

    public boolean approveSuggestion(Staff staff, Suggestion suggestion) {
        // Implement the method
        return false;
    }
}