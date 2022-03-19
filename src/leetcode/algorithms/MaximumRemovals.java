package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 1898. Maximum Number of Removable Characters
 *
 * @author Baltan
 * @date 2022/3/18 22:54
 * @see IsSubsequence
 */
public class MaximumRemovals {
    public static void main(String[] args) {
        System.out.println(maximumRemovals("abcacb", "ab", new int[]{3, 1, 0}));
        System.out.println(maximumRemovals("abcbddddd", "abcd", new int[]{3, 2, 1, 4, 5, 6}));
        System.out.println(maximumRemovals("abcab", "abc", new int[]{0, 1, 2, 3, 4}));
    }

    /**
     * 参考：<a href="https://leetcode-cn.com/problems/maximum-number-of-removable-characters/solution/"></a>
     *
     * @param s
     * @param p
     * @param removable
     * @return
     */
    public static int maximumRemovals(String s, String p, int[] removable) {
        int lo = 0;
        int hi = removable.length;
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        while (lo < hi) {
            int mid = (int) Math.ceil((lo + hi) / 2.0);
            /**
             * 标记字符串s中被删除的字符的索引
             */
            Set<Integer> deleteIndices = new HashSet<>();

            for (int i = 0; i < mid; i++) {
                deleteIndices.add(removable[i]);
            }

            if (isSubsequence(sChars, pChars, deleteIndices)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    /**
     * 判断数组pChars是否是数组sChars的子序列
     *
     * @param sChars
     * @param pChars
     * @param deleteIndices
     * @return
     */
    public static boolean isSubsequence(char[] sChars, char[] pChars, Set<Integer> deleteIndices) {
        int pLength = pChars.length;
        int sLength = sChars.length;
        int pIndex = 0;
        int sIndex = 0;

        outer:
        while (pIndex < pLength) {
            /**
             * 按顺序在数组sChars中查找是否存在字符pChars[pIndex]
             */
            while (sIndex < sLength) {
                /**
                 * 在sChars中找到了pChars[pIndex]，继续查找pChars[pIndex+1]
                 */
                if (!deleteIndices.contains(sIndex) && sChars[sIndex] == pChars[pIndex]) {
                    sIndex++;
                    pIndex++;
                    continue outer;
                }
                sIndex++;
            }
            return false;
        }
        return true;
    }
}
