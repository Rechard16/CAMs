package model;

import java.lang.reflect.Type;
import java.util.List;

public class Student extends User {
    private int points;
    private int CampID;
    private List<Integer> camps;
    private database database;

    public void viewRemainSlots(int campID) {
        Camp camp = database.getCampById(campID);
        if (camp != null) {
            int remainingSlots = camp.getInformation().totalSlots - camp.getTotalRegistered();
            System.out.println("Remaining slots for camp " + campID + ": " + remainingSlots);
        } else {
            System.out.println("Camp not found.");
        }
    }

    public void registerCamp(int campID) {
        Camp camp = database.getCampById(campID);
        if (camp != null && !camps.contains(campID)) {
            camp.addStudent(this);
            camps.add(campID);
            database.updateCamp(camp);
        } else {
            System.out.println("Camp not found or already registered.");
        }
    }

    public void submitQuery(int campID, String description) {
        //
    }

    public void submitSuggestion(int campID, List<Change> changes) {
        //
    }

    public void withdrawCamp(int campID) {
        if (camps.contains(campID)) {
            Camp camp = database.getCampById(campID);
            if (camp != null) {
                camp.removeStudent(this);
                camps.remove(Integer.valueOf(campID));
                database.updateCamp(camp);
            }
        } else {
            System.out.println("You are not registered for this camp or camp not found.");
        }
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