package leetcode.algorithms;

/**
 * Description: 2501. Longest Square Streak in an Array
 *
 * @author Baltan
 * @date 2022/12/15 11:38
 */
public class LongestSquareStreak {
    public static void main(String[] args) {
        System.out.println(longestSquareStreak(new int[]{4, 3, 6, 16, 8, 2}));
        System.out.println(longestSquareStreak(new int[]{2, 3, 5, 6, 7}));
    }

    public static int longestSquareStreak(int[] nums) {
        int result = -1;
        /**
         * 根据题意，数组nums中的元素∈[2,100000]
         */
        final int MAX = 100000;
        /**
         * isExisted[i]表示数字i是否在数组nums中存在
         */
        boolean[] isExisted = new boolean[MAX + 1];
        /**
         * isVisited[i]表示数字i是否已在某个可能的方波中被判断过
         */
        boolean[] isVisited = new boolean[MAX + 1];

        for (int num : nums) {
            isExisted[num] = true;
        }

        for (int i = 2; i * i <= MAX; i++) {
            /**
             * 如果数字i不存在或者已被判断过，不要继续判断
             */
            if (!isExisted[i] || isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            int length = 1;
            int j = i * i;
            /**
             * 依次判断方波的下一个元素是否在数组nums中存在，因为i*i可能存在整型溢出得到负数的情况，所以还要判断j>=0
             */
            while (j >= 0 && j <= MAX && isExisted[j]) {
                isVisited[j] = true;
                length++;
                j = j * j;
            }
            /**
             * 得到一个符合条件的方波
             */
            if (length > 1) {
                result = Math.max(result, length);
            }
        }
        return result;
    }
}
