package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: String Without AAA or BBB
 *
 * @author Baltan
 * @date 2019-04-10 14:35
 */
public class StrWithout3a3b {
    public static void main(String[] args) {
        System.out.println(strWithout3a3b(1, 2));
        System.out.println(strWithout3a3b(4, 1));
        System.out.println(strWithout3a3b(1, 4));
        System.out.println(strWithout3a3b(2, 6));
    }

    public static String strWithout3a3b(int A, int B) {
        StringBuilder builder = new StringBuilder(A + B);

        if (A > B) {
            List<String> list = new ArrayList<>();
            int diff = A - B;
            for (int i = 0; i < B; i++) {
                list.add("a");
                list.add("b");
            }
            for (int i = 0; i < B * 2 && diff > 0; i += 2) {
                list.set(i, "aa");
                diff--;
            }
            for (int i = 0, size = list.size(); i < size; i++) {
                builder.append(list.get(i));
            }
            if (diff > 0) {
                for (int i = 0; i < diff; i++) {
                    builder.append("a");
                }
            }
        } else if (A == B) {
            for (int i = 0; i < A; i++) {
                builder.append("a").append("b");
            }
        } else {
            List<String> list = new ArrayList<>();
            int diff = B - A;
            for (int i = 0; i < A; i++) {
                list.add("b");
                list.add("a");
            }
            for (int i = 0; i < A * 2 && diff > 0; i += 2) {
                list.set(i, "bb");
                diff--;
            }
            for (int i = 0, size = list.size(); i < size; i++) {
                builder.append(list.get(i));
            }
            if (diff > 0) {
                for (int i = 0; i < diff; i++) {
                    builder.append("b");
                }
            }
        }
        return builder.toString();
    }
}
