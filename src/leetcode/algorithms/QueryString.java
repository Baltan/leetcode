package leetcode.algorithms;

/**
 * Description: 1016. Binary String With Substrings Representing 1 To N
 *
 * @author Baltan
 * @date 2019-03-24 13:33
 */
public class QueryString {
    public static void main(String[] args) {
        System.out.println(queryString("0110", 3));
        System.out.println(queryString("0110", 4));
    }

    public static boolean queryString(String S, int N) {
        for (int i = 1; i <= N; i++) {
            String str = Integer.toBinaryString(i);
            if (S.indexOf(str) == -1) {
                return false;
            }
        }
        return true;
    }
}
