package leetcode.algorithms;

/**
 * Description: 2358. Maximum Number of Groups Entering a Competition
 *
 * @author Baltan
 * @date 2023/1/13 17:34
 */
public class MaximumGroups {
    public static void main(String[] args) {
        System.out.println(maximumGroups(new int[]{10, 6, 12, 7, 3, 5}));
        System.out.println(maximumGroups(new int[]{8, 8}));
    }

    public static int maximumGroups(int[] grades) {
        int result = 0;
        int leftCount = grades.length;
        /**
         * 前一个分组的人数
         */
        int prevCount = 0;
        /**
         * 假设已将所有得分按照升序排列，每次循环分组，总是使得当前分组的人数刚好超过前一个分组的人数，因为所有分数是按照升序排列的，所以当前分组
         * 的总分一定大于前一个分组的总分
         */
        while (leftCount > prevCount) {
            /**
             * 如果剩余的人数大于前一个分组的人数就能得到一个新分组
             */
            result++;
            leftCount -= (prevCount + 1);
            prevCount++;
        }
        return result;
    }
}
