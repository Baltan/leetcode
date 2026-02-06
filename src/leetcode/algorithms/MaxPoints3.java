package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3767. Maximize Points After Choosing K Tasks
 *
 * @author baltan
 * @date 2026/1/29 15:54
 */
public class MaxPoints3 {
    public static void main(String[] args) {
        System.out.println(maxPoints(new int[]{5, 2, 10}, new int[]{10, 3, 8}, 2));
        System.out.println(maxPoints(new int[]{10, 20, 30}, new int[]{5, 15, 25}, 2));
        System.out.println(maxPoints(new int[]{1, 2, 3}, new int[]{4, 5, 6}, 0));
    }

    public static long maxPoints(int[] technique1, int[] technique2, int k) {
        long result = 0L;
        int length = technique1.length;
        /**
         * diffs[i]表示如果第i个任务使用技巧1替换技巧2会减少的得分
         */
        int[] diffs = new int[length];
        /**
         * 初始化假设所有任务都使用技巧2完成
         */
        for (int i = 0; i < length; i++) {
            result += technique2[i];
            diffs[i] = technique2[i] - technique1[i];
        }
        Arrays.sort(diffs);
        /**
         * 为了使得总得分尽可能大，选择减少得分最少的k的任务，改用技巧1替换技巧2
         */
        for (int i = 0; i < k; i++) {
            result -= diffs[i];
        }
        /**
         * 将剩余技巧1替换技巧2后得分可能增加的任务都改用技巧1完成
         */
        for (int i = k; i < length && diffs[i] < 0; i++) {
            result -= diffs[i];
        }
        return result;
    }
}
