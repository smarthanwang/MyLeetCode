package leetcode.solution.string;

/**
 * 58. 最后一个单词的长度
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5

 */

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        int i = s.length() -1;
        //seek last word end index
        while (i >= 0 && s.charAt(i) == ' '){
            i --;
        }

        if (i >= 0 ){
            int len = 0;
            while (i >= 0 && s.charAt(i) != ' '){
                i --;len ++;
            }
            return len;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("hello   world"));
        System.out.println(lengthOfLastWord("hello    "));
        System.out.println(lengthOfLastWord(" world"));
        System.out.println(lengthOfLastWord("     "));
    }
}
