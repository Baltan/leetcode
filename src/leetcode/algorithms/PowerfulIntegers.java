package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 970. Powerful Integers
 *
 * @author Baltan
 * @date 2019-03-16 23:13
 */
public class PowerfulIntegers {
    public static void main(String[] args) {
        System.out.println(powerfulIntegers(2, 3, 10));
        System.out.println(powerfulIntegers(3, 5, 15));
        System.out.println(powerfulIntegers(2, 1, 10));
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> result = new ArrayList<>();

        if (x == 1 && y == 1) {
            if (bound >= 2) {
                result.add(2);
            }
            return result;
        } else if (x == 1) {
            int yExponent = 0;

            while (true) {
                int sum = (int) (1 + Math.pow(y, yExponent));
                if (sum <= bound) {
                    result.add(sum);
                    yExponent++;
                } else {
                    return result;
                }
            }
        } else if (y == 1) {
            int xExponent = 0;

            while (true) {
                int sum = (int) (1 + Math.pow(x, xExponent));
                if (sum <= bound) {
                    result.add(sum);
                    xExponent++;
                } else {
                    return result;
                }
            }
        } else {
            int max = Math.max(x, y);
            int min = Math.min(x, y);
            int sumOfExponent = 0;
            boolean flag = false;

            while (true) {
                for (int i = 0; i <= sumOfExponent; i++) {
                    int sum = (int) (Math.pow(max, i) + Math.pow(min, sumOfExponent - i));
                    if (sum <= bound) {
                        if (!result.contains(sum)) {
                            result.add(sum);
                        }
                        flag = true;
                    }
                }
                if (!flag) {
                    return result;
                }
                flag = false;
                sumOfExponent++;
            }
        }
    }
}
