package CollectTaskLearn;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Constants {
    public static final String[] openers = {"(", "{", "["};
    public static final String[] closers =  {")", "}", "]"};

    public static void main(String[] args) {
        Predicate<String> predicate1 = t -> {
            System.out.print("predicate1");
            return t.startsWith(" ");
        };
        Predicate<String> predicate2 = t -> {
            System.out.print("predicate2");
            return t.length() > 6;
        };
        predicate1.and(predicate2).test("Hello world!!!");
    }
}
