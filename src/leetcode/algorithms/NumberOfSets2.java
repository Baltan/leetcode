package leetcode.algorithms;

import java.math.BigInteger;

/**
 * Description: 1621. Number of Sets of K Non-Overlapping Line Segments
 *
 * @author Baltan
 * @date 2022/10/2 15:31
 * @see NumberOfSets
 * @see NumberOfSets1
 */
public class NumberOfSets2 {
    public static void main(String[] args) {
        System.out.println(numberOfSets(4, 2));
        System.out.println(numberOfSets(3, 1));
        System.out.println(numberOfSets(30, 7));
        System.out.println(numberOfSets(33, 20));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/number-of-sets-of-k-non-overlapping-line-segments/solution/mou-da-lao-de-yi-xing-dai-ma-by-darktiantian/"></a>
     *
     * @param n
     * @param k
     * @return
     */
    public static int numberOfSets(int n, int k) {
        BigInteger mod = BigInteger.valueOf(1000000007);
        BigInteger result = BigInteger.ONE;
        int totalPoints = n + k - 1;
        int chosenPoints = 2 * k;
        /**
         * 从totalPoints个点中选择chosenPoints个点，一共的选择数为：
         * [totalPoints*(totalPoints-1)*……*(totalPoints-chosenPoints+1)]/[1*2*……*chosenPoints]
         */
        for (int i = 1; i <= chosenPoints; i++) {
            result = result.multiply(BigInteger.valueOf(totalPoints - i + 1)).divide(BigInteger.valueOf(i));
        }
        return result.mod(mod).intValue();
    }
}
