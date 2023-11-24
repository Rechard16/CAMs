package boundary.action.views;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.ApplyChangesAction;
import boundary.action.actions.CancelChangesAction;
import boundary.action.actions.RejectSuggestionAction;
import boundary.display.CampDisplayer;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.Suggestion;
import model.change.Change;

public class SuggestionView extends ViewHandler{
	private final Camp camp;
	private final Suggestion suggestion;

	public SuggestionView(Context context, UserSession session, Camp camp, Suggestion suggestion) {
		super(context, session);
		this.camp = camp;
		this.suggestion = suggestion;
	}

	@Override
	protected String getPrompt() {
		return "How will you handle this suggestion?:";
	}
	
	@Override
	public void displayView() throws Exception {
		new CampDisplayer(context, camp).display();
		context.print("\nSuggested Modifications to this Camp:");
		for (Change change : suggestion.getModifier().getChanges()) {
			context.print("- " + change.getDescription());
		}
		super.displayView();

	}

	@Override
	protected List<Action> generateActions() throws Exception {
		return List.of(
				new ApplyChangesAction(context, session, camp, suggestion),
				new RejectSuggestionAction(context, session, suggestion),
				new CancelChangesAction(context, session)
				);
	}

	@Override
	protected List<Permission> getPermissions() {
		return context.getPermissionManager()
				.getCampModificationPermissions(this.session.getUser(), camp);
	}
}