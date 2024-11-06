package leetcode.algorithms;

/**
 * Description: 3340. Check Balanced String
 *
 * @author Baltan
 * @date 2024/11/3 13:41
 */
public class IsBalanced1 {
    public static void main(String[] args) {
        System.out.println(isBalanced("1234"));
        System.out.println(isBalanced("24123"));
    }

    public static boolean isBalanced(String num) {
        /**
         * 数字num偶数索引上的数字之和
         */
        int evenSum = 0;
        /**
         * 数字num奇数索引上的数字之和
         */
        int oddSum = 0;

        for (int i = 0; i < num.length(); i++) {
            if (i % 2 == 0) {
                evenSum += num.charAt(i) - '0';
            } else {
                oddSum += num.charAt(i) - '0';
            }
        }
        return evenSum == oddSum;
    }
}
