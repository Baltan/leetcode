package leetcode.algorithms;

/**
 * Description: 2374. Node With Highest Edge Score
 *
 * @author Baltan
 * @date 2023/1/6 17:19
 */
public class EdgeScore {
    public static void main(String[] args) {
        System.out.println(edgeScore(new int[]{3, 3, 3, 0}));
        System.out.println(edgeScore(new int[]{1, 0, 0, 0, 0, 7, 7, 5}));
        System.out.println(edgeScore(new int[]{2, 0, 0, 2}));
    }

    public static int edgeScore(int[] edges) {
        int result = Integer.MAX_VALUE;
        /**
         * 节点的最大边积分值
         */
        long maxScore = Long.MIN_VALUE;
        int length = edges.length;
        /**
         * scores[i]表示节点i的边积分
         */
        long[] scores = new long[length];

        for (int from = 0; from < length; from++) {
            /**
             * 从from节点指向to节点
             */
            int to = edges[from];
            scores[to] += from;
            /**
             * 得到边积分比maxScore更大的节点，或者得到边积分与maxScore相同但是编号更小的节点
             */
            if (scores[to] > maxScore || (scores[to] == maxScore && to < result)) {
                result = to;
                maxScore = scores[to];
            }
        }
        return result;
    }
}
