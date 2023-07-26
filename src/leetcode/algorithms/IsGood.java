package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2784. Check if Array is Good
 *
 * @author Baltan
 * @date 2023/7/24 23:31
 */
public class IsGood {
    public static void main(String[] args) {
        System.out.println(isGood(new int[]{2, 1, 3}));
        System.out.println(isGood(new int[]{1, 3, 3, 2}));
        System.out.println(isGood(new int[]{1, 1}));
        System.out.println(isGood(new int[]{3, 4, 4, 1, 2, 1}));
    }

    public static boolean isGood(int[] nums) {
        int length = nums.length;
        /**
         * counts[i]表示一个长度为length的base数组（[1,2,3,……,length-2,length-1,length-1]）中每个数字i出现的次数
         */
        int[] counts = new int[length];
        Arrays.fill(counts, 1);
        counts[0] = 0;
        counts[length - 1] = 2;
        /**
         * 假设数组nums是由一个base数组排序得到的，逐一判断数组nums中的数字是否还能在此base数组中存在
         */
        for (int num : nums) {
            /**
             * 1、base数组中的数字范围为[1,length-1]，不可能存在大于等于length的元素
             * 2、数字num的个数已经超过了base数组中num的个数
             */
            if (num >= length || counts[num] == 0) {
                return false;
            }
            counts[num]--;
        }
        /**
         * 如果counts中剩余的元素都为0，表示base数组中的元素都在数组nums中出现过了
         */
        return Arrays.stream(counts).allMatch(value -> value == 0);
    }
}
