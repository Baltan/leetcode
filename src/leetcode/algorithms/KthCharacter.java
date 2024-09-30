package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 3304. Find the K-th Character in String Game I
 *
 * @author baltan
 * @date 2024/9/30 19:21
 */
public class KthCharacter {
    public static void main(String[] args) {
        System.out.println(kthCharacter(5));
        System.out.println(kthCharacter(10));
    }

    public static char kthCharacter(int k) {
        List<Integer> values = new ArrayList<>();
        values.add(0);
        /**
         * 模拟追加字符，直到字符串的长度不小于k为止
         */
        while (values.size() < k) {
            List<Integer> append = new ArrayList<>(values.size());

            for (int value : values) {
                append.add(value == 25 ? 0 : value + 1);
            }
            values.addAll(append);
        }
        return (char) (values.get(k - 1) + 'a');
    }
}
