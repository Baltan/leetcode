package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 556. Next Greater Element III
 *
 * @author Baltan
 * @date 2020-02-07 13:20
 */
public class NextGreaterElement1 {
    public static void main(String[] args) {
        System.out.println(nextGreaterElement(12));
        System.out.println(nextGreaterElement(21));
        System.out.println(nextGreaterElement(1999999999));
        System.out.println(nextGreaterElement(123456789));
        System.out.println(nextGreaterElement(987654321));
        System.out.println(nextGreaterElement(123045678));
        System.out.println(nextGreaterElement(2147483647));
        System.out.println(nextGreaterElement(100000005));
        System.out.println(nextGreaterElement(100000000));
        System.out.println(nextGreaterElement(123408765));
        System.out.println(nextGreaterElement(67801234));
        System.out.println(nextGreaterElement(8760123));
        System.out.println(nextGreaterElement(87650321));
    }

    public static int nextGreaterElement(int n) {
        /**
         * 32位整数最大值Integer.MAX_VALUE的数组表示
         */
        char[] threshold = {'2', '1', '4', '7', '4', '8', '3', '6', '4', '7'};
        /**
         * n的数组表示
         */
        char[] charArray = String.valueOf(n).toCharArray();
        int length = charArray.length;
        /**
         * 如果n的每一位都是递减的，例如：654321，则n不存在下一个更大元素。从n的最低位向最高位逐一
         * 比较相邻两位的值，如果出现了严格递增（高位数字小于相邻的低位数字）的情况，查找这个高位数
         * 字后面大于它的最小的数，将这个数和高位数字交换，再将高位数字后面的所有数字升序排列。最后
         * 重新排序过的数字如果不大于Integer.MAX_VALUE，就是我们要找的n的下一个更大的元素
         */
        for (int i = length - 1; i > 0; i--) {
            if (charArray[i] > charArray[i - 1]) {
                /**
                 * charArray[i]-charArray[length-1]的这些数字中大于charArray[i-1]的最小值的
                 * 索引
                 */
                int minIndex = i;
                /**
                 * 交换后得到的新数字可能大于Integer.MAX_VALUE，不符合要求，此时要在原数组上继
                 * 续遍历，所以不能在原数组上交换数字并排序
                 */
                char[] copy = charArray.clone();

                for (int j = i + 1; j < length; j++) {
                    if (copy[j] > copy[i - 1] && copy[j] < copy[minIndex]) {
                        minIndex = j;
                    }
                }
                /**
                 * 将copyArray[i-1]和copyArray[minIndex]交换
                 */
                swap(copy, minIndex, i - 1);
                /**
                 * 将copyArray[i]-charArray[length-1]的这些数字升序排列
                 */
                Arrays.sort(copy, i, length);
                /**
                 * 比较新得到的数字是否不大于Integer.MAX_VALUE，否则就不符合题意，要继续遍历
                 */
                if (!isGreater(copy, threshold)) {
                    return Integer.valueOf(new String(copy));
                }
            }
        }
        return -1;
    }

    /**
     * 交换数组charArray中charArray[i]和charArray[j]的值
     *
     * @param charArray
     * @param i
     * @param j
     */
    public static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    /**
     * 判断charArray表示的数字是否不大于Integer.MAX_VALUE
     *
     * @param charArray
     * @param threshold
     * @return
     */
    public static boolean isGreater(char[] charArray, char[] threshold) {
        int length1 = charArray.length;
        int length2 = threshold.length;

        if (length1 < length2) {
            return false;
        } else {
            for (int i = 0; i < length1; i++) {
                if (charArray[i] > threshold[i]) {
                    return true;
                }
            }
            return false;
        }
    }
}
