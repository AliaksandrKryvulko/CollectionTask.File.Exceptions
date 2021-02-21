package CollectTaskLearn;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static CollectTaskLearn.Constants.closers;
import static CollectTaskLearn.Constants.openers;

class Task1 {

    static String regex = ";";


    public static void main(String[] args) throws IOException {
        sortDesc(123456789);
        //CollectTaskLearn.Task1  Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
        System.out.println("*********************CollectTaskLearn.Task1***********************");
        Path file = Path.of("d:\\Stringa.txt");
        List<String> stroke = Files.readAllLines(Paths.get(String.valueOf(file)));
        List<String> lst = new ArrayList<>();
        ListIterator<String> lstIter = stroke.listIterator();
        while (lstIter.hasNext()) {
            String tmpStr = Pattern.compile(";").splitAsStream(lstIter.next()).collect(Collectors.joining(" "));
            String ans = "";
            String s[] = tmpStr.split(" ");
            for (int i = s.length - 1; i >= 0; i--) {
                ans += s[i] + " ";
            }
            lst.add(ans);
        }
        Collections.reverse(lst);
        Files.write(file, lst, StandardOpenOption.WRITE);

        System.out.println("**********************Task 2**********************");
        //Task2 Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
/*        Stack<String> stk = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String str = new String(sc.nextLine());
        stk.push(str);

        System.out.println(new StringBuffer(stk.pop()).reverse().toString());
        System.out.println("**********************Task3***********************");*/
        //3.   Создать список из элементов каталога и его подкаталогов.

//        RecursiveFileExample rfe= new RecursiveFileExample();
//        rfe.fetchChild();
        File dir = new File("D:\\Java\\Learn.by\\CollectionTask&File");
        String[] path = dir.list();
        for (String pth : path) {
            System.out.println(pth);
        }

        //4.Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
        System.out.println("********************Task4************************");
        List<String> poetry = new ArrayList<>();
        poetry.add("Я помню чудное ");
        poetry.add("Передо мной явилась ты как мимолетное");
        poetry.add("виденье");
        poetry.add("Как гений чистой красоты");
        poetry.stream().sorted(Comparator.comparing(String::length)).
                forEach(s -> {
                    //poetry.remove(s);
                    //poetry.add(s + " ");
                    System.out.println(s);
                });
        List<Integer> tog = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).
                flatMap(List::stream).
                map(integer -> integer + 1).
                collect(Collectors.toList());

        //6. Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections.
        System.out.println("********************Task 6************************");
        File file1 = new File("d:\\java\\TestingTextFile\\testString.txt");
        try (FileReader fileReader = new FileReader(file1);
             Scanner scan = new Scanner(fileReader)) {
            List<String> arList = new ArrayList();
            //sorting on word length in string
            while (scan.hasNextLine()) {
                arList.add(Arrays.stream(scan.nextLine().split(" ")).
                        sorted(Comparator.comparing(String::length)).
                        collect(Collectors.joining(" ")));
            }//sorting string between string
            arList.sort(Comparator.comparing(String::length));
            arList.stream().forEach(System.out::println);
        }

        //7. Задана строка, состоящая из символов «(», «)», «[», «]», «{», «}». Проверить правильность расстановки скобок. Использовать стек.
        System.out.println("************************Task 7**************************");
        String testStroke = "«(», «)», «[», «]», «{», «}»";
        //String testStroke1 = "({[]{}})(";
        String testStroke1 = "(, ),{,},[,]";
        System.out.println(checkingStroke(testStroke1));
        ;
        //System.out.println(cheks(testStroke1));

        //8. Задан файл с текстом на английском языке. Выделить все различные слова.
        // Слова, отличающиеся только регистром букв, считать одинаковыми. Использовать класс HashSet.

        System.out.println("************************Task8**************************");
        File file2 = new File("d:\\java\\TestingTextFile\\Task8Collections.txt");
        try (FileReader fileReader = new FileReader(file2);
             Scanner scanner = new Scanner(fileReader)) {
            Set<StringWrapper> hashSet = new HashSet<>();
            String[] arr;
            while (scanner.hasNextLine()) {
                // hashset=
                //collect(Collectors.toCollection(LinkedHashSet::new));
                hashSet.addAll(Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .map(StringWrapper::new)
                        .collect(Collectors.toSet()));
            }
            hashSet.stream()
                    .map(StringWrapper::getValue)
                    .collect(Collectors.toSet());
            System.out.println(hashSet.toString());

               /* String[] arr;
                while (scanner.hasNextLine());
                    arr = scanner.nextLine().split(" ");
                    for (String str : arr) {
                        if (!hashSet.stream().anyMatch(str::equalsIgnoreCase)) {
                            hashSet.add(str);
                        }
                    }*/


             /*   uniqueWordCount += Arrays.stream(scanner.nextLine().split(" "))
                        .map(String::toLowerCase)
                        // Build a map from word -> frequency
                        .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                        // stream the frequency map entries
                        .entrySet().stream()
                        // filter to retain unique words (with frequency == 1)
                        .filter(e -> e.getValue() == 1).map(e->e.getKey()).collect(Collectors.joining(" ")); //map(Objects::toString).collect(Collectors.joining(" "));
                        // count them
                        ;*/
        }
        //System.out.println(hashSet.toString());
    }


    public static int sortDesc(final int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        int length = digits.length;
        for (int i = 0; i < digits.length / 2; i++) {
            char temp = digits[i];
            digits[i] = digits[length - 1 - i];
            digits[length - 1 - i] = temp;
        }
        return Integer.parseInt(
                Stream.of(digits).
                        map(String::valueOf).
                        collect(Collectors.joining()));
    }

    public static String ssplit(String str) {
        String tmpStr;
        tmpStr = Stream.of(str.split(";"))
                .map(elem -> new String(elem))
                .collect(Collectors.joining(" "));
        //return Stream.of(str.split(";")).map(elem -> new String(elem)).
        // collect(Collectors.joining(" "));
        return tmpStr;
    }

    //«(», «)», «[», «]», «{», «}»
    public static boolean checkingStroke(String stroka) {
        Stack<Integer> stck = new Stack<>();
        String[] parsedArr = stroka.split(",");
        int length = parsedArr.length;
        boolean result = true;
        String currentStr;
        for (int i = 0; i < length && result; i++) {
            currentStr = parsedArr[i];
            for (int j = 0; j < openers.length; j++) {
                if (currentStr.equals(openers[j]) && i != length - 1) {
                    stck.push(j);
                    result = true;
                    break;
                } else if (currentStr.equals(closers[j]) && !stck.empty() && stck.pop() == j) {
                    result = true;
                    break;
                } else result = false;
            }
        }
        return result;
    }

    public static String ssplit(List<String> str) {
        return str.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    public static boolean cheks(String str) {
        final String opn = "({[";
        final String cls = ")}]";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            int oi = opn.indexOf(chr);//if not opn -1
            if (oi != -1) {// if not close symbol push
                stack.push(oi);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                int ci = cls.indexOf(chr);//index 2
                if (ci != stack.peek()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.size() != 0)
            return false;
        return true;
    }
}
