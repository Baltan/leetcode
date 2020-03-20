package leetcode.interview;

/**
 * Description: 面试题 16.07. 最大数值
 *
 * @author Baltan
 * @date 2020-03-20 14:38
 */
public class Maximum {
    public static void main(String[] args) {
        System.out.println(maximum(1, 2));
        System.out.println(maximum(8, 4));
        System.out.println(maximum(2147483647, -2147483648));
    }

    public static int maximum(int a, int b) {
        /**
         * a-b可能会大于Integer.MAX_VALUE，所有要用长整形保存差值
         */
        long difference = 0L + a - b;
        /**
         * 对差值进行无符号右移得到最高位数字，最高位为1，说明差值为负数，则b较大，反之则a较大
         */
        return (difference >>> 63) == 1 ? b : a;
    }
}
