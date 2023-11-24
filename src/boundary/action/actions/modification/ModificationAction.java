package boundary.action.actions.modification;

import java.util.List;

import boundary.action.Action;
import boundary.login.UserSession;
import main.Context;
import model.CampInfoModifier;
import model.Permission;

public abstract class ModificationAction extends Action {
	protected final CampInfoModifier modifier;
	
	public ModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
		super(context, session);
		this.modifier = modifier;
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMP, Permission.MODIFY_CAMP);
	}
	
	public static List<Action> getModificationActions(Context context, UserSession session, CampInfoModifier modifier) {
		return List.of(
				new NameModificationAction(context, session, modifier),
				new LocationModificationAction(context, session, modifier),
				new TotalSlotsModificationAction(context, session, modifier),
				new CommitteeSlotsModificationAction(context, session, modifier),
				new EligibilityModificationAction(context, session, modifier),
				new DescriptionModificationAction(context, session, modifier),
				new DatesModificationAction(context, session, modifier),
				new DeadlineModificationAction(context, session, modifier)
				);
	}
}
