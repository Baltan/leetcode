package leetcode.algorithms;

/**
 * Description: LCS 01. 下载插件
 *
 * @author Baltan
 * @date 2022/1/13 22:44
 */
public class LeastMinutes {
    public static void main(String[] args) {
        System.out.println(leastMinutes(1));
        System.out.println(leastMinutes(2));
        System.out.println(leastMinutes(3));
        System.out.println(leastMinutes(4));
    }

    public static int leastMinutes(int n) {
        /**
         * 除了只下载一个插件时，直接开始下载就行，其他情况下都优先扩大带宽直到每分钟可下载的插件数不少于n个，即求满足2^x>=n的
         * 最小的x，再加上最后下载的1分钟
         */
        if (n == 1) {
            return 1;
        }
        return (int) (Math.ceil(Math.log(n) / Math.log(2)) + 1);
    }
}
