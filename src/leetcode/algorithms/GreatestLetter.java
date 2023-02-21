package leetcode.algorithms;

/**
 * Description: 2309. Greatest English Letter in Upper and Lower Case
 *
 * @author Baltan
 * @date 2023/2/16 09:41
 */
public class GreatestLetter {
    public static void main(String[] args) {
        System.out.println(greatestLetter("lEeTcOdE"));
        System.out.println(greatestLetter("arRAzFif"));
        System.out.println(greatestLetter("AbCdEfGhIjK"));
    }

    public static String greatestLetter(String s) {
        /**
         * upperCases[0]-upperCases[25]依次表示字符串s中字符A-Z是否存在
         */
        boolean[] upperCases = new boolean[26];
        /**
         * lowerCases[0]-lowerCases[25]依次表示字符串s中字符a-z是否存在
         */
        boolean[] lowerCases = new boolean[26];

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowerCases[c - 'a'] = true;
            } else {
                upperCases[c - 'A'] = true;
            }
        }
        /**
         * 按照字母表倒序遍历，判断是否某个字母的大小写都在字符串s中出现过
         */
        for (int i = 25; i >= 0; i--) {
            if (lowerCases[i] && upperCases[i]) {
                return String.valueOf((char) ('A' + i));
            }
        }
        return "";
    }
}
