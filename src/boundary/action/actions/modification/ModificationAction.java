package boundary.action.actions.modification;

import java.util.List;

import boundary.action.Action;
import control.login.UserSession;
import entity.model.CampInfoModifier;
import entity.model.Permission;
import main.Context;

public abstract class ModificationAction extends Action {
	protected final CampInfoModifier modifier;
	/*
	 * Constructor for ModificationAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param modifier The modifier to be used.
	 */

	public ModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
		super(context, session);
		this.modifier = modifier;
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return List.of(Permission.VIEW_CAMP, Permission.MODIFY_CAMP).
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMP, Permission.MODIFY_CAMP);
	}
	/*
	 * Get the modification actions.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param modifier The modifier to be used.
	 * 
	 * @return List.of(
	 * 
	 * new NameModificationAction(context, session, modifier),
	 * 
	 * new LocationModificationAction(context, session, modifier),
	 * 
	 * new TotalSlotsModificationAction(context, session, modifier),
	 * 
	 * new CommitteeSlotsModificationAction(context, session, modifier),
	 * 
	 * new EligibilityModificationAction(context, session, modifier),
	 * 
	 * new DescriptionModificationAction(context, session, modifier),
	 * 
	 * new DatesModificationAction(context, session, modifier),
	 * 
	 * new DeadlineModificationAction(context, session, modifier));
	 */

	public static List<Action> getModificationActions(Context context, UserSession session, CampInfoModifier modifier) {
		return List.of(
				new NameModificationAction(context, session, modifier),
				new LocationModificationAction(context, session, modifier),
				new TotalSlotsModificationAction(context, session, modifier),
				new CommitteeSlotsModificationAction(context, session, modifier),
				new EligibilityModificationAction(context, session, modifier),
				new DescriptionModificationAction(context, session, modifier),
				new DeadlineModificationAction(context, session, modifier));
	}
}
