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

public class CampFilterView extends ViewHandler {
	private final Filter<Camp> filter = new Filter<>();
	private final List<Camp> camps;

	public CampFilterView(Context context, UserSession session, List<Camp> camps) {
		super(context, session);
		this.camps = camps;
	}

	@Override
	protected String getPrompt() {
		return "Add a filter, or perform a search:";
	}
	
	@Override
	public void displayView() throws Exception {
		String filters = "Currently filtering by:";
		for (FilterParameter<?> param: filter.getParameters())
			filters += String.format(" %s,", param.getName());
		context.print(filters);

		super.displayView();
	}

	@Override
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
				new PreviousViewAction(context, session)
				);
	}

	@Override
	protected List<Permission> getPermissions() {
		return context.getPermissionManager()
				.getPermissions(this.session.getUser());
	}

}
