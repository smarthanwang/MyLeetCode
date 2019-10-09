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

    if (s == null) {
      return 0;
    }
    if (s.length() <= 1) {
      return s.length();
    }

    int maxLen = 0;
    int start = 0;
    int position = 0;
    HashMap<Character, Integer> indices = new HashMap<>();

    int length = s.length();
    while (position < length) {

      if (indices.containsKey(s.charAt(position))) {
        start = Math.max(indices.get(s.charAt(position)) + 1, start);
      }
      maxLen = Math.max(maxLen, position - start + 1);
      indices.put(s.charAt(position), position);
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

