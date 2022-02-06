package leetcode.algorithms;

/**
 * Description: 1954. Minimum Garden Perimeter to Collect Enough Apples
 *
 * @author Baltan
 * @date 2022/2/5 11:04
 */
public class MinimumPerimeter {
    public static void main(String[] args) {
        System.out.println(minimumPerimeter(1L));
        System.out.println(minimumPerimeter(13L));
        System.out.println(minimumPerimeter(1000000000L));
        System.out.println(minimumPerimeter(1000000000000000L));
    }

    /**
     * 假设花园右上角的坐标为(n,n)，则花园右上角四分之一的坐标如图所示：
     * <pre>
     * (0,n)    (1,n)   (2,n)   ……  (n,n)
     * (0,n-1)  (1,n-1) (2,n-1) ……  (n,n-1)
     * (0,n-2)  (1,n-2) (2,n-2) ……  (n,n-2)
     *   ……       ……      ……    ……    ……
     * (0,0)    (1,0)   (2,0)   ……  (n,0)
     * </pre>
     * <p>
     * 以上部分花园中，非坐标轴上部分的苹果数量为：(1+n)*n/2*n+(1+n)*n/2*n=n*n*(1+n)，即如下图所示的部分：
     * <pre>
     * (1,n)   (2,n)   ……  (n,n)
     * (1,n-1) (2,n-1) ……  (n,n-1)
     * (1,n-2) (2,n-2) ……  (n,n-2)
     *   ……      ……    ……    ……
     * (1,1)   (2,1)   ……  (n,1)
     * </pre>
     * <p>
     * 以上部分花园中，x轴上（不包含原点）部分的苹果数量为：(1+n)*n/2，即如下图所示的部分
     * <pre>
     * (1,0)   (2,0)   ……  (n,0)
     * </pre>
     * <p>
     * 由于对称性，以上整个花园中的苹果数为以上苹果总数的4倍，即：n*n*(1+n)*4+(1+n)*n/2*4=2n*(n+1)*(2*n+1)
     *
     * @param neededApples
     * @return
     */
    public static long minimumPerimeter(long neededApples) {
        long lo = 1L;
        /**
         * 按照题意，neededApples的最大值为10^15，即2n*(n+1)*(2*n+1)不超过10^15，2n*(n+1)*(2*n+1)<4*n^3<n^3<=10^15，
         * 因此，n的最大值不超过10^5
         */
        long hi = 100000L;
        /**
         * 二分查找最小的符合条件的n
         */
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            long total = 2 * mid * (mid + 1) * (2 * mid + 1);

            if (total < neededApples) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        /**
         * 花园周长为8*n
         */
        return lo * 8;
    }
}
