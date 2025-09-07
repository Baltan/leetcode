package leetcode.algorithms;

/**
 * Description: 3638. Maximum Balanced Shipments
 *
 * @author baltan
 * @date 2025/9/4 17:03
 */
public class MaxBalancedShipments {
    public static void main(String[] args) {
        System.out.println(maxBalancedShipments(new int[]{2, 5, 1, 4, 3}));
        System.out.println(maxBalancedShipments(new int[]{4, 4}));
    }

    public static int maxBalancedShipments(int[] weight) {
        int result = 0;
        /**
         * 贪心思想，每次遇到右边包裹重量大于左边包裹重量的情况，就将它们打包成一个平衡装运
         */
        for (int i = 1; i < weight.length; ) {
            if (weight[i - 1] > weight[i]) {
                result++;
                i += 2;
            } else {
                i++;
            }
        }
        return result;
    }
}
