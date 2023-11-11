package manager;

import java.io.IOException;

import database.SuggestionDatabase;
import model.Query;
import model.Suggestion;
import model.User;
import model.Camp;

public class QueryManager extends SuggestionDatabase {
    private SuggestionDatabase queryDatabase;
 
    // linking with suggestion database 
    public QueryManager() throws ClassNotFoundException, IOException {
        queryDatabase = new database.SuggestionDatabase();
        
    }

     public boolean addQuery(Camp camp, Query query) throws IOException, ClassNotFoundException {
        if (query != null) {

            // Create a new query
            Query newQuery = new Query(query.getUserId(), camp.getId(), query.getDescription(), queryDatabase);

            // Add the query to the database
            // queryDatabase.add(newQuery);
            queryDatabase.save(); // Update the queries in the database
            return true;
        }
        return false;
    }

    // delete by queryID
    public boolean deleteByQueryID(Query query) throws IOException, ClassNotFoundException {
        if (query != null){
            int i = 0;
            while (i < queryDatabase.getAll().size()) {
                if (query.getId() == queryDatabase.getAll().get(i).getSuggestionID()) {
                    queryDatabase.getAll().remove(i);
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
            queryDatabase.remove(queryDatabase.findByID(camp.getId()));
        }
        return false;
    }

    public boolean editQuery(Camp camp, User user, Query query, String editedQuery) throws ClassNotFoundException, IOException {

    int i = 0;
    	while (i < queryDatabase.getAll().size()) {
    		if (query.getId() == queryDatabase.getAll().get(i).getId()) {
    			// Query newQuery = new Query(user.getId(), camp.getId(), editedQuery, queryDatabase);
    			// queryDatabase.getAll().set(i, newQuery);
    			return true; //returns true if successful
    		}
    		i++;
    	}
    	
        return false;
}

public boolean viewQueryByID(int queryId) throws IOException, ClassNotFoundException{
    if (queryDatabase.findByID(queryId) != null)
        System.out.println(queryDatabase.findByID(queryId).getDescription());
    return false;
}

public boolean replyQueryByID(int queryId) throws IOException, ClassNotFoundException{
    //
    return false;
}

    


}
/*
 A staff can view and reply to enquiries from students to the camp(s) his/her has created.
A student can submit enquiries regarding a camp.
    o Only staff and camp committees in charge of that camp can view it.
A student can view, edit, and delete their enquiries before it is processed.
A camp committee member can view and reply to enquiries from students to the camp they oversee.
 */