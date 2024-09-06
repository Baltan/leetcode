package leetcode.algorithms;

/**
 * Description: 3270. Find the Key of the Numbers
 *
 * @author baltan
 * @date 2024/9/6 08:57
 */
public class GenerateKey {
    public static void main(String[] args) {
        System.out.println(generateKey(282, 718, 1028));
        System.out.println(generateKey(1, 10, 1000));
        System.out.println(generateKey(987, 879, 798));
        System.out.println(generateKey(1, 2, 3));
    }

    public static int generateKey(int num1, int num2, int num3) {
        int result = 0;
        int weight = 1;

        for (int i = 0; i < 4; i++) {
            /**
             * num1、num2、num3当前数位上的最小数字
             */
            int min = Math.min(Math.min(num1 % 10, num2 % 10), num3 % 10);
            result += min * weight;
            weight *= 10;
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }
        return result;
    }
}
