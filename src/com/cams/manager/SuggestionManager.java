package com.cams.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.cams.model.Suggestion;
import com.cams.model.Camp;

import database.SuggestionDatabase;
import model.Suggestion;

public class SuggestionManager extends SuggestionDatabase  {
    private SuggestionDatabase suggestionDatabase;

    //constructor
    public SuggestionManager(){
        this.suggestionDatabase = new SuggestionDatabase();
    }

    // add suggestion
    public boolean addSuggestion(model.Suggestion suggestion){
        if (suggestion != null)
        {
            model.Suggestion temp = new Suggestion(suggestion);
            suggestionDatabase.add(temp);
            return true;
        }
        return false;
    }

}