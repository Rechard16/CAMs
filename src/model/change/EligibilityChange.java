package model.change;

import boundary.reader.BooleanReader;
import main.Context;
import model.CampInfo;
import model.Change;
import model.Faculty;
import model.User;

public class EligibilityChange implements Change {
    private Faculty newEligibility;

    private EligibilityChange(Faculty newEligibility) {
        this.newEligibility = newEligibility;
    }

    public static EligibilityChange create(Context context, User user) {
		context.print("Will your camp be open to the school?");
		boolean open = new BooleanReader(context).readBool();
		
		return new EligibilityChange(open?Faculty.SCHOOL: user.getFaculty());
    }

    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setEligibility(newEligibility);
    }
}
