package boundary.action.actions.filter;

import java.util.List;

import boundary.action.Action;
import boundary.action.View;
import boundary.action.views.CampListingView;
import boundary.filter.Filter;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;

public class FilterCampsAction extends Action {
	private final Filter<Camp> filter;
	private List<Camp> camps;

	public FilterCampsAction(Context context, UserSession session, 
			Filter<Camp> filter, List<Camp> camps) {
		super(context, session);
		this.filter = filter;
		this.camps = camps;
	}

	@Override
	public String getDescription() {
		return "Search with current filter";
	}

	@Override
	public void performAction() throws Exception {
		camps = filter.getValid(context, camps);
	}
	
	@Override
	public View getNextView() {
		return new CampListingView(context, session, camps);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMPS);
	}
}
