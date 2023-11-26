package boundary.display;

import boundary.IO;
import entity.model.Camp;
import entity.model.Role;
import entity.model.User;
import main.Context;

public class UserDisplayer extends Displayer {
	private final User user;
	private Camp camp;

	/*
	 * Constructor for UserDisplayer.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param user The user to be used.
	 */

	public UserDisplayer(Context context, User user) {
		super(context);
		this.user = user;
	}
	/*
	 * Constructor for UserDisplayer.
	 * 
	 * @param io The IO to be used.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param user The user to be used.
	 */

	public UserDisplayer(IO io, Context context, User user) {
		super(io, context);
		this.user = user;
	}

	/*
	 * setCamp is a method that sets the camp.
	 * 
	 * @param camp The camp to be set.
	 * 
	 */

	public void setCamp(Camp camp) {
		this.camp = camp;
	}

	@Override

	/**
	 * Displays the user.
	 * 
	 * @throws Exception
	 */

	public void display() throws Exception {
		String s = user.getName();
		if (camp != null) {
			Role role = user.getRole(camp);
			if (role != Role.FREE_VIEWER && role != Role.VIEWER)
				s += String.format(" (%s)", role.name());
		}
		io.print(s);
		;
	}

}
