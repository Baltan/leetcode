package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2564. Substring XOR Queries
 *
 * @author Baltan
 * @date 2023/2/12 13:31
 */
public class SubstringXorQueries {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(substringXorQueries("101101", new int[][]{{0, 5}, {1, 2}}));
        System.out.println("--------------------------------");
        OutputUtils.print2DIntegerArray(substringXorQueries("0101", new int[][]{{12, 8}}));
        System.out.println("--------------------------------");
        OutputUtils.print2DIntegerArray(substringXorQueries("1", new int[][]{{4, 5}}));
        System.out.println("--------------------------------");
        OutputUtils.print2DIntegerArray(substringXorQueries("11101010111", new int[][]{{4, 19}, {9, 30}, {4, 19}, {2, 853}, {4, 3}, {9, 94}, {10, 861}, {7, 18}, {8, 1887}, {0, 3}, {2, 5}, {5, 4}, {0, 87}, {2, 21}, {4, 5}, {4, 15}, {0, 7}, {5, 4}}));
    }

    public static int[][] substringXorQueries(String s, int[][] queries) {
        int[][] result = new int[queries.length][2];
        /**
         * i -> i的二进制值在字符串s中的起止位置，如果不存在则为[-1,-1]
         */
        Map<Integer, int[]> map = new HashMap<>();
        int[] nums = new int[s.length()];
        char[] charArray = s.toCharArray();
        int[] none = new int[]{-1, -1};

        for (int i = 0; i < charArray.length; i++) {
            nums[i] = charArray[i] - '0';
        }
        /**
         * 计算字符串s中的各个子串对应的十进制值
         */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (!map.containsKey(0)) {
                    map.put(0, new int[]{i, i});
                }
                continue;
            }
            int value = 1;

            if (!map.containsKey(1)) {
                map.put(1, new int[]{i, i});
            }
            /**
             * 在当前子串后面追加数字
             */
            for (int j = i + 1; j < nums.length; j++) {
                value = value * 2 + nums[j];
                /**
                 * 如果value小于0，说明此时的子串对应的十进制值已经整型溢出。根据题意，query[i]∈[0,1000000000]，所以query[0]^query[1]
                 * 的范围也不会超过Integer.MAX_VALUE，不需要继续计算
                 */
                if (value < 0) {
                    break;
                }

                if (!map.containsKey(value)) {
                    map.put(value, new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int value = queries[i][0] ^ queries[i][1];
            result[i] = map.getOrDefault(value, none);
        }
        return result;
    }
}
