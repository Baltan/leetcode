package leetcode.algorithms;

/**
 * Description: 2516. Take K of Each Character From Left and Right
 *
 * @author Baltan
 * @date 2022/12/27 10:50
 */
public class TakeCharacters {
    public static void main(String[] args) {
        System.out.println(takeCharacters("abc", 1));
        System.out.println(takeCharacters("aabaaaacaabc", 2));
        System.out.println(takeCharacters("a", 1));
    }

    public static int takeCharacters(String s, int k) {
        int result = Integer.MAX_VALUE;
        char[] chars = s.toCharArray();
        /**
         * counts[0]、counts[1]、counts[2]分别表示字符串s中字符a、b、c的个数
         */
        int[] counts = new int[3];
        int length = chars.length;
        /**
         * 最终留下的子串的起始索引
         */
        int start = 0;
        /**
         * 最终留下的子串的结束索引
         */
        int end = 0;
        /**
         * reservedCounts[0]、reservedCounts[1]、reservedCounts[2]分别表示留下的子串中字符a、b、c的个数
         */
        int[] reservedCounts = new int[3];
        /**
         * 初始时假设最终留下的子串就是s.substring(0,1)
         */
        reservedCounts[chars[0] - 'a']++;
        /**
         * 计算字符串s中每种字符的个数
         */
        for (char c : chars) {
            counts[c - 'a']++;
        }

        for (int i = 0; i < 3; i++) {
            /**
             * 如果字符串s中某一种字符的个数不足k个，直接返回-1
             */
            if (counts[i] < k) {
                return -1;
            }
            /**
             * 计算最终留下的子串中当前字符的个数上限
             */
            counts[i] -= k;
        }
        /**
         * 说明字符串s中的所有字符都要被取走
         */
        if (length == 3 * k) {
            return length;
        }

        while (end < length) {
            if (reservedCounts[0] <= counts[0] && reservedCounts[1] <= counts[1] && reservedCounts[2] <= counts[2]) {
                result = Math.min(result, length - (end - start + 1));
                /**
                 * 扩大子串的长度
                 */
                end++;

                if (end < length) {
                    reservedCounts[chars[end] - 'a']++;
                }
            } else {
                /**
                 * 缩小子串的长度
                 */
                reservedCounts[chars[start] - 'a']--;
                start++;
                /**
                 * 子串的起始索引不能大于结束索引，需要将结束索引也扩大
                 */
                if (start > end) {
                    end++;

                    if (end < length) {
                        reservedCounts[chars[end] - 'a']++;
                    }
                }
            }
        }
        return result;
    }
}
