package leetcode.algorithms;

/**
 * Description: 319. Bulb Switcher
 *
 * @author Baltan
 * @date 2019-06-21 09:25
 * @see BulbSwitch1
 * @see FlipLights
 * @see NumTimesAllBlue
 * @see MinFlips1
 */
public class BulbSwitch {
    public static void main(String[] args) {
        System.out.println(bulbSwitch(1));
        System.out.println(bulbSwitch(2));
        System.out.println(bulbSwitch(3));
        System.out.println(bulbSwitch(4));
        System.out.println(bulbSwitch(5));
        System.out.println(bulbSwitch(6));
        System.out.println(bulbSwitch(7));
        System.out.println(bulbSwitch(8));
        System.out.println(bulbSwitch(9));
        System.out.println(bulbSwitch(100));
        System.out.println(bulbSwitch(1000));
    }

    public static int bulbSwitch(int n) {
        int result = 0;
        int i = 1;
        /**
         * 根据题意，第1轮所有编号为1的倍数的灯泡会被开关一次，第2轮所有编号为2的倍数的灯泡会被开关一次，第3轮所有
         * 编号为3的倍数的灯泡会被开关一次，以此类推，第n轮所有编号为n的倍数的灯泡会被开关一次。所以对于某个灯泡的
         * 编号m，如果它在[1,n]有k个因数，则它会被开关k次。最后开着的灯泡都被开关了奇数次，即灯泡的编号有奇数个因
         * 数，则这些编号一定是平方数，所以求[1,n]中平方数的个数即可
         */
        while (i * i <= n) {
            result++;
            i++;
        }
        return result;
    }
}
