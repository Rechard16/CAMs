/*
Staff:
• A staff will be able to create, edit and delete camps.
• A staff can toggle the visibility of the camp to be “on” or “off”. This will be reflected
in the camp list that will be visible to students.
• A staff can view all camps.
• A staff can see list of camps that his/her created in a separate menu list so they can
edit the camps they created.
• A staff can view and reply to enquiries from students to the camp(s) his/her has
created.
• A staff can view and approve suggestions to changes to camp details from camp
committee.
• A staff can generate a report of the list of students attending each camp that his/her
has created. The list will include details of the camp as well as the roles of the
participants. There should be filters for how the staff would want to generate the list.
(attendee, camp committee, etc.) (generate in either txt or csv format).
• A staff can also generate a performance report of the camp committee members
*/

package model;

import java.util.List;
import database.CampDatabase;
import database.SuggestionDatabase;
//import java.util.Scanner;

public class Staff extends User {
    private CampDatabase campDatabase;
    private SuggestionDatabase suggestionDatabase;

    public Camp createCamp(CampInfo campInfo) {
        Camp camp = new Camp(campInfo);
        campDatabase.add(camp);
        return camp;
    }

    public void editCamp(int campID, CampInfo campInfo) {
        Camp camp = campDatabase.getAll().stream()
                .filter(c -> c.getId() == campID)
                .findFirst()
                .orElse(null);
        if (camp != null) {
            camp.setInformation(campInfo);
            campDatabase.update(camp);
        }
    }

    public void deleteCamp(int campID) {
        Camp camp = campDatabase.getAll().stream()
                .filter(c -> c.getId() == campID)
                .findFirst()
                .orElse(null);
        if (camp != null) {
            campDatabase.remove(camp);
        }
    }

    public void toggleVisibility(int campID) {
        Camp camp = campDatabase.getAll().stream()
                .filter(c -> c.getId() == campID)
                .findFirst()
                .orElse(null);
        if (camp != null) {
            camp.setVisibility(!camp.isVisible());
            campDatabase.update(camp);
        }
    }

    public void viewSuggestion(int suggestionID) {
        Suggestion suggestion = suggestionDatabase.getAll().stream()
                .filter(s -> s.getId() == suggestionID)
                .findFirst()
                .orElse(null);

        if (suggestion != null) {
            suggestion.view();
        } else {
            System.out.println("Suggestion not found.");
        }
    }

    public void approveSuggestion(int suggestionID) {
        /*
         * 没法实现
         * Suggestion suggestion = suggestionDatabase.getAll().stream()
         * .filter(s -> s.getId() == suggestionID)
         * .findFirst()
         * .orElse(null);
         * 
         * if (suggestion != null) {
         * // Assume there's a method in Suggestion to approve it
         * suggestion.approve();
         * suggestionDatabase.update(suggestion);
         * } else {
         * System.out.println("Suggestion not found.");
         * }
         */
    }

    public void generateReport() {
        // 没法实现，缺乏 staff id在camp对象中
    }

    protected void viewQuery() {
        // 待实现
    }

    public void viewCamps() {
        List<Camp> camps = campDatabase.getAll();
        for (Camp camp : camps) {
            System.out.println(camp); // Assuming Camp class has a proper toString method
        }
    }

    protected void generateStudentList() {
        // 没法实现，缺乏 staff id在camp对象中
    }

    protected void filterCamps() {
        // 待实现
    }
}