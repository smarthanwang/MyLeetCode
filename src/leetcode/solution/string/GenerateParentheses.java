package leetcode.solution.string;

import java.util.LinkedList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        if (n == 0){
            return list;
        }
        generate(list, "(", 1, 0, n);
        return list;
    }

    public void generate(List<String> result, String cur, int left, int right, int n){
        if (cur.length() == 2*n){
            result.add(cur);
        }
        if (left  < n){
            generate(result, cur + "(", left+1, right, n);
        }
        if (right < left){
            generate(result, cur + ")", left, right + 1, n);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generator = new GenerateParentheses();
        System.out.println(generator.generateParenthesis(1));
        System.out.println(generator.generateParenthesis(2));
        System.out.println(generator.generateParenthesis(3));
        System.out.println(generator.generateParenthesis(4));
    }



}
