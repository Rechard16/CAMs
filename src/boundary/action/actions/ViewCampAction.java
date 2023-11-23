package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.CampOptionsView;
import boundary.login.UserSession;
import boundary.util.CampDisplayer;
import main.Context;
import model.Camp;
import model.Permission;

public class ViewCampAction implements Action {
	private final Context context;
	private final UserSession session;
	private Camp camp;

	public ViewCampAction(Context context, UserSession session, Camp camp) {
		this.context = context;
		this.session = session;
		this.camp = camp;
	}
	
	public ViewCampAction(Context context, UserSession session) {
		this.context = context;
		this.session = session;
	}
	
	protected void setCamp(Camp camp) {
		this.camp = camp;
	}
	
	protected Camp getCamp() {
		return this.camp;
	}
	
	protected Context getContext() {
		return this.context;
	}
	
	protected UserSession getSession() {
		return this.session;
	}
	
	@Override
	public String getDescription() {
		String name = camp.getInformation().getName();
		if (session.getUser().isRegistered(camp.getID()))
			name += " (Registered)";
		if (!camp.isVisible()) 
			name += " (Hidden)";
		return name;
	}

	@Override
	public void performAction() throws Exception {
		new CampDisplayer(context, camp)
			.dislayCamp();
	}

	@Override
	public ViewHandler getNextView() {
		return new CampOptionsView(context, session, camp);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMP);
	}

}
