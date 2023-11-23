package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Permission;
import model.Student;

public class DisplayPointsAction implements Action{
	private final Context context;
	private final UserSession session;
	private final ViewHandler currentView;

	public DisplayPointsAction(Context context, UserSession session, ViewHandler currentView) {
		this.context = context;
		this.session = session;
		this.currentView = currentView;
	}
	
	@Override
	public String getDescription() { return "View My Current Points"; }
	
	@Override
	public void performAction() {
		Student student = (Student) session.getUser();
		int points = student.getPoints();
		
		context.print("Your current points: %d\n", points);
		
		if (student.getCampID() == -1)
			context.print("You have not registered as a committee member for any camp!");
	}
	
	@Override
	public ViewHandler getNextView() {
		return currentView;
	}
	
	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_POINTS);
	}
}
