package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 3302. Find the Lexicographically Smallest Valid Sequence
 *
 * @author baltan
 * @date 2024/9/30 15:36
 */
public class ValidSequence {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(validSequence("vbcca", "abc"));
        OutputUtils.print1DIntegerArray(validSequence("bacdc", "abc"));
        OutputUtils.print1DIntegerArray(validSequence("aaaaaa", "aaabc"));
        OutputUtils.print1DIntegerArray(validSequence("abc", "ab"));
    }

    public static int[] validSequence(String word1, String word2) {
        int[] result = new int[word2.length()];
        int length1 = word1.length();
        int length2 = word2.length();
        int index1 = length1 - 1;
        int index2 = length2 - 1;
        /**
         * starts[i]表示word1的后缀子串word1.substring(starts[i])中存在一个子序列等于word2的后缀子串word2.substring(i)，初始时，
         * 假设word2的各个后缀子串在word1的后缀子串中都不存在对应的子序列
         */
        int[] starts = new int[length2];
        Arrays.fill(starts, -1);
        /**
         * 从后向前逐一计算如果在不修改任何字符，只能删除某些字符的情况下，要从word1的后缀子串中得到后缀子串word2.substring(index2)，则
         * word1的后缀子串最短是多少，即求starts[index2]的最大值。如果此时index1小于index2，即使可以通过word1的后缀子串得到word2的后缀
         * 子串，因为word1的剩余前缀子串长度小于word2的剩余前缀子串长度，无法实现对word2的剩余前缀子串中字符的匹配，所以无论如何不可能使得
         * word1的某个子序列和word2“几乎相等”，也就不需要继续计算了
         */
        while (index2 >= 0 && index1 >= index2) {
            if (word1.charAt(index1) == word2.charAt(index2)) {
                starts[index2] = index1;
                index1--;
                index2--;
            } else {
                index1--;
            }
        }
        index1 = 0;
        index2 = 0;
        /**
         * 是否还能修改一个字符
         */
        boolean changeable = true;

        while (index2 < length2) {
            /**
             * word1中已没有剩余字符可以匹配word2中剩余的字符，说明无法从word1中找到某个子序列和word2“几乎相等”，直接返回空数组
             */
            if (index1 == length1) {
                return new int[]{};
            }
            /**
             * 因为从word1中查找的子序列必须是对应的索引数组字典顺序最小，所以尽可能利用word1中索引值较小的字符来逐一匹配word2中的字符
             */
            if (word1.charAt(index1) == word2.charAt(index2)) {
                result[index2] = index1;
                index1++;
                index2++;
            } else if (changeable) {
                /**
                 * 如果word2后面没有字符需要匹配，或者word1剩余的后缀子串word1.substring(index1+1)中，可以在不修改任何字符，只能删除
                 * 某些字符的情况下找到子序列word2剩余的后缀子串word2.substring(index2+1)，则可以尽早使用唯一一次修改字符的机会，修改
                 * word1[index1]使得其匹配字符word2[index2]
                 */
                if (index2 + 1 == length2 || (index1 + 1 < length1 && starts[index2 + 1] >= index1 + 1)) {
                    changeable = false;
                    result[index2] = index1;
                    index1++;
                    index2++;
                } else {
                    /**
                     * 无法在不修改任何字符，只能删除某些字符的情况下，从word1剩余的后缀子串word1.substring(index1+1)中找到一个子序列，
                     * 等于word2剩余的后缀子串word2.substring(index2+1)，所以修改字符的机会不能在当前字符word1[index1]上使用
                     */
                    index1++;
                }
            } else {
                /**
                 * word1[index1]和word2[index2]不同，也没有修改字符的机会了
                 */
                index1++;
            }
        }
        return result;
    }
}
