package leetcode.algorithms;

/**
 * Description: 592. Fraction Addition and Subtraction
 *
 * @author Baltan
 * @date 2019-07-20 11:41
 */
public class FractionAddition {
    public static void main(String[] args) {
        System.out.println(fractionAddition("-5/2+10/3+7/9"));
        System.out.println(fractionAddition("-1/2+1/2"));
        System.out.println(fractionAddition("-1/2+1/2+1/3"));
        System.out.println(fractionAddition("1/3-1/2"));
        System.out.println(fractionAddition("5/3+1/3"));
    }

    public static String fractionAddition(String expression) {
        /**
         * 最后添加一个"+"或"-"，用于循环的时候将最后一个分数也计算进结果
         */
        expression = expression + "+";
        StringBuilder aBuilder = new StringBuilder();
        StringBuilder bBuilder = new StringBuilder();
        int length = expression.length();
        int i;
        int signCount = 0;
        /**
         * 查找第一个分数
         */
        if (expression.startsWith("-")) {
            aBuilder.append("-");
            /**
             * 表达式以"-"开头，说明第一个分数是负数，从第二个字符开始遍历
             */
            for (i = 1; i < length; i++) {
                char c = expression.charAt(i);
                /**
                 * 当遍历到"+"或"-"时，说明已经到第二个分数了，可以退出循环
                 */
                if (c == '+' || c == '-') {
                    break;
                } else {
                    aBuilder.append(c);
                }
            }
        } else {
            /**
             * 表达式不以"-"开头，说明第一个分数是正数，从第一个字符开始遍历
             */
            for (i = 0; i < length; i++) {
                char c = expression.charAt(i);
                /**
                 * 当遍历到"+"或"-"时，说明已经到第二个分数了，可以退出循环
                 */
                if (c == '+' || c == '-') {
                    break;
                } else {
                    aBuilder.append(c);
                }
            }
        }
        /**
         * 查找两数相加运算的第二个分数，从查找第一个分数结束的那个字符的位置开始遍历
         */
        for (int j = i; j < length; j++) {
            char c = expression.charAt(j);

            if (c == '+' || c == '-') {
                signCount++;
                /**
                 * 开始遍历的第一个字符是"+"或"-"，因为查找第一个分数时是在这种情况下退出循环的，
                 * 当查找到第二个"+"或"-"时，说明已经到下一个分数了，可以对第一个和第二个分数求和
                 */
                if (signCount == 2) {
                    /**
                     * 将第一个和第二个分数求和的结果作为后续求和运算的第一个分数的值
                     */
                    aBuilder = new StringBuilder(add(aBuilder.toString(), bBuilder.toString()));
                    /**
                     * 第二个分数置空，用于继续查找下一个分数
                     */
                    bBuilder = new StringBuilder();
                    signCount = 0;
                    /**
                     * 退一个位置，退回到下一轮查找的分数的符号前
                     */
                    j--;
                    continue;
                }
                /**
                 * 如果当前分数带有的符号为"-"，说明是个负数，需要在字符串开头添加"-"
                 */
                if (c == '-') {
                    bBuilder.append(c);
                }
            } else {
                bBuilder.append(c);
            }
        }
        return reduction(aBuilder.toString());
    }

