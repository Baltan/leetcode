package leetcode.algorithms;

/**
 * Description: 3751. Total Waviness of Numbers in Range I
 *
 * @author baltan
 * @date 2026/1/23 16:17
 */
public class TotalWaviness {
    public static void main(String[] args) {
        System.out.println(totalWaviness(120, 130));
        System.out.println(totalWaviness(198, 202));
        System.out.println(totalWaviness(4848, 4848));
    }

    public static int totalWaviness(int num1, int num2) {
        int result = 0;
        /**
         * 枚举范围[num1,num2]内的所有数字
         */
        for (int i = num1; i <= num2; i++) {
            int num = i;
            /**
             * 数字i的当前数位数字右边的数字
             */
            int digit2 = -1;
            /**
             * 数字i的当前数位数字右边的右边的数字
             */
            int digit3 = -1;

            while (num != 0) {
                int digit1 = num % 10;

                if (digit2 != -1 && digit3 != -1) {
                    /**
                     * 判断连续三个数位上的数字digit1、digit2、digit3是否构成峰或谷
                     */
                    if ((digit2 > digit1 && digit2 > digit3) || (digit2 < digit1 && digit2 < digit3)) {
                        result++;
                    }
                }
                digit3 = digit2;
                digit2 = digit1;
                num /= 10;
            }
        }
        return result;
    }
}
