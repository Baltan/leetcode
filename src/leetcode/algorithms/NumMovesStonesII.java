package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 1040. Moving Stones Until Consecutive II
 *
 * @author Baltan
 * @date 2022/11/12 12:45
 * @see NumMovesStones
 */
public class NumMovesStonesII {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(numMovesStonesII(new int[]{7, 4, 9}));
        OutputUtils.print1DIntegerArray(numMovesStonesII(new int[]{6, 5, 4, 3, 10}));
        OutputUtils.print1DIntegerArray(numMovesStonesII(new int[]{1, 2, 3, 4, 6}));
        OutputUtils.print1DIntegerArray(numMovesStonesII(new int[]{1, 2, 3, 4, 7}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/moving-stones-until-consecutive-ii/solutions/5446/jie-ti-si-lu-by-owenzzz/"></a>
     *
     * @param stones
     * @return
     */
    public static int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int length = stones.length;
        /**
         * 初始状态下，两个端点石子中间未占用位置的数量
         */
        int unoccupiedPositions = stones[length - 1] - stones[0] + 1 - length;
        /**
         * 每次移动总是将某一个端点石子移动到令自己不再是一个端点石子的距离自己最近的未占用位置，并且移动之后减少的未占用位子要尽可能少，例如：
         * [4,6,8,9,15,16,19,20]，可以将4移动到7，减少5、7两个未占用位置；或者将20移动到18，减少18一个未占用位置，选择后者，得到：
         * [4,6,8,9,15,16,18,19]，之后每次移动端点石子总有一种只减少一个未占用位置的方法，依次得到：
         * [4,6,8,9,15,16,17,18]、[4,6,8,9,14,15,16,17]、[4,6,8,9,13,14,15,16]、[4,6,8,9,12,13,14,15]、
         * [4,6,8,9,11,12,13,14]、[4,6,8,9,10,11,12,13]、[4,6,7,8,9,10,11,12]、[4,5,6,7,8,9,10,11]
         */
        int max = unoccupiedPositions - Math.min(stones[length - 1] - stones[length - 2] - 1, stones[1] - stones[0] - 1);

        int min = Integer.MAX_VALUE;
        int start;
        int end = 0;
        /**
         * 维护一个长度为length的窗口，窗口中包含length个连续的位置，假设这个窗口包含了stones[start]……stones[end]这部分相邻的石子，则剩
         * 余不在窗口中的length-(end-start+1)个石子都需要通过移动放入窗口中
         */
        for (start = 0; start < length; start++) {
            while (end + 1 < length && stones[end + 1] - stones[start] + 1 <= length) {
                end++;
            }
            int moves = length - (end - start + 1);
            /**
             * 如果出现窗口包含了length-1个连续的石子，并且剩下一个石子和最近的石子间隔不止一个未占用位置的情况，需要移动两次才能令所有石子连
             * 续，例如：
             * [1,2,3,4,7]、[2,3,4,5,7]、[3,4,5,6,7]
             * [1,2,3,4,9]、[2,3,4,6,9]、[2,3,4,5,6]
             * 当然对于[1,2,3,4,6]这种剩下一个石子和最近的石子间隔刚好一个未占用位置的情况，其实只需要移动一次即可：[2,3,4,5,6]，这种情况在
             * 窗口包含stones[1]……stones[4]这部分石子的时候已经覆盖到了，所以下面判定要移动两次虽然是错误的，但是不影响最终结果
             */
            if (end - start + 1 == length - 1 && stones[end] - stones[start] + 1 == length - 1) {
                moves = 2;
            }
            min = Math.min(min, moves);
        }
        return new int[]{min, max};
    }
}
