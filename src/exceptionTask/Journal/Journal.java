package exceptionTask.Journal;

import exceptionTask.bean.Student;
import exceptionTask.enums.Subject;
import exceptionTask.except.NonPositiveArgumentException;
import exceptionTask.except.SubjectsNotPresented;

import java.util.ArrayList;
import java.util.List;

public class Journal extends UniversityJournal {
    private List<JournalRecord> records = new ArrayList<>();

    public Journal() {
    }

    public Journal(Subject subject, Student student, int mark) {
        this.records.add(new JournalRecord(subject, student, mark));
    }

    // TODO: 2/20/2021 Exception on null
    public List<JournalRecord> getRecords() {
        return records;
    }

    public double getAvgMark(Subject subject) {
        int sum = 0;
        double avgMark = 0.;
        for (JournalRecord jr : records) {
            if (jr.subject.equals(subject)) {
                sum += jr.mark;
                avgMark++;
            }
        }
        return avgMark = sum / avgMark;
    }

    public void addRecord(Subject subject, Student student, int mark) {
        records.add(new JournalRecord(subject, student, mark));
    }

    public double getAvgMark(Student student) {
        int sum = 0;
        double avgMark = 0.;
        for (JournalRecord jr : records) {
            if (jr.student.equals(student)) {
                sum += jr.mark;
                avgMark++;
            }
        }
        return avgMark = sum / avgMark;
    }

    protected class JournalRecord {
        private Subject subject;
        private Student student;
        private int mark;

        public JournalRecord(Subject subject, Student student, int mark) {
            //subject not presented
            if (!student.getSubjects().contains(subject)) {
                throw new SubjectsNotPresented(student, subject);
            }
            //must be at least one subject
            if (student.getSubjects().isEmpty()) {
                throw new SubjectsNotPresented(student);
            }
            this.subject = subject;
            this.student = student;
            if (mark < 0 || mark > 10) {
                throw new NonPositiveArgumentException(student, mark);
            }
            this.mark = mark;
        }

        public Subject getSubject() {
            return subject;
        }

        public Student getStudent() {
            return student;
        }

        public int getMark() {
            return mark;
        }


    }
}
