package leetcode.algorithms;

/**
 * Description: 2654. Minimum Number of Operations to Make All Array Elements Equal to 1
 *
 * @author Baltan
 * @date 2023/4/23 13:42
 */
public class MinOperations13 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{6, 10, 15}));
        System.out.println(minOperations(new int[]{10, 5, 10, 30, 70, 4, 2, 6, 8, 4}));
        System.out.println(minOperations(new int[]{2, 6, 3, 4}));
        System.out.println(minOperations(new int[]{2, 10, 6, 14}));
        System.out.println(minOperations(new int[]{3, 6, 8}));
    }

    public static int minOperations(int[] nums) {
        int length = nums.length;
        /**
         * 数组nums中的所有元素的最大公约数
         */
        int allGcd = nums[0];
        /**
         * 数组nums中元素1的个数
         */
        int oneCount = nums[0] == 1 ? 1 : 0;
        int last = length - 2;
        int times = 1;
        /**
         * 计算数组nums中的所有元素的最大公约数
         */
        for (int i = 1; i < length; i++) {
            oneCount += nums[i] == 1 ? 1 : 0;
            allGcd = gcd(nums[i], allGcd);
        }
        /**
         * 如果数组nums中的所有元素的最大公约数不是1，则最终只能将所有元素都变成gcd，直接返回-1
         */
        if (allGcd != 1) {
            return -1;
        }
        /**
         * 如果数组nums中本来就有1，则用已有的1可以将其相邻的元素也变为1，只需将数组中所有不为1的元素通过操作变为1即可
         */
        if (oneCount > 0) {
            return length - oneCount;
        }
        /**
         * 将相邻的两个元素两两求最大公约数，直到得到1为止
         */
        while (true) {
            /**
             * 最后一个被替换的元素是nums[last]
             */
            for (int i = 0; i <= last; i++) {
                /**
                 * 将nums[i]替换为nums[i]和nums[i+1]的最大公约数
                 */
                nums[i] = gcd(nums[i], nums[i + 1]);
                /**
                 * 通过最少times次操作可以将数组nums中的某个元素变为1，再利用这个元素将剩余的length-1个元素也变为1即可
                 */
                if (nums[i] == 1) {
                    return times + length - 1;
                }
            }
            /**
             * 这轮循环没有将任何元素替换成1，继续循环计算
             */
            last--;
            times++;
        }
    }

    /**
     * 求x和y的最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    public static int gcd(int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);

        while (max % min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        return min;
    }
}
