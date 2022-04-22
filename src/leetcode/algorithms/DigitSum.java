package leetcode.algorithms;

/**
 * Description: 2243. Calculate Digit Sum of a String
 *
 * @author Baltan
 * @date 2022/4/21 20:16
 */
public class DigitSum {
    public static void main(String[] args) {
        System.out.println(digitSum("11111222223", 3));
        System.out.println(digitSum("00000000", 3));
    }

    public static String digitSum(String s, int k) {
        if (s.length() <= k) {
            return s;
        }
        /**
         * 反复循环减少s的长度，直到s的长度不大于k为止
         */
        do {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                /**
                 * 计算连续k个数字的和，不足k个数字时，只计算这部分数字的和
                 */
                for (int j = 0; j < k && i + j < s.length(); j++) {
                    sum += (s.charAt(i + j) - '0');
                }
                builder.append(sum);
            }
            s = builder.toString();
        } while (s.length() > k);
        return s;
    }
}
