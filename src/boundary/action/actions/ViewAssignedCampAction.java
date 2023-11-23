package boundary.action.actions;

import java.util.ArrayList;
import java.util.List;

import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.Student;

public class ViewAssignedCampAction extends ViewCampAction{
	private final Context context;
	private final UserSession session;
	private ViewHandler nextView;
	
	public ViewAssignedCampAction(Context context, UserSession session) {
		super(context, session);
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
			nextView = session.getViewStack().top();
			return;
		}
		Camp camp = context.getCampManager().getCampByID(id);

		this.setCamp(camp);
		super.performAction();
		nextView = super.getNextView();

	}

	@Override
	public ViewHandler getNextView() {
		return nextView;
	}
	
	@Override
	public List<Permission> getRequiredPermissions() {
		List<Permission> perms = new ArrayList<>();
		perms.addAll(super.getRequiredPermissions());
		perms.add(Permission.COMMITTEE_ELIGIBLE);
		return perms;
	}
}
