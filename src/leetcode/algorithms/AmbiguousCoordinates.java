package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Description: 816. Ambiguous Coordinates
 *
 * @author Baltan
 * @date 2020-02-19 12:34
 */
public class AmbiguousCoordinates {
    public static void main(String[] args) {
        System.out.println(ambiguousCoordinates("(123)"));
        System.out.println(ambiguousCoordinates("(00011)"));
        System.out.println(ambiguousCoordinates("(0123)"));
        System.out.println(ambiguousCoordinates("(100)"));
    }

    public static List<String> ambiguousCoordinates(String S) {
        List<String> result = new LinkedList<>();
        int length = S.length();
        /**
         * 删除S头尾的括号，保留数字部分
         */
        S = S.substring(1, length - 1);
        length -= 2;

        for (int i = 1; i < length; i++) {
            /**
             * 将S分为两部分，其中第一部分长度最短为1，最长为length-1，剩余的数字就是第二部分
             */
            String part1 = S.substring(0, i);
            String part2 = S.substring(i);
            /**
             * 保存第一部分part1可以还原成的数字
             */
            List<String> list1 = new LinkedList<>();
            /**
             * 保存第二部分part2可以还原成的数字
             */
            List<String> list2 = new LinkedList<>();
            /**
             * 1、如果part1就是"0"，则只能还原成数字0；
             * 2、如果part1头尾都是0，则不论还原成整数还是小数，一定会有多余的0，不符合题意；
             * 3、如果part1第一位是"0"，则只能还原成小数0.***；
             * 4、如果part1最后一位是"0"，则只能还原成整数***0；
             * 5、如果part1头尾都不是"0"，则既能还原成整数，也能还原成小数
             */
            if (Objects.equals(part1, "0")) {
                list1.add("0");
            } else if (part1.startsWith("0") && part1.endsWith("0")) {
                continue;
            } else if (part1.startsWith("0")) {
                list1.add("0." + part1.substring(1));
            } else if (part1.endsWith("0")) {
                list1.add(part1);
            } else {
                int length1 = part1.length();
                list1.add(part1);
                /**
                 * 还原的小数整数部分长度最短为1，最长为length1-1
                 */
                for (int j = 1; j < length1; j++) {
                    list1.add(part1.substring(0, j) + "." + part1.substring(j));
                }
            }
            /**
             * part2的处理和part1一样
             */
            if (Objects.equals(part2, "0")) {
                list2.add("0");
            } else if (part2.startsWith("0") && part2.endsWith("0")) {
                continue;
            } else if (part2.startsWith("0")) {
                list2.add("0." + part2.substring(1));
            } else if (part2.endsWith("0")) {
                list2.add(part2);
            } else {
                int length2 = part2.length();
                list2.add(part2);

                for (int j = 1; j < length2; j++) {
                    list2.add(part2.substring(0, j) + "." + part2.substring(j));
                }
            }
            /**
             * 将part1还原的数字和part2还原的数字两两组合
             */
            for (String x : list1) {
                for (String y : list2) {
                    /**
                     * 依照题意，两个数字中间逗号之后有一个空格
                     */
                    result.add("(" + x + ", " + y + ")");
                }
            }
        }
        return result;
    }
}
