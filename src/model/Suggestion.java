package model;

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
    private int userID;

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
    private CampInfoModifier modifier;

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

    public Suggestion(int userID, int campID, CampInfoModifier modifier, String description, int suggestionID) {
        this.userID = userID;
        this.campID = campID;
        this.modifier = modifier;
        this.description = description;
        this.suggestionID = suggestionID;
        modifier.setID(suggestionID);
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
     * Sets the suggestion ID
     * 
     * @parm id the new ID of the suggestion
     */
    public void setID(int id) {
    	this.suggestionID = id;
    }

    /**
     * Retrieves the user who made the suggestion.
     *
     * @return User who made the suggestion.
     */

    public int getUserID() {
        return this.userID;
    }

    /**
     * Sets the user who made the suggestion.
     *
     * @param user The user to be associated with the suggestion.
     */

    public void setUserID(int id) {
        this.userID = id;
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

    public CampInfoModifier getModifier() {
    	return this.modifier;
    }
}
