package model;

public class Query extends Model {
    private int userId;
    private int campId;
    private int queryId;
    private String description;
    
    public Query() {}
    
    public Query(int userId, int campId, String description) {
    	this.userId = userId;
    	this.campId = campId;
    	this.queryId = 1;
    	this.description = description;
    }

    public void view() {
        // Implement the method
    }

    public void reply() {
        // Implement the method
    }

    public int getId() {
        return this.queryId;
    }
    
    public int getCampId() {
    	return this.campId;
    }
    
    public int getUserId() {
    	return this.userId;
    }
    
    public String getDescription() {
    	return this.description;
    }
    
    public void setId(int id) {
    	this.queryId = id;
    }

    public void setCampId(int id) {
    	this.campId = id;
    }

    public void setUserId(int id) {
    	this.userId = id;
    }

    public void setDescription(String description) {
    	this.description = description;
    }
}
