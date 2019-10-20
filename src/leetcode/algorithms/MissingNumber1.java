package leetcode.algorithms;

/**
 * Description: 1228. Missing Number In Arithmetic Progression
 *
 * @author Baltan
 * @date 2019-10-20 09:39
 */
public class MissingNumber1 {
    public static void main(String[] args) {
        int[] arr1 = {5, 7, 11, 13};
        System.out.println(missingNumber(arr1));

        int[] arr2 = {15, 13, 12};
        System.out.println(missingNumber(arr2));

        int[] arr3 = {3, 7};
        System.out.println(missingNumber(arr3));

        int[] arr4 = {0, 0, 0, 0, 0};
        System.out.println(missingNumber(arr4));
    }

    public static int missingNumber(int[] arr) {
        int length = arr.length;
        /**
         * 计算等差数列的公差
         */
        int difference = (arr[length - 1] - arr[0]) / length;
        /**
         * 如果后一个数和前一个数的差值不等于公差，说明后一个数是缺失项
         */
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] + difference != arr[i + 1]) {
                return arr[i] + difference;
            }
        }
        /**
         * 如果以上循环没有满足条件的缺失项，说明等差数列所有项都相等，可以返回数列的第一项
         */
        return arr[0];
    }
}
