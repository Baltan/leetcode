package leetcode.algorithms;

/**
 * Description: 954. Array of Doubled Pairs
 *
 * @author Baltan
 * @date 2020-02-28 11:23
 */
public class CanReorderDoubled {
    public static void main(String[] args) {
        System.out.println(canReorderDoubled(new int[]{3, 1, 3, 6}));
        System.out.println(canReorderDoubled(new int[]{2, 1, 2, 6}));
        System.out.println(canReorderDoubled(new int[]{4, -2, 2, -4}));
        System.out.println(canReorderDoubled(new int[]{1, 2, 4, 16, 8, 4}));
    }

    public static boolean canReorderDoubled(int[] A) {
        int threshold = 100000;
        /**
         * positiveCount[i]表示数组A中i的个数
         */
        int[] positiveCount = new int[threshold + 1];
        /**
         * negativeCount[i]表示数组A中-i的个数
         */
        int[] negativeCount = new int[threshold + 1];
        /**
         * 数组A中0的个数
         */
        int zeroCount = 0;

        for (int value : A) {
            if (value > 0) {
                positiveCount[value]++;
            } else if (value < 0) {
                negativeCount[-value]++;
            } else {
                zeroCount++;
            }
        }
        /**
         * 如果数组A中0的个数为奇数个，则无法完成重组，因为0肯定和0配对
         */
        if ((zeroCount & 1) == 1) {
            return false;
        }
        /**
         * 从小到大遍历数组A中的正数，同时从大到小遍历数组A中的负数，对当前遍历到的数字尝试配对，
         * 如果不能完成，则无法完成重组。
         */
        for (int i = 1; i < threshold; i++) {
            if (positiveCount[i] > 0) {
                /**
                 * 因为不存在i/2，所以i肯定和i*2配对
                 */
                if (i * 2 > threshold || positiveCount[i * 2] < positiveCount[i]) {
                    return false;
                } else {
                    positiveCount[i * 2] -= positiveCount[i];
                }
            }

            if (negativeCount[i] > 0) {
                /**
                 * 因为不存在i/2，所以i肯定和i*2配对
                 */
                if (i * 2 > threshold || negativeCount[i * 2] < negativeCount[i]) {
                    return false;
                } else {
                    negativeCount[i * 2] -= negativeCount[i];
                }
            }
        }
        return true;
    }
}
