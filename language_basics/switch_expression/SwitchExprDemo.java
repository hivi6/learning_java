package language_basics.switch_expression;

public class SwitchExprDemo {
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THRUSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    static int switchFunc1(Day day) {
        int len = 0;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                len = 6;
                break;
            case TUESDAY:
                len = 7;
                break;
            case THRUSDAY:
            case SATURDAY:
                len = 8;
                break;
            case WEDNESDAY:
                len = 9;
                break;
        }
        return len;
    }

    static int switchFunc2(Day day) {
        return switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THRUSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
        };
    }

    static String convertToLabel(int quarter) {
        return switch (quarter) {
            case 0 -> {
                System.out.println("Q1 - Winter");
                yield "Q1 - Winter";
            }
            default -> "Unknown quarter";
        };
    }

    public static void main(String[] args) {
        Day day = Day.MONDAY;
        System.out.println("len = " + switchFunc1(day));
        System.out.println("len = " + switchFunc2(day));
        System.out.println("label = " + convertToLabel(0));
    }
}
