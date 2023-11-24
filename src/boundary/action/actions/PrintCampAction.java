package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.display.CampDisplayer;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.CampInfoModifier;
import model.Permission;

public class PrintCampAction extends Action{
	private final Camp camp;
	private final CampInfoModifier modifier;
	
	public PrintCampAction(Context context, UserSession session, Camp camp, 
			CampInfoModifier modifier) {
		super(context, session);
		this.camp = new Camp(camp);
		this.modifier = modifier;
	}

	@Override
	public String getDescription() { return "Preview this camp"; }

	@Override
	public void performAction() throws Exception {
		Camp modified = modifier.modify(camp);
		new CampDisplayer(context, modified).display();
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMP, Permission.CREATE_CAMP);
	}

}
