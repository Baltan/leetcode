package leetcode.algorithms;

/**
 * Description: 1295. Find Numbers with Even Number of Digits
 *
 * @author Baltan
 * @date 2019-12-23 16:25
 */
public class FindNumbers {
    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{12, 345, 2, 6, 7896}));
        System.out.println(findNumbers(new int[]{555, 901, 482, 1771}));
    }

    public static int findNumbers(int[] nums) {
        int result = 0;

        for (int num : nums) {
            /**
             * 因为根据题意，num在[1,100000]范围内，所以只有以下三种情况num是包含偶数个数字的
             */
            if ((num >= 10 && num <= 99) || (num >= 1000 && num <= 9999) || num == 100000) {
                result++;
            }
        }
        return result;
    }
}
