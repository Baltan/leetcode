package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1860. Incremental Memory Leak
 *
 * @author Baltan
 * @date 2022/5/29 14:01
 */
public class MemLeak {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(memLeak(2, 2));
        OutputUtils.print1DIntegerArray(memLeak(8, 11));
    }

    public static int[] memLeak(int memory1, int memory2) {
        int[] result = new int[3];
        /**
         * 当前要分配的内存大小
         */
        int required = 1;

        while (memory1 >= required || memory2 >= required) {
            if (memory1 > memory2) {
                int diff = memory1 - memory2;
                /**
                 * 计算从memory1可以连续分配到的最大内存，直到memory1不大于memory2
                 */
                int maxAllocated = getAaxAllocated(required, diff);
                /**
                 * 如果计算得到可以连续分配到的最大内存maxAllocated小于required，则只分配required
                 */
                maxAllocated = maxAllocated < required ? required : maxAllocated;
                /**
                 * memory1剩余内存大小
                 */
                memory1 -= (required + maxAllocated) * (maxAllocated - required + 1) / 2;
                required = maxAllocated + 1;
            } else if (memory2 > memory1) {
                int diff = memory2 - memory1;
                /**
                 * 计算从memory2可以连续分配到的最大内存，直到memory2不大于memory1
                 */
                int maxAllocated = getAaxAllocated(required, diff);
                /**
                 * 如果计算得到可以连续分配到的最大内存maxAllocated小于required，则只分配required
                 */
                maxAllocated = maxAllocated < required ? required : maxAllocated;
                /**
                 * memory2剩余内存大小
                 */
                memory2 -= (required + maxAllocated) * (maxAllocated - required + 1) / 2;
                required = maxAllocated + 1;
            } else {
                /**
                 * memory1剩余内存大小
                 */
                memory1 -= required;
                required++;
            }
        }
        result[0] = required;
        result[1] = memory1;
        result[2] = memory2;
        return result;
    }

    /**
     * 计算某一条内存可以连续分配到的最大内存
     *
     * @param required
     * @param diff
     * @return
     */
    public static int getAaxAllocated(int required, int diff) {
        /**
         * 第一次分配的内存为required，第二次为required+1，……，最后一次为max，只要该条内存仍然比另一条内存剩余的多，则一直在
         * 该条内存上分配，则得到不等式：
         * required+(required+1)+……+max<=diff，由高斯求和公式得到：
         * (required+max)*(max-required+1)<=2*diff，展开得到：
         * max*max+max+(required-required*required-2*diff)<=0，由求根公式得到：
         * max=(Math.sqrt(1-4*(required-required*required-2*diff))-1)/2，因为max大于0，所以舍去另一个根
         */
        return (int) ((Math.sqrt(1 - 4 * (required - required * required - 2 * diff)) - 1) / 2);
    }
}
