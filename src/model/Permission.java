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
     * MODIFY_CAMP permission allows a user to create a suggestion to make changes
     * to a camp.
     * This includes changing the camp's schedule, content, or other organizational
     * details.
     */

    MODIFY_CAMP,
    
    DELETE_CAMP,

    /**
     * SUGGEST_CAMP permission allows a user to submit suggestions to make changes
     * to a camp.
     * Users with this permission can submit suggestions but may not have the
     * authority to implement them directly.
     */

    SUGGEST_CAMP,
    
    /**
     * APPROVE_SUGGEST permission is granted to users who can approve suggestions
     * submitted by other users or themselves.
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
     * COMMITTEE_ELIGIBLE permission allows a user to be eligible as a committee member
     */
    COMMITTEE_ELIGIBLE,
    
    /**
     * CHANGE_PASSWORD permission allows a user to change their password
     */
    CHANGE_PASSWORD,

	/**
     * TOGGLE_VISIBILITY permission allows a user to toggle camp visibility
     */
    TOGGLE_VISIBILITY,
    
    /**
     * REGISTER permission allows a user to register for camps
     */
    REGISTER, 
    
    /**
     * REGISTER_COMMITTEE permission allows a user to register as a committee member
     */
    REGISTER_COMMITTEE,
    
    WITHDRAW,
    
    IMPOSSIBLE
}