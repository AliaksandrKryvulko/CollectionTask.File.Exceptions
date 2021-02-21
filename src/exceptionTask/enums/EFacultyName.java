package exceptionTask.enums;

public enum EFacultyName {
    ENGINEERING("engineering"),
    PROGRAMMING("programming"),
    BIOLOGY("biology");
    private final String name;

    EFacultyName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
