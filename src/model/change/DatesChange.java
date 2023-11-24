package model.change;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import boundary.reader.DateReader;
import main.Context;
import model.CampInfo;
import model.Change;
import model.Model;

public class DatesChange extends Model implements Change {
    private Date newStartDate;

    private DatesChange(Date newStartDate) {
        this.newStartDate = newStartDate;
    }

    public static DatesChange create(Context context) {
        context.print("Enter the new start date for your camp:");
        Date newStartDate = new DateReader(context).readDate();

        return new DatesChange(newStartDate);
    }

    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setDates(List.of(newStartDate));
    }

	@Override
	public int getID() { return 0; }

	@Override
	public String getDescription() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		return String.format("Change start date to %s", dateFormat.format(newStartDate));
	}
}
