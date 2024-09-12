package leetcode.algorithms;

/**
 * Description: 330. Patching Array
 *
 * @author baltan
 * @date 2024/9/11 09:04
 */
public class MinPatches {
    public static void main(String[] args) {
        System.out.println(minPatches(new int[]{1, 2, 31, 33}, 2147483647));
        System.out.println(minPatches(new int[]{1, 12, 15}, 43));
        System.out.println(minPatches(new int[]{1, 3}, 6));
        System.out.println(minPatches(new int[]{1, 5, 10}, 20));
        System.out.println(minPatches(new int[]{1, 2, 2}, 5));
    }

    public static int minPatches(int[] nums, int n) {
        int result = 0;
        /**
         * 当前已有数字能得到的最大的和
         */
        long sum = 0L;
        /**
         * 当前需要通过已有数字实现的求和
         */
        long target = 1L;
        int index = 0;

        while (target <= n) {
            /**
             * 当target大于sum时，说明已有数字全部相加也得不到target，此时可以将数组nums中不大于target的数字全部利用起来。因为之前已有数
             * 字可以实现求和[1,sum]，数组nums中不大于target的数字都可以用来继续累加用于实现target求和，例如在已有数字的基础上，加入x后，
             * 就可以实现求和[1,sum+x]
             */
            if (target > sum) {
                while (index < nums.length && nums[index] <= target) {
                    sum += nums[index];
                    index++;
                }
                /**
                 * 数组nums中所有不大于target的数字相加后还是小于target，则只能由外部加入数字target，此时已有数字可以实现求和的范围扩大
                 * 为[1,sum+target]
                 */
                if (target > sum) {
                    sum += target;
                    result++;
                }
            }
            /**
             * [1,sum]范围内的所有数字都能通过已有数字求和得到，继续判断sum+1
             */
            target = sum + 1;
        }
        return result;
    }
}
