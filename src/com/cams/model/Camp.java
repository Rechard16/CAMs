package model;

import java.util.ArrayList;
import java.util.List;

public class Camp extends Model {
    private CampInfo information;
    private List<User> registered;
    private boolean visibility;
    public int Id;
    private List<Integer> committeeMembers;
    private List<Integer> students;
    private int totalRegistered;

    public Camp(CampInfo information) {
        this.information = information;
        this.registered = new ArrayList<>();
        this.visibility = true; // Or false, depending on default visibility requirements
        this.Id = information.getId(); // Assuming the ID comes from the CampInfo object
        this.committeeMembers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.totalRegistered = 0;
    }

    public void addStudent(Student student) {
        // Implement the method
        if (student != null && !students.contains(student.getId())) {
            students.add(student.getId());
            registered.add(student);
            totalRegistered++;
        }
    }

    public void removeStudent(Student student) {
        // Implement the method
        if (student != null && students.contains(student.getId())) {
            students.remove(Integer.valueOf(student.getId()));
            registered.remove(student);
            totalRegistered--;
        }
    }

    public void addCommitteeMember(Student member) {
        // Implement the method
        if (member != null && !committeeMembers.contains(member.getId())) {
            committeeMembers.add(member.getId());
            if (!registered.contains(member)) {
                registered.add(member);
                totalRegistered++;
            }
        }
    }

    public void removeCommitteeMember(Student member) {
        // Implement the method
        if (member != null && committeeMembers.contains(member.getId())) {
            committeeMembers.remove(Integer.valueOf(member.getId()));
        }
    }

    public int getId() {
        return this.Id;
    }

    public CampInfo getInformation() {
        return this.information;
    }
    
    public void setVisibility(boolean visible) {
    	if (visible == true) {
    		this.visibility = true;
    	}
    	else {
    		this.visibility = false;
    	}
    }

}