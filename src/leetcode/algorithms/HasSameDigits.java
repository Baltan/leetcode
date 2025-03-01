package leetcode.algorithms;

/**
 * Description: 3461. Check If Digits Are Equal in String After Operations I
 *
 * @author baltan
 * @date 2025/3/1 23:49
 */
public class HasSameDigits {
    public static void main(String[] args) {
        System.out.println(hasSameDigits("3902"));
        System.out.println(hasSameDigits("34789"));
    }

    public static boolean hasSameDigits(String s) {
        int[] digits = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        /**
         * 每一轮操作减少一个数字，最后剩下两个数字，一共模拟进行s.length()-2轮
         */
        for (int i = 0; i < s.length() - 2; i++) {
            for (int j = 0; j < s.length() - 1 - i; j++) {
                digits[j] = (digits[j] + digits[j + 1]) % 10;
            }
        }
        return digits[0] == digits[1];
    }
}
