package boundary.filter;

import main.Context;
import model.interfaces.Nameable;

public class NameParameter extends FilterParameter<Nameable> {
	private String s;
	
	public NameParameter(String s) {
		this.s = s;
	}
	
	public NameParameter() {}

	@Override
	public boolean isValid(Context context, Nameable obj) {
		return obj.getName().toUpperCase().contains(s.toUpperCase());
	}

	@Override
	public void build(Context context) throws Exception {
		context.print("Enter the string you wish to search for:");
		this.s = context.getScanner().nextLine();
	}

	@Override
	public String getName() { return "name"; }
}
