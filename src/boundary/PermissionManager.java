package boundary;

import java.util.ArrayList;
import java.util.List;

import model.Camp;
import model.Permission;
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
			permissions.add(Permission.VIEW_POINTS);
			permissions.add(Permission.VIEW_CAMPS);
			permissions.add(Permission.COMMITTEE_ELIGIBLE);
			break;
		case STAFF:
			permissions.add(Permission.VIEW_CAMPS_SUPER);
			permissions.add(Permission.TOGGLE_VISIBILITY);
			break;
		default: break;
		}
		
		return permissions;
	}
	
	public List<Permission> getCampModificationPermissions(User user, Camp camp) {
		List<Permission> permissions = getPermissions(user);
		if (user.getType() == UserType.STUDENT) {
			// TODO
			if (((Student) user).getCampID() == camp.getID()) {
				permissions.add(Permission.SUGGEST_CAMP);
				permissions.add(Permission.VIEW_ENQUIRIES);
				permissions.add(Permission.RESOLVE_ENQUIRY);
			} else {
				permissions.add(Permission.ENQUIRY);
			}
		}
		if (user.getType() == UserType.STAFF) {
			permissions.add(Permission.APPROVE_SUGGEST);
			permissions.add(Permission.MODIFY_CAMP);
			permissions.add(Permission.CREATE_CAMP);
		}
		return permissions;
	}
}
