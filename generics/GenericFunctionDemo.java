package generics;

public class GenericFunctionDemo {
    public static <T> void print(T elem) {
        System.out.println("class: " + elem.getClass().getSimpleName() + "; value: " + elem.toString());
    }
    
    public static void main(String[] args) {
        print("abc");
        print(1);
        print(2.3);
    }
}
