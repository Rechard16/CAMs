package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.display.CampDisplayer;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.CampInfoModifier;
import model.Permission;
/*
 * ApplyChangesAction is a class that is used to apply changes.
 */

public class PrintCampAction extends Action {
	private final Camp camp;
	private final CampInfoModifier modifier;
	/*
	 * Constructor for ApplyChangesAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 * 
	 * @param modifier The modifier to be used.
	 */

	public PrintCampAction(Context context, UserSession session, Camp camp,
			CampInfoModifier modifier) {
		super(context, session);
		this.camp = new Camp(camp);
		this.modifier = modifier;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Preview this camp".
	 */
	public String getDescription() {
		return "Preview this camp";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		Camp modified = modifier.modify(camp);
		new CampDisplayer(context, modified).display();
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return The required permissions.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMP, Permission.CREATE_CAMP);
	}

}
