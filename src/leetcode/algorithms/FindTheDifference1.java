package leetcode.algorithms;

/**
 * Description: 389. Find the Difference
 *
 * @author Baltan
 * @date 2017/12/31 00:44
 */
public class FindTheDifference1 {
    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
        System.out.println(findTheDifference("a", "aa"));
    }

    public static char findTheDifference(String s, String t) {
        /**
         * 只有随机添加的字母出现了奇数次，其余字母都出现了偶数次，利用i^i=0和0^i=i的原理可以找到多余的那个字母
         */
        int result = 0;

        for (char c : s.toCharArray()) {
            result ^= c;
        }

        for (char c : t.toCharArray()) {
            result ^= c;
        }
        return (char) result;
    }
}
