package leetcode.algorithms;

/**
 * Description: 1953. Maximum Number of Weeks for Which You Can Work
 *
 * @author Baltan
 * @date 2022/2/6 21:16
 */
public class NumberOfWeeks {
    public static void main(String[] args) {
        System.out.println(numberOfWeeks(new int[]{1, 2, 3}));
        System.out.println(numberOfWeeks(new int[]{5, 2, 1}));
        System.out.println(numberOfWeeks(new int[]{1, 2, 3, 100}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/maximum-number-of-weeks-for-which-you-can-work/solution/ti-yi-zhuan-hua-cha-kong-fa-by-yorwood-bvdv/"></a>
     *
     * @param milestones
     * @return
     */
    public static long numberOfWeeks(int[] milestones) {
        /**
         * 阶段任务总数量
         */
        long total = 0L;
        /**
         * 阶段任务数量最多的项目所包含的阶段任务数
         */
        int max = Integer.MIN_VALUE;

        for (int milestone : milestones) {
            total += milestone;
            max = Math.max(max, milestone);
        }
        /**
         * 除去一个阶段任务数量最多的项目，剩余任务的阶段任务总数量
         */
        long rest = total - max;
        /**
         * 假设阶段任务数量最多的某个项目为X，含有阶段任务max个，用其他项目的rest个阶段任务插进max-1个间隙中。如果能把max-1个
         * 间隙先填满，则得到了2*max-2个间隙，继续以上操作，直到所有阶段任务都被插入到某个间隙中，即可以按照题目要求把所有阶段任
         * 务都完成。如果不能把max-1个间隙都填满，只能填满max个阶段任务中的rest个间隙，此时共可以按照题目要求完成2*rest+1个阶
         * 段任务
         */
        return rest >= max - 1 ? total : rest * 2 + 1;
    }
}
