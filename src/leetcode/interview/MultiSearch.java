package leetcode.interview;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 面试题 17.17. 多次搜索
 *
 * @author Baltan
 * @date 2022/1/6 17:09
 */
public class MultiSearch {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(
                multiSearch("mississippi", new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"}));
        OutputUtils.print2DIntegerArray(
                multiSearch("abc", new String[]{""}));
    }

    public static int[][] multiSearch(String big, String[] smalls) {
        int[][] result = new int[smalls.length][];

        for (int i = 0; i < smalls.length; i++) {
            String small = smalls[i];

            if (small.length() == 0) {
                result[i] = new int[0];
                continue;
            }

            int maxStartIndex = big.length() - small.length();
            List<Integer> positionList = new ArrayList<>();

            for (int j = 0; j <= maxStartIndex; j++) {
                if (match(small, big, j)) {
                    positionList.add(j);
                }
            }

            int[] positionArray = new int[positionList.size()];

            for (int j = 0; j < positionList.size(); j++) {
                positionArray[j] = positionList.get(j);
            }
            result[i] = positionArray;
        }
        return result;
    }

    /**
     * 判断字符串big从索引startIndex开始的子串是否以子串small开头
     *
     * @param small
     * @param big
     * @param startIndex
     * @return
     */
    public static boolean match(String small, String big, int startIndex) {
        int length = small.length();

        for (int i = 0; i < length; i++) {
            if (small.charAt(i) != big.charAt(i + startIndex)) {
                return false;
            }
        }
        return true;
    }
}
