package leetcode.algorithms;

/**
 * Description: 775. Global and Local Inversions
 *
 * @author Baltan
 * @date 2020-02-16 15:58
 */
public class IsIdealPermutation {
    public static void main(String[] args) {
        System.out.println(isIdealPermutation(new int[]{1, 0, 2}));
        System.out.println(isIdealPermutation(new int[]{1, 2, 0}));
        System.out.println(isIdealPermutation(new int[]{4, 3, 4}));
        System.out.println(isIdealPermutation(new int[]{4, 3, 3}));
        System.out.println(isIdealPermutation(new int[]{4, 4, 3}));
        System.out.println(isIdealPermutation(new int[]{4, 4, 3, 3}));
    }

    public static boolean isIdealPermutation(int[] A) {
        int length = A.length;
        int min = Integer.MAX_VALUE;
        /**
         * 局部倒置一定是全局倒置，所以只要检查是否存在不是局部倒置的全局倒置即可。从后向前查找
         * 是否存在以上情况
         */
        for (int i = length - 1; i >= 2; --i) {
            /**
             * A.subarray(i,length)这些数中的最小值
             */
            min = Math.min(min, A[i]);
            /**
             * 不是局部倒置的全局倒置
             */
            if (A[i - 2] > min) {
                return false;
            }
        }
        return true;
    }
}
