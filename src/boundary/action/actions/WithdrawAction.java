package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.interfaces.Registrable;

public class WithdrawAction extends Action {
	private final Camp camp;

	public WithdrawAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	public String getDescription() {
		return "Withdraw from Camp";
	}

	@Override
	public void performAction() throws Exception {
		Registrable user = session.getUser();
		user.deregister(camp);
		camp.removeUser(user.getID());
		
		context.getUserManager().save();
		context.getCampManager().save();
		
		context.print("You have successfully withdrawn from the camp.");
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.WITHDRAW);
	}

	@Override
	public ViewHandler getNextView() {
		return session.getViewStack().reset();
	}
}
