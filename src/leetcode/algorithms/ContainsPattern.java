package leetcode.algorithms;

/**
 * Description: 1566. Detect Pattern of Length M Repeated K or More Times
 *
 * @author Baltan
 * @date 2022/10/23 15:46
 */
public class ContainsPattern {
    public static void main(String[] args) {
        System.out.println(containsPattern(new int[]{1, 2, 4, 4, 4, 4}, 1, 3));
        System.out.println(containsPattern(new int[]{1, 2, 1, 2, 1, 1, 1, 3}, 2, 2));
        System.out.println(containsPattern(new int[]{1, 2, 1, 2, 1, 3}, 2, 3));
        System.out.println(containsPattern(new int[]{1, 2, 3, 1, 2}, 2, 2));
        System.out.println(containsPattern(new int[]{2, 2, 2, 2}, 2, 3));
    }

    public static boolean containsPattern(int[] arr, int m, int k) {
        int length = arr.length;
        /**
         * patternStart表示模式开始的索引位置
         */
        outer:
        for (int patternStart = 0; patternStart < length; patternStart++) {
            /**
             * 数组arr的长度不够构成k个长度为m的模式，直接返回false
             */
            if (patternStart + m * k - 1 >= length) {
                return false;
            }
            /**
             * 模式结束的索引位置
             */
            int patternEnd = patternStart + m - 1;

            for (int i = patternStart; i <= patternEnd; i++) {
                /**
                 * 判断模式[patternStart,patternEnd]后面是否紧跟着k-1个同样的模式
                 */
                for (int patternIndex = 1; patternIndex < k; patternIndex++) {
                    if (arr[i + patternIndex * m] != arr[i]) {
                        continue outer;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
