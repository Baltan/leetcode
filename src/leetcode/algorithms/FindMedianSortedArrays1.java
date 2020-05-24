package leetcode.algorithms;

/**
 * Description: 4. Median of Two Sorted Arrays
 *
 * @author Baltan
 * @date 2020-05-24 11:56
 * @see FindMedianSortedArrays
 */
public class FindMedianSortedArrays1 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4}));
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{2, 3}));
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(
                findMedianSortedArrays(new int[]{1, 3, 4, 9}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/"></a>
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 如果nums1为空数组，返回nums2的中位数
         */
        if (nums1.length == 0) {
            return nums2.length % 2 == 0 ? (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0 :
                    nums2[nums2.length / 2] / 1.0;
        }
        /**
         * 如果nums2为空数组，返回nums1的中位数
         */
        if (nums2.length == 0) {
            return nums1.length % 2 == 0 ? (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0 :
                    nums1[nums1.length / 2] / 1.0;
        }

        int length1 = nums1.length;
        int length2 = nums2.length;
        /**
         * 合并后数组的总长度
         */
        int mergeLength = length1 + length2;
        /**
         * 小于中位数的数字的个数，我们需要将这些数字删除，接下来最小的一个数字或两个数字就是中位数。例如：如果
         * mergeLength为3，则小于中位数的数字有1个；如果mergeLength为4，则小于中位数的个数还是1个。
         */
        int totalDeleteCount = (mergeLength - 1) / 2;
        int index1 = 0;
        int index2 = 0;

        while (totalDeleteCount > 0) {
            /**
             * 如果nums1中的数字都已经被删除，则从nums2中删除剩下的totalDeleteCount个最小的数字即可得到中位数
             */
            if (index1 == length1) {
                index2 += totalDeleteCount;
                return (mergeLength & 1) == 1 ? nums2[index2] : (nums2[index2] + nums2[index2 + 1]) / 2.0;
            }
            /**
             * 如果nums2中的数字都已经被删除，则从nums1中删除剩下的totalDeleteCount个最小的数字即可得到中位数
             */
            if (index2 == length2) {
                index1 += totalDeleteCount;
                return (mergeLength & 1) == 1 ? nums1[index1] : (nums1[index1] + nums1[index1 + 1]) / 2.0;
            }
            /**
             * 如果只需删除1个数字，则从nums1和nums2中删除较小的一个数字即可
             */
            if (totalDeleteCount == 1) {
                if (nums1[index1] < nums2[index2]) {
                    index1++;
                    totalDeleteCount--;
                } else {
                    index2++;
                    totalDeleteCount--;
                }
            } else {
                /**
                 * 尝试从nums1和nums2中各删除totalDeleteCount/2个数字，比较剩下两个数组中最小的数字，较小
                 * 的那个数组刚刚被删除的数字中一定不包含中位数
                 */
                int deleteCount = totalDeleteCount / 2;
                /**
                 * 如果此时nums1中剩余的数字不足deleteCount个，比较nums1[length1-1]和
                 * nums2[index2+deleteCount]
                 */
                if (index1 + deleteCount >= length1) {
                    if (nums1[length1 - 1] <= nums2[index2 + deleteCount]) {
                        totalDeleteCount -= (length1 - index1);
                        index1 = length1;
                    } else {
                        totalDeleteCount -= deleteCount;
                        index2 += deleteCount;
                    }
                    /**
                     * 如果此时nums2中剩余的数字不足deleteCount个，比较nums2[length2-1]和
                     * nums1[index1+deleteCount]
                     */
                } else if (index2 + deleteCount >= length2) {
                    if (nums2[length2 - 1] <= nums1[index1 + deleteCount]) {
                        totalDeleteCount -= (length2 - index2);
                        index2 = length2;
                    } else {
                        totalDeleteCount -= deleteCount;
                        index1 += deleteCount;
                    }
                } else {
                    /**
                     * 比较nums1[index1+deleteCount]和nums2[index2+deleteCount]
                     */
                    if (nums1[index1 + deleteCount] <= nums2[index2 + deleteCount]) {
                        totalDeleteCount -= deleteCount;
                        index1 += deleteCount;
                    } else {
                        totalDeleteCount -= deleteCount;
                        index2 += deleteCount;
                    }
                }
            }
        }
        /**
         * 如果mergeLength为奇数则中位数只有1个，否则中位数为中间两个数的平均数
         */
        if ((mergeLength & 1) == 1) {
            if (index1 >= length1) {
                return nums2[index2];
            } else if (index2 >= length2) {
                return nums1[index1];
            } else {
                return Math.min(nums1[index1], nums2[index2]);
            }
        } else {
            int mediumSum = Integer.MAX_VALUE;

            if (index1 < length1 && index2 < length2) {
                mediumSum = Math.min(mediumSum, nums1[index1] + nums2[index2]);
            }

            if (index1 < length1 - 1) {
                mediumSum = Math.min(mediumSum, nums1[index1] + nums1[index1 + 1]);
            }

            if (index2 < length2 - 1) {
                mediumSum = Math.min(mediumSum, nums2[index2] + nums2[index2 + 1]);
            }
            return mediumSum / 2.0;
        }
    }
}
