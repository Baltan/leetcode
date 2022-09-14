package leetcode.algorithms;

/**
 * Description: 1668. Maximum Repeating Substring
 *
 * @author Baltan
 * @date 2022/9/6 09:59
 */
public class MaxRepeating {
    public static void main(String[] args) {
        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
        System.out.println(maxRepeating("ababc", "ab"));
        System.out.println(maxRepeating("ababc", "ba"));
        System.out.println(maxRepeating("ababc", "ac"));
        System.out.println(maxRepeating("ababab", "ab"));
        System.out.println(maxRepeating("aaaaaa", "a"));
        System.out.println(maxRepeating("b", "b"));
    }

    public static int maxRepeating(String sequence, String word) {
        int result = 0;
        String repeatedWord = word;
        /**
         * 判断word重复若干次拼接在一起的子串在sequence中是否存在
         */
        while (sequence.contains(repeatedWord)) {
            result++;
            repeatedWord = repeatedWord.concat(word);
        }
        return result;
    }
}
