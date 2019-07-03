package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 386. Lexicographical Numbers
 *
 * @author Baltan
 * @date 2019-07-03 09:57
 */
public class LexicalOrder {
    public static void main(String[] args) {
        System.out.println(lexicalOrder(13));
        System.out.println(lexicalOrder(1000));
    }

    public static List<Integer> lexicalOrder(int n) {
        return help(1, 9, n);
    }

    public static List<Integer> help(int start, int end, int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (i > n) {
                return result;
            }
            result.add(i);
            result.addAll(help(i * 10, i * 10 + 9, n));
        }
        return result;
    }
}
