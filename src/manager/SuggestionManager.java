package manager;

import model.*;

import java.util.List;

public class SuggestionManager {
    private ArrayList<Suggestion> suggestions;
    private ArrayList<suggestions> list_suggestion = new ArrayList<>();
    private int s_id;

    public Suggestion createSuggestion(Student user, Camp camp, List<Change> changes) {
        suggestions = new ArrayList<>();
        suggestions.add(s_id);
        list_suggestion.add(camp.getId());
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
        this.s_id = suggestionID;
        // Implement the method
        return null;
    }

    public boolean approveSuggestion(Staff staff, Suggestion suggestion) {
        // Implement the method
        return false;
    }
}