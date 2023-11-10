package com.cams.manager;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import model.Suggestion;

import database.SuggestionDatabase;

public class SuggestionManager extends SuggestionDatabase  {
    private SuggestionDatabase suggestionDatabase;
    private Map<Integer, List<Suggestion>> list_suggestion = new HashMap()
    public SuggestionManager() throws ClassNotFoundException, IOException {
        suggestionDatabase = new database.SuggestionDatabase();
    }
    //add suggestion

    public boolean addSuggestion(model.Camp camp){

        for ()

        if (suggestion != null)
        {
            model.Suggestion temp = new Suggestion(
                    suggestion.getUser(),
                    suggestion.getCampID(),
                    suggestion.getDescription(),
                    suggestionDatabase
            );


            suggestionDatabase.setAll(temp);
            return true;
        }
        return false;
    }
}



    //delete suggestion

