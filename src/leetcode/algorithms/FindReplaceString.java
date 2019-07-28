package leetcode.algorithms;

import java.util.Map;
import java.util.TreeMap;

/**
 * Description: 833. Find And Replace in String
 *
 * @author Baltan
 * @date 2019-07-28 17:54
 */
public class FindReplaceString {
    public static void main(String[] args) {
        String S1 = "abcd";
        int[] indexes1 = {0, 2};
        String[] sources1 = {"a", "cd"};
        String[] targets1 = {"eee", "ffff"};
        System.out.println(findReplaceString(S1, indexes1, sources1, targets1));

        String S2 = "abcd";
        int[] indexes2 = {0, 2};
        String[] sources2 = {"ab", "ec"};
        String[] targets2 = {"eee", "ffff"};
        System.out.println(findReplaceString(S2, indexes2, sources2, targets2));
    }

    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder builder = new StringBuilder();
        int length = indexes.length;
        /**
         * map用于保存符合题意的替换操作，并且按照替换操作的索引递增排序
         */
        Map<Integer, String[]> map = new TreeMap<>();
        /**
         * 上一次替换后字符串S的索引位置
         */
        int prevIndex = 0;

        for (int i = 0; i < length; i++) {
            int index = indexes[i];
            String source = sources[i];
            String target = targets[i];
            /**
             * 将符合题意的替换操作保存到map中
             */
            if (S.substring(index).startsWith(source)) {
                map.put(index, new String[]{source, target});
            }
        }

        for (int index : map.keySet()) {
            /**
             * 上一次替换后的索引和这次替换的索引之间的字符串
             */
            builder.append(S, prevIndex, index);
            /**
             * 本次替换的新的字符串
             */
            builder.append(map.get(index)[1]);
            /**
             * 本次替换后字符串S的索引位置
             */
            prevIndex = index + map.get(index)[0].length();
        }
        /**
         * 字符串S最后一次替换完成后剩余部分的字符串
         */
        builder.append(S, prevIndex, S.length());
        return builder.toString();
    }
}
