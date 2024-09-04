package leetcode.algorithms;

/**
 * Description: 768. Max Chunks To Make Sorted II
 *
 * @author baltan
 * @date 2024/9/2 14:23
 * @see MaxChunksToSorted
 */
public class MaxChunksToSorted1 {
    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{1, 1, 0, 0, 1}));
        System.out.println(maxChunksToSorted(new int[]{1, 0, 1, 3, 2}));
        System.out.println(maxChunksToSorted(new int[]{5, 4, 3, 2, 1}));
        System.out.println(maxChunksToSorted(new int[]{2, 1, 3, 4, 4}));
    }

    public static int maxChunksToSorted(int[] arr) {
        int result = 0;
        /**
         * starts[i]表示数组arr中最靠前的大于arr[i]的元素的索引值，如果不存在这样的元素，则starts[i]为-1
         */
        int[] starts = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            starts[i] = -1;
            /**
             * 查找数组arr中最靠前的大于arr[i]的元素的索引值
             */
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    starts[i] = j;
                    break;
                }
            }
        }
        /**
         * 对于元素arr[i]来说，如果存在x小于i并且arr[x]大于arr[i]，则元素arr[x]和arr[i]分割后必须在同一个子数组中
         */
        for (int i = arr.length - 1; i >= 0; ) {
            /**
             * 分割后以arr[i]为结尾的子数组的第一个元素的索引值
             */
            int start = starts[i];

            if (start == -1) {
                /**
                 * arr[i]的前面没有比它大的元素，可在arr[i]处分割得到一个子数组
                 */
                result++;
                i--;
            } else {
                int j = i;
                /**
                 * 继续向前查找，直到不存在x小于j并且arr[x]大于arr[j]为止
                 */
                while (j >= 0 && j >= start) {
                    /**
                     * arr[j]的前面还有比它大的元素，分割后子数组的至多从arr[start]开始
                     */
                    if (starts[j] != -1) {
                        start = Math.min(start, starts[j]);
                    }
                    j--;
                }
                result++;
                i = j;
            }
        }
        return result;
    }
}
