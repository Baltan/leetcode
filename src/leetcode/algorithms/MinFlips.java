package leetcode.algorithms;

/**
 * Description: 1318. Minimum Flips to Make a OR b Equal to c
 *
 * @author Baltan
 * @date 2020-01-21 11:15
 */
public class MinFlips {
    public static void main(String[] args) {
        System.out.println(minFlips(2, 6, 5));
        System.out.println(minFlips(4, 2, 7));
        System.out.println(minFlips(1, 2, 3));
        System.out.println(minFlips(777777777, 1000000000, 987654321));
    }

    public static int minFlips(int a, int b, int c) {
        int result = 0;
        String prefix = "00000000000000000000000000000000";
        int length = 32;
        /**
         * 将a转为二进制字符串后，截取后32位，不足的前缀补0
         */
        String binaryA = prefix + Integer.toBinaryString(a);
        binaryA = binaryA.substring(binaryA.length() - length);
        /**
         * 将b转为二进制字符串后，截取后32位，不足的前缀补0
         */
        String binaryB = prefix + Integer.toBinaryString(b);
        binaryB = binaryB.substring(binaryB.length() - length);
        /**
         * 将c转为二进制字符串后，截取后32位，不足的前缀补0
         */
        String binaryC = prefix + Integer.toBinaryString(c);
        binaryC = binaryC.substring(binaryC.length() - length);

        for (int i = 0; i < length; i++) {
            char charA = binaryA.charAt(i);
            char charB = binaryB.charAt(i);
            char charC = binaryC.charAt(i);

            if (charC == '0') {
                if (charA == '1' && charB == '1') {
                    result += 2;
                } else if (charA == '1' || charB == '1') {
                    result += 1;
                }
            } else {
                if (charA == '0' && charB == '0') {
                    result += 1;
                }
            }
        }
        return result;
    }
}
