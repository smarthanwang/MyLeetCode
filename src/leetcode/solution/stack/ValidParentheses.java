package leetcode.solution.stack;

/**
 * 20.有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 *      左括号必须用相同类型的右括号闭合。
 *      左括号必须以正确的顺序闭合。
 *      注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *      输入: "()"
 *      输出: true
 *
 * 示例 2:
 *      输入: "()[]{}"
 *      输出: true
 *
 * 示例 3:
 *      输入: "(]"
 *      输出: false
 *
 * 示例 4:
 *      输入: "([)]"
 *      输出: false
 *
 * 示例 5:
 *      输入: "{[]}"
 *      输出: true
 *
 */

public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int tail = -1;
        char[] stack = new char[s.length()];
        for (char c : s.toCharArray()) {
            if (tail == -1 || c == '{' || c == '[' || c == '(') {
                stack[++tail] = c;
                continue;
            }
            char pre = stack[tail];
            if ((c == '}' && pre == '{') || (c == ']' && pre == '[') || (c == ')' && pre == '(')) {
                tail --;
            }else {
                return false;
            }
        }
        return tail < 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("{}"));
        System.out.println(isValid("{((()))}"));
        System.out.println(isValid("{}()[]["));

    }

}
