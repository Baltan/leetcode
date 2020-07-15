package leetcode.algorithms;

/**
 * Description: 1513. Number of Substrings With Only 1s
 *
 * @author Baltan
 * @date 2020-07-14 22:19
 */
public class NumSub {
    public static void main(String[] args) {
        System.out.println(numSub("0110111"));
        System.out.println(numSub("101"));
        System.out.println(numSub("111111"));
        System.out.println(numSub("000"));
    }

    public static int numSub(String s) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * 当前连续的"1"的个数
         */
        int count = 0;
        /**
         * 如果s的结尾为若干个"1"，避免这些所有字符都为"1"的子串被遗漏
         */
        s = s + "0";

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            } else {
                /**
                 * 此处count*(count+1)要处理成Long类型，否则Integer类型可能溢出
                 */
                result = result + 1L * count * (count + 1) / 2;
                count = 0;
            }
        }
        return (int) (result % mod);
    }
}
