package leetcode.solution.string;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串
 * 出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *      输入: haystack = "hello", needle = "ll"
 *      输出: 2
 * 示例 2:
 *      输入: haystack = "aaaaa", needle = "bba"
 *      输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

 */
public class IndexOfString {

    public static int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        char[] src = haystack.toCharArray();
        char[] dst = needle.toCharArray();
        int endPos = src.length - dst.length;
        char first = dst[0];
        for (int i = 0; i <= endPos; i++) {

            if (src[i] != first){
                while (++i <= endPos && first != src[i]);
            }
            if (i <= endPos){
                int j = 0;
                while (++j < dst.length && dst[j] == src[i+j]);
                if (j == dst.length){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi",
                "issipi"));
        System.out.println(strStr("mississippi", "issi"));
        System.out.println(strStr("ccca", "a"));
    }
}
