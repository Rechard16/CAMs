package entity.filter;

import java.io.IOException;

import entity.Locatable;
import main.Context;

/**
 * LocationParameter is a class that is used to filter locatables by
 * location.
 */

public class LocationParameter extends FilterParameter<Locatable> {
	private String s;

	public LocationParameter() {
	}

	@Override
	/**
	 * Builds the filter parameter.
	 * 
	 * @param context The context to be used.
	 */
	public void build(Context context) throws Exception {
		context.print("Enter the location you wish to search for");
		this.s = context.getScanner().nextLine();
	}

	@Override
	/**
	 * Gets the name of the filter parameter.
	 * 
	 * @return "Location"
	 */
	public String getName() {
		return "Location";
	}

	@Override
	/**
	 * Checks if the locatable is valid.
	 * 
	 * @param context The context to be used.
	 * @param obj     The locatable to be used.
	 * @return True if the locatable is valid, false otherwise.
	 */
	public boolean isValid(Context context, Locatable obj) throws ClassNotFoundException, IOException {
		return obj.getLocation().toUpperCase().contains(s.toUpperCase());
	}

}
