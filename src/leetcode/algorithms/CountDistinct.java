package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 2261. K Divisible Elements Subarrays
 *
 * @author Baltan
 * @date 2022/5/5 13:42
 */
public class CountDistinct {
    public static void main(String[] args) {
        System.out.println(countDistinct(new int[]{2, 3, 3, 2, 2}, 2, 2));
        System.out.println(countDistinct(new int[]{1, 2, 3, 4}, 4, 1));
    }

    public static int countDistinct(int[] nums, int k, int p) {
        int result = 0;
        /**
         * 保存每个子数组元素拼接成的字符串，用于对不同的子数组进行去重
         */
        Set<String> set = new HashSet<>();
        int length = nums.length;
        /**
         * divisibleByP[i]表示nums[i]是否可以被p整除
         */
        boolean[] divisibleByP = new boolean[length];

        for (int i = 0; i < length; i++) {
            divisibleByP[i] = nums[i] % p == 0;
        }

        for (int i = 0; i < length; i++) {
            /**
             * 以nums[i]作为第一个元素的子数组中，可以被p整除的元素的个数
             */
            int count = 0;
            StringBuilder builder = new StringBuilder();

            for (int j = i; j < length; j++) {
                /**
                 * 子数组中能被p整除的元素的个数已达上限，不用继续追加元素
                 */
                if (divisibleByP[j] && count == k) {
                    break;
                }

                if (divisibleByP[j]) {
                    count++;
                }
                /**
                 * 子数组中的元素拼接成字符串
                 */
                builder.append(nums[j]).append(",");
                String numsStr = builder.toString();

                if (!set.contains(numsStr)) {
                    result++;
                    set.add(numsStr);
                }
            }
        }
        return result;
    }
}
