package model;

import database.QueryDatabase;

import java.util.List;
import java.util.Scanner;

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
    private int userId;

    /**
     * The ID of the camp associated with the query.
     */
    private int campId;

    /**
     * A unique identifier for the query.
     */
    private int queryId;

    /**
     * The content of the query.
     */
    private String description;

    /**
     * Teacher's reply to the query.
     */
    private String reply;

    /**
     * Default constructor for Query.
     */

    public Query() {
    }

    /**
     * Constructs a Query with specified user ID, camp ID, and description.
     * Initializes queryId to 1.
     *
     * @param userId      The ID of the user making the query.
     * @param campId      The ID of the camp associated with the query.
     * @param description The content of the query.
     * @param reply       Inital reply is none.
     */

    public Query(int userId, int campId, String description) {
        this.userId = userId;
        this.campId = campId;
        this.queryId = 1;
        this.description = description;
        this.reply = null;
    }

    /**
     * Constructs a Query with specified user ID, camp ID, description, and a
     * reference to SuggestionDatabase.
     * The queryId is generated using the SuggestionDatabase.
     *
     * @param userId      The ID of the user making the query.
     * @param campId      The ID of the camp associated with the query.
     * @param description The content of the query.
     * @param queryId     The unique id for query.
     * @param reply       Inital reply is none.
     */

    public Query(int userId, int campId, int queryId, String description) {
        this.userId = userId;
        this.campId = campId;
        this.queryId = queryId;
        this.description = description;
        this.reply = null;
    }

    /**
     * Retrieves the unique identifier of the query.
     *
     * @return int representing the query's unique identifier.
     */
    @Override

    public int getId() {
        return this.queryId;
    }

    /**
     * Retrieves the camp ID associated with the query.
     *
     * @return int representing the camp ID.
     */

    public int getCampId() {
        return this.campId;
    }

    /**
     * Retrieves the user ID of the user who made the query.
     *
     * @return int representing the user's ID.
     */

    public int getUserId() {
        return this.userId;
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
     * Sets the unique identifier for the query.
     *
     * @param id The new unique ID to be set for the query.
     */

    public void setId(int id) {
        this.queryId = id;
    }

    /**
     * Sets the camp ID for the query.
     *
     * @param id The new camp ID to be set for the query.
     */

    public void setCampId(int id) {
        this.campId = id;
    }

    /**
     * Sets the user ID for the user who made the query.
     *
     * @param id The new user ID to be set for the query.
     */

    public void setUserId(int id) {
        this.userId = id;
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

    public void setReply(String reply) {
        this.reply = reply;
    }
}
