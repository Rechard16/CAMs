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
/*
 * GenerateReportAction is a class that is used to generate reports.
 */

public class GenerateReportAction extends Action {
	private final Camp camp;
	private final Filter<User> filter;
	private final ReportGenerator generator;
	/*
	 * Constructor for GenerateReportAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 * 
	 * @param filter The filter to be used.
	 * 
	 * @param generator The generator to be used.
	 */

	public GenerateReportAction(Context context, UserSession session,
			Camp camp, Filter<User> filter, ReportGenerator generator) {
		super(context, session);
		this.camp = camp;
		this.filter = filter;
		this.generator = generator;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Create <generator name>".
	 */
	public String getDescription() {
		return String.format("Create %s", generator.getName());
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		generator.generateReport(context, camp, filter);
		context.print("Successfully created report!");
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public List<Permission> getRequiredPermissions() {
		return generator.getPermissions();
	}
}
