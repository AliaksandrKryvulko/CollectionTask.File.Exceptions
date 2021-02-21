package exceptionTask.bean;

import exceptionTask.enums.EFacultyName;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private EFacultyName facultyName;
    private List<Group> groups;


    public Faculty() {
        groups = new ArrayList<>();
    }

    public Faculty(EFacultyName facultyName, Group group) {
        this();
        this.facultyName = facultyName;
        groups.add(group);
    }


    public Faculty(EFacultyName facultyName, List<Group> groups) {
        this.facultyName = facultyName;
        this.groups = groups;
    }

    public List<Group> getGroups() {
        return groups;
    }


    // TODO: 2/20/2021 returning null?
    public Group getGroup(Group group) {
        for (Group grp : groups) {
            if (grp.equals(group))
                return grp;
        }
        return null;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public EFacultyName getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(EFacultyName facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyName=" + facultyName +
                '}';
    }
}
