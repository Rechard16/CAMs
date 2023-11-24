package boundary;

import java.util.ArrayList;
import java.util.List;

import model.Camp;
import model.Permission;
import model.Role;
import model.Student;
import model.User;
import model.UserType;

public class PermissionManager {
	
	// TODO
	public List<Permission> getPermissions(User user) {
		List<Permission> permissions = new ArrayList<Permission>();
		permissions.add(Permission.VIEW_CAMP);
		permissions.add(Permission.CHANGE_PASSWORD);
		switch (user.getType()) {
		case STUDENT:
			permissions.add(Permission.COMMITTEE_ELIGIBLE);
			permissions.add(Permission.VIEW_CAMPS);
			break;
		case STAFF:
			permissions.add(Permission.VIEW_CAMPS_SUPER);
			permissions.add(Permission.TOGGLE_VISIBILITY);
			permissions.add(Permission.CREATE_CAMP);
			break;
		default: break;
		}
		
		return permissions;
	}
	
	public List<Permission> getCampModificationPermissions(User user, Camp camp) {
		List<Permission> permissions = getPermissions(user);
		Role role = user.getRole(camp);
		
		switch (role) {
		case COMMITTEE_MEMBER:
			permissions.add(Permission.SUGGEST_CAMP);
			permissions.add(Permission.VIEW_ENQUIRIES);
			permissions.add(Permission.RESOLVE_ENQUIRY);
			permissions.add(Permission.MODIFY_CAMP);
			break;
		case OWNER:
			permissions.add(Permission.APPROVE_SUGGEST);
			permissions.add(Permission.MODIFY_CAMP);
			break;
		case PARTICIPANT:
			permissions.add(Permission.ENQUIRY);
			break;
		case STAFF:
			break;
		case FREE_VIEWER:
			permissions.add(Permission.REGISTER_COMMITTEE);
		case VIEWER:
			permissions.add(Permission.REGISTER);
			break;
		}
		return permissions;
	}
}
