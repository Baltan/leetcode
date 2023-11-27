package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2935. Maximum Strong Pair XOR II
 *
 * @author baltan
 * @date 2023/11/23 09:53
 * @see MaximumStrongPairXor
 * @see FindMaximumXOR
 */
public class MaximumStrongPairXor1 {
    public static void main(String[] args) {
        System.out.println(maximumStrongPairXor(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maximumStrongPairXor(new int[]{10, 100}));
        System.out.println(maximumStrongPairXor(new int[]{500, 520, 2500, 3000}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/maximum-strong-pair-xor-ii/solutions/2523213/0-1-trie-hua-dong-chuang-kou-pythonjavac-gvv2/"></a>
     *
     * @param nums
     * @return
     */
    public static int maximumStrongPairXor(int[] nums) {
        int result = 0;
        Set<Integer> numSet = new HashSet<>();
        int mask = 0;

        for (int num : nums) {
            numSet.add(num);
        }
        /**
         * 根据题意nums[i]∈[1,2^20-1]，所以result的二进制值不大于0b1111……111（共20个1）
         */
        for (int i = 20; i >= 0; i--) {
            /**
             * 每次循环依次得到掩码：
             * 100000000000000000000
             * 110000000000000000000
             * 111000000000000000000
             * ……
             * 111111111111111111111
             */
            mask |= (1 << i);
            /**
             * 集合numSet中各个元素从低到高第[i,20]位（0-based）的前缀的值 -> 集合numSet中满足条件的元素列表
             */
            Map<Integer, TreeSet<Integer>> prefixeMap = new HashMap<>();

            for (int num : numSet) {
                prefixeMap.computeIfAbsent(num & mask, x -> new TreeSet<>()).add(num);
            }
            /**
             * 集合numSet中各个元素从低到高第[i,20]位（0-based）的前缀值都相同，即集合numSet中任意两个数字这部分前缀按位异或的结果都为0，
             * 不需要继续计算
             */
            if (prefixeMap.size() == 1) {
                continue;
            }
            /**
             * 因为希望最终得到的两数按位异或值xor最大，所以尽可能地让xor二进制值的每一位都为1。假设result从低到高的i+1位为1，接下去判断
             * 集合numSet中是否存在某两个数x和y使得它们从低到高第[i,20]位（0-based）的前缀按位异或后和xor相同
             */
            int xor = result | (1 << i);
            /**
             * 假设其中一个数x的前缀部分为xPrefix，因为xPrefix和y的前缀部分yPrefix按位异或等于xor，所以xPrefix^xor=yPrefix，只需判断
             * 是否存在前缀为yPrefix的y即可
             */
            for (Map.Entry<Integer, TreeSet<Integer>> entry : prefixeMap.entrySet()) {
                int xPrefix = entry.getKey();
                int yPrefix = xPrefix ^ xor;
                /**
                 * 存在前缀为yPrefix的元素y，并且满足2*Math.min(x,y)>=Math.max(x,y)，说明result从低到高的i+1位可以为1
                 */
                if (prefixeMap.containsKey(yPrefix) &&
                        (check(entry.getValue(), prefixeMap.get(yPrefix)) || check(prefixeMap.get(yPrefix), entry.getValue()))) {
                    result = xor;
                    break;
                }
            }
            prefixeMap.clear();
        }
        return result;
    }

    /**
     * 能否从集合xList中选择一个数x，从集合yList中选择一个数y，使得2*Math.min(x,y)>=Math.max(x,y)
     *
     * @param xList
     * @param yList
     * @return
     */
    public static boolean check(TreeSet<Integer> xList, TreeSet<Integer> yList) {
        /**
         * 总是用较大的集合来做二分查找
         */
        if (xList.size() > yList.size()) {
            return false;
        }

        for (int x : xList) {
            /**
             * 集合yList中大于x的最小元素
             */
            Integer higher = yList.higher(x);

            if (higher != null && x * 2 >= higher) {
                return true;
            }
            /**
             * 集合yList中小于x的最小元素
             */
            Integer lower = yList.lower(x);

            if (lower != null && lower * 2 >= x) {
                return true;
            }
        }
        return false;
    }
}
