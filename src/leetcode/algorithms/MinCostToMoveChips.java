package leetcode.algorithms;

/**
 * Description: 1217. Play with Chips
 *
 * @author Baltan
 * @date 2019-10-07 10:50
 */
public class MinCostToMoveChips {
    public static void main(String[] args) {
        int[] chips1 = {1, 2, 3};
        System.out.println(minCostToMoveChips(chips1));

        int[] chips2 = {2, 2, 2, 3, 3};
        System.out.println(minCostToMoveChips(chips2));
    }

    public static int minCostToMoveChips(int[] chips) {
        int evenNumberCount = 0;
        int oddNumberCount = 0;
        /**
         * 所有奇数位置的砝码移动到奇数位置代价为0，所有偶数位置的砝码移动到偶数位置代价为0，所以将所有砝码移动
         * 到相邻的两个位置上，并保持砝码位置的奇偶性和开始时一样，代价为0。最后判断相邻的两个位置上是奇数位置的
         * 砝码少还是偶数位置的砝码少，将较少位置的所有砝码移动到较多位置，总代价为较少位置的砝码数
         */
        for (int chip : chips) {
            if ((chip & 1) == 1) {
                oddNumberCount++;
            } else {
                evenNumberCount++;
            }
        }
        return Math.min(oddNumberCount, evenNumberCount);
    }
}
