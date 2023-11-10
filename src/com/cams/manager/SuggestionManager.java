package manager;

public class SuggestionManager {
	/*
    private List<Suggestion> suggestions; //list containing suggestionIDs;
    private Map<Integer, List<Suggestion>> list_suggestion = new HashMap() // mapping each 'suggestions' to campID
    private int s_id;

    public Suggestion createSuggestion(Student user, Camp camp, List<Change> changes) {

        // first time creating suggestion
        if (!list_suggestion.containsKey(camp.getId())) {
            suggestions = new ArrayList<>();
        }

        // adding suggestion to the 'suggestions' list
        if (s_id != null){
            suggestions = list_suggestion.get(camp.getId());
            suggestions.add(s_id);

            // updating 'suggestions' list under same campId
            list_suggestion.put(camp.getId(), suggestions);
        }
        return null;
    }

    // needs to be divided into 2 seperate methods
    // needs to have 'Camp camp' as a parameter for both cases
    public boolean deleteSuggestion(int suggestionID) {
        // if camp itself is removed
        list_suggestion.remove(camp.getId());

        // if deleting 1 suggestion from 'suggestions' list
        Iterator<Suggestion> iterator = list_suggestion.get(camp.getId()).iterator()
        while (iterator.hasNext()) {
            Suggestion target = iterator.next();
            if (target.equals(suggestionID))
                iterator.remove();
        }
        return false;
    }

    // only if approveSuggestion is true
    public boolean editSuggestion(Suggestion suggestion, List<Change> changes) {
        if (){
            Iterator<Suggestion> iterator = list_suggestion.get(suggestion.campId).iterator()
            while (iterator.hasNext()) {
                Suggestion target = iterator.next();
                if (target.equals(suggestion.suggestionID))
                    suggestion.suggestionDatabase.update() //needs to know what parameters r required
            }
        }
        return false;
    }

    public Suggestion getSuggestionByID(int suggestionID) {
        this.s_id = suggestionID;
        return null;
    }

    public boolean approveSuggestion(Staff staff, Suggestion suggestion) {
        // Implement the method
        return false;
    }
    */
}