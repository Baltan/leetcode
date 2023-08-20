package leetcode.algorithms;

/**
 * Description: 1017. Convert to Base -2
 *
 * @author Baltan
 * @date 2023/1/30 15:22
 * @see BaseNeg2
 * @see AddNegabinary
 */
public class BaseNeg21 {
    public static void main(String[] args) {
        System.out.println(baseNeg2(2));
        System.out.println(baseNeg2(3));
        System.out.println(baseNeg2(4));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/convert-to-base-2/solutions/377501/ni-neng-kan-dong-de-javajie-fa-by-coldpepsi/"></a>
     *
     * @param n
     * @return
     */
    public static String baseNeg2(int n) {
        StringBuilder builder = new StringBuilder();

        while (n != 0) {
            int remainder = n % (-2);
            n /= -2;

            if (remainder == -1) {
                /**
                 * 将a/-2=x...-1转换成a/-2=(x+1)...1的形式，因为-2(x+1)+1=-2x-1，即商增加1，余数修改为1
                 */
                builder.append(1);
                /**
                 * 商增加1
                 */
                n++;
            } else {
                builder.append(remainder);
            }
        }
        return builder.length() == 0 ? "0" : builder.reverse().toString();
    }
}
