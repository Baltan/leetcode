package leetcode.algorithms;

/**
 * Description: 2716. Minimize String Length
 *
 * @author Baltan
 * @date 2023/6/4 18:18
 */
public class MinimizedStringLength {
    public static void main(String[] args) {
        System.out.println(minimizedStringLength("aaabc"));
        System.out.println(minimizedStringLength("cbbd"));
        System.out.println(minimizedStringLength("dddaaa"));
    }

    public static int minimizedStringLength(String s) {
        int result = 0;
        /**
         * isVisited[0]-isVisited[25]依次表示字符a-z是否在字符串s中出现过
         */
        boolean[] isVisited = new boolean[26];

        for (char c : s.toCharArray()) {
            isVisited[c - 'a'] = true;
        }
        /**
         * 最终留下的字符串中一定不存在重复的字符，所以只需统计字符串s中不同字符的个数即可
         */
        for (boolean bool : isVisited) {
            result += bool ? 1 : 0;
        }
        return result;
    }
}
