package entity.model;

/**
 * The UserType enum defines the different types of users in the system.
 * It categorizes users into distinct groups, each with its own set of
 * properties and behaviors. This enumeration is used to differentiate
 * the roles and capabilities of users within the application.
 */

public enum UserType {
	/**
	 * STAFF represents users who are staff members. This type of user
	 * has administrative and has the right to operate the camps
	 */
	STAFF,
	/**
	 * STUDENT represents users who are students. This type of user
	 * usually can access to the core function of registering system.
	 */
	STUDENT
}
