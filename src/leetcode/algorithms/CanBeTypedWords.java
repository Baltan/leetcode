package leetcode.algorithms;

/**
 * Description: 1935. Maximum Number of Words You Can Type
 *
 * @author Baltan
 * @date 2022/2/25 09:53
 */
public class CanBeTypedWords {
    public static void main(String[] args) {
        System.out.println(canBeTypedWords("hello world", "ad"));
        System.out.println(canBeTypedWords("leet code", "lt"));
        System.out.println(canBeTypedWords("leet code", "e"));
    }

    public static int canBeTypedWords(String text, String brokenLetters) {
        int result = 0;
        int letterCount = 26;
        /**
         * brokenLetterArray[0]-brokenLetterArray[25]依次表示'a'-'z'按键是否损坏
         */
        boolean[] brokenLetterArray = new boolean[letterCount];

        for (char c : brokenLetters.toCharArray()) {
            brokenLetterArray[c - 'a'] = true;
        }

        outer:
        for (String word : text.split(" ")) {
            for (char c : word.toCharArray()) {
                /**
                 * 如果单词word中某个字母不能被打印，不再继续判断当前单词的剩余字母
                 */
                if (brokenLetterArray[c - 'a']) {
                    continue outer;
                }
            }
            result++;
        }
        return result;
    }
}
