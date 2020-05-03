package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1402. Reducing Dishes
 *
 * @author Baltan
 * @date 2020-05-03 11:19
 */
public class MaxSatisfaction {
    public static void main(String[] args) {
        System.out.println(maxSatisfaction(new int[]{-1, -8, 0, 5, -9}));
        System.out.println(maxSatisfaction(new int[]{4, 3, 2}));
        System.out.println(maxSatisfaction(new int[]{-1, -4, -5}));
        System.out.println(maxSatisfaction(new int[]{-2, 5, -1, 0, 3, -3}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/reducing-dishes/solution/zuo-cai-shun-xu-by-leetcode-solution/"></a>
     *
     * @param satisfaction
     * @return
     */
    public static int maxSatisfaction(int[] satisfaction) {
        int result = 0;
        /**
         * 当前已经选中的菜的满意度之和
         */
        int sum = 0;
        Arrays.sort(satisfaction);
        /**
         * 我们总是优先考虑满意度更大的菜，并且将满意度较大的菜放在后面完成
         */
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            /**
             * 如果要选择满意度satisfaction[i]的菜，将这道菜放在已选中的所有菜之前完成，则所有已选中的
             * 菜都需要向后移动一位完成，则总满意度可以增大sum，此时再加上satisfaction[i]，如果获得的
             * 新的总满意度大于不选择第i道菜的满意度，就要选择第i道菜。反之再选择其他菜只会使得总满意度
             * 更低，不再考虑其他菜。
             */
            if (satisfaction[i] + sum + result > result) {
                /**
                 * 更新总满意度
                 */
                result = satisfaction[i] + sum + result;
                /**
                 * 更新已选中的菜的满意度之和
                 */
                sum += satisfaction[i];
            } else {
                break;
            }
        }
        return result;
    }
}
