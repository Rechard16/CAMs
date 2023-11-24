package boundary.display;

import boundary.IO;
import main.Context;
import model.Camp;
import model.Role;
import model.User;

public class UserDisplayer extends Displayer {
	private final User user;
	private Camp camp;

	public UserDisplayer(Context context, User user) {
		super(context);
		this.user = user;
	}
	
	public UserDisplayer(IO io, Context context, User user) {
		super(io, context);
		this.user = user;
	}
	
	public void setCamp(Camp camp) {
		this.camp = camp;
	}

	@Override
	public void display() throws Exception {
		String s = user.getName();
		if (camp != null) {
			Role role = user.getRole(camp);
			if (role != Role.FREE_VIEWER && role != Role.VIEWER)
				s += String.format(" (%s)", role.name());
		}
		io.print(s);;
	}

}
