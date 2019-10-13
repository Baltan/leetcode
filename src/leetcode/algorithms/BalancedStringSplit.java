package leetcode.algorithms;

/**
 * Description: 1221. Split a String in Balanced Strings
 *
 * @author Baltan
 * @date 2019-10-13 13:52
 */
public class BalancedStringSplit {
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
        System.out.println(balancedStringSplit("LRL"));
    }

    public static int balancedStringSplit(String s) {
        int result = 0;
        int lCount = 0;
        int rCount = 0;

        for (char c : s.toCharArray()) {
            if (c == 'L') {
                lCount++;
            } else {
                rCount++;
            }

            if (lCount == rCount) {
                result++;
                lCount = 0;
                rCount = 0;
            }
        }
        return result;
    }
}
