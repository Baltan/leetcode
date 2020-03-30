package leetcode.interview;

/**
 * Description: 面试题62. 圆圈中最后剩下的数字
 *
 * @author Baltan
 * @date 2020-03-30 00:22
 */
public class LastRemaining {
    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
        System.out.println(lastRemaining(10, 17));
        System.out.println(lastRemaining(70866, 116922));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/si-chong-fang-fa-xiang-xi-jie-da-by-yuanninesuns/"></a>
     *
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        /**
         * 开始时，n个数的索引依次为：0、1、2、3、……、n-1。删除第m个数字的索引为(m-1)%n，因为m可能
         * 大于n，所以要取模，记k=(m-1)%n。当第二轮报数开始时，将从索引k+1开始，即报数的顺序为：
         * k+1、k+2、……、n-1、0、1、……、k-1，此时映射到新的索引为：0、1、……、n-k-2、n-k-1、……、
         * n-2。可以得到原始索引=(新索引+k+1)%n。在新索引中继续删除第m个数字直到最后剩下一个数字。
         * 可以求得lastRemaining(n,m)=(lastRemaining(n-1,m)+k+1)%n=
         * (lastRemaining(n-1,m)+(m-1)%n+1)%n=(lastRemaining(n-1,m)+m)%n
         */
        return (lastRemaining(n - 1, m) + m) % n;
    }
}
