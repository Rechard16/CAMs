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

/**
 * The DatesChange class is an implementation of the Change interface
 * that allows modifying the start and end dates of a CampInfo object.
 */
public class DatesChange extends Model implements Change {
    /**
     * The new start date for the camp.
     */
    private Date newStartDate;

    /**
     * The new end date for the camp.
     */
    private Date newEndDate;

    /**
     * Private constructor to create an instance of DatesChange with specified start and end dates.
     *
     * @param newStartDate The new start date for the camp.
     * @param newEndDate   The new end date for the camp.
     */
    private DatesChange(Date newStartDate, Date newEndDate) {
        this.newStartDate = newStartDate;
        this.newEndDate = newEndDate;
    }

    /**
     * Creates a new DatesChange object after prompting the user for the new start and end dates.
     * 
     * @param context The context providing necessary interactions for user input.
     * @return A new instance of DatesChange with the specified start and end dates.
     */
    public static DatesChange create(Context context) {
        context.print("What date will your camp start?");
        Date newStartDate = new DateReader(context).readDate();

        context.print("What date will your camp end?");
        Date newEndDate = new DateReader(context).readDate();

        return new DatesChange(newStartDate, newEndDate);
    }

    /**
     * Applies the change to the given CampInfo object by setting its start and end dates to the new values.
     *
     * @param campInfo The CampInfo object to be modified.
     */
    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setDates(List.of(newStartDate, newEndDate));
    }

    /**
     * Retrieves the unique identifier of this change. In this implementation, it always returns 0.
     *
     * @return The unique identifier (always 0 for this implementation).
     */
    @Override
    public int getID() {
        return 0;
    }

    /**
     * Provides a description of this change, specifically stating the new start and end dates.
     *
     * @return A String description of the modification.
     */
    @Override
    public String getDescription() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("Change start date to %s and end date to %s",
                dateFormat.format(newStartDate),
                dateFormat.format(newEndDate));
    }
}
