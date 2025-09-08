package leetcode.algorithms;

import java.util.TreeSet;

/**
 * Description: 3639. Minimum Time to Activate String
 *
 * @author baltan
 * @date 2025/9/8 13:31
 */
public class MinTime5 {
    public static void main(String[] args) {
        System.out.println(minTime("abc", new int[]{1, 0, 2}, 2));
        System.out.println(minTime("cat", new int[]{0, 2, 1}, 6));
        System.out.println(minTime("xy", new int[]{0, 1}, 4));
    }

    public static int minTime(String s, int[] order, int k) {
        /**
         * 有效子串的个数
         */
        long count = 0L;
        /**
         * 升序保存字符串s中字符"*"的索引值
         */
        TreeSet<Integer> set = new TreeSet<>();
        /**
         * 左右两个哨兵
         */
        set.add(-1);
        set.add(s.length());

        for (int i = 0; i < order.length; i++) {
            int index = order[i];
            /**
             * s[index]左边最近的字符"*"的索引值
             */
            int left = set.lower(index);
            /**
             * s[index]右边最近的字符"*"的索引值
             */
            int right = set.higher(index);
            count += (long) (index - left) * (right - index);

            if (count >= k) {
                return i;
            }
            set.add(index);
        }
        return -1;
    }
}
