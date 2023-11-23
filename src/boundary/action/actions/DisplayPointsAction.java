package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Permission;
import model.Student;

public class DisplayPointsAction extends Action{
	private final ViewHandler currentView;

	public DisplayPointsAction(Context context, UserSession session, ViewHandler currentView) {
		super(context, session);
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
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_POINTS);
	}
}
