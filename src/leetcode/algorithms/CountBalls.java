package leetcode.algorithms;

/**
 * Description: 1742. Maximum Number of Balls in a Box
 *
 * @author Baltan
 * @date 2022/7/31 13:08
 */
public class CountBalls {
    public static void main(String[] args) {
        System.out.println(countBalls(1, 10));
        System.out.println(countBalls(5, 15));
        System.out.println(countBalls(19, 28));
    }

    public static int countBalls(int lowLimit, int highLimit) {
        int result = Integer.MIN_VALUE;
        /**
         * 根据题意，小球编号所有位数之和最大为45，此时小球编号为99999。countArray[i]表示小球编号所有位数之和为i的球的个数
         */
        int[] countArray = new int[46];

        for (int i = lowLimit; i <= highLimit; i++) {
            /**
             * 小球编号所有位数之和
             */
            int sum = 0;
            int number = i;

            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            countArray[sum]++;
        }

        for (int count : countArray) {
            if (count > result) {
                result = count;
            }
        }
        return result;
    }
}
