package leetcode.algorithms;

/**
 * Description: 2384. Largest Palindromic Number
 *
 * @author Baltan
 * @date 2023/1/3 09:12
 */
public class LargestPalindromic {
    public static void main(String[] args) {
        System.out.println(largestPalindromic("444947137"));
        System.out.println(largestPalindromic("00009"));
    }

    public static String largestPalindromic(String num) {
        StringBuilder head = new StringBuilder();
        StringBuilder tail = new StringBuilder();
        /**
         * counts[i]表示字符串num中数字字符i出现的次数
         */
        int[] counts = new int[10];
        /**
         * 回文整数是否会存在先导0
         */
        boolean leadingZero = true;

        for (char c : num.toCharArray()) {
            counts[c - '0']++;
        }
        /**
         * 先处理能在回文整数首尾对称出现的数字，将所有数字按照从大到小的顺序拼接
         */
        for (int i = 9; i > 0; i--) {
            int half = counts[i] / 2;

            if (half == 0) {
                continue;
            }
            leadingZero = false;

            for (int j = 0; j < half; j++) {
                head.append(i);
                tail.insert(0, i);
            }
            counts[i] -= half * 2;
        }
        /**
         * 如果不存在先导0，将数字0也前后对称追加到回文整数中
         */
        if (!leadingZero && counts[0] >= 2) {
            int half = counts[0] / 2;

            for (int i = 0; i < half; i++) {
                head.append(0);
                tail.insert(0, 0);
            }
            counts[0] -= half * 2;
        }
        /**
         * 再看能否在回文整数的正中间位置加入一个数字，如果可能的话，选择剩余的数字中最大的一个
         */
        for (int i = 9; i >= 0; i--) {
            if (counts[i] > 0) {
                head.append(i);
                break;
            }
        }
        return head.append(tail).toString();
    }
}
