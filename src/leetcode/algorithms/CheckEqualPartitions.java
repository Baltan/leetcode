package leetcode.algorithms;

/**
 * Description: 3566. Partition Array into Two Equal Product Subsets
 *
 * @author Baltan
 * @date 2025/6/14 21:12
 */
public class CheckEqualPartitions {
    public static void main(String[] args) {
        System.out.println(checkEqualPartitions(new int[]{3, 1, 6, 8, 4}, 24));
        System.out.println(checkEqualPartitions(new int[]{2, 5, 3, 7}, 15));
    }

    public static boolean checkEqualPartitions(int[] nums, long target) {
        /**
         * 数组nums中所有元素之积
         */
        long product = 1L;
        /**
         * 用一个二进制数表示数组nums中被分到同一子集的元素，这个二进制数的范围为[1,maxStatus)
         */
        int maxStatus = (1 << nums.length) - 1;

        for (int num : nums) {
            product *= num;
        }

        if (target * target != product) {
            return false;
        }
        /**
         * i表示数组nums中被分到同一子集的元素，i的二进制值从低位到高位依次表示nums[0]、nums[1]……nums[length-1]是否在同一子集中，当该
         * 位上值为1时，将对应数组nums中的元素分到同一子集中
         */
        for (int i = 1; i < maxStatus; i++) {
            int status = i;
            /**
             * status某一位上的值为1时，将要加入子集的对应数组nums中元素的索引
             */
            int index = 0;
            /**
             * 当前子集中所有元素之积
             */
            product = 1L;

            while (status != 0) {
                if ((status & 1) == 1) {
                    product *= nums[index];
                    /**
                     * 如果当前子集中所有元素之积恰好为target，则数组nums中剩余元素之积也为target，找到符合条件的分组；如果当前子集中所
                     * 有元素之积已经大于target，则向子集中继续增加元素更加不符合条件，直接结束当前计算
                     */
                    if (product == target) {
                        return true;
                    } else if (product > target) {
                        break;
                    }
                }
                status >>= 1;
                index++;
            }
        }
        return false;
    }
}
