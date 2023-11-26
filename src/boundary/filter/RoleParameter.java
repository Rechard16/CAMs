package boundary.filter;

import java.io.IOException;

import boundary.reader.EnumReader;
import main.Context;
import model.Camp;
import model.Role;
import model.interfaces.Registrable;

/**
 * RoleParameter is a class that is used to filter registrables by role.
 */
public class RoleParameter extends FilterParameter<Registrable> {
	private Role role;
	private final Camp camp;
	/*
	 * Constructor for RoleParameter.
	 * 
	 * @param camp The camp to be used.
	 */

	public RoleParameter(Camp camp) {
		this.camp = camp;
	}

	@Override
	/**
	 * Builds the filter parameter.
	 * 
	 * @param context The context to be used.
	 */
	public void build(Context context) throws Exception {
		context.print("What role do you want to search for?");
		role = new EnumReader<Role>(context, Role.class).readEnum();
	}

	@Override
	/**
	 * Gets the name of the filter parameter.
	 * 
	 * @return "Role"
	 */
	public String getName() {
		return "Role";
	}

	@Override
	/**
	 * Checks if the registrable is valid.
	 * 
	 * @param context The context to be used.
	 * @param obj     The registrable to be used.
	 * @return True if the registrable is valid, false otherwise.
	 */
	public boolean isValid(Context context, Registrable obj) throws ClassNotFoundException, IOException {
		return obj.getRole(camp) == role;
	}
}
