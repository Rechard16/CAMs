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
 

    public SuggestionManager() throws ClassNotFoundException, IOException {
        suggestionDatabase = new database.SuggestionDatabase();
        
    }

    // Add suggestion
    public boolean addSuggestion(Camp camp, Suggestion suggestion, User user) throws IOException, ClassNotFoundException {
        if ( suggestion != null) {
            // Create a new Suggestion
            Suggestion newSuggestion = new Suggestion(user, 98, suggestion.getDescription(), suggestionDatabase);

            // Add the suggestion to the database
            
;           suggestionDatabase.add(newSuggestion);
            suggestionDatabase.save(); // Update the suggestions in the database
            return true;
        }
        return false;
    }

    // Delete suggestion - you can add a delete method if needed

    // Other methods...

  
}
