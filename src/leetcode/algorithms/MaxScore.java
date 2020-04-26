package leetcode.algorithms;

/**
 * Description: 1422. Maximum Score After Splitting a String
 *
 * @author Baltan
 * @date 2020-04-26 17:58
 */
public class MaxScore {
    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
        System.out.println(maxScore("00111"));
        System.out.println(maxScore("1111"));
    }

    public static int maxScore(String s) {
        int result = Integer.MIN_VALUE;
        /**
         * 当前分隔方式下的总得分
         */
        int currentScore = 0;
        int length = s.length();
        /**
         * 假设现在所有数字字符都在右子字符串中，则可以得到的分数就是s中字符"1"的个数
         */
        for (char c : s.toCharArray()) {
            if (c == '1') {
                currentScore++;
            }
        }
        /**
         * 逐一将分割字符串的指针右移，如果经过的字符是"0"，则左子字符串可以多得分，右子字符串得分不变，总得
         * 分加1；如果经过的字符是"1"，则右子字符串少得1分，左子字符串得分不变，总得分减1
         */
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == '0') {
                currentScore++;
            } else {
                currentScore--;
            }
            result = Math.max(result, currentScore);
        }
        return result;
    }
}
