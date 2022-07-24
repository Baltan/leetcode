package leetcode.algorithms;

/**
 * Description: 1759. Count Number of Homogenous Substrings
 *
 * @author Baltan
 * @date 2022/7/23 14:33
 */
public class CountHomogenous {
    public static void main(String[] args) {
        System.out.println(countHomogenous("abbcccaa"));
        System.out.println(countHomogenous("xy"));
        System.out.println(countHomogenous("zzzzz"));
    }

    public static int countHomogenous(String s) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * 在s最后多加一个一定不存在于s中的字符，为了保证循环判定可以进行到s原来的最后一个字符为止
         */
        s += ' ';
        char[] charArray = s.toCharArray();
        /**
         * 判定到的每个字符的前一个字符
         */
        char prev = ' ';
        /**
         * 连续contiguousLength个相同的字符，逐一防止出现计算数值越界的情况，要定义为长整形
         */
        long contiguousLength = 0L;

        for (char c : charArray) {
            if (c == prev) {
                contiguousLength++;
            } else {
                /**
                 * 此时找到了连续contiguousLength个相同的字符，这里面共包含contiguousLength+(contiguousLength-1)+……+
                 * 2+1个同构子字符串
                 */
                if (prev != ' ') {
                    result += contiguousLength * (contiguousLength + 1) / 2;
                }
                /**
                 * 开始查找下一段由连续相同字符构成的子串
                 */
                contiguousLength = 1;
                prev = c;
            }
        }
        return (int) (result % mod);
    }
}
