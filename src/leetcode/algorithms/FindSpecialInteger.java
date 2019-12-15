package leetcode.algorithms;

/**
 * Description: 1287. Element Appearing More Than 25% In Sorted Array
 *
 * @author Baltan
 * @date 2019-12-15 11:26
 */
public class FindSpecialInteger {
    public static void main(String[] args) {
        System.out.println(findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
        System.out.println(findSpecialInteger(new int[]{1}));
    }

    public static int findSpecialInteger(int[] arr) {
        int length = arr.length;
        /**
         * 出现四分之一至少要出现的次数
         */
        int quarterLength = length >> 2;
        int prev = arr[0];
        /**
         * 当前相同数字出现的次数
         */
        int count = 1;

        for (int i = 1; i < length; i++) {
            int curr = arr[i];
            /**
             * 如果当前数字和前一个数字一样，就将该数字出现的次数加1，并判断出现次数是否超过quarterLength
             * 次了；如果不一样就将当前数字作为下一轮比较的基准，该数字出现的次数设为1次。
             */
            if (curr == prev) {
                count++;

                if (count > quarterLength) {
                    return curr;
                }
            } else {
                prev = curr;
                count = 1;
            }
        }
        /**
         * 如果数组只有一个元素的话，返回第一个数字
         */
        return prev;
    }
}
