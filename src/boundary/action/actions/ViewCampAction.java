package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.CampOptionsView;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.Student;
import model.User;
import model.UserType;

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
		User user = session.getUser();
		if (user.getType() == UserType.STUDENT && 
				((Student) user).isRegistered(camp.getID()))
			name += " (Registered)";
		if (!camp.isVisible()) 
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
