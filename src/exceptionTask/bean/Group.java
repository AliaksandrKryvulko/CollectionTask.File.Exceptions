package exceptionTask.bean;

import exceptionTask.Journal.Journal;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupName;
    private List<Student> students;
    private Journal journal;

    public Group() {
        students = new ArrayList<>();
    }

    public Group(String groupName, List<Student> students, Journal journal) {
        this.groupName = groupName;
        this.students = students;
        this.journal = journal;
    }

    public Group(String groupName, List<Student> students) {
        this.groupName = groupName;
        this.students = students;
    }

    public Group(String groupName) {
        this();
        this.groupName = groupName;
    }

    public Group(List<Student> students) {
        this.students = students;
    }


    public void addStudents(Student student) {
        students.add(student);
    }

    public String getGroupName() {
        return groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public void showAllStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                '}';
    }
}
