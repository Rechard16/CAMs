package model;

import java.util.List;

public class Suggestion extends Model {
    private User user;
    private int campID;
    private int suggestionID;
    public List<Change> changes;
    private database database;

    public void view() {
        // Implement the method
        Suggestion suggestion = database.getSuggestionById(this.suggestionID);
        if (suggestion != null) {
            // 这里的逻辑是显示建议的信息，例如输出到控制台或UI组件
            System.out.println("Suggestion ID: " + suggestion.getId());
            System.out.println("Camp ID: " + suggestion.campID);
            // 这里可以扩展显示更多的细节
        } else {
            System.out.println("Suggestion not found.");
        }
    }

    public void edit(List<Change> newChanges) {
        // Implement the method
        this.changes = newChanges;
        database.updateSuggestion(this);
    }

    public void delete() {
        // Implement the method
        database.deleteSuggestion(this.suggestionID);
    }

    public int getId() {
        return this.suggestionID;
    }
}