package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2262. Total Appeal of A String
 *
 * @author Baltan
 * @date 2022/5/6 22:02
 */
public class AppealSum {
    public static void main(String[] args) {
        System.out.println(appealSum("abbca"));
        System.out.println(appealSum("code"));
    }

    public static long appealSum(String s) {
        long result = 0L;
        int length = s.length();
        /**
         * 字符串由小写字母构成，一共可能存在26种字符
         */
        int letterCount = 26;
        /**
         * letterIndexes[0]-letterIndexes[25]分别按顺序保存字符串s中小写字母a-z出现的索引位置
         */
        List<Integer>[] letterIndexes = new List[letterCount];

        for (int i = 0; i < letterCount; i++) {
            letterIndexes[i] = new ArrayList<>();
        }
        /**
         * 保存字符串s中每个字符出现的索引位置
         */
        for (int i = 0; i < length; i++) {
            letterIndexes[s.charAt(i) - 'a'].add(i);
        }

        for (int i = 0; i < letterCount; i++) {
            List<Integer> indexes = letterIndexes[i];

            if (indexes.size() == 0) {
                continue;
            }

            for (int j = 0; j < indexes.size(); j++) {
                /**
                 * 当前字符在字符串s中的索引位置
                 */
                int currIndex = indexes.get(j);

                if (j == 0) {
                    /**
                     * 对于第一次在字符串s中出现的字符而言，它的左侧最少可以选择追加0个字符，最多可以追加currIndex个字符，共
                     * currIndex+1种可能，右侧最少可以选择追加0个字符，最多可以追加length-currIndex-1个字符，共
                     * length-currIndex种可能，所以包含当前字符的子串共(currIndex+1)*(length-currIndex)种可能
                     */
                    result += 1L * (currIndex + 1) * (length - currIndex);
                } else {
                    /**
                     * 和当前字符相同的字符上一次在字符串s中出现的索引位置
                     */
                    int prevIndex = indexes.get(j - 1);
                    /**
                     * 对于非第一次在字符串s中出现的字符而言，它的左侧最少可以选择追加0个字符，最多可以追加
                     * currIndex-prevIndex-1个字符（不能包含字符s[prevIndex]，因为在上一次循环计算包含字符s[prevIndex]
                     * 的子串的时候已经计数过），共currIndex-prevIndex种可能，右侧最少可以选择追加0个字符，最多可以追加
                     * length-currIndex-1个字符，共length-currIndex种可能，所以包含当前字符的子串共
                     * (currIndex-prevIndex)*(length-currIndex)种可能
                     */
                    result += 1L * (currIndex - prevIndex) * (length - currIndex);
                }
            }
        }
        return result;
    }
}
