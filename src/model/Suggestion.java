package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Suggestion class represents a suggestion made by a user in the system.
 * It includes details about the suggestion, the user who made it, and the
 * associated campaign.
 * This class extends the Model class and provides specific functionalities for
 * managing suggestions.
 */

public class Suggestion extends Model {
    /**
     * The user who made the suggestion.
     */
    private User user;

    /**
     * The campaign ID to which this suggestion is related.
     */
    private int campID;

    /**
     * A unique identifier for the suggestion.
     */
    private int suggestionID;

    /**
     * The content of the suggestion.
     */
    private String description;

    /**
     * A list of changes proposed in the suggestion.
     */
    public List<Change> changes = new ArrayList<>();

    /**
     * Constructs a new Suggestion with the specified user, campaign ID, and
     * description.
     * The suggestion ID is generated automatically by the SuggestionDatabase.
     *
     * @param user               The user making the suggestion.
     * @param campID             The campaign ID associated with the suggestion.
     * @param description        The content of the suggestion.
     * @param suggestionDatabase The database used for generating a new suggestion
     *                           ID.
     */

    public Suggestion(User user, int campID, String description, int suggestionID) {
        this.user = user;
        this.campID = campID;
        this.description = description;
        this.suggestionID = suggestionID;
    }

    /**
     * Displays the details of the suggestion including its ID, campaign ID, user
     * ID, and content.
     * Also prints out the list of proposed changes.
     */

    public void view() {
        System.out.println("Suggestion ID: " + this.suggestionID);
        System.out.println("Camp ID: " + this.campID);
        System.out.println("User ID: " + this.user.getID());
        System.out.println("Content: " + this.description);
        for (Change change : changes) {
            System.out.println(change.toString());
        }
    }

    /**
     * Retrieves the suggestion ID.
     *
     * @return int representing the suggestion's unique identifier.
     */

    public int getID() {
        return this.suggestionID;
    }

    /**
     * Retrieves the user who made the suggestion.
     *
     * @return User who made the suggestion.
     */

    public User getUser() {
        return this.user;
    }

    /**
     * Sets the user who made the suggestion.
     *
     * @param user The user to be associated with the suggestion.
     */

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Retrieves the campaign ID associated with the suggestion.
     *
     * @return int representing the campaign ID.
     */

    public int getCampID() {
        return this.campID;
    }

    /**
     * Sets the campaign ID for the suggestion.
     *
     * @param campID The campaign ID to be associated with the suggestion.
     */

    public void setCampID(int campID) {
        this.campID = campID;
    }

    /**
     * Retrieves the unique identifier for the suggestion.
     *
     * @return int representing the suggestion's unique ID.
     */

    public int getSuggestionID() {
        return this.suggestionID;
    }

    /**
     * Sets the unique identifier for the suggestion.
     *
     * @param suggestionID The new unique ID for the suggestion.
     */

    public void setSuggestionID(int suggestionID) {
        this.suggestionID = suggestionID;
    }

    /**
     * Retrieves the description of the suggestion.
     *
     * @return String representing the content of the suggestion.
     */

    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description for the suggestion.
     *
     * @param description The new content to be set for the suggestion.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the list of changes proposed in the suggestion.
     *
     * @return List of Change objects associated with the suggestion.
     */

    public List<Change> getChanges() {
        return this.changes;
    }

    /**
     * Sets the list of changes proposed in the suggestion.
     *
     * @param changes The new list of Change objects to be associated with the
     *                suggestion.
     */

    public void setChanges(List<Change> changes) {
        this.changes = changes;
    }

    /**
     * Overloaded setUser method for convenience, allowing setting user attributes
     * directly.
     *
     * @param id       The new id of user
     * @param userID   The new userID of user.
     * @param faculty  The new faculty of user.
     * @param password The new password of user.
     */

    public void setUser(int id, String userID, Faculty faculty, String password) {
        this.user.setID(id);
        this.user.setUserID(userID);
        this.user.setFaculty(faculty);
        this.user.setPassword(password);
    }
}
