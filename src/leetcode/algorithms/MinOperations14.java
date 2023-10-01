package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 2869. Minimum Operations to Collect Elements
 *
 * @author baltan
 * @date 2023/10/1 14:14
 */
public class MinOperations14 {
    public static void main(String[] args) {
        System.out.println(minOperations(Arrays.asList(3, 1, 5, 4, 2), 2));
        System.out.println(minOperations(Arrays.asList(3, 1, 5, 4, 2), 5));
        System.out.println(minOperations(Arrays.asList(3, 2, 5, 3, 1), 3));
    }

    public static int minOperations(List<Integer> nums, int k) {
        int result = 0;
        /**
         * 每当获得[1,k]中的一个整数x，就将二进制数mask由低到高的第x-1位变为1
         */
        long mask = 0L;
        /**
         * mask最终需要达到的状态是0b111……11（一共k个1）
         */
        long status = (1L << k) - 1;

        for (int i = nums.size() - 1; i >= 0; i--) {
            result++;
            int num = nums.get(i);
            /**
             * 如果当前数字在[1,k]范围之外，忽略
             */
            if (num > k) {
                continue;
            }
            /**
             * 将mask由低到高的第num-1位变为1
             */
            mask |= (1L << (num - 1));

            if (mask == status) {
                break;
            }
        }
        return result;
    }
}
