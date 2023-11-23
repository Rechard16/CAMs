package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.CampOptionsView;
import boundary.login.UserSession;
import boundary.util.CampInfoDisplayer;
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
	
	public void setCamp(Camp camp) {
		this.camp = camp;
	}
	
	@Override
	public String getDescription() {
		return camp.getInformation().getName();
	}

	@Override
	public void performAction() throws Exception {
		context.print("You have selected: %s\n", camp.getInformation().getName());
		
		new CampInfoDisplayer(context, camp.getInformation())
			.displayCampInfo();
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
