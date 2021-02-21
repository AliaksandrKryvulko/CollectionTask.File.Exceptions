package exceptionTask.exceptions;

import exceptionTask.bean.Student;

public class NonPositiveArgumentException extends IllegalArgumentException {
private int value;
private Student student;

    public NonPositiveArgumentException() {
        super();
    }

    public NonPositiveArgumentException(Student student, int value) {
        super();
        this.value=value;
        this.student=student;
    }

    public NonPositiveArgumentException(int value) {
        super();
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Attempt to apply not appropriate value - " + value+" for "+student;
    }
}
