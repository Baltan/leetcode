package leetcode.algorithms;

/**
 * Description: 1262. Greatest Sum Divisible by Three
 *
 * @author Baltan
 * @date 2019-11-21 09:00
 */
public class MaxSumDivThree1 {
    public static void main(String[] args) {
        System.out.println(maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
        System.out.println(maxSumDivThree(new int[]{4}));
        System.out.println(maxSumDivThree(new int[]{1, 2, 3, 4, 4}));
    }

    public static int maxSumDivThree(int[] nums) {
        /**
         * 数组中所有数字的和
         */
        int sum = 0;
        /**
         * 保存数组中最小的除以3余数为1的数
         */
        int a = Integer.MAX_VALUE;
        /**
         * 保存数组中次小的除以3余数为1的数
         */
        int b = Integer.MAX_VALUE;
        /**
         * 保存数组中最小的除以3余数为2的数
         */
        int c = Integer.MAX_VALUE;
        /**
         * 保存数组中次小的除以3余数为2的数
         */
        int d = Integer.MAX_VALUE;

        for (int num : nums) {
            sum += num;

            if (num % 3 == 1) {
                if (num <= a) {
                    b = a;
                    a = num;
                } else if (num < b) {
                    b = num;
                }
            } else if (num % 3 == 2) {
                if (num <= c) {
                    d = c;
                    c = num;
                } else if (num < d) {
                    d = num;
                }
            }
        }

        /**
         * 数组中所有数字的和除以3的余数
         */
        int remainder = sum % 3;

        if (remainder == 1) {
            int minDeletion = Integer.MAX_VALUE;
            /**
             * 如果数组中所有数字的和除以3的余数为1，则需要删除的数字之和除以3的余数也为1，为了保证删除的数字之和
             * 尽可能小，可能有两种操作：选择a或者选择c+d
             */
            if (a != Integer.MAX_VALUE) {
                minDeletion = Math.min(minDeletion, a);
            }

            if (c != Integer.MAX_VALUE && d != Integer.MAX_VALUE) {
                minDeletion = Math.min(minDeletion, c + d);
            }
            return sum - minDeletion;
        } else if (remainder == 2) {
            int minDeletion = Integer.MAX_VALUE;
            /**
             * 如果数组中所有数字的和除以3的余数为2，则需要删除的数字之和除以3的余数也为2，为了保证删除的数字之和
             * 尽可能小，可能有两种操作：选择c或者选择a+b
             */
            if (c != Integer.MAX_VALUE) {
                minDeletion = Math.min(minDeletion, c);
            }

            if (a != Integer.MAX_VALUE && b != Integer.MAX_VALUE) {
                minDeletion = Math.min(minDeletion, a + b);
            }
            return sum - minDeletion;
        } else {
            return sum;
        }
    }
}
