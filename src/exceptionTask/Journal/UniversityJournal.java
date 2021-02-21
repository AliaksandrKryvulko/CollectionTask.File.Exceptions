package exceptionTask.Journal;

import exceptionTask.bean.Faculty;
import exceptionTask.bean.Group;
import exceptionTask.enums.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UniversityJournal {
    private List<Faculty> faculties;

    // TODO: 2/19/2021     //checking what faculty list not empty throw exception if empty 
    //Not shure about this, initialize in field or in constructor?
    public UniversityJournal() {
        faculties = new ArrayList<>();
    }

    public UniversityJournal(List<Faculty> faculty) {
        this.faculties = faculty;
    }

    public UniversityJournal(Faculty faculty) {
        this();
        this.faculties.add(faculty);
    }

    public List<Faculty> getFacultyList() {
        return faculties;
    }

    // TODO: 2/18/2021 return null it's normal?
    Faculty getSpecificFaculty(String facultyName) {
        for (Faculty faculty : faculties) {
            if (facultyName.equals(faculty.getFacultyName())) {
                return faculty;
            }
        }
        return null;
    }

    public double getAvgMark(Subject subject) {
        List<Integer> sumMark = new ArrayList<>();
        sumMark = faculties.stream()
                .map(faculty -> faculty.getGroups())
                .flatMap(groups -> groups.stream())
                .map(group -> group.getJournal())
                .map(journal -> journal.getRecords())
                .flatMap(jRecords -> jRecords.stream())
                .filter(journalRecord -> journalRecord.getSubject() == subject)
                .map(Journal.JournalRecord::getMark)
                .collect(Collectors.toList());
        double quantity = (double) sumMark.stream().count();
        return sumMark.stream().mapToInt(Integer::valueOf).sum() / quantity;
    }

    //get avg mark for (specific) subject group and faculty in all University
    public double getAvgMark(Faculty faculty, Group group, Subject subject) {
        double sum = 0;
        for (Faculty curentFaculty : this.faculties) {
            if (faculty.equals(curentFaculty)) {
                sum = faculty.getGroup(group).getJournal().getAvgMark(subject);
            }
        }
        return sum;
    }

    //list of faculty
    //getAvgMark on specific subject
    //getFacultyList
    //checking what faculty list not empty throw exception if empty
}
