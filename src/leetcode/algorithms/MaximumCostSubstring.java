package leetcode.algorithms;

/**
 * Description: 2606. Find the Substring With Maximum Cost
 *
 * @author Baltan
 * @date 2023/4/2 21:12
 * @see MaxSubArray
 * @see leetcode.interview.MaxSubArray
 */
public class MaximumCostSubstring {
    public static void main(String[] args) {
        System.out.println(maximumCostSubstring("talaqlt", "tqla", new int[]{4, 3, 3, -2}));
        System.out.println(maximumCostSubstring("adaa", "d", new int[]{-1000}));
        System.out.println(maximumCostSubstring("abc", "abc", new int[]{-1, -1, -1}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/find-the-substring-with-maximum-cost/solutions/2203595/zhuan-huan-zui-da-zi-shu-zu-he-pythonjav-6it2/"></a>
     *
     * @param s
     * @param chars
     * @param vals
     * @return
     */
    public static int maximumCostSubstring(String s, String chars, int[] vals) {
        int result = 0;
        /**
         * values[0]-values[25]依次代表字符a-z的价值
         */
        int[] values = new int[26];
        /**
         * 当前子序列中所有数字的和
         */
        int temp = 0;
        /**
         * 计算不在字符串chars中的字符的价值，此处先假设所有字符都不在字符串chars中
         */
        for (int i = 0; i < 26; i++) {
            values[i] = i + 1;
        }
        /**
         * 计算在字符串chars中的字符的价值
         */
        for (int i = 0; i < vals.length; i++) {
            values[chars.charAt(i) - 'a'] = vals[i];
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            /**
             * 如果当前数字values[index]加上它前面子序列中所有数字的和大于values[index]，就继续扩展它前面的子序列，否则就从当前数字开始重
             * 新尝试扩展子序列
             */
            temp = Math.max(values[index] + temp, values[index]);
            result = Math.max(result, temp);
        }
        return result;
    }
}
