package model;

import java.util.ArrayList;
import java.util.List;

public class Camp extends Model {
    private CampInfo information;
    private List<User> registered;
    private boolean visibility;
    private int Id;
    private List<Integer> committeeMembers;
    private List<Integer> students;
    private int totalRegistered;

    public Camp(CampInfo information) {
        this.information = information;
        this.registered = new ArrayList<>();
        this.committeeMembers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.totalRegistered = 0;
        this.visibility = true; // 默认设置为可见
        this.Id = information.getId(); // 根据提供的信息设置ID
    }

    public boolean isVisible() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public void setInformation(CampInfo information) {
        this.information = information;
    }

    public void addStudent(Student student) {
        // Adds a student to the list of registered students and updates the total
        if (student != null && !this.students.contains(student.getId())) {
            this.students.add(student.getId());
            this.registered.add(student);
            this.totalRegistered++;
        }
    }

    public void removeStudent(Student student) {
        // Removes a student from the list of registered students and updates the total
        if (student != null && this.students.remove(Integer.valueOf(student.getId()))) {
            this.registered.remove(student);
            this.totalRegistered--;
        }
    }

    public void addCommitteeMember(Student member) {
        // Adds a committee member to the list if they are not already in it
        if (member != null && !this.committeeMembers.contains(member.getId())) {
            this.committeeMembers.add(member.getId());
        }
    }

    public void removeCommitteeMember(Student member) {
        // Removes a committee member from the list
        if (member != null) {
            this.committeeMembers.remove(Integer.valueOf(member.getId()));
        }
    }

    public int getId() {
        return this.Id;
    }
}
