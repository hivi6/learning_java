package generics;

public class GenericFunctionDemo {
    public static <T> void print(T elem) {
        System.out.println("class: " + elem.getClass().getName() + "; value: " + elem.toString());
    }

    public static <T1, T2> void print2(T1 elem1, T2 elem2) {
        System.out.println("class of elem1: " + elem1.getClass().getName() + "; value: " + elem1.toString());
        System.out.println("class of elem2: " + elem2.getClass().getName() + "; value: " + elem2.toString());
    }

    private interface TestInterface {}

    public static void main(String[] args) {
        print("abc");
        print(1);
        print(2.3);

        print2("abc", 1.2);
        print2("abc", 1.2f);
        print2(new TestInterface() {}, 'a');
    }
}
