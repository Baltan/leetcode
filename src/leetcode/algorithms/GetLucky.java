package leetcode.algorithms;

/**
 * Description: 1945. Sum of Digits of String After Convert
 *
 * @author Baltan
 * @date 2022/2/19 18:31
 */
public class GetLucky {
    public static void main(String[] args) {
        System.out.println(getLucky("iiii", 1));
        System.out.println(getLucky("leetcode", 2));
        System.out.println(getLucky("zbax", 2));
    }

    public static int getLucky(String s, int k) {
        int sum = 0;
        /**
         * 第一次操作现将字符串s中的每个字符转换为对应的数字，并求和
         */
        for (char c : s.toCharArray()) {
            int num = c - 'a' + 1;
            /**
             * 各个数位上的数字相加
             */
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
        }
        /**
         * 剩下的k-1次操作
         */
        for (int i = 1; i < k; i++) {
            int currSum = 0;
            /**
             * 各个数位上的数字相加
             */
            while (sum > 0) {
                currSum += sum % 10;
                sum /= 10;
            }
            /**
             * 如果求和结果已经是个位数了，后面的操作不需要继续，结果只会是当前个位数currSum
             */
            if (currSum < 10) {
                return currSum;
            } else {
                sum = currSum;
            }
        }
        return sum;
    }
}
