package manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.SuggestionDatabase;
import model.Suggestion;
import model.User;
import model.Camp;

public class SuggestionManager extends SuggestionDatabase {
    private SuggestionDatabase suggestionDatabase;
    private List<Suggestion> suggestions;
    private Map<Integer, List<Suggestion>> list_suggestion = new HashMap<>();

    public SuggestionManager() throws ClassNotFoundException, IOException {
        suggestionDatabase = new database.SuggestionDatabase();
        suggestions = getAll(); // Load existing suggestions from the database
        
    }

    // Add suggestion
    public boolean addSuggestion(Camp camp, Suggestion suggestion, User user) throws IOException {
        if (camp != null && suggestion != null) {
            // Create a new Suggestion
            Suggestion newSuggestion = new Suggestion(user, camp.getId(), suggestion.getDescription(), suggestionDatabase);

            // Add the suggestion to the list associated with the camp
            list_suggestion.computeIfAbsent(camp.getId(), k -> new ArrayList<>()).add(newSuggestion);

            // Add the suggestion to the database
            suggestions.add(newSuggestion);
;           suggestionDatabase.add(suggestions);
            save(); // Update the suggestions in the database
            return true;
        }
        return false;
    }

    // Delete suggestion - you can add a delete method if needed

    // Other methods...

    // Save changes to the database
    private void save() throws IOException {
        setAll(suggestions);
    }
}
