public class Test {
    public static void foo() {
        String s = null;
        System.out.println("1");
        System.out.println(s.length());
        System.out.println("2");
        }

    public static void main(String[] args) {
        System.out.println("3");
        try {
            System.out.println("4");
            foo();
            System.out.println("5");
        } catch (Exception e) {
            System.out.println("6");
        }
        System.out.println("7");
        }
}