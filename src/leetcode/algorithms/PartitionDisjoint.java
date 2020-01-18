package leetcode.algorithms;

/**
 * Description: 915. Partition Array into Disjoint Intervals
 *
 * @author Baltan
 * @date 2020-01-17 16:59
 */
public class PartitionDisjoint {
    public static void main(String[] args) {
        int[] A1 = {5, 0, 3, 8, 6};
        System.out.println(partitionDisjoint(A1));

        int[] A2 = {1, 1, 1, 0, 6, 12};
        System.out.println(partitionDisjoint(A2));

        int[] A3 = {1, 2};
        System.out.println(partitionDisjoint(A3));
    }

    public static int partitionDisjoint(int[] A) {
        int length = A.length;
        /**
         * maxArray[i]表示数组A最左边i+1个数的最大值
         */
        int[] maxArray = new int[length];
        /**
         * minArray[i]表示数组A最右边i+1个数的最小值
         */
        int[] minArray = new int[length];
        maxArray[0] = A[0];
        minArray[0] = A[length - 1];

        for (int i = 1; i < length; i++) {
            /**
             * 数组A最左边x个数的最大值为Math.max(数组A最左边x-1个数的最大值,A[x-1])
             */
            maxArray[i] = Math.max(maxArray[i - 1], A[i]);
            /**
             * 数组A最右边x个数的最小值为Math.min(数组A最右边x-1个数的最小值,A[length-x])
             */
            minArray[i] = Math.min(minArray[i - 1], A[length - 1 - i]);
        }
        /**
         * 对于数组A如果最左边x个数的最大值不大于最右边length-x个数的最小值，则这种分割就满足题意
         */
        for (int i = 1; i < length; i++) {
            /**
             * 数组A最左边i个数的最大值
             */
            int leftMax = maxArray[i - 1];
            /**
             * 数组A最右边length-i个数的最小值
             */
            int rightMin = minArray[length - i - 1];

            if (leftMax <= rightMin) {
                return i;
            }
        }
        return -1;
    }
}
