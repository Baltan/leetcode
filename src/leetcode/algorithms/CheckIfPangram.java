package leetcode.algorithms;

/**
 * Description: 1832. Check if the Sentence Is Pangram
 *
 * @author Baltan
 * @date 2022/6/13 09:12
 */
public class CheckIfPangram {
    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(checkIfPangram("leetcode"));
    }

    public static boolean checkIfPangram(String sentence) {
        /**
         * flags[0]-flags[25]依次表示小写字母'a'-'z'是否在sentence中出现过
         */
        boolean[] flags = new boolean[26];

        for (char c : sentence.toCharArray()) {
            flags[c - 'a'] = true;
        }
        /**
         * 判断是否有小写字母未在sentence中出现过
         */
        for (boolean flag : flags) {
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
