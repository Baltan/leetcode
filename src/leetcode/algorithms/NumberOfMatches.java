package leetcode.algorithms;

/**
 * Description: 1688. Count of Matches in Tournament
 *
 * @author Baltan
 * @date 2022/8/27 22:23
 */
public class NumberOfMatches {
    public static void main(String[] args) {
        System.out.println(numberOfMatches(7));
        System.out.println(numberOfMatches(14));
    }

    public static int numberOfMatches(int n) {
        /**
         * 一共需要淘汰n-1个队伍
         */
        return n - 1;
    }
}
