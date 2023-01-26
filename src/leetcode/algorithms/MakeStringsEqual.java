package leetcode.algorithms;

/**
 * Description: 2546. Apply Bitwise Operations to Make Strings Equal
 *
 * @author Baltan
 * @date 2023/1/23 20:55
 */
public class MakeStringsEqual {
    public static void main(String[] args) {
        System.out.println(makeStringsEqual("1010", "0110"));
        System.out.println(makeStringsEqual("11", "00"));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/apply-bitwise-operations-to-make-strings-equal/solutions/2072726/nao-jin-ji-zhuan-wan-yi-xing-dai-ma-by-e-0fce/"></a>
     *
     * @param s
     * @param target
     * @return
     */
    public static boolean makeStringsEqual(String s, String target) {
        /**
         * 1|1=1    1^1=0
         * 1|0=1    1^0=1
         * 0|1=1    0^1=1
         * 0|0=0    0^0=0
         * 假设字符串s中存在某一位s[i]为1：
         * 1、如果需要令s[j]从1变成0，则可以通过s[i]=s[i]|s[j]=1|1=1，s[j]=s[i]^s[j]=1^1=0
         * 2、如果需要令s[j]从0变成1，则可以通过s[i]=s[i]^s[j]=1|0=1，s[j]=s[i]|s[j]=1^0=1
         * 但是如果s中只有0，是不可能在s中得到1的，因为0|0=0，0^0=0，所以要是一个字符串中有1，一个字符串中没有1，就不可能实现变换
         */
        return s.contains("1") == target.contains("1");
    }
}
