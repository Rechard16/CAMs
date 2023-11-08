package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import database.SuggestionDatabase;

public class Suggestion extends Model {
    private User user;
    private int campID;
    private int suggestionID;
    private String description;
    public List<Change> changes = new ArrayList<>();
    private SuggestionDatabase suggestionDatabase;

    public Suggestion(User user, int campID, String description, SuggestionDatabase suggestionDatabase) {
        this.user = user;
        this.campID = campID;
        this.description = description;
        this.suggestionDatabase = suggestionDatabase;
        this.suggestionID = suggestionDatabase.generateNewId();
    }

    public void view() {
        System.out.println("Suggestion ID: " + this.suggestionID);
        System.out.println("Camp ID: " + this.campID);
        System.out.println("User ID: " + this.user.getId());
        System.out.println("Content: " + this.description);
        for (Change change : changes) {
            System.out.println(change.toString());
        }
    }

    public void edit() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Select option: \n1. Edit Content \n2. Delete Suggestion \n3. Exit");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (option) {
                    case 1:
                        System.out.println("Current content: " + this.description);
                        System.out.println("Enter new description:");
                        this.description = scanner.nextLine();
                        suggestionDatabase.update(this);
                        break;
                    case 2:
                        this.delete();
                        return; // Exit after deletion
                    case 3:
                        return; // Exit editing
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } finally {
            scanner.close();
        }
    }

    public void delete() {
        suggestionDatabase.remove(this);
    }

    public int getId() {
        return this.suggestionID;
    }

    // Getter and Setter for user
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Getter and Setter for campID
    public int getCampID() {
        return this.campID;
    }

    public void setCampID(int campID) {
        this.campID = campID;
    }

    // Getter and Setter for suggestionID
    public int getSuggestionID() {
        return this.suggestionID;
    }

    public void setSuggestionID(int suggestionID) {
        this.suggestionID = suggestionID;
    }

    // Getter and Setter for description
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for changes
    public List<Change> getChanges() {
        return this.changes;
    }

    public void setChanges(List<Change> changes) {
        this.changes = changes;
    }
}
