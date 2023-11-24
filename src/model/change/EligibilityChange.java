package model.change;

import main.Context;
import model.CampInfo;
import model.Faculty;
import model.Change;

public class EligibilityChange implements Change {
    private Faculty newEligibility;

    private EligibilityChange(Faculty newEligibility) {
        this.newEligibility = newEligibility;
    }

    public static EligibilityChange create(Context context) {
        context.print("Enter the new eligibility criteria for your camp (e.g., SCSE, NBS, ADM, SSS, EEE, or SCHOOL):");
        String eligibilityString = context.getScanner().nextLine();

        try {
            Faculty newEligibility = Faculty.valueOf(eligibilityString.toUpperCase());
            return new EligibilityChange(newEligibility);
        } catch (IllegalArgumentException e) {
            context.print("Invalid faculty name. Please enter a valid faculty name.");
            return null; 
        }
    }

    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setEligibility(newEligibility);
    }
}
