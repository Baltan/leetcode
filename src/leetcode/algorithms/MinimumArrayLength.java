package leetcode.algorithms;

/**
 * Description: 3012. Minimize Length of Array Using Operations
 *
 * @author Baltan
 * @date 2024/1/21 22:55
 */
public class MinimumArrayLength {
    public static void main(String[] args) {
        System.out.println(minimumArrayLength(new int[]{5, 2, 2, 2, 9, 10}));
        System.out.println(minimumArrayLength(new int[]{1, 4, 3, 1}));
        System.out.println(minimumArrayLength(new int[]{5, 5, 5, 10, 5}));
        System.out.println(minimumArrayLength(new int[]{2, 3, 4}));
    }

    public static int minimumArrayLength(int[] nums) {
        /**
         * 数组中最小元素的个数
         */
        int minCount = 0;
        /**
         * 数组中所有元素的最大公约数
         */
        int gcd = nums[0];

        for (int i = 1; i < nums.length; i++) {
            gcd = gcd(gcd, nums[i]);

            if (gcd == 1) {
                break;
            }
        }

        for (int num : nums) {
            if (num == gcd) {
                minCount++;
            }
        }
        /**
         * 如果数组nums中所有元素的最大公约数为1，则总可以通过得到的1去除以其他更大的数字，使得更大的数字被删除，1在数组中得以保留。最后数组
         * 中剩下的所有1两两组合进行操作，剩余minCount/2个0和minCount%2个1，一共(minCount+1)/2个数字。如果数组nums中所有元素的最大公
         * 约数不为1，则可以将所有元素除以最大公约数后，再进行第一种情况的处理
         */
        return minCount == 0 ? 1 : (minCount + 1) / 2;
    }

    /**
     * 求x和y的最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    public static int gcd(int x, int y) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);

        while (max % min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        return min;
    }
}
