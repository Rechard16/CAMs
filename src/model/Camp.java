package model;

import java.util.List;

public class Camp {
    private CampInfo information;
    private List<User> registered;
    private boolean visibility;
    private int Id;
    private List<Integer> committeeMembers;
    private List<Integer> students;
    private int totalRegistered;

    public void addStudent(Student student) {
        // Implement the method
    }

    public void removeStudent(Student student) {
        // Implement the method
    }

    public void addCommitteeMember(Student member) {
        // Implement the method
    }

    public void removeCommitteeMember(Student member) {
        // Implement the method
    }
}
