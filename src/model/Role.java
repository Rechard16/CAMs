package model;

/**
 * The Role enum is used to represent the role of a user in a camp.
 * It is used in the Camp class.
 */
public enum Role {
	/**
	 * Represents a user who is the owner of a camp
	 */
	OWNER,

	/**
	 * Represents a user who is a committee member of a camp
	 */
	COMMITTEE_MEMBER,

	/**
	 * Represents a user who is a staff member of a camp
	 */

	STAFF,

	/**
	 * Represents a user who is a participant of a camp
	 */

	PARTICIPANT,

	/**
	 * Represents a user who is a viewer of a camp
	 */

	VIEWER,

	/**
	 * Represents a user who is not a committee member or owner of any camp
	 */
	FREE_VIEWER,

	/**
	 * Represents a user who has withdrawn from a camp
	 */
	WITHDRAWN
}