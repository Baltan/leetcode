package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 899. Orderly Queue
 *
 * @author Baltan
 * @date 2023/3/3 09:23
 */
public class OrderlyQueue {
    public static void main(String[] args) {
        System.out.println(orderlyQueue("cba", 1));
        System.out.println(orderlyQueue("baaca", 3));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/orderly-queue/solutions/1716417/nao-jin-ji-zhuan-wan-by-heren1229-gg97/"></a>
     *
     * @param s
     * @param k
     * @return
     */
    public static String orderlyQueue(String s, int k) {
        /**
         * 当k为1时，每次只能将首字母移动最后，最多只有length种可能，得到其中字典顺序最小的即可；当k>1时，总能够通过有限次操作将字符串s中的所
         * 有字母按照任意顺序排列，将所有字母按照升序排列即可
         */
        if (k == 1) {
            String result = s;
            int length = s.length();

            for (int i = 1; i < length; i++) {
                String ss = s.substring(i) + s.substring(0, i);

                if (ss.compareTo(result) < 0) {
                    result = ss;
                }
            }
            return result;
        } else {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        }
    }
}
