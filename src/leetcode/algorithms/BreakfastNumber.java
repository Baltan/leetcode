package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: LCP 18. 早餐组合
 *
 * @author Baltan
 * @date 2022/1/14 13:53
 * @see BreakfastNumber1
 */
public class BreakfastNumber {
    public static void main(String[] args) {
        System.out.println(breakfastNumber(new int[]{10, 20, 5}, new int[]{5, 5, 2}, 15));
        System.out.println(breakfastNumber(new int[]{2, 1, 1}, new int[]{8, 9, 5, 1}, 9));
    }

    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
        int stapleCount = staple.length;
        int drinksCount = drinks.length;

        if (stapleCount >= drinksCount) {
            return help(staple, drinks, x);
        } else {
            return help(drinks, staple, x);
        }
    }

    public static int help(int[] bigArray, int[] smallArray, int x) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * countArray[i]表示smallArray中价格i出现次数
         */
        int[] countArray = new int[100001];
        Arrays.sort(bigArray);

        for (int num : smallArray) {
            countArray[num]++;
        }

        for (int num = 0; num < countArray.length; num++) {
            if (countArray[num] == 0) {
                continue;
            }
            /**
             * 另一种食物的最贵价格
             */
            int otherNum = x - num;
            /**
             * 计算不超过价格otherNum的另一种食物的数量
             */
            int position = binarySearch(bigArray, otherNum);

            if (position != -1) {
                result += 1L * (position + 1) * countArray[num];
            }
        }
        return (int) (result % mod);
    }

    /**
     * 在已排序的bigArray中查找最后一个小于等于num的数的索引位置，如果不存在返回-1
     *
     * @param bigArray
     * @param num
     * @return
     */
    public static int binarySearch(int[] bigArray, int num) {
        if (bigArray[0] > num) {
            return -1;
        }

        int lo = 0;
        int hi = bigArray.length - 1;

        while (lo < hi) {
            int mid = (int) Math.ceil((lo + hi) / 2.0);

            if (bigArray[mid] > num) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
