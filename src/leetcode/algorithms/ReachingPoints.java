package leetcode.algorithms;

/**
 * Description: 780. Reaching Points
 *
 * @author Baltan
 * @date 2019-08-13 08:55
 */
public class ReachingPoints {
    public static void main(String[] args) {
        System.out.println(reachingPoints(1, 1, 3, 5));
        System.out.println(reachingPoints(1, 1, 2, 2));
        System.out.println(reachingPoints(1, 1, 1, 1));
        System.out.println(reachingPoints(1, 1, 1000000000, 500000000));
        System.out.println(reachingPoints(1, 1, 1000000000, 999999999));
        System.out.println(reachingPoints(1, 2, 1000000000, 2));
    }

    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (tx == sx && ty == sy) {
            return true;
        }

        if (tx < sx || ty < sy) {
            return false;
        }
        /**
         * 从[tx,ty]逆推[sx,sy]，因为只有一种可能
         */
        while (true) {
            if (tx > ty) {
                /**
                 * 如果tx远远大于ty，计算出tx和sx的差值相差多少个ty，一次性减掉这些ty，并且至少减掉1个ty
                 */
                tx -= Math.max(1, (tx - sx) / ty) * ty;
            } else if (ty > tx) {
                /**
                 * 如果ty远远大于tx，计算出ty和sy的差值相差多少个tx，一次性减掉这些tx，并且至少减掉1个tx
                 */
                ty -= Math.max(1, (ty - sy) / tx) * tx;
            } else {
                return false;
            }

            if (sx == tx && sy == ty) {
                return true;
            }
            /**
             * 如果tx小于sx或者ty小于sy，则不可能再得到sx或sy了，返回false
             */
            if (sx > tx || sy > ty) {
                return false;
            }
        }
    }
}
