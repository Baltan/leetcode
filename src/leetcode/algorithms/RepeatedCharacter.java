package leetcode.algorithms;

/**
 * Description: 2351. First Letter to Appear Twice
 *
 * @author Baltan
 * @date 2023/2/14 11:34
 */
public class RepeatedCharacter {
    public static void main(String[] args) {
        System.out.println(repeatedCharacter("abccbaacz"));
        System.out.println(repeatedCharacter("abcdd"));
    }

    public static char repeatedCharacter(String s) {
        char[] charArray = s.toCharArray();
        /**
         * isExisted[0]-isExisted[25]依次表示字符a-z已出现过
         */
        boolean[] isExisted = new boolean[26];

        for (char c : charArray) {
            if (isExisted[c - 'a']) {
                return c;
            }
            isExisted[c - 'a'] = true;
        }
        return ' ';
    }
}
