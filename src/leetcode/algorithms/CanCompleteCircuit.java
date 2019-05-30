package leetcode.algorithms;

/**
 * Description: 134. Gas Station
 *
 * @author Baltan
 * @date 2019-05-30 09:46
 */
public class CanCompleteCircuit {
    public static void main(String[] args) {
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas1, cost1));

        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println(canCompleteCircuit(gas2, cost2));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;

        int totalRest = 0;
        int currentRest = 0;
        int startIndex = 0;

        for (int i = 0; i < length; ++i) {
            currentRest += (gas[i] - cost[i]);
            totalRest += (gas[i] - cost[i]);

            if (currentRest < 0) {
                startIndex = i + 1;
                currentRest = 0;
            }
        }
        return totalRest < 0 ? -1 : startIndex;
    }
}
