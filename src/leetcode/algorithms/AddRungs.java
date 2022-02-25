package leetcode.algorithms;

/**
 * Description: 1936. Add Minimum Number of Rungs
 *
 * @author Baltan
 * @date 2022/2/24 19:34
 */
public class AddRungs {
    public static void main(String[] args) {
        System.out.println(addRungs(new int[]{1, 3, 5, 10}, 2));
        System.out.println(addRungs(new int[]{3, 6, 8, 10}, 3));
        System.out.println(addRungs(new int[]{3, 4, 6, 7}, 2));
        System.out.println(addRungs(new int[]{4, 1000000000}, 1));
    }

    public static int addRungs(int[] rungs, int dist) {
        int result = 0;
        /**
         * 当前所在的位置
         */
        int currRung = 0;

        for (int i = 0; i < rungs.length; ) {
            int rung = rungs[i];

            if (currRung + dist >= rung) {
                currRung = rung;
                i++;
            } else {
                int diff = rung - currRung;
                currRung = rung;
                /**
                 * 当前所在位置和目标位置差距在[(k-1)*dist+1,k*dist]时，需要增加k个横档
                 */
                result += (diff - 1) / dist;
            }
        }
        return result;
    }
}
