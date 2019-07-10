package leetcode.algorithms;

/**
 * Description: 402. Remove K Digits
 *
 * @author Baltan
 * @date 2019-07-10 10:12
 */
public class RemoveKdigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 2));
        System.out.println(removeKdigits("10", 1));
        System.out.println(removeKdigits("100", 1));
    }

    public static String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();
        int length = num.length();
        int restLength = length - k;
        int startIndex = 0;

        for (int i = 0; i < restLength; i++) {
            char min = num.charAt(startIndex);
            int minIndex = startIndex;
            /**
             * 上一轮原数字中取数的后一个位置开始，到原数字第k+i个位置中最小的数字就是新数字的第i个数字
             *
             * 例如：原数字：1432219，删除3个数字，新数字长度为4
             * 新数字第一个数字：1、4、3、2中选择1，索引位置是0
             * 新数字第二个数字：4、3、2、2中选择2，索引位置是3
             * 新数字第三个数字：2、1中选择1，索引位置是5
             * 新数字第四个数字：9中选择9，索引位置是6
             *
             */
            for (int j = startIndex; j <= k + i; j++) {
                if (num.charAt(j) < min) {
                    min = num.charAt(j);
                    minIndex = j;
                }
            }

            builder.append(min);
            startIndex = minIndex + 1;
        }

        /**
         * 删除新数字的前导0，找到新数字中第一个不为0的数字的索引，如果没找到，返回"0"
         */
        int start = -1;

        for (int i = 0; i < restLength; i++) {
            if (builder.charAt(i) != '0') {
                start = i;
                break;
            }
        }

        if (start == -1) {
            return "0";
        } else {
            return builder.substring(start);
        }
    }
}
