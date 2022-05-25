package leetcode.algorithms;

/**
 * Description: 1869. Longer Contiguous Segments of Ones than Zeros
 *
 * @author Baltan
 * @date 2022/5/25 09:14
 */
public class CheckZeroOnes {
    public static void main(String[] args) {
        System.out.println(checkZeroOnes("1101"));
        System.out.println(checkZeroOnes("111000"));
        System.out.println(checkZeroOnes("110100010"));
    }

    public static boolean checkZeroOnes(String s) {
        int maxLength0 = 0;
        int maxLength1 = 0;
        /**
         * 当前连续字符串0的长度
         */
        int currLength0 = 0;
        /**
         * 当前连续字符串1的长度
         */
        int currLength1 = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                currLength0++;
                maxLength0 = Math.max(maxLength0, currLength0);
                currLength1 = 0;
            } else {
                currLength1++;
                maxLength1 = Math.max(maxLength1, currLength1);
                currLength0 = 0;
            }
        }
        return maxLength1 > maxLength0;
    }
}
