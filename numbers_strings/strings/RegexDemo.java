package numbers_strings.strings;

import java.util.Scanner;
import java.util.regex.*;;

public class RegexDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var pattern = Pattern.compile(scanner.nextLine());
        var str = scanner.nextLine();
        var m = pattern.matcher(str);
        if (m.find()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                System.out.println("Group " + i + ": " + m.group(i));
            }
        } else {
            System.out.println("NO MATCH");
        }
        scanner.close();
    }
}
