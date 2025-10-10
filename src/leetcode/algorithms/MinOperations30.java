package leetcode.algorithms;

/**
 * Description: 3675. Minimum Operations to Transform String
 *
 * @author baltan
 * @date 2025/10/10 14:08
 */
public class MinOperations30 {
    public static void main(String[] args) {
        System.out.println(minOperations("yz"));
        System.out.println(minOperations("a"));
    }

    public static int minOperations(String s) {
        int result = 0;
        /**
         * isVisited[0]-isVisited[25]表示是否已计算过将字符a-z转换为字符a的情况
         */
        boolean[] isVisited = new boolean[26];

        for (char c : s.toCharArray()) {
            /**
             * 字符a不需要操作
             */
            if (c == 'a') {
                continue;
            }
            int index = c - 'a';

            if (!isVisited[index]) {
                /**
                 * 将当前字符转换为字符a需要的操作次数为'a'-c+26
                 */
                result = Math.max(result, 'a' + 26 - c);
                isVisited[index] = true;
            }
        }
        return result;
    }
}
