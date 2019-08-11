package leetcode.algorithms;

/**
 * Description: 738. Monotone Increasing Digits
 *
 * @author Baltan
 * @date 2019-08-11 18:07
 */
public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(10));
        System.out.println(monotoneIncreasingDigits(1234));
        System.out.println(monotoneIncreasingDigits(332));
        System.out.println(monotoneIncreasingDigits(656354347));
        System.out.println(monotoneIncreasingDigits(987654321));
        System.out.println(monotoneIncreasingDigits(1093892));
        System.out.println(monotoneIncreasingDigits(7162100));
        System.out.println(monotoneIncreasingDigits(10010013));
        System.out.println(monotoneIncreasingDigits(13572468));
        System.out.println(monotoneIncreasingDigits(12340));
        System.out.println(monotoneIncreasingDigits(123456789));
        System.out.println(monotoneIncreasingDigits(668841));
    }

    public static int monotoneIncreasingDigits(int N) {
        StringBuilder builder = new StringBuilder();
        String nString = String.valueOf(N);
        int length = nString.length();
        int i;

        for (i = 0; i < length; i++) {
            /**
             * 如果当前字符不大于下一个字符，直接追加当前字符
             */
            if (i == length - 1 || nString.charAt(i) <= nString.charAt(i + 1)) {
                builder.append(nString.charAt(i));
            } else {
                /**
                 * 如果当前字符大于下一个字符，追加当前字符后，后面追加的字符不能小于当前字符，那么获得的数字必然大于原数字N，
                 * 需要对当前追加后的字符以及前面的部分字符进行调整
                 */
                builder.append(nString.charAt(i));
                /**
                 * 如果此时builder已经有字符存在（即i>0），从索引i开始向前查找，直到找到某个索引index处，
                 * index处的数字大于index-1处的数字，此时i即为最终确定的index
                 */
                while (i > 0 && nString.charAt(i - 1) == nString.charAt(i)) {
                    i--;
                }
                /**
                 * 如果此时builder已经有字符存在（即i>0），将i处的数字减1，并删除i后的所有字符
                 * 例如：原数字N=13332 builder="1333"时，向前推得要修改的索引i=1，将i处的"3"修改为"2"，并删除后面的数字，
                 * 从而，builder="12"
                 */
                if (builder.length() > 0) {
                    char iChar = builder.charAt(i);
                    builder.delete(i, builder.length());
                    builder.append(iChar - '0' - 1);
                }
                break;
            }
        }
        /**
         * 如果还有剩余的字符没有追加，全都追加"9"，例如：以上builder="12999"
         */
        for (int j = i + 1; j < length; j++) {
            builder.append(9);
        }
        return Integer.valueOf(builder.toString());
    }
}
