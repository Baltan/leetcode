package leetcode.algorithms;

/**
 * Description: 461. Hamming Distance
 * @author Baltan
 *
 * @date 2017/11/7 11:29
 */
public class HammingDistance {
    public static void main(String[] args) {
        int result = hammingDistance(14, 2);
        System.out.println(result);
    }

    public static int hammingDistance(int x, int y) {
        String str1 = Integer.toBinaryString(x);
        String str2 = Integer.toBinaryString(y);
        if (str1.length() < str2.length()) {
            int j = str2.length() - str1.length();
            for (int i = 0; i < j; i++) {
                str1 = "0" + str1;
            }
        } else if (str2.length() < str1.length()) {
            int j = str1.length() - str2.length();
            for (int i = 0; i < j; i++) {
                str2 = "0" + str2;
            }
        }
        int length = str1.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (!Integer.valueOf(str1.charAt(i)).equals(Integer.valueOf(str2.charAt(i)))) {
                count++;
            }
        }
        return count;
    }
}
