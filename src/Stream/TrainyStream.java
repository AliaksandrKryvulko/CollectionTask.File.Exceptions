package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TrainyStream {
    List <Integer> lst=new ArrayList<>();
    public static void main(String[] args) {
        List<String> list= Arrays.stream(args).filter(s -> s.length()<6).collect(Collectors.toList());
        IntStream.of(120,110,4,56,654,64,89).filter(x->x<110).map(x->x+10).limit(2).forEach(System.out::println);
        Stream.Builder<Integer> strBuilder=Stream.<Integer>builder().add(1).add(2).add(3);
        for (int i = 10; i < 14; i++) {
            strBuilder.accept(i);
        }
        System.out.println("---------------------------------------\nStrBuilder output: ");
        strBuilder.build().forEach(System.out::print);
        System.out.println();
        Stream.of("10","155","22"). map(x->Integer.parseInt(x,8)).forEach(System.out::println);

    }
}
