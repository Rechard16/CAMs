package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.LoginSession;
import main.Context;
import model.Permission;
import model.Student;

public class DisplayPointsAction implements Action{
	private final Context context;
	private final LoginSession session;

	public DisplayPointsAction(Context context, LoginSession session) {
		this.context = context;
		this.session = session;
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
		return context.getPreviousView();
	}
	
	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_POINTS);
	}
}
