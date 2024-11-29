package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Description: 3365. Rearrange K Substrings to Form Target String
 *
 * @author Baltan
 * @date 2024/11/29 23:19
 */
public class IsPossibleToRearrange {
    public static void main(String[] args) {
        System.out.println(isPossibleToRearrange("abcd", "cdab", 2));
        System.out.println(isPossibleToRearrange("aabbcc", "bbaacc", 3));
        System.out.println(isPossibleToRearrange("aabbcc", "bbaacc", 2));
    }

    public static boolean isPossibleToRearrange(String s, String t, int k) {
        int length = s.length() / k;
        /**
         * 字符串s拆分后的k个等长的字符串
         */
        List<String> substringsS = new ArrayList<>();
        /**
         * 字符串t拆分后的k个等长的字符串
         */
        List<String> substringsT = new ArrayList<>();

        for (int i = 0; i < s.length(); i += length) {
            substringsS.add(s.substring(i, i + length));
            substringsT.add(t.substring(i, i + length));
        }
        Collections.sort(substringsS);
        Collections.sort(substringsT);
        /**
         * 如果重新拼接字符串s拆分后的k个等长的字符串可以得到字符串t，则数组substringsS和substringsT中的子串都是一一对应相等的
         */
        for (int i = 0; i < k; i++) {
            if (!Objects.equals(substringsS.get(i), substringsT.get(i))) {
                return false;
            }
        }
        return true;
    }
}
