package leetcode.algorithms;

/**
 * Description: 3091. Apply Operations to Make Sum of Array Greater Than or Equal to k
 *
 * @author Baltan
 * @date 2024/3/25 22:48
 */
public class MinOperations21 {
    public static void main(String[] args) {
        System.out.println(minOperations(9));
        System.out.println(minOperations(11));
        System.out.println(minOperations(1));
    }

    public static int minOperations(int k) {
        int result = Integer.MAX_VALUE;
        /**
         * 不论是哪种操作，操作对象都应该是数组nums中的最大值max，如果有2次操作机会，则max可以变为：
         *      ①、操作1、操作1：max+1+1=max+2
         *      ②、操作1、操作2：(max+1)*2=max+max+2
         *      ③、操作2、操作1：max+max+1
         *      ④、操作2、操作2：max+max+max
         * 显然，先对max进行加1，再将新得到的最大值max_重复加入数组，能使数组中所有元素之和尽可能大。所以应该将所有加1操作先执行，后续再执行
         * 所有重复最大值的操作。遍历所有可能的加1操作次数，最多情况下只进行加1操作，共k-1次
         */
        for (int i = 0; i < k; i++) {
            /**
             * i次加1操作后，数组中的最大值变为max，后续进行若干次max复制操作，直到数组中所有元素的和不小于k
             */
            int max = 1 + i;
            result = Math.min(result, (int) Math.ceil((k - max) * 1.0 / max) + i);
        }
        return result;
    }
}
