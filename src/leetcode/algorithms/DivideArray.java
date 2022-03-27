package leetcode.algorithms;

/**
 * Description: 2206. Divide Array Into Equal Pairs
 *
 * @author Baltan
 * @date 2022/3/26 21:04
 */
public class DivideArray {
    public static void main(String[] args) {
        System.out.println(divideArray(new int[]{3, 2, 3, 2, 2, 2}));
        System.out.println(divideArray(new int[]{1, 2, 3, 4}));
    }

    public static boolean divideArray(int[] nums) {
        /**
         * 根据题意，数组nums中的元素范围为[1,500]，count[i]表示数组nums中i出现的次数
         */
        int[] count = new int[501];

        for (int num : nums) {
            count[num]++;
        }
        /**
         * 如果有任意一个元素出现的次数不是偶数次，就不能实现题目的分组要求，直接返回false
         */
        for (int value : count) {
            if (value % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
