package entity.filter;

import entity.Nameable;
import main.Context;

public class NameParameter extends FilterParameter<Nameable> {
	private String s;
	/*
	 * Constructs a name parameter.
	 * 
	 * @param s The string to be used.
	 */

	public NameParameter(String s) {
		this.s = s;
	}
	/*
	 * Constructs a name parameter.
	 */

	public NameParameter() {
	}

	@Override
	/*
	 * Checks if the object is valid.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param obj The object to be used.
	 * 
	 * @return True if the object is valid, false otherwise.
	 */
	public boolean isValid(Context context, Nameable obj) {
		return obj.getName().toUpperCase().contains(s.toUpperCase());
	}

	@Override
	/*
	 * Gets the name of the filter parameter.
	 * 
	 * @return "Name"
	 */
	public void build(Context context) throws Exception {
		context.print("Enter the string you wish to search for:");
		this.s = context.getScanner().nextLine();
	}

	@Override
	/*
	 * Gets the name of the filter parameter.
	 * 
	 * @return "Name"
	 */
	public String getName() {
		return "name";
	}
}
