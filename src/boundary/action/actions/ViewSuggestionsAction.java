package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.SuggestionListingView;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.Suggestion;

public class ViewSuggestionsAction extends Action {
	private final Camp camp;
	private List<Suggestion> suggestions;

	public ViewSuggestionsAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}
	
	@Override
	public String getDescription() { return "View all suggestions for camp"; }

	@Override
	public void performAction() throws Exception {
		suggestions = context.getSuggestionManager().getSuggestionsByCamp(camp.getID());
	}

	@Override
	public ViewHandler getNextView() {
		return new SuggestionListingView(context, session, camp, suggestions);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.MODIFY_CAMP, Permission.APPROVE_SUGGEST);
	}


}
