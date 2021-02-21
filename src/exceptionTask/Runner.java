package exceptionTask;

import exceptionTask.Journal.UniversityJournal;
import exceptionTask.bean.Faculty;
import exceptionTask.bean.Group;
import exceptionTask.Journal.Journal;
import exceptionTask.bean.Student;
import exceptionTask.enums.Subject;

import java.util.ArrayList;
import java.util.List;

import static exceptionTask.enums.EFacultyName.*;
import static exceptionTask.enums.Subject.*;

public class Runner {
    public static void main(String[] args) {
        //ArrayList <Subjects> subjects=new ArrayList<>();
        //Initialize Students
        Student vasilii = new Student("Vasilii", Subject.MATHEMATICS);
        Student masha = new Student("Mashai", Subject.MATHEMATICS);
        Student natasha = new Student("Natasha", ENGLISH);
        Student ilon = new Student("Ilon", MATHEMATICS);
        Student jennifer = new Student("Jennifer", OOP);
        //Adding students to List
        List<Student> studentList = new ArrayList<>(List.of(vasilii, masha, natasha, ilon, jennifer));
        //Initialize Group
        Group pk12 = new Group("Pk-12", studentList);
        Group pk13 = new Group("Pk-13", studentList);
        //create journal
        Journal journalPk12 = new Journal(MATHEMATICS, vasilii, 8);
        journalPk12.addRecord(MATHEMATICS, vasilii, 5);
        journalPk12.addRecord(MATHEMATICS, vasilii, 10);
        //apply journal for group
        pk12.setJournal(journalPk12);
        //calculate avgMark for specific student, for all subjects
        double avgStudentMark = journalPk12.getAvgMark(vasilii);
        //Creating faculty and add it in University Journal
        Faculty engineeringFaculty = new Faculty(ENGINEERING, pk12);
        //engineeringFaculty.addGroup(pk13);
        UniversityJournal universityJournal = new UniversityJournal(engineeringFaculty);
        //Calculate AvgMark for specific faculty group and subject
        double avgMarkOnSubjGroupFaculty = universityJournal.
                getAvgMark(engineeringFaculty, pk12, MATHEMATICS);
        System.out.printf("Showing Avg Mark on " + MATHEMATICS + " is %.3f \n", avgMarkOnSubjGroupFaculty);
        //Calculate AvgMark for specific subject in All University
        double avgMarkSubject = universityJournal.getAvgMark(MATHEMATICS);
        System.out.printf("Avg mark on subject in University %.3f", avgMarkSubject);

    }
}
