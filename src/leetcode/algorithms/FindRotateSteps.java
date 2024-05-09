package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 514. Freedom Trail
 *
 * @author Baltan
 * @date 2024/5/4 21:47
 */
public class FindRotateSteps {
    public static void main(String[] args) {
        System.out.println(findRotateSteps("godding", "gd"));
        System.out.println(findRotateSteps("godding", "godding"));
    }

    public static int findRotateSteps(String ring, String key) {
        int result = Integer.MAX_VALUE;
        /**
         * dp[i][j]表示用ring[j]拼写完key[i]后的最少步数
         */
        int[][] dp = new int[key.length()][ring.length()];
        /**
         * indexes[0]-indexes[25]依次表示字符串ring中字符a-z各自出现过的索引值
         */
        List<Integer>[] indexes = new List[26];
        Arrays.setAll(indexes, i -> new ArrayList<>());

        for (int i = 0; i < ring.length(); i++) {
            indexes[ring.charAt(i) - 'a'].add(i);
        }

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        /**
         * 计算用字符串ring中的各个字符key[0]拼写完key[0]的最少步数
         */
        for (int index : indexes[key.charAt(0) - 'a']) {
            /**
             * 为了拼写key[0]，可以到达字符串ring中indexes[key.charAt(0)-'a']表示的这些索引位置。因为初始时在ring[0]，从ring[0]到达
             * ring[index]可以通过顺时针和逆时针两个方向
             */
            dp[0][index] = Math.min(index, ring.length() - index);
        }
        /**
         * 依次计算拼写完key[i]后，到达ring[index]的最少步数
         */
        for (int i = 1; i < key.length(); i++) {
            /**
             * 拼写key[i]需要到达ring[index]
             */
            for (int index : indexes[key.charAt(i) - 'a']) {
                /**
                 * 拼写完key[i-1]可能停留在ring[prevIndex]
                 */
                for (int prevIndex : indexes[key.charAt(i - 1) - 'a']) {
                    /**
                     * 上一步如果在ring[prevIndex]，则这一步到达ring[index]可以通过顺时针和逆时针两个方向
                     */
                    dp[i][index] = Math.min(dp[i][index], dp[i - 1][prevIndex] + Math.abs(index - prevIndex));
                    dp[i][index] = Math.min(dp[i][index], dp[i - 1][prevIndex] + ring.length() - Math.abs(index - prevIndex));
                }
            }
        }
        /**
         * 选择拼写完字符串key后的最少步数
         */
        for (int index : indexes[key.charAt(key.length() - 1) - 'a']) {
            result = Math.min(result, dp[key.length() - 1][index]);
        }
        /**
         * 每次按下中心按钮也算一步，共按下key.length()次中心按钮
         */
        return result + key.length();
    }
}
