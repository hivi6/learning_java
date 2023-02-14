package language_basics.var;

import java.util.List;

public class VarDemo {
    public static void main(String[] args) {
        var message = "Hello World!";
        System.out.println(message);

        var list = List.of("one", "two", "three", "four");
        for (var element: list) {
            System.out.println(element);
        }
    }
}
