package model;

import model.interfaces.FacultyMember;
import model.interfaces.Nameable;
import model.interfaces.Registrable;

/**
 * The abstract User class represents a user in the system. It extends Model,
 * inheriting its properties and functionalities. This class includes attributes
 * and methods that are common to all types of users.
 */

public abstract class User extends Model implements Registrable, Nameable, FacultyMember {

    /**
     * Unique identifier for the user.
     */
    private int id;

    /**
     * A string-based unique ID for the user.
     */
    private String name;

    /**
     * The faculty to which the user belongs.
     */
    private Faculty faculty;

    /**
     * Stores the user's password.
     */
    private String password;

    /**
     * Constructs a User with the specified details.
     *
     * @param id       The user's unique identifier.
     * @param userID   The user's string-based unique ID.
     * @param faculty  The faculty to which the user belongs.
     * @param password The user's password.
     */

    public User(int id, String userID, Faculty faculty, String password) {
        this.id = id;
        this.name = userID;
        this.faculty = faculty;
        this.password = password;
    }

    /**
     * Changes the user's password if the old password matches the current one.
     *
     * @param oldPassword The user's current password.
     * @param newPassword The new password to be set.
     */

    protected void changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(this.password)) {
            this.password = newPassword;
        }
    }

    /**
     * An abstract method that returns the type of the user. This method must be
     * implemented by subclasses.
     *
     * @return UserType representing the type of the user.
     */

    public abstract UserType getType();

    @Override

    /**
     * Retrieves the unique identifier of the user.
     *
     * @return int representing the user's unique identifier.
     */

    public int getID() {
        return id;
    }

    /**
     * Sets the unique identifier of the user.
     *
     * @param id The new unique identifier to be set for the user.
     */

    public void setID(int id) {
        this.id = id;
    }

    /**
     * Retrieves the string-based unique ID of the user.
     *
     * @return String representing the user's string-based unique ID.
     */

    public String getName() {
        return name;
    }

    /**
     * Sets the string-based unique ID for the user.
     *
     * @param id The new string-based unique ID to be set for the user.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return String representing the user's password. Returns an empty string if
     *         the password is null.
     */

    public String getPassword() {
        return this.password == null ? "" : password;
    }

    /**
     * Sets the password for the user.
     *
     * @param password The new password to be set for the user.
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the faculty to which the user belongs.
     *
     * @return Faculty representing the faculty of the user.
     */

    public Faculty getFaculty() {
        return this.faculty;
    }

    /**
     * Sets the faculty for the user.
     *
     * @param faculty The new faculty to be set for the user.
     */

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}