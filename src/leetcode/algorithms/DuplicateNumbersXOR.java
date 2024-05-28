package leetcode.algorithms;

/**
 * Description: 3158. Find the XOR of Numbers Which Appear Twice
 *
 * @author Baltan
 * @date 2024/5/28 22:53
 */
public class DuplicateNumbersXOR {
    public static void main(String[] args) {
        System.out.println(duplicateNumbersXOR(new int[]{1, 2, 1, 3}));
        System.out.println(duplicateNumbersXOR(new int[]{1, 2, 3}));
        System.out.println(duplicateNumbersXOR(new int[]{1, 2, 2, 1}));
    }

    public static int duplicateNumbersXOR(int[] nums) {
        int result = 0;
        /**
         * isVisited[i]表示数组nums中是否已出现过数字i，根据题意，i∈[1,50]
         */
        boolean[] isVisited = new boolean[51];

        for (int num : nums) {
            if (isVisited[num]) {
                /**
                 * 数字num在数组nums中第二次出现
                 */
                result ^= num;
            } else {
                /**
                 * 数字num在数组nums中第一次出现
                 */
                isVisited[num] = true;
            }
        }
        return result;
    }
}
