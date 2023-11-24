package boundary.action.actions;

import java.io.IOException;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.ModifySuggestionView;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.Suggestion;
import model.SuggestionStatus;

public class ModifySuggestionAction extends Action {
	private final Suggestion suggestion;
	private final Camp camp;

	public ModifySuggestionAction(Context context, UserSession session, Camp camp, Suggestion suggestion) throws ClassNotFoundException, IOException {
		super(context, session);
		this.suggestion = suggestion;
		this.camp = camp;
	}

	@Override
	public String getDescription() {
		String name = suggestion.getDescription();
		if (suggestion.getStatus() != SuggestionStatus.OPEN)
			name += String.format(" (%s)", suggestion.getStatus().name());
		return name;
	}

	@Override
	public void performAction() throws Exception {}
	
	@Override
	public ViewHandler getNextView() {
		return new ModifySuggestionView(context, session, camp, suggestion);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.MODIFY_CAMP, Permission.SUGGEST_CAMP);
	}
}
