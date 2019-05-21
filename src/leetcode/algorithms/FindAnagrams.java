package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 438. Find All Anagrams in a String
 *
 * @author Baltan
 * @date 2018/1/7 20:23
 */
public class FindAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return list;
        }
        int sLength = s.length();
        int pLength = p.length();
        //小写字母z的ASCLL码为122，数组的最大索引为122即可
        int[] pArray = new int[123];
        int[] sArray = new int[123];
        for (int i = 0; i < pLength; i++) {
            pArray[p.charAt(i)]++;
        }
        for (int i = 0; i < sLength; i++) {
            sArray[s.charAt(i)]++;
            if (i >= pLength) {
                sArray[s.charAt(i - pLength)]--;
            }
            if (Arrays.equals(sArray, pArray)) {
                list.add(i - pLength + 1);
            }
        }
        return list;
    }
}
