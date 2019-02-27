package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Partition Labels
 *
 * @author Baltan
 * @date 2018/8/11 20:41
 */
public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("qwerty"));
        System.out.println(partitionLabels("qwertyq"));
        System.out.println(partitionLabels("a"));
    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        int length = S.length();
        int startIndex = 0;

        while (startIndex < length) {
            int[] array = getSubstringIndex(S, startIndex);
            list.add(array[1] - array[0] + 1);
            startIndex = array[1] + 1;
        }
        return list;
    }

    public static int[] getSubstringIndex(String S, int startIndex) {
        int[] array = new int[2];
        array[0] = startIndex;
        char[] sArray = S.toCharArray();
        int endIndex = S.lastIndexOf(sArray[startIndex]);
        if (startIndex == endIndex) {
            array[1] = endIndex;
            return array;
        }
        while (startIndex != endIndex) {
            startIndex++;
            int currentLetterEnd = S.lastIndexOf(sArray[startIndex]);
            if (currentLetterEnd > endIndex) {
                endIndex = currentLetterEnd;
            }
        }
        array[1] = endIndex;
        return array;
    }
}
