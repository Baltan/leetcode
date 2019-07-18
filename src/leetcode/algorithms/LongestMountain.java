package leetcode.algorithms;

/**
 * Description: 845. Longest Mountain in Array
 *
 * @author Baltan
 * @date 2019-07-18 11:04
 */
public class LongestMountain {
    public static void main(String[] args) {
        int[] A1 = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(longestMountain(A1));

        int[] A2 = {2, 2, 2};
        System.out.println(longestMountain(A2));

        int[] A3 = {2, 3, 3, 2, 0, 2};
        System.out.println(longestMountain(A3));

        int[] A4 =
                {1, 4, 5, 6, 3, 2, 3, 4, 6, 5, 3, 2, 1, 1, 3, 4, 5, 6, 8, 5, 4, 2, 1, 1, 4, 5, 7, 8, 3, 6, 5,
                        3, 7, 2, 1, 9};
        System.out.println(longestMountain(A4));
    }

    public static int longestMountain(int[] A) {
        int result = 0;
        /**
         * 当前处于山的上坡阶段，flag为1，下坡阶段flag为-1，否则不构成山flag为0
         */
        int flag = 0;
        int length = A.length;
        /**
         * 记录当前山的长度（假如最后能构成山的话）
         */
        int temp = 0;
        int j = length;
        /**
         * 查找数组中最早开始上坡的地方
         */
        for (int i = 1; i < length; i++) {
            if (A[i] > A[i - 1]) {
                /**
                 * 当前山的长度为2（假如最后能构成山的话）
                 */
                temp = 2;
                /**
                 * 标记此时处于山的上坡阶段
                 */
                flag = 1;
                /**
                 * 因为索引i-1，i开始已经上坡了，接下去只需要从j=i+1开始处理就行了
                 */
                j = i + 1;
                break;
            }
        }

        for (int i = j; i < length; i++) {
            if (A[i] > A[i - 1]) {
                /**
                 * 此时是上坡并且之前也是上坡的话，说明可以形成连续上坡，当前山的长度+1（假如最后能构成山的话），
                 * 否则就是重新构成一座山的上坡，当前山的长度为2（假如最后能构成山的话）
                 */
                if (flag == 1) {
                    temp++;
                } else {
                    temp = 2;
                }
                /**
                 * 标记此时处于山的上坡阶段
                 */
                flag = 1;
            } else if (A[i] < A[i - 1]) {
                /**
                 * 此时是下坡，并且之前是上坡或者下坡的话，说明可以形成连续下坡或者到达山顶处，当前山的长度+1（一定能构成山）
                 * 否则无法构成一座山
                 */
                if (flag == -1 || flag == 1) {
                    temp++;
                    /**
                     * 标记此时处于山的下坡阶段
                     */
                    flag = -1;
                    /**
                     * 保存最长的山的长度
                     */
                    result = Math.max(result, temp);
                } else {
                    temp = 0;
                    /**
                     * 标记此时不能构成山
                     */
                    flag = 0;
                }
            } else {
                temp = 0;
                /**
                 * 标记此时不能构成山
                 */
                flag = 0;
            }
        }
        return result;
    }
}
