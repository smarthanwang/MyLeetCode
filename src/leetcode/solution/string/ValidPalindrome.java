package leetcode.solution.string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
