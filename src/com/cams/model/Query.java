package model;

import database.SuggestionDatabase;

import java.util.List;
import java.util.Scanner;

public class Query extends Model {
    private int userId;
    private int campId;
    private int queryId;
    private String description;
    private SuggestionDatabase suggestionDatabase; // 添加对SuggestionDatabase的引用

    public Query() {
    }

    public Query(int userId, int campId, String description) {
        this.userId = userId;
        this.campId = campId;
        this.queryId = 1;
        this.description = description;
    }

    public Query(int userId, int campId, String description, SuggestionDatabase suggestionDatabase) {
        this.userId = userId;
        this.campId = campId;
        this.queryId = suggestionDatabase.generateNewId(); // 使用suggestionDatabase生成新的ID
        this.description = description;
        this.suggestionDatabase = suggestionDatabase;
    }

    public void view() {
        System.out.println("Query ID: " + this.queryId);
        System.out.println("Camp ID: " + this.campId);
        System.out.println("User ID: " + this.userId);
        System.out.println("Description: " + this.description);
    }

    public void reply() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the Suggestion ID to reply to:");
            int suggestionId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            Suggestion suggestion = findSuggestionById(suggestionId);
            if (suggestion != null) {
                System.out.println("Enter your reply:");
                String reply = scanner.nextLine();
                System.out.println("Your reply: " + reply);
                suggestion.changes.add(new Change(this.queryId, reply));
                suggestionDatabase.update(suggestion);
            } else {
                System.out.println("Suggestion not found.");
            }
        } finally {
            scanner.close();
        }
    }

    private Suggestion findSuggestionById(int id) {
        // 使用suggestionDatabase来查找具有特定ID的Suggestion
        List<Suggestion> suggestions = suggestionDatabase.getAll();
        for (Suggestion suggestion : suggestions) {
            if (suggestion.getId() == id) {
                return suggestion;
            }
        }
        return null;
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
