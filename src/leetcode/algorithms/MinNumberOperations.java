package leetcode.algorithms;

/**
 * Description: 1526. Minimum Number of Increments on Subarrays to Form a Target Array
 *
 * @author Baltan
 * @date 2023/3/1 10:32
 */
public class MinNumberOperations {
    public static void main(String[] args) {
        System.out.println(minNumberOperations(new int[]{1, 2, 3, 2, 1}));
        System.out.println(minNumberOperations(new int[]{3, 1, 1, 2}));
        System.out.println(minNumberOperations(new int[]{3, 1, 5, 4, 2}));
        System.out.println(minNumberOperations(new int[]{1, 1, 1, 1}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/solutions/371326/xing-cheng-mu-biao-shu-zu-de-zi-shu-zu-zui-shao-ze/"></a>
     *
     * @param target
     * @return
     */
    public static int minNumberOperations(int[] target) {
        /**
         * initial[0]一定需要target[0]次操作
         */
        int result = target[0];
        int length = target.length;
        /**
         * 在对initial[0]进行target[0]次操作时，如果target[0]>=target[1]，可以顺便将initial[1]也变为target[1]，此时对于initial[1]
         * 而言还需要0次操作；如果target[0]<target[1]，可以将initial[1]变为target[0]，此时对于initial[1]而言还需要target[1]-
         * target[0]次操作，以此类推……
         */
        for (int i = 1; i < length; i++) {
            result += Math.max(target[i] - target[i - 1], 0);
        }
        return result;
    }
}
