package exceptionTask.bean;

import exceptionTask.enums.Subject;

import java.util.*;

public class Student extends Group {
    private String name;
    private List<Subject> subjects = new ArrayList<>();//no one?
    //private ListMultimap<Subject, Integer> marks = ArrayListMultimap.create();
   /* private String group;//it's nececery heare?
    private EFacultyName facultyName;//it's nececery heare?
*/

    public Student(String name, Subject subject) {
        this.subjects.add(subject);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getName().equals(student.getName()) &&
                getSubjects().equals(student.getSubjects());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSubjects());
    }

    @Override
    public String toString() {
        return "Student " + name + " subjects " + subjects;
    }
}