package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: LCP 11. 期望个数统计
 *
 * @author Baltan
 * @date 2020-06-26 12:08
 */
public class ExpectNumber {
    public static void main(String[] args) {
        System.out.println(expectNumber(new int[]{1, 2, 3}));
        System.out.println(expectNumber(new int[]{1, 1}));
        System.out.println(expectNumber(new int[]{1, 1, 2}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/qi-wang-ge-shu-tong-ji/solution/qi-wang-ge-shu-tong-ji-qi-wang-ji-suan-yu-zheng-mi/"></a>
     *
     * @param scores
     * @return
     */
    public static int expectNumber(int[] scores) {
        /**
         * 以为A和B都是按照能力值从高到低浏览，所以不同能力值的简历之间相互不影响，我们只需计算对于相同能力值的简历，A和B
         * 的浏览顺序中出现在同一位置的简历数的期望，然后将各个能力值计算得到的期望求和即可。假设某一能力值相同的简历为a1、
         * a2、a3、……、an，则这n份简历打乱后，第k个位置上还是ak的概率为1/n（k∈[1,n]），即A和B在第k个位置上浏览的简历相
         * 同的概率为1/n，所以求得期望E(X)=n*(1/n)=1。也就是说对于相同能力值的简历，A和B的浏览顺序中出现在同一位置的简
         * 历数的期望为1，则对于所有简历所求期望值就是不同能力值的个数
         */
        Set<Integer> set = new HashSet<>();

        for (int score : scores) {
            set.add(score);
        }
        return set.size();
    }
}
