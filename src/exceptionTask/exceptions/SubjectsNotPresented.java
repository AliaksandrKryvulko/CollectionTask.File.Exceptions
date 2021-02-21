package exceptionTask.exceptions;

import exceptionTask.bean.Student;
import exceptionTask.enums.Subject;

public class SubjectsNotPresented extends RuntimeException {
private Subject subject;

    public SubjectsNotPresented(Student student) {
        super();
        System.err.println("This student "+student+" don't have any subject");
    }

    public SubjectsNotPresented(Student student ,Subject subject) {
        super();
        System.err.println("This student "+student+"don't have this subject "+ subject);
    }

}
