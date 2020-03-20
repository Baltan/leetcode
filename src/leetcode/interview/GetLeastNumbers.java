package leetcode.interview;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 面试题40. 最小的k个数
 *
 * @author Baltan
 * @date 2020-03-20 12:09
 */
public class GetLeastNumbers {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(getLeastNumbers(new int[]{3, 2, 1}, 2));
        OutputUtils.print1DIntegerArray(getLeastNumbers(new int[]{0, 1, 2, 1}, 1));
        OutputUtils.print1DIntegerArray(getLeastNumbers(
                new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18,
                        23, 34, 15, 35, 25, 53, 51}, 6));
        OutputUtils.print1DIntegerArray(getLeastNumbers(new int[]{0, 0, 2, 3, 2, 1, 1, 2, 0, 4}, 10));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        heapSort(arr, k);
        System.out.println(Arrays.toString(arr));
        return Arrays.copyOfRange(arr, arr.length - k, arr.length);
    }

    /**
     * 堆排序
     *
     * @param arr
     * @param k
     */
    public static void heapSort(int[] arr, int k) {
        int length = arr.length;
        /**
         * 最后一个叶子节点的索引为length-1，则最后一个非叶子节点的索引为(length-1-1)/2=length/2-1
         */
        int lastNonLeafNodeIndex = length / 2 - 1;
        /**
         * 从最后一个非叶子节点开始依次向前调整二叉树，直到根节点，此时，二叉树被调整为一个小顶堆，调整完后
         * 的小顶堆二叉树的根节点数值（索引为0）即时最小值
         */
        for (int i = lastNonLeafNodeIndex; i >= 0; i--) {
            heapify(arr, length, i);
        }
        /**
         * 将小顶堆二叉树的根节点数值（索引为0）与数组中最后一个值（索引为length-1）交换。固定数组最后一个
         * 值，将数组的剩余部分从根节点开始重新构造小顶堆，直到找到数组中最小的k个值或者循环到数组第一个元素
         */
        for (int i = length - 1; i >= length - k && i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    /**
     * 构造小顶堆
     *
     * @param arr
     * @param length
     * @param nodeIndex
     */
    public static void heapify(int[] arr, int length, int nodeIndex) {
        /**
         * 对于某一个非叶子节点，如果其在数组中对应的索引为nodeIndex，并且假设它的左、右子节点存在，
         * 则其左子节点的索引为nodeIndex*2+1，右子节点的索引为nodeIndex*2+2。
         */
        int leftNodeIndex = nodeIndex * 2 + 1;
        int rightNodeIndex = nodeIndex * 2 + 2;
        int minValueIndex = nodeIndex;
        /**
         * 找到这三个节点中的最小值，通过交换节点位置，将最小值交换到双亲节点的位置。
         */
        if (leftNodeIndex < length && arr[leftNodeIndex] < arr[minValueIndex]) {
            minValueIndex = leftNodeIndex;
        }

        if (rightNodeIndex < length && arr[rightNodeIndex] < arr[minValueIndex]) {
            minValueIndex = rightNodeIndex;
        }
        /**
         * 若发生了节点交换，则最小值原来所在位置对应的小顶堆子树可能被破坏，需要向下递归重新调整。
         */
        if (minValueIndex != nodeIndex) {
            swap(arr, minValueIndex, nodeIndex);
            heapify(arr, length, minValueIndex);
        }
    }

    /**
     * 交换数组中索引为i和j的数字
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
