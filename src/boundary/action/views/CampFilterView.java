package boundary.action.views;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.PreviousViewAction;
import boundary.action.actions.filter.AddFilterAction;
import boundary.action.actions.filter.FilterCampsAction;
import boundary.filter.FacultyParameter;
import boundary.filter.Filter;
import boundary.filter.FilterParameter;
import boundary.filter.LocationParameter;
import boundary.filter.NameParameter;
import boundary.filter.StaffParameter;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.interfaces.FacultyMember;
import model.interfaces.Locatable;
import model.interfaces.Nameable;

/*
 * CampFilterView is a class that is used to filter camps.
 */
public class CampFilterView extends ViewHandler {
	private final Filter<Camp> filter = new Filter<>();
	private final List<Camp> camps;
	/*
	 * Constructor for CampFilterView.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camps The camps to be used.
	 */

	public CampFilterView(Context context, UserSession session, List<Camp> camps) {
		super(context, session);
		this.camps = camps;
	}

	@Override
	/*
	 * Get the prompt.
	 * 
	 * @return "Add a filter, or perform a search:".
	 */
	protected String getPrompt() {
		return "Add a filter, or perform a search:";
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
	 * @return A list of actions.
	 */
	protected List<Action> generateActions() throws Exception {
		return List.of(
				new AddFilterAction<Locatable>(context, session,
						new LocationParameter(), filter),
				new AddFilterAction<FacultyMember>(context, session,
						new FacultyParameter(), filter),
				new AddFilterAction<Nameable>(context, session,
						new NameParameter(), filter),
				new AddFilterAction<Camp>(context, session,
						new StaffParameter(), filter),
				new FilterCampsAction(context, session, filter, camps),
				new PreviousViewAction(context, session));
	}

	@Override
	/*
	 * Gets the permissions.
	 * 
	 * @return A list of permissions.
	 */
	protected List<Permission> getPermissions() {
		return context.getPermissionManager()
				.getPermissions(this.session.getUser());
	}

}
