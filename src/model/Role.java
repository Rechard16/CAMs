package model;

public enum Role {
	OWNER, COMMITTEE_MEMBER,
	STAFF, PARTICIPANT,
	VIEWER, 

	/**
	 * Represents a user who is not a committee member or owner of any camp
	 */
	FREE_VIEWER
}