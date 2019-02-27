package leetcode.algorithms;

import java.util.HashMap;

/**
 * Description:Longest Substring Without Repeating Characters
 * @author Baltan
 *
 * @date 2017/11/7 11:29
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("lxhgmywmlalijiypvmrpqpptipcntdygafppgldr"));
        System.out.println(lengthOfLongestSubstring("c"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int length = s.length();
        if (length == 0) {
            result = 0;
        } else if (length > 0) {
            for (int i = 0; i < length - result; i++) {
                HashMap hm = new HashMap();
                int temp = 0;
                for (int j = i; j < length; j++) {
                    if (!hm.containsKey(s.charAt(j))) {
                        hm.put(s.charAt(j), null);
                        temp++;
                    } else {
                        break;
                    }
                }
                result = Math.max(result, temp);
            }
        }
        return result;
    }
}