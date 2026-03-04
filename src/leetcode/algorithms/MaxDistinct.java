package leetcode.algorithms;

/**
 * Description: 3760. Maximum Substrings With Distinct Start
 *
 * @author baltan
 * @date 2026/1/27 15:46
 */
public class MaxDistinct {
    public static void main(String[] args) {
        System.out.println(maxDistinct("abab"));
        System.out.println(maxDistinct("abcd"));
        System.out.println(maxDistinct("aaaa"));
    }

    public static int maxDistinct(String s) {
        int result = 0;
        /**
         * isVisited[0]-isVisited[25]依次表示字符串s中是否包含字符a-z
         */
        boolean[] isVisited = new boolean[26];
        /**
         * 计算字符串s中不同字符的个数
         */
        for (char c : s.toCharArray()) {
            if (!isVisited[c - 'a']) {
                result++;
                isVisited[c - 'a'] = true;
            }
        }
        return result;
    }
}
