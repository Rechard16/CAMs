package model;

import java.util.List;

public interface database {
    public void getFilePath();

    public void save();

    public void load();

    public void add();

    public void delete();

    public void update();

    public void getAll();

    public void getByID();

    public void isEmpty();

    public void clear();

    /*
     * void addCamp(Camp camp);
     * 
     * void updateCamp(int campID, CampInfo campInfo);
     * 
     * void deleteCamp(int campID);
     * 
     * void toggleCampVisibility(int campID);
     * 
     * Camp getCampById(int campID);
     * 
     * Suggestion getSuggestionById(int suggestionID);
     * 
     * Suggestion updateSuggestion(Suggestion suggestion);
     * 
     * Suggestion deleteSuggestion(int suggestionID);
     * 
     * void approveSuggestion(int suggestionID);
     * 
     * List<Camp> getAllCamps();
     * 
     * List<Student> getAllStudents();
     * 
     * List<Student> getStudentsByCampId(int campID);
     * .........
     */
}
