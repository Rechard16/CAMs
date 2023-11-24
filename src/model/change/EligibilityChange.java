package model.change;

import boundary.reader.BooleanReader;
import main.Context;
import model.CampInfo;
import model.Faculty;
import model.Model;
import model.User;

public class EligibilityChange extends Model implements Change {
    private Faculty newEligibility;

    private EligibilityChange(Faculty newEligibility) {
        this.newEligibility = newEligibility;
    }

    public static EligibilityChange create(Context context, User user) {
        context.print("Will your camp be open to the school?");
        boolean open = new BooleanReader(context).readBool();

        return new EligibilityChange(open ? Faculty.SCHOOL : user.getFaculty());
    }

    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setEligibility(newEligibility);
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public String getDescription() {
        return String.format("Change eligibility to %s", newEligibility.name());
    }
}
