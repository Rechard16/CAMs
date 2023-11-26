package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import control.login.UserSession;
import entity.Registrable;
import entity.model.Camp;
import entity.model.Permission;
import main.Context;

public class WithdrawAction extends Action {
	private final Camp camp;
	/*
	 * Constructor for WithdrawAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 */

	public WithdrawAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Withdraw from Camp".
	 */
	public String getDescription() {
		return "Withdraw from Camp";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		Registrable user = session.getUser();
		user.deregister(camp);
		camp.removeUser(user.getID());

		context.getUserManager().save();
		context.getCampManager().save();

		context.print("You have successfully withdrawn from the camp.");
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return The required permissions.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.WITHDRAW);
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public ViewHandler getNextView() {
		return session.getViewStack().reset();
	}
}
