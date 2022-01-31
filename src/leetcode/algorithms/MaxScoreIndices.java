package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2155. All Divisions With the Highest Score of a Binary Array
 *
 * @author Baltan
 * @date 2022/1/31 12:58
 */
public class MaxScoreIndices {
    public static void main(String[] args) {
        System.out.println(maxScoreIndices(new int[]{0, 0, 1, 0}));
        System.out.println(maxScoreIndices(new int[]{0, 0, 0}));
        System.out.println(maxScoreIndices(new int[]{1, 1}));
    }

    public static List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> result = new ArrayList<>();
        /**
         * 假设当i为0的时候，即左子数组为空数组，右子数组为nums自身时，所求和为0（等于任意值x都可）
         */
        int sum = 0;
        /**
         * 假设当i为0时就是所求和的最大值状态
         */
        int max = 0;
        /**
         * 从左向右逐一将nums中的每个元素从右子数组移出放进左子数组中，如果元素是0，会使得左子数组中0的个数加1，右子数组中1的个
         * 数不变，从而所求和sum加1；反之如果元素是1，会使得左子数组中0的个数不变，右子数组中1的个数减1，从而所求和sum减1。通过
         * 以上操作可以获得所求和为最大值时的状态
         */
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? 1 : -1;
            max = Math.max(max, sum);
        }
        /**
         * 重新将i初始化为0，即左子数组为空数组，右子数组为nums自身时
         */
        sum = 0;
        /**
         * 先判断当前初始化状态能否使所求和达到最大值
         */
        if (max == sum) {
            result.add(0);
        }
        /**
         * 从左向右逐一将nums中的每个元素从右子数组移出放进左子数组中，判断能否使所求和达到最大值
         */
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? 1 : -1;

            if (max == sum) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
