package leetcode.algorithms;

/**
 * Description: 3029. Minimum Time to Revert Word to Initial State I
 *
 * @author Baltan
 * @date 2024/2/8 15:41
 */
public class MinimumTimeToInitialState {
    public static void main(String[] args) {
        System.out.println(minimumTimeToInitialState("abacaba", 3));
        System.out.println(minimumTimeToInitialState("abacaba", 4));
        System.out.println(minimumTimeToInitialState("abcbabcd", 2));
    }

    public static int minimumTimeToInitialState(String word, int k) {
        /**
         * 操作时间大于0，说明至少需要操作一次，直接从word[k]开始操作
         */
        int result = 1;
        char[] charArray = word.toCharArray();
        /**
         * 依次判断字符串word的后缀子串word.substring(k)是否匹配word的前缀子串
         */
        outer:
        for (int i = k; i < charArray.length; i += k) {
            for (int j = i; j < charArray.length; j++) {
                if (charArray[j] != charArray[j - i]) {
                    result++;
                    continue outer;
                }
            }
            break;
        }
        return result;
    }
}
