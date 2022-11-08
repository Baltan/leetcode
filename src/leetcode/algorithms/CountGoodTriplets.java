package leetcode.algorithms;

/**
 * Description: 1534. Count Good Triplets
 *
 * @author Baltan
 * @date 2022/10/27 17:17
 */
public class CountGoodTriplets {
    public static void main(String[] args) {
        System.out.println(countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3));
        System.out.println(countGoodTriplets(new int[]{1, 1, 2, 2, 3}, 0, 0, 1));
    }

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int result = 0;
        int length = arr.length;
        /**
         * 枚举所有三元组，查找其中的好三元组
         */
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b &&
                            Math.abs(arr[i] - arr[k]) <= c) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
