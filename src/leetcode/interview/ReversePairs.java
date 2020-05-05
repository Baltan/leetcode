package leetcode.interview;

/**
 * Description: 面试题51. 数组中的逆序对
 *
 * @author Baltan
 * @date 2020-04-24 08:02
 */
public class ReversePairs {
    private static int result;

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{7, 5, 6, 4}));
        System.out.println(reversePairs(
                new int[]{43, 6544, 242, 435, 42, 345, 13, 64, 24, 75, 2, 756, 5, 24, 64, 786, 52, 54, 6, 24,
                        64, 24, 36, 786, 75, 35, 21, 53, 4, 24, 13, 35, 46, 75, 36, 57, 86, 46, 24, 246, 758,
                        53, 46, 58}));
    }

    public static int reversePairs(int[] nums) {
        result = 0;
        mergeSort(nums, 0, nums.length - 1);
        return result;
    }

    /**
     * 对数组arr中所有元素进行归并排序
     *
     * @param arr
     * @param lo
     * @param hi
     */
    public static void mergeSort(int[] arr, int lo, int hi) {
        /**
         * 递归条件：当开始索引小于结束索引时，否则说明两个索引重合，即只有一个数字无需再递归
         */
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            /**
             * 将数组的两个子数组分别排序后，执行归并操作
             */
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }
    }

    /**
     * 将arr.subarray(lo,mid+1)和arr.subarray(mid+1,hi+1)这两个已经完成排序的子数组合并为一个排序
     * 的数组
     *
     * @param arr
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(int[] arr, int lo, int mid, int hi) {
        /**
         * 将一个数组分成两段，可以看做是两个子数组。新建一个临时数组用于存放后续操作的数字。
         * 维护两个指针，分别指向两个子数组的第一个数字。
         * 比较两个指针指向的数字，将较小的一个放入临时数组，向后移动指向较小数字的指针。
         * 如此循环，直到其中一个子数组中的数字都被放入临时数组，将另一个子数组中的数字也都放入到临时数组。
         * 最后将临时数组中的数字放回原数组中对应的位置
         */
        int[] temp = new int[hi - lo + 1];
        int index = 0;
        int firstCursor = lo;
        int secondCursor = mid + 1;

        while (firstCursor <= mid && secondCursor <= hi) {
            if (arr[firstCursor] <= arr[secondCursor]) {
                temp[index++] = arr[firstCursor++];
            } else {
                /**
                 * 当第二个子数组的指针指向的数字小于第一个子数组的指针指向的数字时，说明第二个子数组的
                 * 指针指向的数字和第一个子数组剩余的所有数字都构成逆序对，此时第一个子数组剩余数字的个
                 * 数为mid-firstCursor+1，即有mid-firstCursor+1个逆序对
                 */
                result += (mid - firstCursor + 1);
                temp[index++] = arr[secondCursor++];
            }
        }
        /**
         * 如果第一个子数组中还有剩余的数字，按序放入temp中
         */
        while (firstCursor <= mid) {
            temp[index++] = arr[firstCursor++];
        }
        /**
         * 如果第二个子数组中还有剩余的数字，按序放入temp中
         */
        while (secondCursor <= hi) {
            temp[index++] = arr[secondCursor++];
        }
        /**
         * 将temp中的数字放回原数组中对应的位置
         */
        for (int i = 0; i < temp.length; i++) {
            arr[i + lo] = temp[i];
        }
    }
}
