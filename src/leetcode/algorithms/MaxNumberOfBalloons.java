package leetcode.algorithms;

/**
 * Description: 1189. Maximum Number of Balloons
 *
 * @author Baltan
 * @date 2019-09-16 09:05
 */
public class MaxNumberOfBalloons {
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko"));
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(maxNumberOfBalloons("leetcode"));
    }

    public static int maxNumberOfBalloons(String text) {
        int result = Integer.MAX_VALUE;
        int[] count = new int[26];

        for (char c : text.toCharArray()) {
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                count[c - 'a']++;
            }
        }
        result = Math.min(result, count['b' - 'a']);
        result = Math.min(result, count['a' - 'a']);
        result = Math.min(result, count['l' - 'a'] / 2);
        result = Math.min(result, count['o' - 'a'] / 2);
        result = Math.min(result, count['n' - 'a']);
        return result;
    }
}
