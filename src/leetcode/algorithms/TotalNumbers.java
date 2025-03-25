package leetcode.algorithms;

/**
 * Description: 3483. Unique 3-Digit Even Numbers
 *
 * @author Baltan
 * @date 2025/3/25 23:45
 */
public class TotalNumbers {
    public static void main(String[] args) {
        System.out.println(totalNumbers(new int[]{1, 2, 3, 4}));
        System.out.println(totalNumbers(new int[]{0, 2, 2}));
        System.out.println(totalNumbers(new int[]{6, 6, 6}));
        System.out.println(totalNumbers(new int[]{1, 3, 5}));
    }

    public static int totalNumbers(int[] digits) {
        int result = 0;
        /**
         * isVisited[i]表示是否已得到过三位偶数i
         */
        boolean[] isVisited = new boolean[1000];
        int length = digits.length;
        /**
         * 枚举所有可以得到的三位数，三位数的从高位到低位上的三个数字依次为digits[i]、digits[j]、digits[k]
         */
        for (int i = 0; i < length; i++) {
            if (digits[i] == 0) {
                continue;
            }

            for (int j = 0; j < length; j++) {
                if (j == i) {
                    continue;
                }

                for (int k = 0; k < length; k++) {
                    if (k == i || k == j || digits[k] % 2 != 0) {
                        continue;
                    }
                    int sum = digits[i] * 100 + digits[j] * 10 + digits[k];

                    if (!isVisited[sum]) {
                        isVisited[sum] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
