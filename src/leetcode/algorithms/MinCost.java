package leetcode.algorithms;

/**
 * Description: 1578. Minimum Deletion Cost to Avoid Repeating Letters
 *
 * @author Baltan
 * @date 2020-09-15 22:37
 */
public class MinCost {
    public static void main(String[] args) {
        System.out.println(minCost("abaac", new int[]{1, 2, 3, 4, 5}));
        System.out.println(minCost("abc", new int[]{1, 2, 3}));
        System.out.println(minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/solution/bian-li-yi-ci-chao-ji-jian-dan-de-fang-fa-by-50425/"></a>
     *
     * @param s
     * @param cost
     * @return
     */
    public static int minCost(String s, int[] cost) {
        int result = 0;
        char[] charArray = s.toCharArray();
        int length = charArray.length;

        for (int i = 1; i < length; i++) {
            if (charArray[i - 1] == charArray[i]) {
                /**
                 * 当出现相邻的两个字母相同时，总是删除成本较小的那个
                 */
                result += Math.min(cost[i - 1], cost[i]);
                /**
                 * 剩下成本较大的字母可能还需要和后面的字母比较，将charArray[i]和charArray[i-1]较大成本看
                 * 做是下一次比较中charArray[i]的成本
                 */
                cost[i] = Math.max(cost[i - 1], cost[i]);
            }
        }
        return result;
    }
}
