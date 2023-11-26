package control.manager;

import java.util.ArrayList;
import java.util.List;

import entity.model.Camp;
import entity.model.Permission;
import entity.model.Role;
import entity.model.User;

/**
 * PermissionManager is a class that is used to manage permissions.
 */
public class PermissionManager {

	/*
	 * Gets the permissions of a user.
	 * 
	 * @param user The user.
	 * 
	 * @return The list of permissions.
	 */

	public List<Permission> getPermissions(User user) {
		List<Permission> permissions = new ArrayList<Permission>();
		permissions.add(Permission.VIEW_CAMP);
		permissions.add(Permission.VIEW_CAMPS);
		permissions.add(Permission.CHANGE_PASSWORD);
		switch (user.getType()) {
			case STUDENT:
				permissions.add(Permission.COMMITTEE_ELIGIBLE);
				break;
			case STAFF:
				permissions.add(Permission.VIEW_CAMPS_SUPER);
				permissions.add(Permission.CREATE_CAMP);
				break;
		}

		return permissions;
	}
	/*
	 * get camp modification permissions
	 * 
	 * @param user The user.
	 * 
	 * @param camp The camp.
	 * * @return The list of permissions.
	 */

	public List<Permission> getCampModificationPermissions(User user, Camp camp) {
		List<Permission> permissions = getPermissions(user);
		Role role = user.getRole(camp);

		switch (role) {
			case COMMITTEE_MEMBER:
				permissions.add(Permission.SUGGEST_CAMP);
				permissions.add(Permission.VIEW_ENQUIRIES);
				permissions.add(Permission.RESOLVE_ENQUIRY);
				permissions.add(Permission.MODIFY_CAMP);
				permissions.add(Permission.RESOLVE_ENQUIRY);
				permissions.add(Permission.VIEW_ENQUIRIES);
				permissions.add(Permission.GENERATE_REPORT);
				break;
			case OWNER:
				permissions.add(Permission.MODIFY_CAMP);
				permissions.add(Permission.DELETE_CAMP);
			case STAFF:
				permissions.add(Permission.TOGGLE_VISIBILITY);
				permissions.add(Permission.GENERATE_REPORT);
				permissions.add(Permission.VIEW_PERFORMANCE);
				permissions.add(Permission.RESOLVE_ENQUIRY);
				permissions.add(Permission.VIEW_ENQUIRIES);
				permissions.add(Permission.APPROVE_SUGGEST);
				break;
			case PARTICIPANT:
				permissions.add(Permission.ENQUIRY);
				permissions.add(Permission.WITHDRAW);
				permissions.add(Permission.ENQUIRY);
				break;
			case FREE_VIEWER:
				permissions.add(Permission.REGISTER_COMMITTEE);
			case VIEWER:
				permissions.add(Permission.REGISTER);
				break;
			case WITHDRAWN:
				break;
		}
		return permissions;
	}
}
