package boundary.util;

import java.io.IOException;

import main.Context;
import model.Camp;

public class CampDisplayer {
	private final Context context;
	private final Camp camp;
	private final CampInfoDisplayer infoDisplayer;

	public CampDisplayer(Context context, Camp camp) {
		this.context = context;
		this.camp = camp;
		this.infoDisplayer = new CampInfoDisplayer(context, camp.getInformation());
	}
	
	public void dislayCamp() throws ClassNotFoundException, IOException {
		infoDisplayer.displayCampInfo();
		context.print(String.format("Available slots: %d", 
				camp.getInformation().getTotalSlots() - camp.getTotalRegistered()));
		context.print(String.format("Available committee slots: %d", 
				camp.getInformation().getCommitteeSlots() - camp.getCommitteeMembers().size()));
		context.print(String.format("This camp is %s to students.",
				camp.getVisibility()?"visible":"hidden"));
	}
}
