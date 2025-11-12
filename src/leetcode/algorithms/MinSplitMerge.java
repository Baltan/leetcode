package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3690. Split and Merge Array Transformation
 *
 * @author baltan
 * @date 2025/11/6 15:15
 */
public class MinSplitMerge {
    public static void main(String[] args) {
        System.out.println(minSplitMerge(new int[]{-17, -31}, new int[]{-31, -17}));
        System.out.println(minSplitMerge(new int[]{3, 1, 2}, new int[]{1, 2, 3}));
        System.out.println(minSplitMerge(new int[]{1, 1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1, 1}));
    }

    public static int minSplitMerge(int[] nums1, int[] nums2) {
        /**
         * 如果数组nums1和nums2相同，则不需要进行操作
         */
        if (Arrays.equals(nums1, nums2)) {
            return 0;
        }
        int result = 0;
        /**
         * 保存所有拆分合并操作之后得到的新数组
         */
        Queue<int[]> queue = new LinkedList<>();
        /**
         * 保存所有拆分合并操作之后的新数组对应的字符串
         */
        Set<String> isVisited = new HashSet<>();
        int length = nums1.length;
        queue.offer(nums1);
        isVisited.add(Arrays.toString(nums1));
        /**
         * 广度优先搜索遍历所有拆分合并操作后可能得到的新数组
         */
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            /**
             * 遍历第x次拆分合并操作后得到的所有新数组
             */
            for (int i = 0; i < size; i++) {
                int[] nums = queue.poll();
                /**
                 * 第2步移除的子数组为nums[j……k]，剩余的子数组为nums[0……j-1]和nums[k+1……length-1]
                 */
                for (int j = 0; j < length; j++) {
                    for (int k = j; k < length; k++) {
                        /**
                         * 先在子数组nums[0……j-1]的前l个元素之后追加子数组nums[j……k]，再追加子数组nums[0……j-1]的后j-l个元素，最后再
                         * 追加子数组nums[k+1……length-1]。
                         */
                        for (int l = 0; l <= j; l++) {
                            int[] newNums = new int[length];
                            System.arraycopy(nums, 0, newNums, 0, l);
                            System.arraycopy(nums, j, newNums, l, k - j + 1);
                            System.arraycopy(nums, l, newNums, k - j + l + 1, j - l);
                            System.arraycopy(nums, k + 1, newNums, k + 1, length - k - 1);
                            /**
                             * 得到的新数组newNums和数组nums2相同，已完成转换
                             */
                            if (Arrays.equals(newNums, nums2)) {
                                return result;
                            }
                            String s = Arrays.toString(newNums);

                            if (!isVisited.contains(s)) {
                                queue.offer(newNums);
                                isVisited.add(s);
                            }
                        }
                        /**
                         * 先在子数组nums[0……j-1]后追加子数组nums[k+1……length-1]的前l个元素，再追加子数组nums[j……k]，最后再追加子
                         * 数组nums[k+1……length-1]的后length-1-k-l个元素
                         */
                        for (int l = 0; l <= length - k - 1; l++) {
                            int[] newNums = new int[length];
                            System.arraycopy(nums, 0, newNums, 0, j);
                            System.arraycopy(nums, k + 1, newNums, j, l);
                            System.arraycopy(nums, j, newNums, j + l, k - j + 1);
                            System.arraycopy(nums, k + 1 + l, newNums, k + l + 1, length - (k + 1 + l));
                            /**
                             * 得到的新数组newNums和数组nums2相同，已完成转换
                             */
                            if (Arrays.equals(newNums, nums2)) {
                                return result;
                            }
                            String s = Arrays.toString(newNums);

                            if (!isVisited.contains(s)) {
                                queue.offer(newNums);
                                isVisited.add(s);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
