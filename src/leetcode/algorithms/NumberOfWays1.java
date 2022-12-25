package leetcode.algorithms;

import java.math.BigInteger;

/**
 * Description: 2400. Number of Ways to Reach a Position After Exactly k Steps
 *
 * @author Baltan
 * @date 2022/12/24 12:40
 */
public class NumberOfWays1 {
    public static void main(String[] args) {
        System.out.println(numberOfWays(1, 2, 3));
        System.out.println(numberOfWays(2, 5, 10));
        System.out.println(numberOfWays(1, 995, 1000));
        System.out.println(numberOfWays(1, 505, 1000));
    }

    public static int numberOfWays(int startPos, int endPos, int k) {
        /**
         * 1、如果startPos和endPos距离相差超过k，不存在k步从startPos到endPos的方法
         * 2、如果k步中向左a步，向右k-a步，则startPos-a+(k-a)=endPos，即startPos-endPos+k=2a，所以startPos-endPos+k应当为偶数
         */
        if ((startPos - endPos + k) % 2 != 0 || Math.abs(endPos - startPos) > k) {
            return 0;
        }
        BigInteger result = BigInteger.valueOf(1);
        BigInteger mod = BigInteger.valueOf(1000000007);
        /**
         * k步中向左移动的步数
         */
        int leftSteps = (startPos - endPos + k) / 2;
        /**
         * 只需要确定其中一个方向上的情况，剩下的每一步都是另一个方向，选择步数较少的一个方向
         */
        int min = Math.min(leftSteps, k - leftSteps);
        /**
         * 在k步中选择min步都向其中某个方向前进，共C(k,min)种情况
         */
        for (int i = 1; i <= min; i++) {
            result = result.multiply(BigInteger.valueOf(k - i + 1)).divide(BigInteger.valueOf(i));
        }
        return result.mod(mod).intValue();
    }
}
