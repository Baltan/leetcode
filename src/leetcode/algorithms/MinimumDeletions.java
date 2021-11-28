package leetcode.algorithms;

/**
 * Description: 2091. Removing Minimum and Maximum From Array
 *
 * @author Baltan
 * @date 2021/11/28 13:29
 */
public class MinimumDeletions {
    public static void main(String[] args) {
        System.out.println(minimumDeletions(new int[]{2, 10, 7, 5, 4, 1, 8, 6}));
        System.out.println(minimumDeletions(new int[]{0, -4, 19, 1, 8, -2, -3, 5}));
        System.out.println(minimumDeletions(new int[]{101}));
    }

    public static int minimumDeletions(int[] nums) {
        int length = nums.length;
        /**
         * 如果nums中只有一个或两个元素，则所有元素都会被删除
         */
        if (length < 3) {
            return length;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        /**
         * 最小值索引位置
         */
        int minIndex = -1;
        /**
         * 最大值索引位置
         */
        int maxIndex = -1;
        /**
         * 查找最小值索引位置和最大值索引位置
         */
        for (int i = 0; i < length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        /**
         * 如果从两侧删除需要删除操作的总次数
         */
        int deletionFromBoth = (Math.min(minIndex, maxIndex) + 1) + (length - Math.max(minIndex, maxIndex));
        /**
         * 如果只从左侧删除需要删除操作的总次数
         */
        int deletionFromLeft = Math.max(minIndex, maxIndex) + 1;
        /**
         * 如果只从右侧删除需要删除操作的总次数
         */
        int deletionFromRight = length - Math.min(minIndex, maxIndex);
        return Math.min(Math.min(deletionFromBoth, deletionFromLeft), deletionFromRight);
    }
}
