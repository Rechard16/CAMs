package model.change;

import java.util.Date;

import boundary.reader.DateReader;
import main.Context;
import model.CampInfo;
import model.Change;
import model.Model;

public class DeadlineChange extends Model implements Change {
    private Date newDeadline;

    private DeadlineChange(Date newDeadline) {
        this.newDeadline = newDeadline;
    }

    public static DeadlineChange create(Context context) {
        context.print("Enter the new registration deadline for your camp:");
        Date newDeadline = new DateReader(context).readDate();
        return new DeadlineChange(newDeadline);
    }

    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setDeadline(newDeadline);
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public String getDescription() {
        return String.format("Change deadline to: %s", newDeadline.toString());
    }

}
