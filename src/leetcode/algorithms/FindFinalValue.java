package leetcode.algorithms;

/**
 * Description: 2154. Keep Multiplying Found Values by Two
 *
 * @author Baltan
 * @date 2022/2/2 11:33
 */
public class FindFinalValue {
    public static void main(String[] args) {
        System.out.println(findFinalValue(new int[]{5, 3, 6, 1, 12}, 3));
        System.out.println(findFinalValue(new int[]{2, 7, 9}, 4));
    }

    public static int findFinalValue(int[] nums, int original) {
        /**
         * 根据题意，数组nums中的最大元素不超过1000
         */
        int max = 1000;
        /**
         * count[i]表示数组nums中数字i出现的次数
         */
        int[] count = new int[max + 1];

        for (int num : nums) {
            count[num]++;
        }
        /**
         * 判断数组nums中是否存在元素original
         */
        while (original <= max && count[original] > 0) {
            original <<= 1;
        }
        return original;
    }
}
