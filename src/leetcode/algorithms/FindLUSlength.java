package leetcode.algorithms;

/**
 * Description: 521. Longest Uncommon Subsequence I
 * @author Baltan
 *
 * @date 2017/11/17 14:45
 */
public class FindLUSlength {
    public static void main(String[] args) {
        System.out.println(findLUSlength("aba", "cdc"));
    }

    public static int findLUSlength(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        if (a.equals(b)) {
            return -1;
        } else {
            return aLength > bLength ? aLength : bLength;
        }
    }
}
