package leetcode.algorithms;

/**
 * Description: 1849. Splitting a String Into Descending Consecutive Values
 *
 * @author Baltan
 * @date 2022/6/1 16:36
 */
public class SplitString {
    public static void main(String[] args) {
        System.out.println(splitString("0095749573"));
        System.out.println(splitString("94650723337775781477"));
        System.out.println(splitString("10"));
        System.out.println(splitString("43420"));
        System.out.println(splitString("1234"));
        System.out.println(splitString("050043"));
        System.out.println(splitString("9080701"));
        System.out.println(splitString("10009998"));
    }

    public static boolean splitString(String s) {
        StringBuilder builder = new StringBuilder(s);
        /**
         * 删除前导0
         */
        while (builder.length() > 0 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }

        if (builder.length() <= 1) {
            return false;
        }
        s = builder.toString();
        /**
         * 第一个数字可能的最大位数，当s长度为偶数时，最大位数可能为s长度的一半，例如：9998；当s长度为奇数时，最大位数可能为s长
         * 度的一半加1，例如：10099
         */
        int maxLength = (s.length() + 1) / 2;

        for (int i = 1; i <= maxLength; i++) {
            /**
             * 当前要在builder前缀中查找的数字
             */
            long num = 0;

            while (true) {
                if (builder.length() == s.length()) {
                    /**
                     * 暂定第一个数字的值
                     */
                    num = Long.valueOf(s.substring(0, i));
                    builder.delete(0, i);
                } else {
                    num--;
                    /**
                     * 删除前导0
                     */
                    while (builder.length() > 0 && builder.charAt(0) == '0') {
                        builder.deleteCharAt(0);
                    }
                    /**
                     * 将builder的前导0都删除后，如果builder没有其他字符了，若当前要查找的数字就是0，则直接返回true；否则当
                     * 前情况无法将字符串s拆分为递减的连续值
                     */
                    if (builder.length() == 0) {
                        if (num == 0) {
                            return true;
                        } else {
                            builder = new StringBuilder(s);
                            break;
                        }
                    }

                    String target = String.valueOf(num);
                    /**
                     * 在builder前缀中查找到num后，builder没有其他字符了，则直接返回true；否则当前情况无法将字符串s拆分为递
                     * 减的连续值
                     */
                    if (builder.indexOf(target) == 0) {
                        builder.delete(0, target.length());

                        if (builder.length() == 0) {
                            return true;
                        }
                    } else {
                        builder = new StringBuilder(s);
                        break;
                    }
                }
            }
        }
        return false;
    }
}
