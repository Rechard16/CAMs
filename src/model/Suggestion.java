package model;

import java.util.List;

public class Suggestion extends Model {
    private User user;
    private int campID;
    private int suggestionID;
    public List<Change> changes;

    public void view() {
        // Implement the method
    }

    public void edit() {
        // Implement the method
    }

    public void delete() {
        // Implement the method
    }
    public int getId() {
        return this.suggestionID;
    }
}