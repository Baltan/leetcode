package leetcode.algorithms;

/**
 * Description: 2513. Minimize the Maximum of Two Arrays
 *
 * @author Baltan
 * @date 2022/12/28 14:45
 */
public class MinimizeSet {
    public static void main(String[] args) {
        System.out.println(minimizeSet(2557, 15901, 805236426, 194763574));
        System.out.println(minimizeSet(94560, 71250, 30680567, 87765279));
        System.out.println(minimizeSet(2, 7, 1, 3));
        System.out.println(minimizeSet(3, 5, 2, 1));
        System.out.println(minimizeSet(2, 4, 8, 2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimize-the-maximum-of-two-arrays/solutions/2031827/er-fen-da-an-by-endlesscheng-y8fp/"></a>
     *
     * @param divisor1
     * @param divisor2
     * @param uniqueCnt1
     * @param uniqueCnt2
     * @return
     */
    public static int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int lo = 1;
        int hi = Integer.MAX_VALUE;
        /**
         * divisor1和divisor2的最大公约数
         */
        int gcd = gcd(divisor1, divisor2);
        /**
         * divisor1和divisor2的最小公倍数
         */
        long lcm = 1L * divisor1 * divisor2 / gcd;
        /**
         * 二分查找两个数组中的最大值
         */
        while (lo < hi) {
            /**
             * 防止lo+hi整型越界
             */
            int mid = (int) ((lo + 1L * hi) / 2);
            /**
             * 正整数[1,mid]中能被divisor1整除的数字的个数
             */
            int byDivisor1Count = mid / divisor1;
            /**
             * 正整数[1,mid]中能被divisor2整除的数字的个数
             */
            int byDivisor2Count = mid / divisor2;
            /**
             * 正整数[1,mid]中能同时被divisor1和divisor2整除的数字的个数
             */
            int byBothCount = (int) (mid / lcm);
            /**
             * 正整数[1,mid]中能被divisor2整除且不能被divisor1整除的数字的个数
             */
            int onlyNotByDivisor1Count = byDivisor2Count - byBothCount;
            /**
             * 正整数[1,mid]中能被divisor1整除且不能被divisor2整除的数字的个数
             */
            int onlyNotByDivisor2Count = byDivisor1Count - byBothCount;
            /**
             * 正整数[1,mid]中既不能被divisor2整除又不能被divisor1整除的数字的个数
             */
            int notByBothCount = mid - (byDivisor1Count + byDivisor2Count - byBothCount);
            /**
             * 将onlyNotByDivisor1Count个数字都加入arr1，将onlyNotByDivisor2Count个数字都加入arr2后，两个数组加起来还缺少的数字个数
             */
            int missingCount = 0;

            if (uniqueCnt1 > onlyNotByDivisor1Count) {
                missingCount += (uniqueCnt1 - onlyNotByDivisor1Count);
            }

            if (uniqueCnt2 > onlyNotByDivisor2Count) {
                missingCount += (uniqueCnt2 - onlyNotByDivisor2Count);
            }
            /**
             * 两个数组缺少的数字只能从notByBothCount个数字中取
             */
            if (notByBothCount >= missingCount) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /**
     * 求x和y的最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    public static int gcd(int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);

        while (max % min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        return min;
    }
}
