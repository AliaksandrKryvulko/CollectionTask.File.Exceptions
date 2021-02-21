public class TestExc {
    static String txt = "literal";
    static String txt2 = new String("literal").intern();

    public static void main(String[] args) {
        double as=53/2.;
        System.out.printf("%.2f",as);
    }
}