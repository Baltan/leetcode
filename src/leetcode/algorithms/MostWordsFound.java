package leetcode.algorithms;

/**
 * Description: 2114. Maximum Number of Words Found in Sentences
 *
 * @author Baltan
 * @date 2021/12/28 22:53
 */
public class MostWordsFound {
    public static void main(String[] args) {
        System.out.println(mostWordsFound(new String[]{"alice and bob love leetcode", "i think so too",
                "this is great thanks very much"}));
        System.out.println(
                mostWordsFound(new String[]{"please wait", "continue to fight", "continue to win"}));
    }

    public static int mostWordsFound(String[] sentences) {
        int result = 0;

        for (String sentence : sentences) {
            /**
             * 句子中空格的个数
             */
            int spaceCount = 0;

            for (char c : sentence.toCharArray()) {
                if (c == ' ') {
                    spaceCount++;
                }
            }
            /**
             * 句子中单词的个数比空格的个数多一个
             */
            result = Math.max(result, spaceCount + 1);
        }
        return result;
    }
}
