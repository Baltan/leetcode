package leetcode.algorithms;

/**
 * Description: 1850. Minimum Adjacent Swaps to Reach the Kth Smallest Number
 *
 * @author Baltan
 * @date 2022/6/5 13:20
 * @see NextPermutation
 */
public class GetMinSwaps {
    public static void main(String[] args) {
        System.out.println(getMinSwaps("5489355142", 4));
        System.out.println(getMinSwaps("11112", 4));
        System.out.println(getMinSwaps("00123", 1));
    }

    public static int getMinSwaps(String num, int k) {
        char[] permutation = num.toCharArray();
        /**
         * 查找第k个妙数的排列
         */
        for (int i = 0; i < k; i++) {
            nextPermutation(permutation);
        }
        return swapCount(num.toCharArray(), permutation);
    }

    /**
     * 计算从排列oldPermutation得到排列newPermutation的最少相邻位置交换次数
     *
     * @param oldPermutation
     * @param newPermutation
     * @return
     */
    public static int swapCount(char[] oldPermutation, char[] newPermutation) {
        int result = 0;
        int length = oldPermutation.length;

        for (int i = 0; i < length; i++) {
            if (oldPermutation[i] == newPermutation[i]) {
                continue;
            }
            /**
             * 从oldPermutation[i+1]开始向右找到第一个等于newPermutation[i]的字符
             */
            for (int j = i + 1; j < length; j++) {
                /**
                 * 将oldPermutation[j]从右向左逐一进行相邻位置交换，直到将oldPermutation[j]换到oldPermutation[i]，一共
                 * 需要进行j-i次相邻位置交换
                 */
                if (oldPermutation[j] == newPermutation[i]) {
                    result += (j - i);
                    char temp = oldPermutation[j];
                    /**
                     * 进行相邻位置交换
                     */
                    for (int k = j; k > i; k--) {
                        oldPermutation[k] = oldPermutation[k - 1];
                    }
                    oldPermutation[i] = temp;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * permutation的下一个排列
     *
     * @param permutation
     */
    public static void nextPermutation(char[] permutation) {
        int index = -1;
        /**
         * 找到索引最大的相邻两数顺序排列的一对数字
         */
        for (int i = permutation.length - 2; i >= 0; i--) {
            if (permutation[i] < permutation[i + 1]) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            /**
             * 冒泡排序将nums中索引index之后部分的数字按照升序排列
             */
            for (int i = permutation.length - 2; i > index; i--) {
                for (int j = index + 1; j <= i; j++) {
                    if (permutation[j] > permutation[j + 1]) {
                        char temp = permutation[j];
                        permutation[j] = permutation[j + 1];
                        permutation[j + 1] = temp;
                    }
                }
            }
            /**
             * 找到nums中索引index之后部分的第一个大于nums[index]的数字nums[i]，交换两数
             */
            for (int i = index + 1; i < permutation.length; i++) {
                if (permutation[i] > permutation[index]) {
                    char temp = permutation[i];
                    permutation[i] = permutation[index];
                    permutation[index] = temp;
                    break;
                }
            }
        }
    }
}
