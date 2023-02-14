package numbers_strings.strings;

public class StringDemo {
    static boolean isPalindrome(String s)
    {
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println("aaaabbaaaa is Pali? " + isPalindrome("aaaabbaaaa"));
        System.out.println("aaaabaaaa is Pali? " + isPalindrome("aaaabaaaa"));
        System.out.println("aaaabaaa is Pali? " + isPalindrome("aaaabaaa"));
    }
}
