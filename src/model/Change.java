package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The Change class represents a change or update made in the system, typically
 * in response to a query or suggestion.
 * It includes a unique identifier for each change, the associated query ID, a
 * description of the change,
 * and a timestamp indicating when the change was made.
 */
public class Change {
    private static int lastChangeId = 0; // Static variable to keep track of the last change ID assigned.
    private int changeId; // Unique identifier for this change.
    private int queryId; // The ID of the query associated with this change.
    private String description; // A description of what the change entails.
    private LocalDateTime timestamp; // The date and time when the change was made.

    /**
     * Constructs a Change with the specified query ID and description.
     * Automatically assigns a unique change ID and sets the current time as the
     * timestamp.
     *
     * @param queryId     The ID of the query associated with this change.
     * @param description A description of the change.
     */
    public Change(int queryId, String description) {
        this.changeId = ++lastChangeId; // Increment and assign the next unique ID.
        this.queryId = queryId;
        this.description = description;
        this.timestamp = LocalDateTime.now(); // Set the current time as the timestamp.
    }

    // Getters for each attribute
    // ...

    /**
     * Returns a string representation of the Change, including its ID, associated
     * query ID,
     * description, and timestamp.
     *
     * @return A string detailing the change's information.
     */
    @Override
    public String toString() {
        return "Change ID: " + this.changeId +
                ", Query ID: " + this.queryId +
                ", Description: " + this.description +
                ", Timestamp: " +
                this.timestamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    // Additional methods and functionalities can be added here.
    // For instance, setters if modification of fields is allowed.
}

/**
 * The Change interface defines the contract for classes that represent changes
 * or updates in the system.
 * It requires implementing classes to define how modifications are made.
 */
public interface Change {
    /**
     * The modify method, to be implemented by classes implementing this interface,
     * should contain the logic for making modifications or updates represented by
     * the change.
     */
    public void modify();
}
