package leetcode.algorithms;

/**
 * Description: 3722. Lexicographically Smallest String After Reverse
 *
 * @author baltan
 * @date 2026/1/7 16:55
 */
public class LexSmallest {
    public static void main(String[] args) {
        System.out.println(lexSmallest("knm"));
        System.out.println(lexSmallest("dcab"));
        System.out.println(lexSmallest("abba"));
        System.out.println(lexSmallest("zxy"));
    }

    public static String lexSmallest(String s) {
        String result = s;

        for (int i = 1; i <= s.length(); i++) {
            /**
             * 逐一比较反转s[0……i-1]后得到的子串和子串s[0……i-1]各个位置上的字符，如果前者更小，说明可以得到字典顺序小于s的字符串
             */
            for (int j = 0; j <= i / 2; j++) {
                if (s.charAt(i - 1 - j) < s.charAt(j)) {
                    /**
                     * 反转s[0……i-1]后得到的子串
                     */
                    String head = new StringBuilder(s.substring(0, i)).reverse().toString();
                    String tail = s.substring(i);
                    String reverse = head + tail;

                    if (reverse.compareTo(result) < 0) {
                        result = reverse;
                    }
                    break;
                }
            }
            /**
             * 逐一比较反转s[i……length-1]后得到的子串和子串s[i……length-1]各个位置上的字符，如果前者更小，说明可以得到字典顺序小于s的字
             * 符串
             */
            for (int j = i; j <= (i + s.length() - 1) / 2; j++) {
                if (s.charAt(i + s.length() - 1 - j) < s.charAt(j)) {
                    String head = s.substring(0, i);
                    /**
                     * 反转s[i……length-1]后得到的子串
                     */
                    String tail = new StringBuilder(s.substring(i)).reverse().toString();
                    String reverse = head + tail;

                    if (reverse.compareTo(result) < 0) {
                        result = reverse;
                    }
                    break;
                }
            }
        }
        return result;
    }
}
