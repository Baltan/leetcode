package leetcode.algorithms;

/**
 * Description: 2733. Neither Minimum nor Maximum
 *
 * @author Baltan
 * @date 2023/6/11 18:31
 */
public class FindNonMinOrMax {
    public static void main(String[] args) {
        System.out.println(findNonMinOrMax(new int[]{3, 2, 1, 4}));
        System.out.println(findNonMinOrMax(new int[]{1, 2}));
        System.out.println(findNonMinOrMax(new int[]{2, 1, 3}));
    }

    public static int findNonMinOrMax(int[] nums) {
        /**
         * 数组nums中的最小值
         */
        int min = Integer.MAX_VALUE;
        /**
         * 数组nums中的最大值
         */
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        /**
         * 在数组nums中找到一个既不等于最小值，也不等于最大值的的数字返回
         */
        for (int num : nums) {
            if (num != min && num != max) {
                return num;
            }
        }
        return -1;
    }
}
