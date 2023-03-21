package leetcode.algorithms;

/**
 * Description: 2598. Smallest Missing Non-negative Integer After Operations
 *
 * @author Baltan
 * @date 2023/3/20 09:38
 */
public class FindSmallestInteger {
    public static void main(String[] args) {
        System.out.println(findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 5));
        System.out.println(findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 7));
    }

    public static int findSmallestInteger(int[] nums, int value) {
        /**
         * 数组nums中元素分别对value取余后，同余的元素最少的数量
         */
        int minCount = Integer.MAX_VALUE;
        /**
         * 数量最少的同余的元素对应的余数的最小值
         */
        int index = -1;
        /**
         * counts[i]表示数组nums中元素对value取余后余数为i（余数取正值）的元素的个数
         */
        int[] counts = new int[value];

        for (int num : nums) {
            int remainder = num % value;
            /**
             * 如果nums[i]为负数，则remainder也可能为负数，通过remainder+value将余数转换为正值
             */
            remainder = remainder < 0 ? remainder + value : remainder;
            counts[remainder]++;
        }

        for (int i = 0; i < value; i++) {
            if (counts[i] < minCount) {
                minCount = counts[i];
                index = i;
            }
        }
        /**
         * 操作后数组中缺失的最小非负整数MEX对value取余的值为index，而之前的[0,value)、[value,2*value)、……、
         * [(counts[index]-1)*value,counts[index]*value)都是可以得到的，所以MEX为counts[index]*value+index
         */
        return counts[index] * value + index;
    }
}
