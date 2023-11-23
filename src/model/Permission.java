package model;

/**
 * The Permission enum defines various permissions or actions that users in the
 * system can perform.
 * These permissions are typically used to control access to different
 * functionalities based on the
 * user's role, such as staff or student, and their specific responsibilities or
 * privileges.
 */

public enum Permission {

    /**
     * CREATE_CAMP permission allows a user to create a new camp.
     */

    CREATE_CAMP,

    /**
     * MODIFY_CAMP permission allows a user to modify the details of an existing
     * camp.
     * This includes changing the camp's schedule, content, or other organizational
     * details.
     */

    MODIFY_CAMP,

    /**
     * SUGGEST_CAMP permission allows a user to suggest changes or improvements
     * to a camp.
     * Users with this permission can submit suggestions but may not have the
     * authority to implement them directly.
     */

    SUGGEST_CAMP,

    /**
     * APPROVE_SUGGEST permission is granted to users who can approve suggestions
     * made for camps.
     */

    APPROVE_SUGGEST,

    /**
     * VIEW_CAMPS permission allows a user to view a list of all visible camps to their faculty.
     */

    VIEW_CAMPS,

    /**
     * VIEW_CAMPS_SUPER permission allows a user to view all camps from all faculties.
     */

    VIEW_CAMPS_SUPER,

    /**
     * VIEW_CAMP permission allows a staff to view the details of a specific camp.
     */

    VIEW_CAMP,
   
    /**
     * ENQUIRY permission enables a user to submit enquiries or questions about a
     * camp.
     */

    ENQUIRY,

    /**
     * VIEW_ENQUIRIES permission allows a user to view all enquiries made about a
     * camp.
     */

    VIEW_ENQUIRIES,

    /**
     * RESOLVE_ENQUIRY permission grants the ability to address and resolve
     * enquiries made by users.
     * This involves providing answers or solutions to the questions posed in the
     * enquiries.
     */

    RESOLVE_ENQUIRY,
    
    /**
     * VIEW_POINTS permission allows a student to view his own points.
     */
    VIEW_POINTS,
    
    /**
     * CHANGE_PASSWORD permission allows a user to change their password
     */
    CHANGE_PASSWORD,
    
    /**
     * COMMITTEE_ELIGIBLE permission allows a user to register themself as a committee member
     */
    COMMITTEE_ELIGIBLE,
    
    /**
     * TOGGLE_VISIBILITY permission allows a user to 
     */
    TOGGLE_VISIBILITY
}