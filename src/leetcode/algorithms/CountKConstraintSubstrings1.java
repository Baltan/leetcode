package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3261. Count Substrings That Satisfy K-Constraint II
 *
 * @author baltan
 * @date 2024/8/21 14:06
 * @see CountKConstraintSubstrings
 */
public class CountKConstraintSubstrings1 {
    public static void main(String[] args) {
        int[][] queries1 = {{0, 6}};
        OutputUtils.print1DLongArray(countKConstraintSubstrings("0001111", 2, queries1));

        int[][] queries2 = {{0, 5}, {1, 4}, {2, 3}};
        OutputUtils.print1DLongArray(countKConstraintSubstrings("010101", 1, queries2));
    }

    public static long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        long[] result = new long[queries.length];
        int length = s.length();
        /**
         * zeroPrefixesCounts[i]表示子串s.substring(0,i)中0的个数
         */
        int[] zeroPrefixesCounts = new int[length + 1];
        /**
         * onePrefixesCounts[i]表示子串s.substring(0,i)中1的个数
         */
        int[] onePrefixesCounts = new int[length + 1];
        /**
         * maxIndexes[i]表示以字符s[i]开头且满足k约束的最长子串中最后一个字符的索引值
         */
        int[] maxIndexes = new int[length];
        /**
         * prefixSums[i]表示以s[0]、s[1]、……、s[i-1]开头且满足k约束的所有子串的总数
         */
        long[] prefixSums = new long[length + 1];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeroPrefixesCounts[i + 1] = zeroPrefixesCounts[i] + 1;
                onePrefixesCounts[i + 1] = onePrefixesCounts[i];
            } else {
                onePrefixesCounts[i + 1] = onePrefixesCounts[i] + 1;
                zeroPrefixesCounts[i + 1] = zeroPrefixesCounts[i];
            }
        }

        for (int i = 0; i < length; i++) {
            int lo = i;
            int hi = length - 1;
            /**
             * 如果子串s.substring(i,j)不满足k约束，则子串s.substring(i,j+1)一定也不满足k约束；反之，如果子串s.substring(i,j)满足k
             * 约束，则子串s.substring(i,j-1)一定也满足k约束。通过二分计算以字符s[i]开头且满足k约束的最长子串中最后一个字符的索引值
             */
            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;
                /**
                 * 子串s.substring(i,mid+1)中0的个数
                 */
                int zeroCount = zeroPrefixesCounts[mid + 1] - zeroPrefixesCounts[i];
                /**
                 * 子串s.substring(i,mid+1)中1的个数
                 */
                int oneCount = onePrefixesCounts[mid + 1] - onePrefixesCounts[i];

                if (zeroCount <= k || oneCount <= k) {
                    /**
                     * 因为子串s.substring(i,mid+1)满足k约束，所以子串s.substring(i,i+1)、……、s.substring(i,mid)也全都满足k约束
                     */
                    lo = mid;
                } else {
                    /**
                     * 因为子串s.substring(i,mid+1)不满足k约束，所以子串s.substring(i,mid+2)、……、s.substring(i,length)也全都
                     * 不满足k约束
                     */
                    hi = mid - 1;
                }
            }
            maxIndexes[i] = lo;
        }
        /**
         * 以字符s[i]开头且满足k约束的子串的个数为maxIndexes[i]-i+1，计算前缀和数组prefixSums
         */
        for (int i = 0; i < length; i++) {
            prefixSums[i + 1] = prefixSums[i] + (maxIndexes[i] - i + 1);
        }

        for (int i = 0; i < queries.length; i++) {
            int lo = queries[i][0];
            int hi = queries[i][1];

            if (maxIndexes[lo] >= hi) {
                /**
                 * 因为子串s.substring(lo,maxIndexes[lo]+1)满足k约束，且长度大于子串s.substring(lo,hi+1)，所以子串
                 * s.substring(lo,hi+1)也满足k约束，同理，子串s.substring(lo+1,hi+1)、s.substring(lo+2,hi+1)、……、
                 * s.substring(hi,hi+1)也都满足k约束，即子串s.substring(lo,hi+1)中的所有子串都满足k约束，子串的总数为：
                 * (hi-lo+1)+(hi-lo)+……+1
                 * =(hi-lo+2)*(hi-lo+1)/2
                 */
                result[i] = (long) (hi - lo + 2) * (hi - lo + 1) / 2;
            } else if (maxIndexes[hi] <= hi) {
                /**
                 * 因为以字符s[hi]开头且满足k约束的所有子串都是子串s.substring(lo,hi+1)的子串，所以以字符s[hi-1]、s[hi-2]、……、
                 * s[lo]开头且满足k约束的所有子串也都是子串s.substring(lo,hi+1)的子串，直接计算字符串s中以s[hi]、s[hi-1]、……、s[lo]
                 * 开头且满足k约束的子串的总数即可
                 */
                result[i] = prefixSums[hi + 1] - prefixSums[lo];
            } else {
                /**
                 * 假设以字符s[x]开头且满足k约束的所有子串都在子串s.substring(lo,hi+1)中，二分计算x的最大值
                 */
                while (lo < hi) {
                    int mid = (lo + hi + 1) / 2;

                    if (maxIndexes[mid] > queries[i][1]) {
                        hi = mid - 1;
                    } else {
                        lo = mid;
                    }
                }
                /**
                 * 字符串s中，以字符s[queries[i][0]]、s[queries[i][0]+1]、……、s[lo]开头且满足k约束的所有子串也都是子串
                 * s.substring(queries[i][0],queries[i][1]+1)的子串，因此，这些子串的总数为prefixSums[lo+1]-
                 * prefixSums[queries[i][0]]。以字符s[lo+1]、s[lo+2]、……、s[queries[i][1]]开头，结尾不超过s[queries[i][1]]的
                 * 所有子串都满足k约束，这部分子串的总数为：
                 * (queries[i][1]-(lo+1)+1)+(queries[i][1]-(lo+2)+1)+……+1
                 * =(queries[i][1]-lo)+(queries[i][1]-lo-1)+……+1
                 * =(queries[i][1]-lo+1)*(queries[i][1]-lo)/2
                 */
                result[i] = prefixSums[lo + 1] - prefixSums[queries[i][0]] + (long) (queries[i][1] - lo + 1) * (queries[i][1] - lo) / 2;
            }
        }
        return result;
    }
}
