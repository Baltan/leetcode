package leetcode.algorithms;

/**
 * Description: 793. Preimage Size of Factorial Zeroes Function
 *
 * @author Baltan
 * @date 2020-01-11 14:23
 */
public class PreimageSizeFZF {
    public static void main(String[] args) {
        System.out.println(preimageSizeFZF(0));
        System.out.println(preimageSizeFZF(1));
        System.out.println(preimageSizeFZF(2));
        System.out.println(preimageSizeFZF(3));
        System.out.println(preimageSizeFZF(4));
        System.out.println(preimageSizeFZF(5));
        System.out.println(preimageSizeFZF(6));
        System.out.println(preimageSizeFZF(7));
        System.out.println(preimageSizeFZF(8));
        System.out.println(preimageSizeFZF(9));
        System.out.println(preimageSizeFZF(10));
        System.out.println(preimageSizeFZF(10000));
        System.out.println(preimageSizeFZF(50000));
        System.out.println(preimageSizeFZF(1000000));
        System.out.println(preimageSizeFZF(999999999));
        System.out.println(preimageSizeFZF(1000000000));
    }

    public static int preimageSizeFZF(int K) {
        long lo = 0;
        long hi = 5000000000L;
        /**
         * 二分查找使得尾部"0"的个数至少为K个的值中最小的那个，显然这个最小值只可能是5的倍数，因为：
         * 假设最小值min=5x(x为正整数)，若min!尾部"0"的个数为K个，则
         * (min+1)!=min!*(min+1)
         * (min+2)!=min!*(min+1)*(min+2)
         * (min+3)!=min!*(min+1)*(min+2)*(min+3)
         * (min+4)!=min!*(min+1)*(min+2)*(min+3)*(min+4)
         * 这四个数尾部"0"的个数也为K个，但是对于
         * (min+5)!=min!*(min+1)*(min+2)*(min+3)*(min+4)*(min+5)
         *         =min!*(min+1)*(min+2)*(min+3)*(min+4)*5(x+1)
         * 尾部"0"的个数至少有K+1（取决于x+1是否为5的倍数）个，对于
         * (min-1)!=min!/min=min!/5x
         * 尾部"0"的个数至多有K-1（取决于x是否为5的倍数）个
         */
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            long trailingZeroCount = trailingZeroCount(mid);
            /**
             * 如果mid!尾部"0"的个数少于K个，那么最小值一定大于mid，否则最小值一定小于等于mid
             */
            if (trailingZeroCount < K) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        /**
         * 二分查找的结果不能保证尾部"0"的个数一定是K个，也可能多余K个。例如：24!尾部"0"的个数为4个，
         * 25!尾部"0"的个数为6个，即尾部"0"的个数为5个情况不存在
         */
        return trailingZeroCount(hi) == K ? 5 : 0;
    }

    /**
     * 计算number!尾部"0"的个数
     *
     * @param number
     * @return
     */
    public static int trailingZeroCount(long number) {
        int count = 0;
        /**
         * 对number!进行素因数分解后，只有"2×5"可以在尾部得到0，而"2"的个数显然是要多余"5"的，所以只
         * 需计算素因素分解后有几个"5"。通过number/5即可得到[1,number]中5的倍数的个数，但是对于25、
         * 125、625……的倍数能分解出更多的因子"5"，所以还需计算[1,number]中25、125、625……的倍数的个
         * 数
         */
        while (number > 0) {
            number /= 5;
            count += number;
        }
        return count;
    }
}
