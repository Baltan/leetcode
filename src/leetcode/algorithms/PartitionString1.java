package leetcode.algorithms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Description: 3597. Partition String
 *
 * @author baltan
 * @date 2025/7/23 17:46
 */
public class PartitionString1 {
    public static void main(String[] args) {
        System.out.println(partitionString("abbccccd"));
        System.out.println(partitionString("aaaa"));
    }

    public static List<String> partitionString(String s) {
        /**
         * 按顺序去重保存截取到的子串
         */
        LinkedHashSet<String> result = new LinkedHashSet<>();
        StringBuilder builder = new StringBuilder();

        for (char c : s.toCharArray()) {
            builder.append(c);
            String substring = builder.toString();

            if (!result.contains(substring)) {
                result.add(substring);
                builder = new StringBuilder();
            }
        }
        return new ArrayList<>(result);
    }
}
