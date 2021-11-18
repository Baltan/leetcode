package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2048. Next Greater Numerically Balanced Number
 *
 * @author Baltan
 * @date 2021/11/18 17:18
 */
public class NextBeautifulNumber {
    public static void main(String[] args) {
        System.out.println(nextBeautifulNumber(1));
        System.out.println(nextBeautifulNumber(1000));
        System.out.println(nextBeautifulNumber(3000));
        System.out.println(nextBeautifulNumber(768758));
        System.out.println(nextBeautifulNumber(44325));
    }

    public static int nextBeautifulNumber(int n) {
        List<Integer> beautifulNumberList = new ArrayList<>();

        for (int i = 1; ; i++) {
            if (isBeautifulNumber(i)) {
                beautifulNumberList.add(i);
                /**
                 * 因为题意说明n范围为[0,1000000]，所以找到第一个大于1000000的数值平衡数为止即可
                 */
                if (i > 1000000) {
                    break;
                }
            }
        }
        return binarySearch(n, beautifulNumberList);
    }

    /**
     * 判断n是否是数值平衡数
     *
     * @param n
     * @return
     */
    public static boolean isBeautifulNumber(int n) {
        /**
         * countArr[i]表示数字i在n中出现的次数
         */
        int[] countArr = new int[10];

        while (n > 0) {
            /**
             * n个位上的数字
             */
            int remainder = n % 10;
            countArr[remainder]++;
            n /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (countArr[i] != 0 && countArr[i] != i) {
                return false;
            }
        }
        return true;
    }

    /**
     * 在beautifulNumberList中二分查找严格大于n的第一个数字
     *
     * @param n
     * @param beautifulNumberList
     * @return
     */
    public static int binarySearch(int n, List<Integer> beautifulNumberList) {
        int lo = 0;
        int hi = beautifulNumberList.size();

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (beautifulNumberList.get(mid) <= n) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return beautifulNumberList.get(lo);
    }
}
