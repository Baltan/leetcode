package leetcode.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 3211. Generate Binary Strings Without Adjacent Zeros
 *
 * @author baltan
 * @date 2024/7/12 10:20
 */
public class ValidStrings {
    public static void main(String[] args) {
        System.out.println(validStrings(3));
        System.out.println(validStrings(1));
    }

    public static List<String> validStrings(int n) {
        int length = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0");
        queue.offer("1");

        while (length < n) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                /**
                 * 为了保证连续的两个字符中至少有一个"1"，则字符"0"后面可以追加"1"，字符"1"后面可以追加"0"和"1"
                 */
                if (s.charAt(0) == '0') {
                    queue.offer("1" + s);
                } else {
                    queue.offer("0" + s);
                    queue.offer("1" + s);
                }
            }
            length++;
        }
        return new ArrayList<>(queue);
    }
}
