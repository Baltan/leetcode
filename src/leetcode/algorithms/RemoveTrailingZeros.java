package leetcode.algorithms;

/**
 * Description: 2710. Remove Trailing Zeros From a String
 *
 * @author Baltan
 * @date 2023/5/28 20:12
 */
public class RemoveTrailingZeros {
    public static void main(String[] args) {
        System.out.println(removeTrailingZeros("51230100"));
        System.out.println(removeTrailingZeros("123"));
    }

    public static String removeTrailingZeros(String num) {
        int index = num.length() - 1;
        /**
         * 找到数字num中最低位的非0的数字
         */
        while (num.charAt(index) == '0') {
            index--;
        }
        return num.substring(0, index + 1);
    }
}
