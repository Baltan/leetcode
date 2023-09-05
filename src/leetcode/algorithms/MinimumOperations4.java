package leetcode.algorithms;

/**
 * Description: 2844. Minimum Operations to Make a Special Number
 *
 * @author Baltan
 * @date 2023/9/4 23:26
 */
public class MinimumOperations4 {
    public static void main(String[] args) {
        System.out.println(minimumOperations("2245047"));
        System.out.println(minimumOperations("2908305"));
        System.out.println(minimumOperations("10"));
    }

    public static int minimumOperations(String num) {
        char[] charArray = num.toCharArray();
        /**
         * 是否在字符串num中找到数字5
         */
        boolean endsWithFive = false;
        /**
         * 如果找到的特殊数字以25或75结尾，要删除的数字个数
         */
        int count1 = 0;
        /**
         * 是否在字符串num中找到数字0
         */
        boolean endsWithZero = false;
        /**
         * 如果找到的特殊数字以00或50结尾，要删除的数字个数
         */
        int count2 = 0;
        /**
         * 倒序遍历字符串num，找到尾部的最后一个子序列25或75或00或50
         */
        for (int i = charArray.length - 1; i >= 0; i--) {
            int digit = charArray[i] - '0';
            /**
             * 尾部已出现过数字2或7，可以得到一个以25或75结尾的特殊数字
             */
            if ((digit == 2 || digit == 7) && endsWithFive) {
                return count1;
            }
            /**
             * 尾部已出现过数字0或5，可以得到一个以00或50结尾的特殊数字
             */
            if ((digit == 0 || digit == 5) && endsWithZero) {
                return count2;
            }

            if (digit == 0) {
                /**
                 * 第一次找到数字0
                 */
                endsWithZero = true;
                /**
                 * 对于查找以25或75结尾的特殊数字而言，数字0需要被删除
                 */
                count1++;
            } else if (digit == 5 && !endsWithFive) {
                /**
                 * 第一次找到数字5
                 */
                endsWithFive = true;
                /**
                 * 对于查找以00或50结尾的特殊数字而言，数字5需要被删除
                 */
                count2++;
            } else {
                count1++;
                count2++;
            }
        }
        /**
         * 如果字符串num中有数字0，则可以删除除0以外的其余数字，否则将所有数字都删除后得到0
         */
        return endsWithZero ? charArray.length - 1 : charArray.length;
    }
}
