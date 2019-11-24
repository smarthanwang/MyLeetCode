package leetcode.solution.string;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int d = 'a' - 'A';

        int length = s.length();
        int i = 0;
        int j = length - 1;
        while (i < j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            if ((a > 'Z' || a < 'A') && (a > 'z' || a < 'a') && (a > '9' || a < '0')) {
                i++;
            } else if ((b > 'Z' || b < 'A') && (b > 'z' || b < 'a') && (b > '9' || b < '0')) {
                j--;
            } else if (a == b || (a >= 'A' && b >= 'A' && Math.abs(a - b) == d)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validator = new ValidPalindrome();
        System.out.println(validator.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validator.isPalindrome("         "));
        System.out.println(validator.isPalindrome("       rac a car "));
        System.out.println(validator.isPalindrome("       0P "));
    }
}
