package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: 473. Matchsticks to Square
 *
 * @author Baltan
 * @date 2019-08-31 11:58
 */
public class Makesquare {
    public static void main(String[] args) {
        System.out.println(makesquare(new int[]{1, 1, 2, 2, 2}));
        System.out.println(makesquare(new int[]{3, 3, 3, 3, 4}));
        System.out.println(makesquare(new int[]{1, 10, 9, 2, 7, 4, 3, 3, 2, 3}));
        System.out.println(makesquare(new int[]{1, 1, 1, 1}));
        System.out.println(makesquare(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
    }

    public static boolean makesquare(int[] nums) {
        /**
         * 如果火柴棍不足四根，无法拼成正方形，直接返回false
         */
        if (nums == null || nums.length < 4) {
            return false;
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        int totalLength = 0;

        for (int num : nums) {
            totalLength += num;
            numList.add(num);
        }
        /**
         * 如果火柴棍总长度不为4的整数倍，边长不为整数，无法拼成正方形，直接返回false
         */
        if (totalLength % 4 != 0) {
            return false;
        }
        /**
         * 正方形的边长
         */
        int sideLength = totalLength / 4;
        Collections.sort(numList);
        /**
         * 如果最长的火柴棍长度大于边长，无法拼成正方形，直接返回false
         */
        if (numList.get(numList.size() - 1) > sideLength) {
            return false;
        }

        help(result, numList, new ArrayList<>(), 0, sideLength);
        /**
         * 如果火柴棍无法凑得边长，无法拼成正方形，直接返回false
         */
        if (result.isEmpty()) {
            return false;
        }

        result = new ArrayList<>();
        help(result, numList, new ArrayList<>(), 0, sideLength);
        /**
         * 如果剩余的火柴棍无法凑得边长，无法拼成正方形，直接返回false
         */
        if (result.isEmpty()) {
            return false;
        }

        result = new ArrayList<>();
        help(result, numList, new ArrayList<>(), 0, sideLength);
        /**
         * 如果剩余的火柴棍无法凑得边长，无法拼成正方形，直接返回false
         */
        if (result.isEmpty()) {
            return false;
        }

        result = new ArrayList<>();
        help(result, numList, new ArrayList<>(), 0, sideLength);
        /**
         * 如果剩余的火柴棍无法凑得边长或者还有剩余的火柴棍，无法拼成正方形，直接返回false
         */
        return !result.isEmpty() && numList.isEmpty();
    }

    /**
     * 从numList中选择一组数，这几个数的和为target
     *
     * @param result
     * @param numList
     * @param temp
     * @param sum
     * @param target
     */
    public static void help(List<List<Integer>> result, List<Integer> numList, List<Integer> temp, int sum,
                            int target) {
        int size = numList.size();

        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = size - 1; i >= 0; i--) {
            int num = numList.get(i);
            temp.add(num);
            numList.remove(i);
            help(result, numList, temp, sum + num, target);

            if (!result.isEmpty()) {
                return;
            }

            temp.remove(temp.size() - 1);
            numList.add(i, num);
        }
    }
}
