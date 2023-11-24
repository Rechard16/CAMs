package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.filter.Filter;
import boundary.login.UserSession;
import boundary.util.CampReportGenerator;
import main.Context;
import model.Camp;
import model.Permission;
import model.Student;
import model.User;

public class GenerateReportAction extends Action {
	private final Camp camp;
	private final Filter<User> filter;

	public GenerateReportAction(Context context, UserSession session, Camp camp, Filter<User> filter) {
		super(context, session);
		this.camp = camp;
		this.filter = filter;
	}

	@Override
	public String getDescription() {
		return "Create Report";
	}

	@Override
	public void performAction() throws Exception {
		new CampReportGenerator().generateCampReport(context, camp, filter);
		context.print("Successfully created report!");
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.GENERATE_REPORT);
	}
}
