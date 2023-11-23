package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.EntryView;
import boundary.login.LoginSession;
import boundary.util.CampInfoDisplayer;
import main.Context;
import model.Camp;
import model.Permission;
import model.Student;

public class ViewAssignedCampAction implements Action {
	private final Context context;
	private final LoginSession session;
	private ViewHandler nextView;
	
	public ViewAssignedCampAction(Context context, LoginSession session) {
		this.context = context;
		this.session = session;
	}

	@Override
	public String getDescription() {
		return "View Assigned Camp";
	}

	@Override
	public void performAction() throws Exception {
		Student student = (Student) session.getUser();
		int id = student.getCampID();
		if (id == -1) {
			context.print("You do not have an assigned camp!");
			nextView = new EntryView(context, session);
			return;
		}

		Camp camp = context.getCampManager().getCampByID(id);
		new CampInfoDisplayer(context, camp.getInformation())
			.displayCampInfo();
	}

	@Override
	public ViewHandler getNextView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		// TODO Auto-generated method stub
		return null;
	}

}
