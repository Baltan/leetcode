package leetcode.algorithms;

/**
 * Description: 3206. Alternating Groups I
 *
 * @author Baltan
 * @date 2024/7/9 19:20
 * @see NumberOfAlternatingGroups1
 */
public class NumberOfAlternatingGroups {
    public static void main(String[] args) {
        System.out.println(numberOfAlternatingGroups(new int[]{1, 1, 1}));
        System.out.println(numberOfAlternatingGroups(new int[]{0, 1, 0, 0, 1}));
    }

    public static int numberOfAlternatingGroups(int[] colors) {
        int result = 0;
        /**
         * 判断colors[i-1]、colors[i]、colors[i+1]是否构成交替组
         */
        for (int i = 1; i < colors.length - 1; i++) {
            if (colors[i] != colors[i - 1] && colors[i] != colors[i + 1]) {
                result++;
            }
        }
        /**
         * 判断colors[colors.length-1]、colors[0]、colors[1]是否构成交替组
         */
        if (colors[0] != colors[colors.length - 1] && colors[0] != colors[1]) {
            result++;
        }
        /**
         * 判断colors[colors.length-2]、colors[colors.length-1]、colors[0]是否构成交替组
         */
        if (colors[colors.length - 1] != colors[colors.length - 2] && colors[colors.length - 1] != colors[0]) {
            result++;
        }
        return result;
    }
}
