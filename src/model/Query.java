package model;

public class Query extends Model {
    private User user;
    private Camp CampID;
    private int QueryID;
    private String description;
    private database database;

    public Query(database database) {
        this.database = database;
    }

    public void view() {
        // Implement the method
        Query query = database.getQueryById(this.QueryID);
        if (query != null) {
            System.out.println("Query ID: " + query.getId());
            System.out.println("Description: " + query.description);
        } else {
            System.out.println("Query not found.");
        }
    }

    public void reply() {
        // Implement the method
    }

    public int getId() {
        return this.QueryID;
    }
}
