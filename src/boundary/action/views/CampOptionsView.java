package boundary.action.views;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.ConfirmationAction;
import boundary.action.actions.CreateQueryAction;
import boundary.action.actions.DeleteCampAction;
import boundary.action.actions.ModifyCampAction;
import boundary.action.actions.PreviousViewAction;
import boundary.action.actions.RegisterAction;
import boundary.action.actions.RegisterCommitteeAction;
import boundary.action.actions.ToggleVisibilityAction;
import boundary.action.actions.ViewEnquiriesAction;
import boundary.action.actions.ViewEnquiriesSuperAction;
import boundary.action.actions.ViewSuggestionsAction;
import boundary.action.actions.ViewSuggestionsSuperAction;
import boundary.action.actions.WithdrawAction;
import boundary.action.actions.filter.UserFilterByAction;
import boundary.display.CampDisplayer;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;

public class CampOptionsView extends ViewHandler {
	private Camp camp;
	
	public CampOptionsView(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp=camp;
	}

	@Override
	protected String getPrompt() {
		return "What do you wish to do with this camp?";
	}
	
	@Override 
	public void displayView() throws Exception {
		new CampDisplayer(context, camp).display();
		super.displayView();
	}

	@Override
	protected List<Action> generateActions() {
		return List.of(
				new ToggleVisibilityAction(context, session, camp),
				new ModifyCampAction(context, session, camp),
				new ViewSuggestionsAction(context, session, camp),
				new ViewSuggestionsSuperAction(context, session, camp),
				new CreateQueryAction(context, session, camp),
				new ViewEnquiriesAction(context, session, camp),
				new ViewEnquiriesSuperAction(context, session, camp),
				new UserFilterByAction(context, session, camp),
				new RegisterAction(context, session, camp),
				new RegisterCommitteeAction(context, session, camp),
				new ConfirmationAction(context, session, 
						new WithdrawAction(context, session, camp)),
				new ConfirmationAction(context, session, 
						new DeleteCampAction(context, session, camp)),
				new PreviousViewAction(context, session)
				);
	}

	@Override
	protected List<Permission> getPermissions() {
		return context.getPermissionManager()
				.getCampModificationPermissions(this.session.getUser(), camp);
	}

}
