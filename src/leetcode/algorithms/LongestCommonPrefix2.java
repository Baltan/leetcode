package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3598. Longest Common Prefix Between Adjacent Strings After Removals
 *
 * @author baltan
 * @date 2025/7/24 11:25
 */
public class LongestCommonPrefix2 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(longestCommonPrefix(new String[]{"jump", "run", "run", "jump", "run"}));
        OutputUtils.print1DIntegerArray(longestCommonPrefix(new String[]{"dog", "racer", "car"}));
    }

    public static int[] longestCommonPrefix(String[] words) {
        int[] result = new int[words.length];
        /**
         * commonPrefixLengths[0][i]表示words[i]和words[i+1]的最长公共前缀，commonPrefixLengths[1][i]表示words[i]和words[i+2]
         * 的最长公共前缀
         */
        int[][] commonPrefixLengths = new int[2][words.length];
        /**
         * 数组words中相邻字符串最大的公共前缀长度
         */
        int first = 0;
        /**
         * 数组words中相邻字符串公共前缀长度为first的字符串对的数量
         */
        int firstCount = 0;
        /**
         * 数组words中相邻字符串第二大的公共前缀长度
         */
        int second = 0;
        /**
         * 数组words中相邻字符串公共前缀长度为second的字符串对的数量
         */
        int secondCount = 0;
        /**
         * 数组words中相邻字符串第三大的公共前缀长度
         */
        int third = 0;
        /**
         * 数组words中相邻字符串公共前缀长度为third的字符串对的数量
         */
        int thirdCount = 0;

        for (int i = 0; i < words.length; i++) {
            /**
             * 比较字符串words[i]的第index个字符和words[i+1]或words[i+2]的第index个字符是否相同
             */
            int index = 0;
            /**
             * 是否需要继续计算字符串words[i]和words[i+1]的公共前缀
             */
            boolean next = true;
            /**
             * 是否需要继续计算字符串words[i]和words[i+2]的公共前缀
             */
            boolean nextNext = true;

            while (index < words[i].length()) {
                /**
                 * 当字符words[i][index]和words[i+1][index]都存在且相同时，将字符串words[i]和words[i+1]的公共前缀长度加1
                 */
                if (next && i + 1 < words.length && index < words[i + 1].length() && words[i + 1].charAt(index) == words[i].charAt(index)) {
                    commonPrefixLengths[0][i]++;
                } else {
                    next = false;
                }
                /**
                 * 当字符words[i][index]和words[i+2][index]都存在且相同时，将字符串words[i]和words[i+2]的公共前缀长度加1
                 */
                if (nextNext && i + 2 < words.length && index < words[i + 2].length() && words[i + 2].charAt(index) == words[i].charAt(index)) {
                    commonPrefixLengths[1][i]++;
                } else {
                    nextNext = false;
                }
                index++;
            }
        }
        /**
         * 计算数组words中相邻字符串最大的、第二大的、第三大的公共前缀长度，以及这些长度的公共前缀出现的次数
         */
        for (int commonPrefixLength : commonPrefixLengths[0]) {
            if (commonPrefixLength > first) {
                third = second;
                thirdCount = secondCount;
                second = first;
                secondCount = firstCount;
                first = commonPrefixLength;
                firstCount = 1;
            } else if (commonPrefixLength == first) {
                firstCount++;
            } else if (commonPrefixLength > second) {
                third = second;
                thirdCount = secondCount;
                second = commonPrefixLength;
                secondCount = 1;
            } else if (commonPrefixLength == second) {
                secondCount++;
            } else if (commonPrefixLength > third) {
                third = commonPrefixLength;
                thirdCount = 1;
            } else if (commonPrefixLength == third) {
                thirdCount++;
            }
        }

        for (int i = 0; i < words.length; i++) {
            int firstCopy = first;
            int firstCountCopy = firstCount;
            int secondCopy = second;
            int secondCountCopy = secondCount;
            int thirdCopy = third;
            int thirdCountCopy = thirdCount;
            /**
             * 当数组words中删除字符串words[i]后，删除字符串words[i-1]和words[i]的公共前缀的长度
             */
            if (i - 1 >= 0) {
                if (commonPrefixLengths[0][i - 1] == first) {
                    firstCountCopy--;
                } else if (commonPrefixLengths[1][i - 1] == second) {
                    secondCountCopy--;
                } else if (commonPrefixLengths[1][i - 1] == third) {
                    thirdCountCopy--;
                }
            }
            /**
             * 当数组words中删除字符串words[i]后，删除字符串words[i]和words[i+1]的公共前缀的长度
             */
            if (i + 1 < words.length) {
                if (commonPrefixLengths[0][i] == first) {
                    firstCountCopy--;
                } else if (commonPrefixLengths[1][i] == second) {
                    secondCountCopy--;
                } else if (commonPrefixLengths[1][i] == third) {
                    thirdCountCopy--;
                }
            }
            /**
             * 当数组words中删除字符串words[i]后，新增字符串words[i-1]和words[i+1]的公共前缀的长度
             */
            if (i - 1 >= 0) {
                if (commonPrefixLengths[1][i - 1] > firstCopy) {
                    thirdCopy = secondCopy;
                    thirdCountCopy = secondCountCopy;
                    secondCopy = firstCopy;
                    secondCountCopy = firstCountCopy;
                    firstCopy = commonPrefixLengths[1][i - 1];
                    firstCountCopy = 1;
                } else if (commonPrefixLengths[1][i - 1] == firstCopy) {
                    firstCountCopy++;
                } else if (commonPrefixLengths[1][i - 1] > secondCopy) {
                    thirdCopy = secondCopy;
                    thirdCountCopy = secondCountCopy;
                    secondCopy = commonPrefixLengths[1][i - 1];
                    secondCountCopy = 1;
                } else if (commonPrefixLengths[1][i - 1] == secondCopy) {
                    secondCountCopy++;
                } else if (commonPrefixLengths[1][i - 1] > thirdCopy) {
                    thirdCopy = commonPrefixLengths[1][i - 1];
                    thirdCountCopy = 1;
                } else if (commonPrefixLengths[1][i - 1] == thirdCopy) {
                    thirdCountCopy++;
                }
            }
            /**
             * 获取删除字符串words[i]后，剩余字符串中相邻字符串最大的公共前缀长度
             */
            if (firstCountCopy > 0) {
                result[i] = firstCopy;
            } else if (secondCountCopy > 0) {
                result[i] = secondCopy;
            } else if (thirdCountCopy > 0) {
                result[i] = thirdCopy;
            }
        }
        return result;
    }
}
