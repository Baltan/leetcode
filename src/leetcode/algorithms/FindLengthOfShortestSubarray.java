package leetcode.algorithms;

/**
 * Description: 1574. Shortest Subarray to be Removed to Make Array Sorted
 *
 * @author Baltan
 * @date 2022/10/23 14:57
 */
public class FindLengthOfShortestSubarray {
    public static void main(String[] args) {
        System.out.println(findLengthOfShortestSubarray(new int[]{16, 10, 0, 3, 22, 1, 14, 7, 1, 12, 15}));
        System.out.println(findLengthOfShortestSubarray(new int[]{6, 3, 10, 11, 15, 20, 13, 3, 18, 12}));
        System.out.println(findLengthOfShortestSubarray(new int[]{2, 2, 2, 1, 1, 1}));
        System.out.println(findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 4, 2, 3, 5}));
        System.out.println(findLengthOfShortestSubarray(new int[]{5, 4, 3, 2, 1}));
        System.out.println(findLengthOfShortestSubarray(new int[]{1, 2, 3}));
        System.out.println(findLengthOfShortestSubarray(new int[]{1}));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/solutions/1032852/shan-chu-lian-xu-zi-shu-zu-by-taicailea-tp0t/"></a>
     *
     * @param arr
     * @return
     */
    public static int findLengthOfShortestSubarray(int[] arr) {
        int result = Integer.MAX_VALUE;
        int length = arr.length;
        /**
         * 使得arr[i-1]>arr[i]的最小索引值i，即当i<left时，不存在arr[i-1]>arr[i]的情况
         */
        int left = 1;
        /**
         * 使得arr[i]<=arr[i+1]的最小索引值i，且当right>i时，不存在arr[i]>arr[i+1]的情况
         */
        int right = length - 1;

        while (left < length && arr[left - 1] <= arr[left]) {
            left++;
        }

        while (right - 1 >= 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        /**
         * 此时说明数组arr中所有元素已经是非递减的，不需要删除任何元素
         */
        if (left > right) {
            return 0;
        }
        /**
         * 删除以后最终只保留[0,left-1]这部分子数组的情况
         */
        result = Math.min(result, length - left);
        /**
         * 删除以后最终只保留[right,length-1]这部分子数组的情况
         */
        result = Math.min(result, right);
        /**
         * 目前数组arr被分成了左中右三个部分[0,left-1]、[left,right-1]、[right,length-1]，其中左边和右边的子数组都是满足
         * 所有元素非递减的，中间的子数组一定被包含在最终删除的子数组内。遍历左子数组的每一个元素arr[i]，对应在右子数组中找到第一
         * 个大于等于arr[i]的元素arr[j]，则[i+1,left-1]和[right,j-1]也会被包含在删除的子数组内，即最终删除的子数组为
         * [i+1,left-1]+[left,right-1]+[right,j-1]，求删除的子数组长度最短的情况即可
         */
        for (int i = 0; i < left; ++i) {
            int lo = right;
            int hi = length - 1;

            while (lo < hi) {
                int mid = (lo + hi) / 2;

                if (arr[mid] < arr[i]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            result = arr[lo] >= arr[i] ? Math.min(result, lo - i - 1) : Math.min(result, length - i - 1);
        }
        return result;
    }
}
