package leetcode.algorithms;

/**
 * Description: 1915. Number of Wonderful Substrings
 *
 * @author Baltan
 * @date 2023/1/28 19:31
 */
public class WonderfulSubstrings {
    public static void main(String[] args) {
        System.out.println(wonderfulSubstrings("aba"));
        System.out.println(wonderfulSubstrings("aabb"));
        System.out.println(wonderfulSubstrings("he"));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/number-of-wonderful-substrings/solutions/847067/lc-contest_247-zui-mei-zi-fu-chuan-xiang-qc61/"></a>
     *
     * @param word
     * @return
     */
    public static long wonderfulSubstrings(String word) {
        long result = 0L;
        /**
         * 根据题意，字符串word由'a'-'j'共10种字符构成，用一个值为0bxxxxxxxxxx的十位二进制数mask表示一个子串中各个字母出现的奇偶性情况，其
         * 中mask由低到高每一位为1依次代表'a'-'j'在子串中出现奇数次，为0依次代表'a'-'j'在子串中出现偶数次，则mask共有2^10=1024种可能，
         * counts[i]表示字符串word的前缀子串中mask十进制值为i的情况的数量
         */
        int[] counts = new int[1024];
        /**
         * 字符串word前缀子串的mask值
         */
        int prefixMask = 0;
        /**
         * 初始化子串为空字符串的情况，即'a'-'j'每个字符都出现了0次，mask为0b0000000000
         */
        counts[0] = 1;

        for (char c : word.toCharArray()) {
            /**
             * 字符串word当前缀子串的mask值。因为前缀子串多加了一个字符c，所以子串中字符c的数量奇偶性发生了变化，其他字符不变，所以mask中只有
             * 从低到高的第c-'a'位（0-based）要取反，其他位不变，而根据按位异或运算：0^0=0，1^0=1，0^1=1，1^1=0，刚好其他位与0异或运算值
             * 不变，第c-'a'位与1异或运算值取反
             */
            prefixMask ^= 1 << (c - 'a');
            /**
             * 如果之前已经有某个前缀子串word.substring(0,x)的mask值为prefixMask，当前前缀子串word.substring(0,y)的mask值也为
             * prefixMask，则子串word.substring(x,y)中的每个字符一定都出现了偶数次，这个子串是个最美子串。也就是说之前有多少个mask值为
             * prefixMask的前缀子串，就有多少个对应的最美子串
             */
            result += counts[prefixMask];
            /**
             * 查找只有一个字符出现奇数次的最美子串，考虑'a'-'j'每一种字符的情况
             */
            for (int i = 0; i < 10; i++) {
                /**
                 * 假如某个前缀子串word.substring(0,x)的mask值为m，当前前缀子串word.substring(0,y)的mask值prefixMask，如果xor=
                 * m^prefixMask的结果中只有一位为1，其余位都为0，说明两个前缀子串中只有xor为1的那一位对应的字符奇偶性不同，则子串
                 * word.substring(x,y)中只有这个奇偶性不同的字符出现过奇数次，此时word.substring(x,y)就是个最美子串。于是有多少个mask
                 * 值为m的前缀子串，就有多少个对应的最美子串。而根据异或运算的性质，因为m^prefixMask=(1<<i)，所以m=prefixMask^(1<<i)
                 */
                result += counts[prefixMask ^ (1 << i)];
            }
            /**
             * 当前子串使得mask为prefixMask的前缀子串个数增加一个
             */
            counts[prefixMask]++;
        }
        return result;
    }
}
