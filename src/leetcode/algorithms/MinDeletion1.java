package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3545. Minimum Deletions for At Most K Distinct Characters
 *
 * @author baltan
 * @date 2025/6/6 11:15
 */
public class MinDeletion1 {
    public static void main(String[] args) {
        System.out.println(minDeletion("abc", 2));
        System.out.println(minDeletion("aabb", 2));
        System.out.println(minDeletion("yyyzz", 1));
    }

    public static int minDeletion(String s, int k) {
        int result = s.length();
        /**
         * counts[0]-counts[25]依次表示字符串s中字母a-z的个数
         */
        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        /**
         * 将字符串s中各个字母出现的次数按照升序排列
         */
        Arrays.sort(counts);
        /**
         * 按照字符串s中各个字母出现的次数倒序遍历，留下出现次数最多的k个字母，其余的都删除
         */
        for (int i = counts.length - 1; i >= 0 && k > 0; i--) {
            result -= counts[i];
            k--;
        }
        return result;
    }
}
