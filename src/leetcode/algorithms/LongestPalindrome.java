package leetcode.algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Description: 409. Longest Palindrome
 *
 * @author Baltan
 * @date 2018/1/4 10:58
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {
        Map<String, Integer> map = new HashMap<>();
        int palindromeLength = 0;
        boolean hasOddNumLetter = false;
        for (int i = 0; i < s.length(); i++) {
            String letter = s.substring(i, i + 1);
            if (map.get(letter) == null) {
                map.put(letter, 1);
            } else {
                map.put(letter, map.get(letter) + 1);
            }
        }
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int letterNum = map.get(iterator.next());
            if (letterNum % 2 == 0) {
                palindromeLength += letterNum;
            } else {
                palindromeLength += (letterNum - 1);
                hasOddNumLetter = true;
            }
        }
        if (hasOddNumLetter) {
            palindromeLength += 1;
        }
        return palindromeLength;
    }
}
