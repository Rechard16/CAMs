/*
Student:
• A student can only view the list of camps that are open to his/her user group (SCSE,
whole NTU etc.) and if their visibility has been toggled “on”.
• A student can view the remaining slots of each camp that is open to his/her.
• A student will be able to register for camps either as a camp attendee or camp
committee.
• A student can submit enquiries regarding a camp.
o Only staff and camp committees in charge of that camp can view it.
• A student can view, edit, and delete their enquiries before it is processed.
• The status of the student as a camp committee will be reflected in their profile.
• A student is only able to be in the camp committee for one camp but can attend
multiple camps.
• A student is not allowed to register for multiple camps if there are clashes in the
dates.
• A student only can register a camp before it is full.
• A student only can register a camp before it’s registration deadline.
• A student can see the camps that his/her has already registered for and his/her roles
(attendees OR camp committee)
• A student is allowed to withdraw from camps that his/her has already registered for.
The remaining slot will be updated automatically. But the student is not allowed to
register the same camp again
*/
package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private int points=0;
    private int campID=0;
    private List<Integer> camps = new ArrayList<Integer>();
    
    public Student() {super();}

    public Student(int id, String userID, Faculty faculty, String password, int campID) {
    	super(id, userID, faculty, password);
    	this.campID = campID;
    }
    
    @Override
    public UserType getType() { return UserType.STUDENT; }

    public void registerCamp(int campID) {
        // Implement the method
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    // Getter and Setter for CampID
    public int getCampID() {
        return this.campID;
    }

    public void setCampID(int CampID) {
        this.campID = CampID;
    }

    // Getter and Setter for camps
    public List<Integer> getCamps() {
        return this.camps;
    }

    public void setCamps(List<Integer> camps) {
        this.camps = camps;
    }
    
}
