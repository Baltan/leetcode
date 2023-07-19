package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2551. Put Marbles in Bags
 *
 * @author Baltan
 * @date 2023/7/9 16:36
 */
public class PutMarbles {
    public static void main(String[] args) {
        System.out.println(putMarbles(new int[]{1, 3, 5, 1}, 2));
        System.out.println(putMarbles(new int[]{1, 3}, 2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/put-marbles-in-bags/solutions/2080578/wen-ti-zhuan-hua-pai-xu-tan-xin-by-endle-bx8t/"></a>
     *
     * @param weights
     * @param k
     * @return
     */
    public static long putMarbles(int[] weights, int k) {
        long result = 0L;
        int length = weights.length;
        /**
         * 根据题意，需要将数组weights分割成k个连续的子数组，将这k个子数组各自的首尾元素全部相加即为背包的价格。当weights[i]被计入价格时，
         * weights[i+1]必定也会被计入价格，所以将weights[0]+weights[1]、weights[1]+weights[2]、weights[2]+weights3]、……、
         * weights[i-2]+weights[i-1]这i-1种情况的价格之和依次对应保存到weights[0]、weights[1]、weights[2]、……、weights[i-2]中
         */
        for (int i = 0; i < length - 1; i++) {
            weights[i] += weights[i + 1];
        }
        Arrays.sort(weights, 0, length - 1);
        /**
         * 为了将数组weights分割成k个连续的子数组，除了首尾元素必须会被选中外，还需要选择k-1个分割点，对于排序后的元素weights[0]、
         * weights[1]、weights[2]、……、weights[i-2]，从中选择最大的k-1个元素可以得到所有分配方案中的最大分数，选择最小的k-1个元素可以
         * 得到所有分配方案中的最小分数，而首尾元素因为是所有方案中都必选的，可以抵消不计算
         */
        for (int i = 0; i < k - 1; i++) {
            result += (weights[length - 2 - i] - weights[i]);
        }
        return result;
    }
}
