package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.LinkedList;

/**
 * Description: 821. Shortest Distance to a Character
 *
 * @author Baltan
 * @date 2018/7/31 10:17
 */
public class ShortestToChar {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(shortestToChar("loveleetcode", 'e'));
        OutputUtils.print1DIntegerArray(shortestToChar("abba", 'b'));
    }

    public static int[] shortestToChar(String S, char C) {
        int length = S.length();
        int[] distanceArray = new int[length];
        LinkedList<Integer> indexList = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == C) {
                indexList.add(i);
                distanceArray[i] = 0;
            }
        }
        int cursor = 0;
        for (int i = 0; i < length; i++) {
            if (indexList.contains(i)) {
                cursor++;
                continue;
            }
            if (i < indexList.getFirst()) {
                distanceArray[i] = indexList.getFirst() - i;
            } else if (i > indexList.getLast()) {
                distanceArray[i] = i - indexList.getLast();
            } else {
                distanceArray[i] = Math.min(i - indexList.get(cursor - 1), indexList.get(cursor) - i);
            }
        }
        return distanceArray;
    }
}
