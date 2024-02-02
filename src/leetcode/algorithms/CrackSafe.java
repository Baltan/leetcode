package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 753. Cracking the Safe
 *
 * @author Baltan
 * @date 2024/2/2 22:22
 */
public class CrackSafe {
    public static void main(String[] args) {
        System.out.println(crackSafe(1, 2));
        System.out.println(crackSafe(2, 2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/cracking-the-safe/solutions/2054177/mei-you-by-jvaeyhcd-vx35/"></a>
     *
     * @param n
     * @param k
     * @return
     */
    public static String crackSafe(int n, int k) {
        StringBuilder result = new StringBuilder("0".repeat(n));
        /**
         * 所有可能的密码的数量
         */
        int total = (int) Math.pow(k, n);
        /**
         * 保存已被尝试过的密码
         */
        Set<String> isVisited = new HashSet<>();
        isVisited.add(result.toString());

        while (isVisited.size() < total) {
            /**
             * 尝试将上一个密码去除第一个数字后，在尾部再追加一个数字得到一个此前没有得到过的新密码。追加的数字必须从大到小遍历，证明参考：
             * <a href="https://leetcode.cn/problems/cracking-the-safe/solutions/275196/yi-bu-yi-bu-tui-dao-chu-0ms-jie-fa-tan-xin-gou-zao/"></a>
             */
            for (int i = k - 1; i >= 0; i--) {
                String num = result.substring(result.length() - n + 1) + i;

                if (!isVisited.contains(num)) {
                    result.append(i);
                    isVisited.add(num);
                    break;
                }
            }
        }
        return result.toString();
    }
}
