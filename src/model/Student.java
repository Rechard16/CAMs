package model;

import java.lang.reflect.Type;
import java.util.List;

public class Student extends User {
    private int points;
    private int CampID;
    private List<Integer> camps;
    public void viewRemainSlots(int campID) {
        // Implement the method
    }

    public void registerCamp(int campID) {
        // Implement the method
    }

    public void submitQuery(int campID, String description) {
        // Implement the method
    }

    public void submitSuggestion(int campID, List<Change> changes) {
        // Implement the method
    }

    public void withdrawCamp(int campID) {
        // Implement the method
    }



    @Override
    public int getId() {
        return this.id;
    }



    @Override
    protected void viewQuery() {

    }

    @Override
    protected void viewCamps() {

    }

    @Override
    protected void generateStudentList() {

    }

    @Override
    protected void filterCamps() {

    }
}
