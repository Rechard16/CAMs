package manager;

import model.*;

import java.util.List;

public class SuggestionManager {
    private List<Suggestion> suggestions; //list containing suggestionIDs;
    private Map<Integer, List<Suggestion>> list_suggestion = new HashMap() // mapping each 'suggestions' to campID
    private int s_id;

    public Suggestion createSuggestion(Student user, Camp camp, List<Change> changes) {

        // first time creating suggestion
        if (!list_suggestion.containsKey(camp.getId())) {
            suggestions = new ArrayList<>();
        }

        // adding suggestion to the 'suggestions' list
        suggestions = list_suggestion.get(camp.getId());
        suggestions.add(s_id);

        // updating 'suggestions' list under same campId
        list_suggestion.put(camp.getId(), suggestions);
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