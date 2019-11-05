package leetcode.solution.dynamicprogramming;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int start = 0;
        int maxLen = 0;
        int position = 0;
        int[] indices = new int[2 << 16 - 1];

        int length = s.length();
        while (position < length) {
            char c = s.charAt(position);
            if (indices[c] > 0) {
                start = Math.max(indices[c], start);
            }
            maxLen = Math.max(maxLen, position - start + 1);
            indices[c] = position + 1;
            position++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(lengthOfLongestSubstring("abcdabcebb"));
        System.out.println(lengthOfLongestSubstring("a"));
        System.out.println(lengthOfLongestSubstring("ab"));
        System.out.println(lengthOfLongestSubstring("abcdefghijklamnopqrsta"));
    }
}

