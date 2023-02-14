package numbers_strings.numbers;

import java.text.*;

public class DecimalFormatDemo {
    static public void customFormat(String pattern, double value) {
        var myFormatter = new DecimalFormat(pattern);
        var res = myFormatter.format(value);
        System.out.println(value + " " + pattern + " " + res);
    }
    
    public static void main(String[] args) {
        customFormat("###,###.###", 123456.789);
        customFormat("###.##", 123456.789);
        customFormat("000000.00", 123.78);
        customFormat("$###,###.###", 12345.67);
    }
}
