package manager;

import model.Query;
import model.Student;
import model.Staff;
import model.Camp;
import java.util.List;

public class QueryManager {
    private List<Query> queries; //list containing queriesIDs
    private Map<Integer, List<Query>> list_query = new HashMap() // mapping each 'queries' to campID
    private int q_id;
    public Query createQuery(Student user, Camp camp, String description) {
        // first time creating query
        if (!list_query.containsKey(camp.getId())) {
            queries = new ArrayList<>();
        }

        // adding query to the 'queries' list
        if (q_id != null){
            queries = list_query.get(camp.getId());
            queries.add(q_id);

            // updating 'queries' list under same campId
            list_query.put(camp.getId(), queries);
        }
        return null;
    }

    public boolean deleteQuery(int queryID) {
        // Implement the method
        return false;
    }

    public boolean editQuery(Query query, String description) {
        // Implement the method
        return false;
    }

    public Query getQueryByID(int queryID) {
        this.q_id = queryID;
        return null;
    }

    public boolean replyToQuery(Staff staff, Query query, String response) {
        // Implement the method
        return false;
    }
}