package leetcode.algorithms;

/**
 * Description: 1256. Encode Number
 *
 * @author Baltan
 * @date 2019-11-17 12:07
 */
public class Encode {
    public static void main(String[] args) {
        System.out.println(encode(0));
        System.out.println(encode(1));
        System.out.println(encode(2));
        System.out.println(encode(3));
        System.out.println(encode(4));
        System.out.println(encode(5));
        System.out.println(encode(6));
        System.out.println(encode(7));
        System.out.println(encode(8));
        System.out.println(encode(9));
        System.out.println(encode(10));
        System.out.println(encode(23));
        System.out.println(encode(107));
        System.out.println(encode(1000));
        System.out.println(encode(1000000000));
    }

    public static String encode(int num) {
        if (num == 0) {
            return "";
        }
        /**
         * 观察到如下规律：
         * f(n)的长度     n的范围     m=n+2的范围
         *     0           0             2
         *     1          1-2           3-4
         *     2          3-6           5-8
         *     3          7-14          9-16
         *     4         15-30         17-32
         *     ……          ……            ……
         *
         *  如果已知n，则m=n+2，f(n)的长度为m对2取对数再向上取整，再减1
         */
        int length = (int) (Math.ceil(Math.log(num + 2) / Math.log(2)) - 1);
        /**
         * 有coun个数字加密后的加密字符串长度为length
         */
        int count = (int) Math.pow(2, length);
        /**
         * count个数字中的最小值
         */
        int min = count - 1;
        int distance = num - min;
        /**
         * 如果所求值num与min的差值不小于count/2，则num的加密字符串以"1"开头，后面跟上num-count的加密字符串；
         * 如果所求值num与min的差值小于count/2，则num的加密字符串以"0"开头，后面跟上num-count/2的加密字符串
         */
        if (distance < count / 2) {
            return "0" + encode(num - count / 2);
        } else {
            return "1" + encode(num - count);
        }
    }
}
