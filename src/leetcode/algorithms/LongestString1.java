package leetcode.algorithms;

/**
 * Description: 2745. Construct the Longest New String
 *
 * @author Baltan
 * @date 2023/6/25 23:27
 * @see LongestString
 */
public class LongestString1 {
    public static void main(String[] args) {
        System.out.println(longestString(10, 27, 43));
        System.out.println(longestString(2, 5, 1));
        System.out.println(longestString(3, 2, 2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/construct-the-longest-new-string/solutions/2319365/liang-chong-fang-fa-o1-gong-shi-ji-yi-hu-7fdi/"></a>
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public static int longestString(int x, int y, int z) {
        /**
         * 每个"AA"后面只能是"BB"，每个"BB"前面只能是"AA"，所以"AA"和"BB"在新字符串中必定要交替出现，则：
         * 1、如果"AA"和"BB"个数相同，则可以构成字符串"AABBAABB……AABB"，最后将所有"AB"相连放在头部或尾部即可
         * 2、如果"AA"和"BB"个数不同，则可以构成字符串"AABBAABB……AA"或"BBAABBAA……BB"，最后将所有"AB"相连放在前者头部或后者尾部即可
         */
        return ((x == y ? x + y : (Math.min(x, y) << 1) + 1) + z) << 1;
    }
}
