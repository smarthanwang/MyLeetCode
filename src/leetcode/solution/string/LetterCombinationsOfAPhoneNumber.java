package leetcode.solution.string;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */

public class LetterCombinationsOfAPhoneNumber {


    public List<String> letterCombinations(String digits) {

        List<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> cur = new LinkedList<>();
            char c = digits.charAt(i);
            for (String s : result) {
                if (c < '7') {
                    char start = (char) ('a' + (c - '2') * 3);
                    cur.add(s + start);
                    cur.add(s + (char) (start + 1));
                    cur.add(s + (char) (start + 2));
                } else if (c == '7') {
                    cur.add(s + 'p');
                    cur.add(s + 'q');
                    cur.add(s + 'r');
                    cur.add(s + 's');
                } else if (c == '8') {
                    cur.add(s + 't');
                    cur.add(s + 'u');
                    cur.add(s + 'v');
                } else {
                    cur.add(s + 'w');
                    cur.add(s + 'x');
                    cur.add(s + 'y');
                    cur.add(s + 'z');
                }
            }
            result = cur;
        }
        return result;
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber();
        System.out.println(l.letterCombinations("29"));
    }

}
