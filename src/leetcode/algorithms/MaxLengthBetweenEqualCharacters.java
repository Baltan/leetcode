package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1624. Largest Substring Between Two Equal Characters
 *
 * @author Baltan
 * @date 2022/10/1 15:15
 */
public class MaxLengthBetweenEqualCharacters {
    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("aa"));
        System.out.println(maxLengthBetweenEqualCharacters("abca"));
        System.out.println(maxLengthBetweenEqualCharacters("cbzxy"));
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        int result = -1;
        char[] chars = s.toCharArray();
        /**
         * positions[0]-positions[25]依次表示'a'-'z'在字符串s中第一次出现的索引位置
         */
        int[] positions = new int[26];
        Arrays.fill(positions, -1);

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = c - 'a';

            if (positions[index] != -1) {
                result = Math.max(result, i - positions[index] - 1);
            } else {
                /**
                 * 记录字符c在字符串s中第一次出现的索引位置
                 */
                positions[index] = i;
            }
        }
        return result;
    }
}
