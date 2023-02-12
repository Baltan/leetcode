package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 2465. Number of Distinct Averages
 *
 * @author Baltan
 * @date 2023/2/8 09:17
 */
public class DistinctAverages {
    public static void main(String[] args) {
        System.out.println(distinctAverages(new int[]{4, 1, 4, 0, 3, 5}));
        System.out.println(distinctAverages(new int[]{1, 100}));
    }

    public static int distinctAverages(int[] nums) {
        /**
         * 计算不同的平均数个数等同于计算不同的两数之和的个数，sumSet保存所有最大最小值之和
         */
        Set<Integer> sumSet = new HashSet<>();
        int lo = 0;
        int hi = nums.length - 1;
        Arrays.sort(nums);

        while (lo < hi) {
            sumSet.add(nums[lo] + nums[hi]);
            lo++;
            hi--;
        }
        return sumSet.size();
    }
}
