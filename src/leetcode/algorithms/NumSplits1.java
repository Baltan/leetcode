package leetcode.algorithms;

/**
 * Description: 1525. Number of Good Ways to Split a String
 *
 * @author Baltan
 * @date 2020-07-28 22:07
 * @see NumSplits
 */
public class NumSplits1 {
    public static void main(String[] args) {
        System.out.println(numSplits("aacaba"));
        System.out.println(numSplits("abcd"));
        System.out.println(numSplits("aaaaa"));
        System.out.println(numSplits("acbadbaada"));
    }

    public static int numSplits(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        /**
         * 记录左边的子串中各个字符出现的次数
         */
        int[] leftCount = new int[26];
        /**
         * 记录右边的子串中各个字符出现的次数
         */
        int[] rightCount = new int[26];
        /**
         * 左边的子串中不同字符的个数
         */
        int leftDifference = 0;
        /**
         * 右边的子串中不同字符的个数
         */
        int rightDifference = 0;
        /**
         * 初始化左边的子串就是s本身，对子串中各个字符出现的次数进行计数
         */
        for (char c : charArray) {
            /**
             * 更新左边的子串中不同字符的个数
             */
            if (leftCount[c - 'a'] == 0) {
                leftDifference++;
            }
            leftCount[c - 'a']++;
        }
        /**
         * 逐一将s最右边的字符逐一移动到右边的子串中
         */
        for (int i = charArray.length - 1; i > 0; i--) {
            char c = charArray[i];
            /**
             * 更新右边的子串中不同字符的个数
             */
            if (rightCount[c - 'a'] == 0) {
                rightDifference++;
            }

            rightCount[c - 'a']++;
            leftCount[c - 'a']--;
            /**
             * 更新左边的子串中不同字符的个数
             */
            if (leftCount[c - 'a'] == 0) {
                leftDifference--;
            }

            if (leftDifference == rightDifference) {
                result++;
            } else if (leftDifference < rightDifference) {
                /**
                 * 如果左边的子串中的不同字符的个数少于右边的子串，直接退出循环
                 */
                break;
            }
        }
        return result;
    }
}
