package boundary.filter;

import java.io.IOException;

import main.Context;
import model.interfaces.Locatable;

public class LocationParameter extends FilterParameter<Locatable> {
	private String s;
	
	public LocationParameter() {}
	

	@Override
	public void build(Context context) throws Exception {
		context.print("Enter the location you wish to search for");
		this.s = context.getScanner().nextLine();
	}

	@Override
	public String getName() { return "Location"; }

	@Override
	public boolean isValid(Context context, Locatable obj) throws ClassNotFoundException, IOException {
		return obj.getLocation().toUpperCase().contains(s.toUpperCase());
	}

}
