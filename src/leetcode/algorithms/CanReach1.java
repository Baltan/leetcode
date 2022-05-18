package leetcode.algorithms;

/**
 * Description: 1871. Jump Game VII
 *
 * @author Baltan
 * @date 2022/5/15 14:32
 */
public class CanReach1 {
    public static void main(String[] args) {
        System.out.println(canReach("0000000000", 8, 8));
        System.out.println(canReach("00111010", 3, 5));
        System.out.println(canReach("011010", 2, 3));
        System.out.println(canReach("01101110", 2, 3));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/jump-game-vii/solution/hua-chuang-si-xiang-dp-bu-xu-yao-qian-zh-j865/"></a>
     *
     * @param s
     * @param minJump
     * @param maxJump
     * @return
     */
    public static boolean canReach(String s, int minJump, int maxJump) {
        int length = s.length();
        /**
         * dp[i]表示s[i]是否可达
         */
        boolean[] dp = new boolean[length];
        char[] charArray = s.toCharArray();
        /**
         * 初始时在s[0]，标记s[0]可达
         */
        dp[0] = true;
        /**
         * 如果s[i]可达，则[j-maxJump,j-minJump]中存在一个可达的坐标。定义一个长度为maxJump−minJump+1的窗口，count记录窗
         * 口里可达的坐标数量，初始时s[0]是可达的，将窗口里可达的坐标数量记为1
         */
        int count = 1;
        /**
         * 第一步至少到坐标minJump，所以[1,minJump-1]都是不可达的，直接跳过判断
         */
        for (int i = minJump; i < length; i++) {
            /**
             * 判断当前坐标是否可达
             */
            if (charArray[i] == '0' && count > 0) {
                dp[i] = true;
            }
            /**
             * 如果窗口右移一位前最左边的坐标可达，右移一位后窗口里可达的坐标数量需要将这一个坐标减去
             */
            if (i >= maxJump && dp[i - maxJump]) {
                count--;
            }
            /**
             * 如果窗口右移一位后最右边的坐标可达，右移一位后窗口里可达的坐标数量需要将这一个坐标加上
             */
            if (dp[i - minJump + 1]) {
                count++;
            }
        }
        return dp[length - 1];
    }
}
