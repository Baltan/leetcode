package leetcode.algorithms;

/**
 * Description: 2843. Count Symmetric Integers
 *
 * @author baltan
 * @date 2023/9/7 09:59
 */
public class CountSymmetricIntegers {
    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(1, 100));
        System.out.println(countSymmetricIntegers(1200, 1230));
    }

    public static int countSymmetricIntegers(int low, int high) {
        int result = 0;

        for (int i = low; i <= high; ) {
            int clone = i;
            int digitsCount = digitsCount(i);
            /**
             * 如果i的数位个数为奇数，则直接将i值为数位个数比i大1的最小数字，即10^digitsCount
             */
            if (digitsCount % 2 == 1) {
                i = (int) Math.pow(10, digitsCount);
                continue;
            }
            /**
             * 数字i前面一半数位上数字的和
             */
            int firstSum = 0;
            /**
             * 数字i后面一半数位上数字的和
             */
            int lastSum = 0;

            for (int j = digitsCount / 2; j > 0; j--) {
                lastSum += i % 10;
                i /= 10;
            }

            for (int j = digitsCount / 2; j > 0; j--) {
                firstSum += i % 10;
                i /= 10;
            }

            if (firstSum == lastSum) {
                result++;
            }
            /**
             * 继续判断下一个数字
             */
            i = clone + 1;
        }
        return result;
    }

    /**
     * 计算数字num的数位个数
     *
     * @param num
     * @return
     */
    public static int digitsCount(int num) {
        int count = 0;

        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }
}
