package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2963. Count the Number of Good Partitions
 *
 * @author Baltan
 * @date 2023/12/15 22:27
 */
public class NumberOfGoodPartitions {
    public static void main(String[] args) {
        System.out.println(numberOfGoodPartitions(new int[]{1, 2, 3, 4}));
        System.out.println(numberOfGoodPartitions(new int[]{1, 1, 1, 1}));
        System.out.println(numberOfGoodPartitions(new int[]{1, 2, 1, 3}));
    }

    public static int numberOfGoodPartitions(int[] nums) {
        long result = 1L;
        int mod = 1000000007;
        /**
         * 数字i -> [i在数组nums中第一次出现的索引,i在数组nums中最后一次出现的索引]
         */
        Map<Integer, int[]> map = new HashMap<>();
        /**
         * gaps[i]为true表示不能将nums[i]和nums[i+1]分割到两个不同的子数组中
         */
        boolean[] gaps = new boolean[nums.length - 1];
        /**
         * 可以作为分割点的的索引数量
         */
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int[] indexes = map.get(nums[i]);

            if (indexes == null) {
                indexes = new int[]{i, i};
                map.put(nums[i], indexes);
            } else {
                indexes[1] = i;
            }
        }
        /**
         * 因为indexes[0]=indexes[1]，所以indexes[0]和indexes[1]必须被划分到同一个子数组中，它们之间的所有索引都不能作为分割点
         */
        for (int[] indexes : map.values()) {
            for (int i = indexes[0]; i < indexes[1]; i++) {
                gaps[i] = true;
            }
        }

        for (boolean gap : gaps) {
            if (!gap) {
                count++;
            }
        }
        /**
         * 在可以作为分割点的count个索引中选择0、1、2、……、count-1、count处分割数组nums，共有8C0+8C1+8C2+……+8C(count-1)+8C(count)
         * =2^count种情况
         */
        for (int i = 0; i < count; i++) {
            result = (result * 2) % mod;
        }
        return (int) result;
    }
}
