package leetcode.algorithms;

/**
 * Description: 1881. Maximum Value after Insertion
 *
 * @author Baltan
 * @date 2022/5/1 11:24
 */
public class MaxValue {
    public static void main(String[] args) {
        System.out.println(maxValue("99", 9));
        System.out.println(maxValue("-13", 2));
    }

    public static String maxValue(String n, int x) {
        /**
         * 要插入数字x的字符表示，即'x'
         */
        char insert = (char) (x + '0');
        int length = n.length();
        /**
         * n中要插入x的索引位置
         */
        int j = -1;

        if (n.charAt(0) == '-') {
            /**
             * 如果n是负数，从左向右遍历n找到第一个大于x的数字的索引，在这个索引之前插入x即可
             */
            for (int i = 1; i < length; i++) {
                if (n.charAt(i) > insert) {
                    j = i;
                    break;
                }
            }
        } else {
            /**
             * 如果n是正数，从左向右遍历n找到第一个小于x的数字的索引，在这个索引之前插入x即可
             */
            for (int i = 0; i < length; i++) {
                if (n.charAt(i) < insert) {
                    j = i;
                    break;
                }
            }
        }
        /**
         * 如果在遍历n的过程中没有找到符合条件的数字，将x加到n的末尾
         */
        return j == -1 ? n + x : n.substring(0, j) + x + n.substring(j);
    }
}
