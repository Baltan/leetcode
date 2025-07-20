package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 3592. Inverse Coin Change
 *
 * @author baltan
 * @date 2025/7/17 16:55
 */
public class FindCoins {
    public static void main(String[] args) {
        System.out.println(findCoins(new int[]{0, 1, 0, 2, 0, 3, 0, 4, 0, 5}));
        System.out.println(findCoins(new int[]{1, 2, 2, 3, 4}));
        System.out.println(findCoins(new int[]{1, 2, 3, 4, 15}));
    }

    public static List<Integer> findCoins(int[] numWays) {
        List<Integer> result = new ArrayList<>();
        /**
         * ways[i]表示已有硬币面值凑出总金额i的方法数
         */
        int[] ways = new int[numWays.length + 1];
        int index = 0;
        /**
         * 当总结额为0时，只有一种方法
         */
        ways[0] = 1;
        /**
         * 从小到大依次判断当前面值的硬币是否存在
         */
        while (index < numWays.length) {
            /**
             * 如果numWays[index]不为0，说明无法用已有小面值的硬币凑出总金额index+1，则一定存在面值为index+1的硬币，记为denomination
             */
            if (numWays[index] != 0) {
                int denomination = index + 1;
                result.add(denomination);
                /**
                 * 对于此前通过小面值的硬币已得到的总金额，对于每种方法，依次添加j个面值为denomination的硬币可以凑到更大总金额的，但是总金
                 * 额不会超过ways.length。注意必须是按照已有总金额的倒序来添加若干面值为denomination的硬币。
                 */
                for (int i = ways.length - 1; i >= 0; i--) {
                    for (int j = 1; i + j * denomination < ways.length; j++) {
                        /**
                         * 已有硬币凑出总金额i的方法数为ways[i]，则在此基础上增加j个面值为denomination的硬币后，可以得到ways[i]种凑出
                         * 总金额i+j*denomination的方法
                         */
                        ways[i + j * denomination] += ways[i];
                        /**
                         * 扣除总金额为i+j*denomination的ways[i]种凑硬币方法
                         */
                        numWays[i + j * denomination - 1] -= ways[i];
                    }
                }
            }
            index++;
        }
        /**
         * 依次判断已有硬币凑出某个总金额的方法数是否和原题一致为numWay，如果不等，则说明不存在这样的硬币面值集合
         */
        for (int numWay : numWays) {
            if (numWay != 0) {
                return List.of();
            }
        }
        return result;
    }
}
