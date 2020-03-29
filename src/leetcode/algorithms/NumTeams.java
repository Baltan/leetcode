package leetcode.algorithms;

/**
 * Description: 1395. Count Number of Teams
 *
 * @author Baltan
 * @date 2020-03-29 14:11
 */
public class NumTeams {
    public static void main(String[] args) {
        System.out.println(numTeams(new int[]{2, 5, 3, 4, 1}));
        System.out.println(numTeams(new int[]{2, 1, 3}));
        System.out.println(numTeams(new int[]{1, 2, 3, 4}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/count-number-of-teams/solution/c-on2jie-fa-by-tmoonli/"></a>
     *
     * @param rating
     * @return
     */
    public static int numTeams(int[] rating) {
        int result = 0;
        int length = rating.length;
        /**
         * 将rating[i]作为作战单位的中间数
         */
        for (int i = 1; i < length - 1; i++) {
            /**
             * rating[i]左边小于rating[i]的数的个数
             */
            int leftLessCount = 0;
            /**
             * rating[i]左边大于rating[i]的数的个数
             */
            int leftGreaterCount = 0;
            /**
             * rating[i]右边小于rating[i]的数的个数
             */
            int rightLessCount = 0;
            /**
             * rating[i]右边大于rating[i]的数的个数
             */
            int rightGreaterCount = 0;

            for (int j = 0; j <= i - 1; j++) {
                if (rating[j] < rating[i]) {
                    leftLessCount++;
                } else if (rating[j] > rating[i]) {
                    leftGreaterCount++;
                }
            }

            for (int j = i + 1; j < length; j++) {
                if (rating[j] < rating[i]) {
                    rightLessCount++;
                } else if (rating[j] > rating[i]) {
                    rightGreaterCount++;
                }
            }
            /**
             * 计算以rating[i]作为作战单位的中间数可以组件的作战单位的个数
             */
            result += (leftLessCount * rightGreaterCount + leftGreaterCount * rightLessCount);
        }
        return result;
    }
}
