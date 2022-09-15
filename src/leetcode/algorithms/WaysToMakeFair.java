package leetcode.algorithms;

/**
 * Description: 1664. Ways to Make a Fair Array
 *
 * @author Baltan
 * @date 2022/9/8 09:59
 */
public class WaysToMakeFair {
    public static void main(String[] args) {
        System.out.println(waysToMakeFair(new int[]{2, 1, 6, 4}));
        System.out.println(waysToMakeFair(new int[]{1, 1, 1}));
        System.out.println(waysToMakeFair(new int[]{1, 2, 3}));
    }

    public static int waysToMakeFair(int[] nums) {
        int result = 0;
        int length = nums.length;
        boolean lengthIsEven = length % 2 == 0;
        /**
         * prefixSums[2k+2]=nums[0]+nums[2]+……+nums[2k]
         * prefixSums[2k+1]=nums[1]+nums[3]+……+nums[2k-1]
         */
        int[] prefixSums = new int[length + 2];
        /**
         * 计算nums的奇偶位置上的前缀和
         */
        for (int i = 0; i < length; i++) {
            prefixSums[i + 2] = prefixSums[i] + nums[i];
        }

        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                /**
                 * nums[i]前面偶数索引位置元素的和：nums[0]+nums[2]+……+nums[i-2]
                 */
                int prevEvenSum = prefixSums[i];
                /**
                 * nums[i]前面奇数索引位置元素的和：nums[1]+nums[3]+……+nums[i-1]
                 */
                int prevOddSum = prefixSums[i + 1];
                /**
                 * 删除nums[i]后，后面偶数索引位置元素的和：nums[i+1]+nums[i+3]+……+nums[length-2]或nums[length-1]
                 */
                int nextEvenSum =
                        (lengthIsEven ? prefixSums[length + 1] : prefixSums[length]) - prefixSums[i + 1];
                /**
                 * 删除nums[i]后，后面奇数索引位置元素的和：nums[i+2]+nums[i+4]+……+nums[length-2]或nums[length-1]
                 */
                int nextOddSum =
                        (lengthIsEven ? prefixSums[length] : prefixSums[length + 1]) - prefixSums[i + 2];

                if (prevEvenSum + nextEvenSum == prevOddSum + nextOddSum) {
                    result++;
                }
            } else {
                /**
                 * nums[i]前面偶数索引位置元素的和：nums[0]+nums[2]+……+nums[i-1]
                 */
                int prevEvenSum = prefixSums[i + 1];
                /**
                 * nums[i]前面奇数索引位置元素的和：nums[1]+nums[3]+……+nums[i-2]
                 */
                int prevOddSum = prefixSums[i];
                /**
                 * 删除nums[i]后，后面偶数索引位置元素的和：nums[i+2]+nums[i+4]+……+nums[length-2]或nums[length-1]
                 */
                int nextEvenSum =
                        (lengthIsEven ? prefixSums[length + 1] : prefixSums[length]) - prefixSums[i + 2];
                /**
                 * 删除nums[i]后，后面奇数索引位置元素的和：nums[i+1]+nums[i+3]+……+nums[length-2]或nums[length-1]
                 */
                int nextOddSum =
                        (lengthIsEven ? prefixSums[length] : prefixSums[length + 1]) - prefixSums[i + 1];

                if (prevEvenSum + nextEvenSum == prevOddSum + nextOddSum) {
                    result++;
                }
            }
        }
        return result;
    }
}
