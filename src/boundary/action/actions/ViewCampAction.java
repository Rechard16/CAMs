package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.CampOptionsView;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.Role;

public class ViewCampAction extends Action {
	private Camp camp;

	public ViewCampAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}
	
	public ViewCampAction(Context context, UserSession session) {
		super(context, session);
	}
	
	protected void setCamp(Camp camp) {
		this.camp = camp;
	}
	
	protected Camp getCamp() {
		return this.camp;
	}
	
	@Override
	public String getDescription() {
		String name = camp.getInformation().getName();

		Role role = session.getUser().getRole(camp);
		if (role != Role.FREE_VIEWER && role != Role.VIEWER)
			name += String.format(" (%s)", role.name());

		if (!camp.getVisibility()) 
			name += " (Hidden)";
		return name;
	}

	@Override
	public void performAction() throws Exception {}

	@Override
	public ViewHandler getNextView() {
		return new CampOptionsView(context, session, camp);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMP);
	}

}
