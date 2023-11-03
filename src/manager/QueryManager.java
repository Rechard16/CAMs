package manager;

import model.Query;
import model.Student;
import model.Staff;
import model.Camp;
import java.util.List;

public class QueryManager {
    private List<Query> queries;

    public Query createQuery(Student user, Camp camp, String description) {
        // Implement the method
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
        // Implement the method
        return null;
    }

    public boolean replyToQuery(Staff staff, Query query, String response) {
        // Implement the method
        return false;
    }
}