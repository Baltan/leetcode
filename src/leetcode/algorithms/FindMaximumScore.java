package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 3282. Reach End of Array With Max Score
 *
 * @author baltan
 * @date 2024/9/10 09:08
 */
public class FindMaximumScore {
    public static void main(String[] args) {
        System.out.println(findMaximumScore(Arrays.asList(1, 6, 1)));
        System.out.println(findMaximumScore(Arrays.asList(1, 3, 1, 5)));
        System.out.println(findMaximumScore(Arrays.asList(4, 3, 1, 3, 2)));
    }

    public static long findMaximumScore(List<Integer> nums) {
        long result = 0;
        /**
         * 上一步所在位置的索引值
         */
        int prevIndex = 0;
        /**
         * 对于索引x,y,z，如果直接从x跳到z，则得分为(z-x)*nums[x]；如果先从x跳到y，再从y跳到z，则得分为(y-x)*nums[x]+(z-y)*nums[y]，
         * 显然，当nums[y]>nums[x]时，后者可以得到更多的分数。所以只要每一步总是跳到最接近当前位置，并且数字大于当前位置的索引处，就能使得
         * 得分最大。最后一步总是跳到数组nums[nums.size()-1]处
         */
        for (int i = 1; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(prevIndex)) {
                result += (long) nums.get(prevIndex) * (i - prevIndex);
                prevIndex = i;
            }
        }
        /**
         * 之前的得分要再加上最后一步从nums[prevIndex]跳到nums[nums.size()-1]的得分
         */
        return result + (long) nums.get(prevIndex) * (nums.size() - 1 - prevIndex);
    }
}
