package leetcode.algorithms;

/**
 * Description: 2275. Largest Combination With Bitwise AND Greater Than Zero
 *
 * @author Baltan
 * @date 2022/5/17 09:12
 */
public class LargestCombination {
    public static void main(String[] args) {
        System.out.println(largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14}));
        System.out.println(largestCombination(new int[]{8, 8}));
    }

    public static int largestCombination(int[] candidates) {
        int result = 0;
        /**
         * 根据题意，candidates[i]∈[1,10000000]
         */
        int limit = 10000000;
        /**
         * 计算candidates中所有数字二进制表示后，每一位上为1的数字的个数，最大个数即为所求
         */
        for (int i = 1; i <= limit; i <<= 1) {
            /**
             * candidates中所有数字二进制表示的当前数位上为1的数字的个数
             */
            int count = 0;

            for (int candidate : candidates) {
                /**
                 * 表达式(candidate&i)==i可以依次判断candidate的二进制表示从低位开始每一位是否为1
                 */
                if ((candidate & i) == i) {
                    count++;
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
