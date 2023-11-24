package boundary.filter;

import java.io.IOException;

import boundary.reader.EnumReader;
import main.Context;
import model.Camp;
import model.Role;
import model.interfaces.Registrable;

public class RoleParameter extends FilterParameter<Registrable>{
	private Role role;
	private final Camp camp;
	
	public RoleParameter(Camp camp) {
		this.camp = camp;
	}

	@Override
	public void build(Context context) throws Exception {
		context.print("What role do you want to search for?");
		role = new EnumReader<Role>(context, Role.class).readEnum();
	}

	@Override
	public String getName() {
		return "Role";
	}

	@Override
	public boolean isValid(Context context, Registrable obj) throws ClassNotFoundException, IOException {
		return obj.getRole(camp) == role;
	}
}
