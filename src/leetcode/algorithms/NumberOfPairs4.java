package leetcode.algorithms;

/**
 * Description: 3164. Find the Number of Good Pairs II
 *
 * @author Baltan
 * @date 2024/5/30 22:28
 * @see NumberOfPairs3
 */
public class NumberOfPairs4 {
    public static void main(String[] args) {
        System.out.println(numberOfPairs(new int[]{2, 18, 2, 14}, new int[]{3, 4, 1, 11}, 2));
        System.out.println(numberOfPairs(new int[]{1, 3, 4}, new int[]{1, 3, 4}, 1));
        System.out.println(numberOfPairs(new int[]{1, 2, 4, 12}, new int[]{2, 4}, 3));
    }

    public static long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long result = 0L;
        /**
         * counts[i]表示数组nums2中元素i的个数，根据题意，i∈[1,1000000]
         */
        int[] counts = new int[1000001];

        for (int num : nums2) {
            counts[num]++;
        }

        for (int num : nums1) {
            /**
             * 因为nums1[i]%(nums2[j]*k)==0，所以nums1[i]%k==0并且(nums1[i]/k)%nums2[j]==0，即首先满足num%k==0
             */
            if (num % k == 0) {
                /**
                 * 其次满足(num/k)%nums2[j]==0，即quotient%nums2[j]==0，枚举quotient的所有因数，判断它们各自在数组nums2中出现几次
                 */
                int quotient = num / k;

                for (int i = 1; i * i <= quotient; i++) {
                    if (quotient % i != 0) {
                        continue;
                    }

                    if (i * i != quotient) {
                        result += counts[i];
                        result += counts[quotient / i];
                    } else {
                        result += counts[i];
                    }
                }
            }
        }
        return result;
    }
}
