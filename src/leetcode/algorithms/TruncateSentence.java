package leetcode.algorithms;

/**
 * Description: 1816. Truncate Sentence
 *
 * @author Baltan
 * @date 2022/6/21 16:36
 */
public class TruncateSentence {
    public static void main(String[] args) {
        System.out.println(truncateSentence("Hello how are you Contestant", 4));
        System.out.println(truncateSentence("What is the solution to this problem", 4));
        System.out.println(truncateSentence("chopper is not a tanuki", 5));
    }

    public static String truncateSentence(String s, int k) {
        StringBuilder builder = new StringBuilder(s.length());
        /**
         * 截断后的句子中包含k个单词，即包含k-1个空格
         */
        int spaceCount = k - 1;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                /**
                 * 此时找到s中的第k个空格，则该空格之前的内容即为截断后的句子
                 */
                if (spaceCount == 0) {
                    break;
                }
                spaceCount--;
            }
            builder.append(c);
        }
        return builder.toString();
    }
}
