package model.change;

import main.Context;
import model.CampInfo;
import model.Model;

public class LocationChange extends Model implements Change {
    private String newLocation;

    private LocationChange(String newLocation) {
        this.newLocation = newLocation;
    }

    public static LocationChange create(Context context) {
        context.print("Enter the new location for your camp:");
        String newLocation = context.getScanner().nextLine();
        return new LocationChange(newLocation);
    }

    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setLocation(newLocation);
    }

	@Override
	public int getID() { return 0; }

	@Override
	public String getDescription() {
		return String.format("Change location to %s", newLocation);
	}
}
