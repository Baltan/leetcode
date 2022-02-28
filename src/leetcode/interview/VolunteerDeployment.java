package leetcode.interview;

import leetcode.util.OutputUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Description: LCP 46. 志愿者调配
 *
 * @author Baltan
 * @date 2022/2/28 10:59
 */
public class VolunteerDeployment {
    public static void main(String[] args) {
        int[] finalCnt1 = {1, 16};
        long totalNum1 = 21;
        int[][] edges1 = {{0, 1}, {1, 2}};
        int[][] plans1 = {{2, 1}, {1, 0}, {3, 0}};
        OutputUtils.print1DIntegerArray(volunteerDeployment(finalCnt1, totalNum1, edges1, plans1));

        int[] finalCnt2 = {4, 13, 4, 3, 8};
        long totalNum2 = 54;
        int[][] edges2 = {{0, 3}, {1, 3}, {4, 3}, {2, 3}, {2, 5}};
        int[][] plans2 = {{1, 1}, {3, 3}, {2, 5}, {1, 0}};
        OutputUtils.print1DIntegerArray(volunteerDeployment(finalCnt2, totalNum2, edges2, plans2));
    }

    public static int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
        int[] result = new int[finalCnt.length + 1];
        /**
         * 场馆i -> 与场馆i相邻的场馆列表
         */
        Map<Integer, List<Integer>> neighborMap = new HashMap<>();
        /**
         * 假设第i个场馆最终志愿者人数为kArray[i]*x+bArray[i]，其中第0个场馆的最终志愿者人数为x
         */
        long[] kArray = new long[finalCnt.length + 1];
        long[] bArray = new long[finalCnt.length + 1];
        kArray[0] = 1;
        bArray[0] = 0;

        for (int i = 0; i < finalCnt.length; i++) {
            bArray[i + 1] = finalCnt[i];
        }
        /**
         * 查询每个场馆相邻的场馆列表
         */
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            List<Integer> xNeighbors = neighborMap.computeIfAbsent(x, i -> new LinkedList<>());
            xNeighbors.add(y);
            List<Integer> yNeighbors = neighborMap.computeIfAbsent(y, i -> new LinkedList<>());
            yNeighbors.add(x);
        }
        /**
         * 按照方案执行的顺序从后向前倒推
         */
        for (int i = plans.length - 1; i >= 0; i--) {
            /**
             * 当前方案的编号
             */
            int planIdx = plans[i][0];
            /**
             * 当前方案针对的场馆索引
             */
            int stadiumIdx = plans[i][1];

            if (planIdx == 1) {
                /**
                 * 第stadiumIdx个场馆志愿者人数翻倍
                 */
                kArray[stadiumIdx] <<= 1;
                bArray[stadiumIdx] <<= 1;
            } else if (planIdx == 2) {
                /**
                 * 与第stadiumIdx个场馆相邻的所有场馆志愿者人数减去第stadiumIdx个场馆志愿者的人数
                 */
                if (neighborMap.containsKey(stadiumIdx)) {
                    for (int neighbor : neighborMap.get(stadiumIdx)) {
                        kArray[neighbor] -= kArray[stadiumIdx];
                        bArray[neighbor] -= bArray[stadiumIdx];
                    }
                }
            } else if (planIdx == 3) {
                /**
                 * 与第stadiumIdx个场馆相邻的所有场馆志愿者人数加上第stadiumIdx个场馆志愿者的人数
                 */
                if (neighborMap.containsKey(stadiumIdx)) {
                    for (int neighbor : neighborMap.get(stadiumIdx)) {
                        kArray[neighbor] += kArray[stadiumIdx];
                        bArray[neighbor] += bArray[stadiumIdx];
                    }
                }
            }
        }
        /**
         * 初始状态所有场馆志愿者人数和的一次项系数
         */
        long kSum = 0L;
        /**
         * 初始状态所有场馆志愿者人数和的常数项系数
         */
        long bSum = 0L;

        for (int i = 0; i <= finalCnt.length; i++) {
            kSum += kArray[i];
            bSum += bArray[i];
        }
        /**
         * 初始状态所有场馆志愿者总人数为kSum*x+bSum=totalNum，解得x
         */
        long x = (totalNum - bSum) / kSum;
        /**
         * 计算初始状态各个场馆志愿者人数
         */
        for (int i = 0; i <= finalCnt.length; i++) {
            result[i] = (int) (kArray[i] * x + bArray[i]);
        }
        return result;
    }
}
