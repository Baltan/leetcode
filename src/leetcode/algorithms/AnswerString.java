package leetcode.algorithms;

/**
 * Description: 3403. Find the Lexicographically Largest String From the Box I
 *
 * @author Baltan
 * @date 2025/1/1 19:45
 */
public class AnswerString {
    public static void main(String[] args) {
        System.out.println(answerString("gh", 1));
        System.out.println(answerString("dbca", 2));
        System.out.println(answerString("gggg", 4));
    }

    public static String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        /**
         * 字符串word中字典序最大的子串第一个字符的索引值
         */
        int startIndex = 0;
        int length = word.length();
        /**
         * 因为numFriends个子串都是非空的，所以单个子串的最大长度为maxLength，此时，其余numFriends-1个子串的长度都为1
         */
        int maxLength = length - numFriends + 1;
        /**
         * 依次判断以word[i]开头的子串的字典序是否可能比以word[startIndex]开头的子串的字典序更大
         */
        for (int i = 1; i < length; i++) {
            int x = startIndex;
            int y = i;
            /**
             * 将两个子串逐个字符比较，直到某个索引上两个子串的字符不同，或者起始索引更大的以word[i]开头的子串已到达字符串word的末尾
             */
            while (y < Math.min(length, y + maxLength) && word.charAt(x) == word.charAt(y)) {
                x++;
                y++;
            }
            /**
             * 如果以word[i]开头的子串比以word[startIndex]开头的子串的字典序更大，唯一的可能就是在某个索引上以word[i]开头的子串的字符字
             * 典序更大，更新startIndex
             */
            if (y < length && word.charAt(x) < word.charAt(y)) {
                startIndex = i;
            }
        }
        return word.substring(startIndex, Math.min(length, startIndex + maxLength));
    }
}
