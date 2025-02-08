package leetcode.algorithms;

/**
 * Description: 3443. Maximum Manhattan Distance After K Changes
 *
 * @author baltan
 * @date 2025/2/8 13:52
 */
public class MaxDistance4 {
    public static void main(String[] args) {
        System.out.println(maxDistance("EWWE", 0));
        System.out.println(maxDistance("NWSE", 1));
        System.out.println(maxDistance("NSWWEW", 3));
    }

    public static int maxDistance(String s, int k) {
        int result = 0;
        /**
         * 保存在东南西北四个方向上各自移动的步数
         */
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'A']++;
            result = Math.max(result, help(counts, 'N', 'W', 'S', 'E', k));
            result = Math.max(result, help(counts, 'N', 'E', 'S', 'W', k));
            result = Math.max(result, help(counts, 'S', 'W', 'N', 'E', k));
            result = Math.max(result, help(counts, 'S', 'E', 'N', 'W', k));
        }
        return result;
    }

    /**
     * 计算当前移动状态下可以达到的最大曼哈顿距离
     *
     * @param counts    当前移动状态下在四个方向上各自移动的步数
     * @param positiveY 南北方向上正向移动的步数
     * @param positiveX 东西方向上正向移动的步数
     * @param negativeY 南北方向上反向移动的步数
     * @param negativeX 东西方向上反向移动的步数
     * @param k
     * @return
     */
    public static int help(int[] counts, char positiveY, char positiveX, char negativeY, char negativeX, int k) {
        /**
         * 以为计算曼哈顿距离时，南北方向上的步数和东西方向上的步数互不影响，此时得到从原点出发后，正向移动的步数和为positive，反向移动的步
         * 数为negative
         */
        int negative = counts[negativeX - 'A'] + counts[negativeY - 'A'];
        int positive = counts[positiveX - 'A'] + counts[positiveY - 'A'];
        /**
         * 最多可将changed步反向移动修改为正向移动
         */
        int changed = Math.min(negative, k);
        /**
         * 修改后正向移动的步数为positive+changed，反向移动的步数为negative-changed，两个方向上的步数相抵即为距离原点的曼哈短距离
         */
        return positive + changed - (negative - changed);
    }
}
