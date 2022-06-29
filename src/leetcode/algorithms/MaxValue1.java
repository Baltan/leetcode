package leetcode.algorithms;

/**
 * Description: 1802. Maximum Value at a Given Index in a Bounded Array
 *
 * @author Baltan
 * @date 2022/6/28 16:08
 */
public class MaxValue1 {
    public static void main(String[] args) {
        System.out.println(maxValue(2, 1, 865959216));
        System.out.println(maxValue(1, 0, 24));
        System.out.println(maxValue(4, 2, 6));
        System.out.println(maxValue(6, 1, 10));
        System.out.println(maxValue(500000000, 300000000, 1000000000));
    }

    public static int maxValue(int n, int index, int maxSum) {
        int result = 1;
        /**
         * 每次操作中index位置左边部分元素增加的值
         */
        int leftAdd = 0;
        /**
         * 每次操作中index位置右边部分元素增加的值
         */
        int rightAdd = 0;
        /**
         * 每次操作中index位置左边部分元素可以增加的最大值，例如：n=9，index=3，每次操作左边最多增加3
         */
        int leftMost = index;
        /**
         * 每次操作中index位置右边部分元素可以增加的最大值，例如：n=9，index=3，每次操作右边最多增加5
         */
        int rightMost = n - 1 - index;
        /**
         * 每次操作可以增加的最大值
         */
        int addMost = leftMost + rightMost + 1;
        /**
         * 先把每个索引上的值都初始化为1，保证每个索引上的值都为正数，剩下可以加的总和
         */
        maxSum -= n;
        /**
         * 每次操作把index位置的值加1，同时为了保证相邻索引上的值之差的绝对值∈[0,1]，需要把index左边和右边一些索引上的值也加1，
         * 例如：n=9，index=3
         * 初始时
         * 1  1  1  1  1  1  1  1  1
         * 第一轮操作后
         * 1  1  1  2  1  1  1  1  1
         * 第二轮操作后
         * 1  1  2  3  2  1  1  1  1
         * 第三轮操作后
         * 1  2  3  4  3  2  1  1  1
         * ……
         */
        while (true) {
            /**
             * 本次操作index位置左边部分元素增加的总和
             */
            leftAdd = Math.min(leftAdd, leftMost);
            /**
             * 本次操作index位置右边部分元素增加的总和
             */
            rightAdd = Math.min(rightAdd, rightMost);
            /**
             * 本次操作所有位置元素增加的总和
             */
            int totalAdd = leftAdd + rightAdd + 1;

            if (totalAdd <= maxSum) {
                if (totalAdd == addMost) {
                    /**
                     * 以后的每次操作所有位置元素增加的总和都为addMost，可以这样操作的次数
                     */
                    int levels = maxSum / addMost;
                    result += levels;
                    maxSum -= addMost * levels;
                    leftAdd += levels;
                    rightAdd += levels;
                } else {
                    /**
                     * 从index位置开始向左右两边将值加1
                     */
                    result++;
                    maxSum -= (1 + leftAdd + rightAdd);
                    leftAdd++;
                    rightAdd++;
                }
            } else {
                break;
            }
        }
        return result;
    }
}
