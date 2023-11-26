package boundary.action.views;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.GenerateReportAction;
import boundary.action.actions.PreviousViewAction;
import boundary.action.actions.filter.AddFilterAction;
import boundary.display.report.CampReportGenerator;
import boundary.display.report.CommitteeReportGenerator;
import control.login.UserSession;
import entity.FacultyMember;
import entity.Nameable;
import entity.Registrable;
import entity.filter.FacultyParameter;
import entity.filter.Filter;
import entity.filter.FilterParameter;
import entity.filter.NameParameter;
import entity.filter.RoleParameter;
import entity.model.Camp;
import entity.model.Permission;
import entity.model.User;
import main.Context;

public class UserFilterView extends ViewHandler {
	private final Filter<User> filter = new Filter<>();
	private final Camp camp;
	/*
	 * Constructor for UserFilterView.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 */

	public UserFilterView(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	/*
	 * Get the prompt.
	 * 
	 * @return "Add a filter, or generate the report:".
	 */
	protected String getPrompt() {
		return "Add a filter, or generate the report:";
	}

	@Override
	/*
	 * Displays the view.
	 * 
	 * @throws Exception
	 */
	public void displayView() throws Exception {
		String filters = "Currently filtering by: Alphabetical Order";
		for (FilterParameter<?> param : filter.getParameters())
			filters += String.format(", %s", param.getName());
		context.print(filters);

		super.displayView();
	}

	@Override
	/*
	 * Generates the actions.
	 * 
	 * @return The actions.
	 */
	protected List<Action> generateActions() throws Exception {
		return List.of(
				new AddFilterAction<Registrable>(context, session,
						new RoleParameter(camp), filter),
				new AddFilterAction<FacultyMember>(context, session,
						new FacultyParameter(), filter),
				new AddFilterAction<Nameable>(context, session,
						new NameParameter(), filter),
				new GenerateReportAction(context, session, camp,
						filter, new CampReportGenerator()),
				new GenerateReportAction(context, session, camp,
						filter, new CommitteeReportGenerator()),
				new PreviousViewAction(context, session));
	}

	@Override
	/*
	 * Get the permissions.
	 * 
	 * @return The permissions.
	 */
	protected List<Permission> getPermissions() {
		return context.getPermissionManager()
				.getCampModificationPermissions(this.session.getUser(), camp);
	}

}
