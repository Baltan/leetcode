package leetcode.algorithms;

/**
 * Description: 415. Add Strings
 *
 * @author Baltan
 * @date 2018/1/4 15:12
 */
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("408", "5"));
        System.out.println(addStrings("999", "1"));
        System.out.println(addStrings("999", "111"));
        System.out.println(addStrings("0", "0"));
    }

    public static String addStrings(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        /**
         * num1和num2中的较大值决定了最终和的长度，因为最高位加完后可能还有一个进位1，所以初始化和的长度为
         * Math.max(length1,length2) + 1
         */
        StringBuilder builder = new StringBuilder(Math.max(length1, length2) + 1);
        /**
         * 进位
         */
        int carry = 0;
        /**
         * 指向当前num1的第index1个数字（0-based）
         */
        int index1 = length1 - 1;
        /**
         * 指向当前num2的第index2个数字（0-based）
         */
        int index2 = length2 - 1;
        char[] charArray1 = num1.toCharArray();
        char[] charArray2 = num2.toCharArray();

        while (index1 >= 0 || index2 >= 0) {
            int sum = carry;

            if (index1 >= 0) {
                sum += charArray1[index1] - '0';
            }

            if (index2 >= 0) {
                sum += charArray2[index2] - '0';
            }
            /**
             * 判断当前位加完后是否有进位
             */
            if (sum >= 10) {
                builder.append(sum - 10);
                carry = 1;
            } else {
                builder.append(sum);
                carry = 0;
            }
            index1--;
            index2--;
        }
        /**
         * 如果最高位加完后还有一个进位1
         */
        if (carry == 1) {
            builder.append(1);
        }
        return builder.reverse().toString();
    }
}
