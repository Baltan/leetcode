package leetcode.algorithms;

/**
 * Description: 3208. Alternating Groups II
 *
 * @author Baltan
 * @date 2024/7/9 19:21
 * @see NumberOfAlternatingGroups
 */
public class NumberOfAlternatingGroups1 {
    public static void main(String[] args) {
        System.out.println(numberOfAlternatingGroups(new int[]{0, 1, 0, 1, 0}, 3));
        System.out.println(numberOfAlternatingGroups(new int[]{0, 1, 0, 0, 1, 0, 1}, 6));
        System.out.println(numberOfAlternatingGroups(new int[]{1, 1, 0, 1}, 4));
    }

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int result = 0;
        int start = 0;
        int curr = start + 1;
        /**
         * 将两个剪开的环头尾相接连在一起
         */
        int[] band = new int[colors.length << 1];

        for (int i = 0; i < colors.length; i++) {
            band[i] = colors[i];
            band[i + colors.length] = colors[i];
        }
        /**
         * 如果当前交替组的第一个瓷砖为band[start]（start>=colors.length），则在环上实际的第一个瓷砖为band[start-colors.length]，已
         * 被计算过
         */
        while (start < colors.length) {
            if (band[curr] != band[curr - 1]) {
                /**
                 * 得到一个长度为k的交替组，并且band[start+1]作为第一块瓷砖开始判断新的交替组
                 */
                if (curr - start + 1 == k) {
                    result++;
                    start++;
                }
                /**
                 * 继续延长交替组
                 */
                curr++;
            } else {
                /**
                 * band[start]作为第一块瓷砖开始判断新的交替组
                 */
                start = curr;
                curr = start + 1;
            }
        }
        return result;
    }
}
