package JavaIoFile;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommLineArg {
    public static void main(String[] args) {
        Function<String, String> trim = String::trim;
        String str = trim
                .andThen(String::toLowerCase)
                .andThen(StringBuilder::new)
                .andThen(StringBuilder::reverse)
                .andThen(StringBuilder::toString)
                .apply(" ABCDEFG ");

        Function<String, Integer> toInteger = CommLineArg::parse;
        Integer integer = toInteger.apply("5");

        List <Person> persons= Arrays.asList(
                new Person( 20,"Andrew"),
                new Person( 24,"Rew"),
                new Person( 22,"Crew"),
                new Person( 20,"Verew"));
        Map<Integer, List<Person>> personByAge= persons.stream().collect(Collectors.groupingBy(p->p.age));
        Map<Integer, String> personByAgez= persons.stream().collect(Collectors.toMap(
                p->p.age,
                p->p.name,
                (name1,name2)->name1+";"+name2));
        System.out.println(personByAgez.get(20));
        personByAge.forEach((age,p)-> System.out.format("age %s: %s\n", age, p));

        Properties properties = System.getProperties();
        // properties.list(System.out);
        double f = 1.964;
        //System.out.println((int)rounds()*10);
        System.out.println(rounds(4));
    }

    public static double rounds(float v) {
        return v;
    }


    private static Integer parse(String s) {
        return Integer.parseInt(s);
    }
}
