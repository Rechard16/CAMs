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
 
    // linking with suggestion database 
    public SuggestionManager() throws ClassNotFoundException, IOException {
        suggestionDatabase = new database.SuggestionDatabase();
        
    }

    public boolean addSuggestion(Camp camp, Suggestion suggestion, User user) throws IOException, ClassNotFoundException {
        if (suggestion != null) {

            // Create a new Suggestion
            Suggestion newSuggestion = new Suggestion(user, camp.getId(), suggestion.getDescription(), suggestionDatabase);

            // Add the suggestion to the database
            suggestionDatabase.add(newSuggestion);
            suggestionDatabase.save(); // Update the suggestions in the database
            return true;
        }
        return false;
    }

    // delete by segestionID
    public boolean deleteBySuggestionID(Suggestion suggestion) throws IOException, ClassNotFoundException {
        if (suggestion != null){
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
        if (camp != null){
            suggestionDatabase.remove(suggestionDatabase.findByID(camp.getId()));
        }
        return false;
    }


    public boolean editSuggestion(Camp camp, Suggestion suggestion, User user) throws IOException, ClassNotFoundException{

        if (suggestion != null){

            //create empty suggestion template
            Suggestion newSuggestion = new Suggestion(user, camp.getId(), suggestion.getDescription(), suggestionDatabase);

            suggestionDatabase.findByID(suggestion.getSuggestionID());
            
            //delete original suggestion
            deleteSuggestion(suggestion);

            //replace with edited suggestion
            addSuggestion(camp, newSuggestion, user);

            return true;
        }
            
        return false;
    }

    public boolean submitSuggestion() throws IOException, ClassNotFoundException{

        return false;
    }

    public boolean approveChange()throws IOException, ClassNotFoundException {

        return false;
    }

    public boolean viewSuggestionByID(int suggestionID){

        return false;
    }

}


/*
 A staff can view and approve suggestions to changes to camp details from camp
committee
A camp committee member can submit suggestions for changes to camp details to staff
A camp committee member can view, edit, and delete the details of his/her
suggestions before being processed
 */