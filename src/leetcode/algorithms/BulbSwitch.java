package leetcode.algorithms;

/**
 * Description: 319. Bulb Switcher
 *
 * @author Baltan
 * @date 2019-06-21 09:25
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

        while (i * i - 1 < n) {
            result++;
            i++;
        }
        return result;
    }
}
