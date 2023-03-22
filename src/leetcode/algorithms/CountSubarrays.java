package leetcode.algorithms;

/**
 * Description: 2444. Count Subarrays With Fixed Bounds
 *
 * @author Baltan
 * @date 2023/3/17 11:47
 */
public class CountSubarrays {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 1, 3, 5, 7, 7, 7, 2, 1, 8, 3, 1, 4}, 1, 7));
        System.out.println(countSubarrays(new int[]{1, 3, 5, 2, 7, 5, 5, 3, 2, 5, 8, 2, 1, 5, 7, 9, 3, 1, 4, 7, 9, 3, 2, 1, 4, 5, 8, 9, 9, 3, 1, 1, 3, 5, 7, 7, 7, 2, 1, 8, 3, 1, 4, 6, 8, 9, 3, 2, 1, 5, 7, 9, 9, 4, 2, 1, 5, 7, 8}, 1, 7));
        System.out.println(countSubarrays(new int[]{1, 3, 5, 2, 7, 5, 5, 3, 2, 5, 8, 2, 1, 5, 7, 9, 3, 1, 4, 7, 9, 3, 2, 1, 4, 5, 8, 9, 9, 3, 1, 1, 3, 5, 7, 7, 7, 2, 1, 8, 3, 1, 4, 6, 8, 9, 3, 2, 1, 5, 7, 9, 9, 4, 2, 1, 5, 7, 8}, 1, 5));
        System.out.println(countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5));
        System.out.println(countSubarrays(new int[]{1, 1, 1, 1}, 1, 1));
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;
        int length = nums.length;

        if (minK == maxK) {
            /**
             * 设minK=maxK=x，count表示遍历过程中连续的x的个数
             */
            int count = 0;

            for (int i = 0; i < length; i++) {
                if (nums[i] == minK) {
                    count++;
                    /**
                     * 有count个以nums[i]结尾的子数组是定界子数组
                     */
                    result += count;
                } else {
                    count = 0;
                }
            }
        } else {
            /**
             * 当前定界子数组中索引Math.min(minIndex,maxIndex)之前连续的元素的个数，且这些元素∈[minK,maxK]
             */
            int count = 0;
            /**
             * 遍历过程中当前元素之前最后一次出现minK的索引，初始化为Integer.MAX_VALUE表示不存在minK
             */
            int minIndex = Integer.MAX_VALUE;
            /**
             * 遍历过程中当前元素之前最后一次出现maxK的索引，初始化为Integer.MAX_VALUE表示不存在maxK
             */
            int maxIndex = Integer.MAX_VALUE;

            for (int i = 0; i < length; i++) {
                if (nums[i] < minK || nums[i] > maxK) {
                    /**
                     * 当前元素不可能在某个定界子数组中，重新开始计算
                     */
                    count = 0;
                    minIndex = Integer.MAX_VALUE;
                    maxIndex = Integer.MAX_VALUE;
                } else if (nums[i] == minK) {
                    if (minIndex == Integer.MAX_VALUE) {
                        if (maxIndex != Integer.MAX_VALUE) {
                            /**
                             * 可以以nums[i]结尾生成count+1个定界子数组
                             * 例如：nums=[2,7,3,5,1]，minK=1，maxK=7，此时i=4，count=1，minIndex=Integer.MAX_VALUE，
                             * maxIndex=4，可以生成2个定界子数组[2,7,3,5,1]和[7,3,5,1]
                             */
                            result += (count + 1);
                        }
                    } else {
                        if (maxIndex != Integer.MAX_VALUE) {
                            if (maxIndex < minIndex) {
                                /**
                                 * 可以以nums[i]结尾生成count+1个定界子数组
                                 * 例如：nums=[2,7,3,5,1,1]，minK=1，maxK=7，此时i=5，count=1，minIndex=4，maxIndex=1，可以生
                                 * 成2个定界子数组[2,7,3,5,1,1]和[7,3,5,1,1]
                                 */
                                result += (count + 1);
                            } else {
                                /**
                                 * 可以以nums[i]结尾生成count+1个定界子数组
                                 * 例如：nums=[2,1,3,5,7,1]，minK=1，maxK=7，此时i=5，count=1，minIndex=1，maxIndex=4，可以生
                                 * 成5个定界子数组[2,1,3,5,7,1]、[1,3,5,7,1]、[3,5,7,1]、[5,7,1]、[7,1]
                                 */
                                count += maxIndex - minIndex;
                                result += (count + 1);
                            }
                        } else {
                            /**
                             * 不能生成定界子数组，但是可以将索引∈[minIndex,i)这部分元素都累计到count中
                             * 例如：nums=[2,5,1,3,1,7]，minK=1，maxK=7，此时i=4，count=2，minIndex=2，
                             * maxIndex=Integer.MAX_VALUE，可以将[1,3]这两个数累计到count中
                             */
                            count += (i - minIndex);
                        }
                    }
                    /**
                     * 更新最后一次出现minK的索引
                     */
                    minIndex = i;
                } else if (nums[i] == maxK) {
                    if (maxIndex == Integer.MAX_VALUE) {
                        if (minIndex != Integer.MAX_VALUE) {
                            /**
                             * 可以以nums[i]结尾生成count+1个定界子数组
                             * 例如：nums=[2,1,3,5,7]，minK=1，maxK=7，此时i=4，count=1，minIndex=1，
                             * maxIndex=Integer.MAX_VALUE，可以生成2个定界子数组[2,1,3,5,7]和[1,3,5,7]
                             */
                            result += (count + 1);
                        }
                    } else {
                        if (minIndex != Integer.MAX_VALUE) {
                            if (minIndex < maxIndex) {
                                /**
                                 * 可以以nums[i]结尾生成count+1个定界子数组
                                 * 例如：nums=[2,1,3,5,7,7]，minK=1，maxK=7，此时i=5，count=1，minIndex=1，maxIndex=4，可以生
                                 * 成2个定界子数组[2,1,3,5,7,7]和[1,3,5,7,7]
                                 */
                                result += (count + 1);
                            } else {
                                /**
                                 * 可以以nums[i]结尾生成count+1个定界子数组
                                 * 例如：nums=[2,7,3,5,1,7]，minK=1，maxK=7，此时i=5，count=1，minIndex=4，maxIndex=1，可以生
                                 * 成5个定界子数组[2,7,3,5,1,7]、[7,3,5,1,7]、[3,5,1,7]、[5,1,7]、[1,7]
                                 */
                                count += minIndex - maxIndex;
                                result += (count + 1);
                            }
                        } else {
                            /**
                             * 不能生成定界子数组，但是可以将索引∈[minIndex,i)这部分元素都累计到count中
                             * 例如：nums=[2,5,7,3,7,1]，minK=1，maxK=7，此时i=4，count=2，maxIndex=2，
                             * minIndex=Integer.MAX_VALUE，可以将[7,3]这两个数累计到count中
                             */
                            count += (i - maxIndex);
                        }
                    }
                    /**
                     * 更新最后一次出现maxK的索引
                     */
                    maxIndex = i;
                } else {
                    if (minIndex != Integer.MAX_VALUE && maxIndex != Integer.MAX_VALUE) {
                        /**
                         * 可以以nums[i]结尾生成count+1个定界子数组
                         * 例如：nums=[2,1,3,5,7,4]，minK=1，maxK=7，此时i=5，count=1，minIndex=1，maxIndex=4，可以生成2个定界
                         * 子数组[2,1,3,5,7,4]和[1,3,5,7,4]
                         */
                        result += (count + 1);
                    } else if (minIndex == Integer.MAX_VALUE && maxIndex == Integer.MAX_VALUE) {
                        /**
                         * 不能生成定界子数组，但是可以将当前元素都累计到count中
                         * 例如：nums=[2,5,7,3,1]，minK=1，maxK=7，此时i=1，count=1，maxIndex=Integer.MAX_VALUE，
                         * minIndex=Integer.MAX_VALUE，可以将5这个数累计到count中
                         */
                        count++;
                    }
                }
            }
        }
        return result;
    }
}
