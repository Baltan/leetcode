package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 1593. Split a String Into the Max Number of Unique Substrings
 *
 * @author Baltan
 * @date 2022/10/16 10:41
 */
public class MaxUniqueSplit {
    public static void main(String[] args) {
        System.out.println(maxUniqueSplit("ababccc"));
        System.out.println(maxUniqueSplit("aba"));
        System.out.println(maxUniqueSplit("aa"));
    }

    private static int result;

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/split-a-string-into-the-max-number-of-unique-substrings/solutions/441191/chai-fen-zi-fu-chuan-shi-wei-yi-zi-zi-fu-chuan-de-/"></a>
     *
     * @param s
     * @return
     */
    public static int maxUniqueSplit(String s) {
        result = 1;
        /**
         * 保存已经得到的子串
         */
        Set<String> set = new HashSet<>();
        int length = s.length();
        backtrack(0, 0, s, length, set);
        return result;
    }

    public static void backtrack(int startIndex, int count, String s, int length, Set<String> set) {
        if (startIndex >= length) {
            result = Math.max(result, count);
        } else {
            for (int i = startIndex; i < length; i++) {
                String substring = s.substring(startIndex, i + 1);

                if (!set.contains(substring)) {
                    set.add(substring);
                    backtrack(i + 1, count + 1, s, length, set);
                    set.remove(substring);
                }
            }
        }
    }
}
