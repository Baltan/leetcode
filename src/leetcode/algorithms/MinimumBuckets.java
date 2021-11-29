package leetcode.algorithms;

/**
 * Description: 2086. Minimum Number of Buckets Required to Collect Rainwater from Houses
 *
 * @author Baltan
 * @date 2021/11/29 09:56
 */
public class MinimumBuckets {
    public static void main(String[] args) {
        System.out.println(minimumBuckets("H..H"));
        System.out.println(minimumBuckets(".H.H."));
        System.out.println(minimumBuckets(".HHH."));
        System.out.println(minimumBuckets("H"));
        System.out.println(minimumBuckets("."));
    }

    public static int minimumBuckets(String street) {
        int result = 0;
        int length = street.length();
        char[] charArray = street.toCharArray();
        /**
         * 先从左向右遍历，尽可能在房子的右侧放桶，因为在右侧放桶可能使更右边的房子也能被接到雨水
         */
        for (int i = 0; i < length; i++) {
            if (charArray[i] == 'H') {
                /**
                 * 如果房子左侧就是桶，则此房子已经可以被接到雨水，直接将房子标记为"X"（避免后面被重复判断）
                 */
                if (i - 1 >= 0 && charArray[i - 1] == 'B') {
                    charArray[i] = 'X';
                    continue;
                    /**
                     * 如果房子右侧是空地，在此处放桶用于接房子的雨水
                     */
                } else if (i + 1 < length && charArray[i + 1] == '.') {
                    result++;
                    charArray[i] = 'X';
                    charArray[i + 1] = 'B';
                }
            }
        }
        /**
         * 再从右向左遍历，尽可能在房子的左侧放桶，因为在左侧放桶可能使更左边的房子也能被接到雨水
         */
        for (int i = length - 1; i >= 0; i--) {
            if (charArray[i] == 'H') {
                /**
                 * 如果房子右侧就是桶，则此房子已经可以被接到雨水，直接将房子标记为"X"
                 */
                if (i + 1 < length && charArray[i + 1] == 'B') {
                    charArray[i] = 'X';
                    continue;
                    /**
                     * 如果房子左侧是空地，在此处放桶用于接房子的雨水
                     */
                } else if (i - 1 >= 0 && charArray[i - 1] == '.') {
                    result++;
                    charArray[i] = 'X';
                    charArray[i - 1] = 'B';
                }
            }
        }
        /**
         * 如果还存在不能被接到雨水的房子，返回-1
         */
        for (int i = 0; i < length; i++) {
            if (charArray[i] == 'H') {
                return -1;
            }
        }
        return result;
    }
}
