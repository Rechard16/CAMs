package entity.model;

/**
 * The Query class represents a query or enquiry made by a user in the system.
 * It contains details about the query, including the user who made it, the
 * associated camp,
 * and a unique identifier for the query. This class extends the Model class.
 */

public class Query extends Model {
    /**
     * The ID of the user who made the query.
     */
    private int userID;

    /**
     * The ID of the camp associated with the query.
     */

    private int campID;

    /**
     * A unique identifier for the query.
     */

    private int queryID;

    /**
     * The content of the query.
     */

    private String description;

    /**
     * The title of the query.
     */

    private String title;

    /**
     * Committee member's reply to the query.
     */

    private String reply;

    /**
     * The status of the query.
     */
    private EnquiryStatus status = EnquiryStatus.UNANSWERED;

    /**
     * Constructs a Query with specified user ID, camp ID, and description.
     * Initializes queryID to 1.
     *
     * @param userID      The ID of the user making the query.
     * @param campID      The ID of the camp associated with the query.
     * @param description The content of the query.
     * @param reply       Inital reply is none.
     */

    public Query(int userID, int campID, String title, String description) {
        this.userID = userID;
        this.campID = campID;
        this.queryID = 1;
        this.description = description;
        this.title = title;
        this.reply = "Unanswered";
    }

    /**
     * Constructs a Query with specified user ID, camp ID, description, and a
     * reference to SuggestionDatabase.
     * The queryID is generated using the SuggestionDatabase.
     *
     * @param userID      The ID of the user making the query.
     * @param campID      The ID of the camp associated with the query.
     * @param description The content of the query.
     * @param queryID     The unique id for query.
     * @param reply       Inital reply is none.
     */

    public Query(int userID, int campID, int queryID, String title, String description) {
        this.userID = userID;
        this.campID = campID;
        this.queryID = queryID;
        this.description = description;
        this.title = title;
        this.reply = "Unanswered";
    }

    /**
     * Retrieves the unique identifier of the query.
     *
     * @return int representing the query's unique identifier.
     */
    @Override

    public int getID() {
        return this.queryID;
    }

    /**
     * Retrieves the camp ID associated with the query.
     *
     * @return int representing the camp ID.
     */

    public int getCampID() {
        return this.campID;
    }

    /**
     * Retrieves the user ID of the user who made the query.
     *
     * @return int representing the user's ID.
     */
    public int getUserID() {
        return this.userID;
    }

    /**
     * Retrieves the description of the query.
     *
     * @return String representing the content of the query.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Retrieves the title of the query.
     *
     * @return String representing the title of the query.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the title of the query.
     *
     * @return String representing the title of the query.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the unique identifier for the query.
     *
     * @param id The new unique ID to be set for the query.
     */

    public void setID(int id) {
        this.queryID = id;
    }

    /**
     * Sets the camp ID for the query.
     *
     * @param id The new camp ID to be set for the query.
     */

    public void setCampID(int id) {
        this.campID = id;
    }

    /**
     * Sets the user ID for the user who made the query.
     *
     * @param id The new user ID to be set for the query.
     */

    public void setUserID(int id) {
        this.userID = id;
    }

    /**
     * Sets the description for the query.
     *
     * @param description The new description to be set for the query.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the reply to the query.
     *
     * @return String representing the reply to the query.
     */

    public String getReply() {
        return this.reply;
    }

    /**
     * Sets the reply for the query.
     *
     * @param reply The new reply to be set for the query.
     */

    public void answer(String reply) {
        this.reply = reply;
        this.status = EnquiryStatus.ANSWERED;
    }

    /**
     * Retrieves the status of the query.
     *
     * @return The status of the query.
     */
    public EnquiryStatus getStatus() {
        return this.status;
    }
}
