package boundary.action.views;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.ApplyChangesAction;
import boundary.action.actions.CancelChangesAction;
import boundary.action.actions.PrintCampAction;
import boundary.action.actions.SubmitSuggestionAction;
//import boundary.action.actions.ToggleVisibilityAction;
import boundary.action.actions.modification.CommitteeSlotsModificationAction;
import boundary.action.actions.modification.DatesModificationAction;
import boundary.action.actions.modification.DeadlineModificationAction;
import boundary.action.actions.modification.DescriptionModificationAction;
import boundary.action.actions.modification.EligibilityModificationAction;
import boundary.action.actions.modification.LocationModificationAction;
import boundary.action.actions.modification.NameModificationAction;
import boundary.action.actions.modification.TotalSlotsModificationAction;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.CampInfoModifier;
import model.Change;
import model.Permission;
import model.Suggestion;

public class ModifyCampView extends ViewHandler {
	private final Camp camp;
	private final CampInfoModifier modifier;

	public ModifyCampView(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
		this.modifier = new CampInfoModifier();
	}

	public ModifyCampView(Context context, UserSession session, Camp camp, Suggestion suggestion) {
		super(context, session);
		this.camp = camp;
		this.modifier = new CampInfoModifier(suggestion.getModifier());
	}

	@Override
	protected String getPrompt() {
		return "How will you modify this camp?:";
	}

	@Override
	public void displayView() throws Exception {
		new PrintCampAction(context, session, camp, modifier)
				.performAction();
		context.print("\nCurrent Modifications to this Camp:");
		for (Change change : modifier.getChanges()) {
			context.print("- " + change.getDescription());
		}
		super.displayView();
	}

	@Override
	protected List<Action> generateActions() {
		return List.of(
				new NameModificationAction(context, session, modifier),
				new LocationModificationAction(context, session, modifier),
				new TotalSlotsModificationAction(context, session, modifier),
				new CommitteeSlotsModificationAction(context, session, modifier),
				new EligibilityModificationAction(context, session, modifier),
				new DescriptionModificationAction(context, session, modifier),
				new DatesModificationAction(context, session, modifier),
				new DeadlineModificationAction(context, session, modifier),

				// new ToggleVisibilityAction(context, session, camp),
				new SubmitSuggestionAction(context, session, camp, modifier),
				new ApplyChangesAction(context, session, camp, modifier),
				new CancelChangesAction(context, session));
	}

	@Override
	protected List<Permission> getPermissions() {
		return context.getPermissionManager()
				.getCampModificationPermissions(this.session.getUser(), camp);
	}
}
