package leetcode.algorithms;

import java.util.TreeSet;

/**
 * Description: 1675. Minimize Deviation in Array
 *
 * @author baltan
 * @date 2024/8/26 17:38
 */
public class MinimumDeviation {
    public static void main(String[] args) {
        System.out.println(minimumDeviation(new int[]{1, 2, 3, 4}));
        System.out.println(minimumDeviation(new int[]{4, 1, 5, 20, 3}));
        System.out.println(minimumDeviation(new int[]{2, 10, 8}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimize-deviation-in-array/solutions/502412/you-xu-ji-he-you-xian-dui-lie-xun-huan-chu-li-by-m/"></a>
     *
     * @param nums
     * @return
     */
    public static int minimumDeviation(int[] nums) {
        int result = Integer.MAX_VALUE;
        /**
         * 升序去重保存数组nums中的所有数字
         */
        TreeSet<Integer> set = new TreeSet<>();
        /**
         * 将数组nums中所有数字都映射为可能的最大值（即偶数不变，奇数乘以2）
         */
        for (int num : nums) {
            set.add(num % 2 == 0 ? num : num * 2);
        }
        /**
         * 数组nums中所有数字都相等，数组的最小偏移量就是0
         */
        if (set.size() == 1) {
            return 0;
        }
        /**
         * 因为奇数可以先乘以2变成偶数后，再除以2还原，但是偶数未必可以先除以2变成奇数后，再乘以2还原，所以将数组nums中所有数字都映射为可能
         * 的最大值（即偶数不变，奇数乘以2）后，再逐次将所有数字中的最大值执行除以2操作，判断是否得到更小的偏移量，直到数组中所有数字都变成奇
         * 数为止
         */
        while (set.last() - set.first() > 0 && set.last() % 2 == 0) {
            int max = set.removeLast();
            set.add(max / 2);
            result = Math.min(result, set.last() - set.first());
        }
        return result;
    }
}
