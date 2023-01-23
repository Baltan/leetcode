package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2284. Sender With Largest Word Count
 *
 * @author Baltan
 * @date 2023/1/22 15:38
 */
public class LargestWordCount {
    public static void main(String[] args) {
        System.out.println(largestWordCount(new String[]{"Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree"}, new String[]{"Alice", "userTwo", "userThree", "Alice"}));
        System.out.println(largestWordCount(new String[]{"How is leetcode for everyone", "Leetcode is useful for practice"}, new String[]{"Bob", "Charlie"}));
    }

    public static String largestWordCount(String[] messages, String[] senders) {
        String result = "";
        /**
         * 最大单词数量
         */
        int maxWordCount = Integer.MIN_VALUE;
        /**
         * 发件人姓名 -> 单词数
         */
        Map<String, Integer> map = new HashMap<>();
        int length = messages.length;

        for (int i = 0; i < length; i++) {
            String sender = senders[i];
            /**
             * 信息中的空格数，单词数为空格数+1
             */
            int spaceCount = 0;

            for (char c : messages[i].toCharArray()) {
                if (c == ' ') {
                    spaceCount++;
                }
            }
            int wordCount = map.getOrDefault(sender, 0) + (spaceCount + 1);
            map.put(sender, wordCount);
            /**
             * 存在单词数更多的发件人或者单词数一样多但是姓名字段顺序更大的发件人
             */
            if (wordCount > maxWordCount || (wordCount == maxWordCount && sender.compareTo(result) > 0)) {
                result = sender;
                maxWordCount = wordCount;
            }
        }
        return result;
    }
}
