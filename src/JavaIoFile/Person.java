package JavaIoFile;

import java.util.stream.Stream;

public class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return  "age=" + age +
                ", name='" + name;
    }
}
