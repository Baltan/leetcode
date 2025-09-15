package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description: 3645. Maximum Total from Optimal Activation Order
 *
 * @author baltan
 * @date 2025/9/10 17:10
 */
public class MaxTotal {
    public static void main(String[] args) {
        System.out.println(maxTotal(new int[]{3, 5, 8}, new int[]{2, 1, 3}));
        System.out.println(maxTotal(new int[]{4, 2, 6}, new int[]{1, 1, 1}));
        System.out.println(maxTotal(new int[]{4, 1, 5, 2}, new int[]{3, 3, 2, 3}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/maximum-total-from-optimal-activation-order/solutions/3748516/yue-du-li-jie-ti-nao-jin-ji-zhuan-wan-py-kua4/"></a>
     *
     * @param value
     * @param limit
     * @return
     */
    public static long maxTotal(int[] value, int[] limit) {
        long result = 0L;
        int length = value.length;
        /**
         * limitGroups[i]保存所有limit值为i的索引x对应的value[x]值
         */
        List<Integer>[] limitGroups = new List[length + 1];
        Arrays.setAll(limitGroups, i -> new ArrayList<>());

        for (int i = 0; i < length; i++) {
            limitGroups[limit[i]].add(value[i]);
        }
        /**
         * 按照limit值升序激活元素
         */
        for (int i = 1; i <= length; i++) {
            long sum = limitGroups[i].stream()
                    /**
                     * 将元素按照价值降序排列
                     */
                    .sorted(Collections.reverseOrder())
                    /**
                     * 选择价值最大的前i个元素
                     */
                    .limit(i)
                    .mapToInt(x -> x)
                    .sum();
            result += sum;
        }
        return result;
    }
}