    /**
     * 两个字符串表示的分数进行求和运算
     */
    public static String add(String a, String b) {
        StringBuilder builder = new StringBuilder();

        if (a.startsWith("-") && b.startsWith("-")) {
            int aSeperator = a.indexOf("/");
            int bSeperator = b.indexOf("/");
            /**
             * 第一个分数的分母
             */
            int aDenominator = Integer.valueOf(a.substring(aSeperator + 1));
            /**
             * 第一个分数的分子
             */
            int aNumerator = Integer.valueOf(a.substring(1, aSeperator));
            /**
             * 第二个分数的分母
             */
            int bDenominator = Integer.valueOf(b.substring(bSeperator + 1));
            /**
             * 第二个分数的分子
             */
            int bNumerator = Integer.valueOf(b.substring(1, bSeperator));
            int cDenominator = aDenominator * bDenominator;
            int cNumerator = aDenominator * bNumerator + bDenominator * aNumerator;
            builder.append("-").append(cNumerator).append("/").append(cDenominator);
        } else if (!a.startsWith("-") && !b.startsWith("-")) {
            int aSeperator = a.indexOf("/");
            int bSeperator = b.indexOf("/");
            int aDenominator = Integer.valueOf(a.substring(aSeperator + 1));
            int aNumerator = Integer.valueOf(a.substring(0, aSeperator));
            int bDenominator = Integer.valueOf(b.substring(bSeperator + 1));
            int bNumerator = Integer.valueOf(b.substring(0, bSeperator));
            int cDenominator = aDenominator * bDenominator;
            int cNumerator = aDenominator * bNumerator + bDenominator * aNumerator;
            builder.append(cNumerator).append("/").append(cDenominator);
        } else if (a.startsWith("-") && !b.startsWith("-")) {
            int aSeperator = a.indexOf("/");
            int bSeperator = b.indexOf("/");
            int aDenominator = Integer.valueOf(a.substring(aSeperator + 1));
            int aNumerator = Integer.valueOf(a.substring(1, aSeperator));
            int bDenominator = Integer.valueOf(b.substring(bSeperator + 1));
            int bNumerator = Integer.valueOf(b.substring(0, bSeperator));
            int cDenominator = aDenominator * bDenominator;
            int cNumerator = aDenominator * bNumerator - bDenominator * aNumerator;
            builder.append(cNumerator).append("/").append(cDenominator);
        } else {
            int aSeperator = a.indexOf("/");
            int bSeperator = b.indexOf("/");
            int aDenominator = Integer.valueOf(a.substring(aSeperator + 1));
            int aNumerator = Integer.valueOf(a.substring(0, aSeperator));
            int bDenominator = Integer.valueOf(b.substring(bSeperator + 1));
            int bNumerator = Integer.valueOf(b.substring(1, bSeperator));
            int cDenominator = aDenominator * bDenominator;
            int cNumerator = bDenominator * aNumerator - aDenominator * bNumerator;
            builder.append(cNumerator).append("/").append(cDenominator);
        }
        return builder.toString();
    }

    /**
     * 对字符串表示的分数进行约分
     */
    public static String reduction(String a) {
        StringBuilder builder;
        int aSeperator = a.indexOf("/");
        /**
         * 分母
         */
        int aDenominator;
        /**
         * 分子
         */
        int aNumerator;

        if (a.startsWith("-")) {
            /**
             * 如果当前分数已符号"-"开头，说明是个负数，需要在字符串开头添加"-"
             */
            builder = new StringBuilder("-");
            aDenominator = Integer.valueOf(a.substring(aSeperator + 1));
            /**
             * 分子取正数，所以负数从第二哥字符开始取
             */
            aNumerator = Integer.valueOf(a.substring(1, aSeperator));
        } else {
            builder = new StringBuilder();
            aDenominator = Integer.valueOf(a.substring(aSeperator + 1));
            aNumerator = Integer.valueOf(a.substring(0, aSeperator));
        }
        /**
         * 如果分数值为0，按照题意返回"0/1"
         */
        if (aNumerator == 0) {
            return "0/1";
        } else if (aNumerator % aDenominator == 0) {
            builder.append(aNumerator / aDenominator).append("/1");
        } else if (aDenominator % aNumerator == 0) {
            builder.append("1/").append(aDenominator / aNumerator);
        } else {
            /**
             * 求分子和分母的最大公约数，辗转相减法
             */
            int max = Math.max(aNumerator, aDenominator);
            int min = Math.min(aNumerator, aDenominator);
            int difference = max - min;

            while (difference != min) {
                max = Math.max(min, difference);
                min = Math.min(min, difference);
                difference = max - min;
            }
            builder.append(aNumerator / min).append("/").append(aDenominator / min);
        }
        return builder.toString();
    }
}
