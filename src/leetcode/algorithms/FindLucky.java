package leetcode.algorithms;

/**
 * Description: 1394. Find Lucky Integer in an Array
 *
 * @author Baltan
 * @date 2020-04-02 22:54
 */
public class FindLucky {
    public static void main(String[] args) {
        System.out.println(findLucky(new int[]{2, 2, 3, 4}));
        System.out.println(findLucky(new int[]{1, 2, 2, 3, 3, 3}));
        System.out.println(findLucky(new int[]{2, 2, 2, 3, 3}));
        System.out.println(findLucky(new int[]{5}));
        System.out.println(findLucky(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }

    public static int findLucky(int[] arr) {
        /**
         * count[i]表示数组arr中i出现的次数
         */
        int[] count = new int[501];
        /**
         * 对数组arr中每个值出现的次数计数
         */
        for (int value : arr) {
            count[value]++;
        }
        /**
         * 从大到小判断是否存在幸运数
         */
        for (int i = 500; i >= 1; i--) {
            if (count[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
