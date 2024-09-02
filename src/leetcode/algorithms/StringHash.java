package leetcode.algorithms;

/**
 * Description: 3271. Hash Divided String
 *
 * @author baltan
 * @date 2024/9/2 09:04
 */
public class StringHash {
    public static void main(String[] args) {
        System.out.println(stringHash("abcd", 2));
        System.out.println(stringHash("mxz", 3));
    }

    public static String stringHash(String s, int k) {
        int groups = s.length() / k;
        char[] charArray = new char[groups];

        for (int i = 0; i < groups; i++) {
            /**
             * 子串中所有字符哈希值之和
             */
            int sum = 0;

            for (int j = 0; j < k; j++) {
                sum += s.charAt(i * k + j) - 'a';
            }
            charArray[i] = (char) ('a' + sum % 26);
        }
        return new String(charArray);
    }
}
