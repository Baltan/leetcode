package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 984. String Without AAA or BBB
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
            /**
             * 先将"a"、"b"相间排列，得到["a","b","a","b","a","b",……,"a","b"]（共B个"b"），此时
             * 还有diff个"a"没有放到字符串中
             */
            for (int i = 0; i < B; i++) {
                list.add("a");
                list.add("b");
            }
            /**
             * 从头开始，依次将list中的"a"换成"aa"，每次替换都会多消耗一个"a"，直到数组最后或者已将
             * diff个"a"都消耗
             */
            for (int i = 0; i < B * 2 && diff > 0; i += 2) {
                list.set(i, "aa");
                diff--;
            }
            /**
             * 将list中的字符串逐一取出拼接成一个长字符串
             */
            for (int i = 0, size = list.size(); i < size; i++) {
                builder.append(list.get(i));
            }
            /**
             * 此时如果还有多余的"a"没有加入字符串，就将剩下的"a"排在字符串最后
             */
            if (diff > 0) {
                for (int i = 0; i < diff; i++) {
                    builder.append("a");
                }
            }
        } else if (A == B) {
            /**
             * 将"a"、"b"相间排列
             */
            for (int i = 0; i < A; i++) {
                builder.append("a").append("b");
            }
        } else {
            List<String> list = new ArrayList<>();
            int diff = B - A;
            /**
             * 先将"b"、"a"相间排列，得到["b","a","b","a","b","a",……,"b","a"]（共A个"a"），此时
             * 还有diff个"b"没有放到字符串中
             */
            for (int i = 0; i < A; i++) {
                list.add("b");
                list.add("a");
            }
            /**
             * 从头开始，依次将list中的"b"换成"bb"，每次替换都会多消耗一个"b"，直到数组最后或者已将
             * diff个"b"都消耗
             */
            for (int i = 0; i < A * 2 && diff > 0; i += 2) {
                list.set(i, "bb");
                diff--;
            }
            /**
             * 将list中的字符串逐一取出拼接成一个长字符串
             */
            for (int i = 0, size = list.size(); i < size; i++) {
                builder.append(list.get(i));
            }
            /**
             * 此时如果还有多余的"b"没有加入字符串，就将剩下的"b"排在字符串最后
             */
            if (diff > 0) {
                for (int i = 0; i < diff; i++) {
                    builder.append("b");
                }
            }
        }
        return builder.toString();
    }
}
