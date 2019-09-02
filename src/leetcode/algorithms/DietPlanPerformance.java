package leetcode.algorithms;

/**
 * Description: 1176. Diet Plan Performance
 *
 * @author Baltan
 * @date 2019-09-02 09:03
 */
public class DietPlanPerformance {
    public static void main(String[] args) {
        System.out.println(dietPlanPerformance(new int[]{1, 2, 3, 4, 5}, 1, 3, 3));
        System.out.println(dietPlanPerformance(new int[]{3, 2}, 2, 0, 1));
        System.out.println(dietPlanPerformance(new int[]{6, 5, 0, 0}, 2, 1, 5));
        System.out.println(dietPlanPerformance(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3, 6, 10));
        System.out.println(dietPlanPerformance(new int[]{1, 2}, 3, 1, 2));
        System.out.println(dietPlanPerformance(new int[]{1, 2, 3}, 3, 1, 2));
    }

    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int result = 0;
        int length = calories.length;
        int T = 0;
        /**
         * 如果健身计划总天数不足k天，直接返回0
         */
        if (length < k) {
            return 0;
        }
        /**
         * 计算开头k天的卡路里总消耗量
         */
        for (int i = 0; i < k; i++) {
            T += calories[i];
        }

        if (T > upper) {
            result++;
        } else if (T < lower) {
            result--;
        }
        /**
         * 遍历判断之后每个连续k天的卡路里总消耗量
         */
        for (int i = k; i < length; i++) {
            T -= calories[i - k];
            T += calories[i];

            if (T > upper) {
                result++;
            } else if (T < lower) {
                result--;
            }
        }
        return result;
    }
}
