package numbers_strings.strings;

import java.util.Scanner;
import java.util.regex.*;;

public class RegexDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var pattern = Pattern.compile("/hi/(?<name>\\w+)");
        var match = pattern.matcher(scanner.nextLine());

        if (match.find()) {
            System.out.println(match.group("hi"));
        }

        scanner.close();
    }
}
