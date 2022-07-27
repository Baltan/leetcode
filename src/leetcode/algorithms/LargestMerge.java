package leetcode.algorithms;

/**
 * Description: 1754. Largest Merge Of Two Strings
 *
 * @author Baltan
 * @date 2022/7/24 12:49
 */
public class LargestMerge {
    public static void main(String[] args) {
        System.out.println(largestMerge("cabaa", "bcaaa"));
        System.out.println(largestMerge("abcabc", "abdcaba"));
    }

    public static String largestMerge(String word1, String word2) {
        StringBuilder merge = new StringBuilder();
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();
        int length1 = charArray1.length;
        int length2 = charArray2.length;
        /**
         * 指向word1下一个可以追加到builder的最后的字符所在的索引位置
         */
        int index1 = 0;
        /**
         * 指向word2下一个可以追加到builder的最后的字符所在的索引位置
         */
        int index2 = 0;

        while (index1 < length1 && index2 < length2) {
            /**
             * 如果word1的第index1个字符和word2的第index2个字符不同，则总是选择较大的字符追加到builder的最后
             */
            if (charArray1[index1] > charArray2[index2]) {
                merge.append(charArray1[index1]);
                index1++;
            } else if (charArray1[index1] < charArray2[index2]) {
                merge.append(charArray2[index2]);
                index2++;
            } else {
                int x = index1;
                int y = index2;
                /**
                 * 从word1的第index1个字符和word2的第index2个字符开始依次逐一比较，直到某一个字符串没有字符或者两个字符串的
                 * 字符不同为止
                 */
                while (x < length1 && y < length2 && charArray1[x] == charArray2[y]) {
                    x++;
                    y++;
                }
                /**
                 * 如果两个字符串都还有字符，则将两个不同的字符中较大的字符所在的字符串的第一个字符追加到merge的最后；如果
                 * word1还有字符，则将word1的第一个字符追加到merge的最后；如果word2还有字符，则将word2的第一个字符追加到
                 * merge的最后；如果word1和word2都没有字符，则任选一个字符串的第一个字符追加到merge的最后，此处总是选择
                 * word1的第一个字符追加到merge的最后
                 */
                if (x < length1 && y < length2) {
                    if (charArray1[x] > charArray2[y]) {
                        merge.append(charArray1[index1]);
                        index1++;
                    } else {
                        merge.append(charArray2[index2]);
                        index2++;
                    }
                } else if (x < length1) {
                    merge.append(charArray1[index1]);
                    index1++;
                } else if (y < length2) {
                    merge.append(charArray2[index2]);
                    index2++;
                } else {
                    merge.append(charArray1[index1]);
                    index1++;
                }
            }
        }
        /**
         * 将word1或者word2剩余的字符都追加到merge的最后
         */
        if (index1 < length1) {
            merge.append(word1.substring(index1));
        } else {
            merge.append(word2.substring(index2));
        }
        return merge.toString();
    }
}
