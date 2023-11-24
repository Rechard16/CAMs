package boundary.display;

import java.io.IOException;

import boundary.IO;
import main.Context;
import model.Camp;

public class CampDisplayer extends Displayer {
	private final Camp camp;

	public CampDisplayer(Context context, Camp camp) {
		super(context);
		this.camp = camp;
	}

	public CampDisplayer(IO io, Context context, Camp camp) {
		super(io, context);
		this.camp = camp;
	}
	
	@Override
	public void display() throws ClassNotFoundException, IOException {
		CampInfoDisplayer infoDisplayer = new CampInfoDisplayer(io, context, camp.getInformation());

		io.lineBreak();
		infoDisplayer.display();
		io.print(String.format("Available slots: %d", 
				camp.getInformation().getTotalSlots() - camp.getTotalRegistered()));
		io.print(String.format("Available committee slots: %d", 
				camp.getInformation().getCommitteeSlots() - camp.getCommitteeMembers().size()));
		io.print(String.format("This camp is %s to students.",
				camp.getVisibility()?"visible":"hidden"));
	}
}
