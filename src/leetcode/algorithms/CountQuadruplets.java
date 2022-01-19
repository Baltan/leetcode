package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1995. Count Special Quadruplets
 *
 * @author Baltan
 * @date 2022/1/19 08:58
 */
public class CountQuadruplets {
    public static void main(String[] args) {
        System.out.println(countQuadruplets(new int[]{1, 2, 3, 6}));
        System.out.println(countQuadruplets(new int[]{3, 3, 6, 4, 5}));
        System.out.println(countQuadruplets(new int[]{1, 1, 1, 3, 5}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/count-special-quadruplets/solution/tong-ji-te-shu-si-yuan-zu-by-leetcode-so-50e2/"></a>
     *
     * @param nums
     * @return
     */
    public static int countQuadruplets(int[] nums) {
        int result = 0;
        int length = nums.length;
        /**
         * 满足条件的d-c -> d-c值的个数
         */
        Map<Integer, Integer> countMap = new HashMap<>();
        /**
         * 转化等式为a+b=d-c，数字b的索引范围为[1,length-3]
         */
        for (int bIndex = length - 3; bIndex >= 1; bIndex--) {
            /**
             * 数字d的索引范围为[bIndex+2,length)
             */
            for (int dIndex = bIndex + 2; dIndex < length; dIndex++) {
                /**
                 * 令c的索引始终为bIndex+1
                 */
                countMap.put(nums[dIndex] - nums[bIndex + 1],
                        countMap.getOrDefault(nums[dIndex] - nums[bIndex + 1], 0) + 1);
            }
            /**
             * 数字a的索引范围为[0,bIndex)
             */
            for (int aIndex = 0; aIndex < bIndex; aIndex++) {
                result += countMap.getOrDefault(nums[aIndex] + nums[bIndex], 0);
            }
        }
        return result;
    }
}
