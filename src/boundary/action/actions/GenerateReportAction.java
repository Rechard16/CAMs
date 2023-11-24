package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.filter.Filter;
import boundary.login.UserSession;
import boundary.util.ReportGenerator;
import main.Context;
import model.Camp;
import model.Permission;
import model.User;

public class GenerateReportAction extends Action {
	private final Camp camp;
	private final Filter<User> filter;
	private final ReportGenerator generator;

	public GenerateReportAction(Context context, UserSession session, 
			Camp camp, Filter<User> filter, ReportGenerator generator) {
		super(context, session);
		this.camp = camp;
		this.filter = filter;
		this.generator = generator;
	}

	@Override
	public String getDescription() {
		return String.format("Create %s", generator.getName());
	}

	@Override
	public void performAction() throws Exception {
		generator.generateReport(context, camp, filter);
		context.print("Successfully created report!");
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return generator.getPermissions();
	}
}
