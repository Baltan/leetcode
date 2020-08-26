package leetcode.algorithms;

import java.util.*;

/**
 * Description: 17. Letter Combinations of a Phone Number
 *
 * @author Baltan
 * @date 2018/8/29 11:15
 * @see LetterCombinations
 */
public class LetterCombinations1 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("23456"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        /**
         * 保存当前可以得到的所有组合
         */
        Queue<String> queue = new LinkedList<>();
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        queue.offer("");
        dfs(result, queue, map, digits, 0);
        return result;
    }

    /**
     * 深度优先搜索查找可以得到的所有组合
     *
     * @param result
     * @param queue
     * @param map
     * @param digits
     * @param i      当前判断digits[i]这个数字
     */
    public static void dfs(List<String> result, Queue<String> queue, Map<Character, char[]> map,
                           String digits, int i) {
        /**
         * 所有的数字都遍历完，queue中剩下的所有组合就是所求结果
         */
        if (i == digits.length()) {
            result.addAll(queue);
            return;
        }

        char digit = digits.charAt(i);
        char[] chars = map.get(digit);
        int size = queue.size();
        /**
         * 将前面的数字得到的所有组合和当前数字可以得到的所有字母两两组合
         */
        for (int j = 0; j < size; j++) {
            String s = queue.poll();

            for (char c : chars) {
                queue.offer(s + c);
            }
        }
        dfs(result, queue, map, digits, i + 1);
    }
}
