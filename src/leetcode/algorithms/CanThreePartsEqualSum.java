package leetcode.algorithms;

/**
 * Description: 1013. Partition Array Into Three Parts With Equal Sum
 *
 * @author Baltan
 * @date 2019-03-24 12:09
 */
public class CanThreePartsEqualSum {
    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        System.out.println(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
        System.out.println(canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
        System.out.println(canThreePartsEqualSum(new int[]{1, 1, 1}));
    }

    public static boolean canThreePartsEqualSum(int[] A) {
        /**
         * 数组A中所有数字的和
         */
        int sum = 0;

        for (int value : A) {
            sum += value;
        }

        if (sum % 3 != 0) {
            return false;
        }
        /**
         * 分成3组后，每组中元素的和
         */
        int average = sum / 3;
        /**
         * 当前分割的组数
         */
        int groupCount = 0;
        /**
         * 当前一组中所有元素的和
         */
        int currentSum = 0;
        int length = A.length;

        for (int i = 0; i < length; i++) {
            currentSum += A[i];
            /**
             * 如果当前这组数字的和为average，则说明得到了一个目标分组，继续尝试下一个分组
             */
            if (currentSum == average) {
                groupCount++;
                currentSum = 0;
                /**
                 * 如果已经得到了2个分组并且还有剩余的数字，则剩余的数字的和必然是average，此时说明可以将数
                 * 组分成和相等的三个部分，返回true
                 */
                if (groupCount == 2 && i < length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
