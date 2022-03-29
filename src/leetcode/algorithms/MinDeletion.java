package leetcode.algorithms;

/**
 * Description: 2216. Minimum Deletions to Make Array Beautiful
 *
 * @author Baltan
 * @date 2022/3/28 11:24
 */
public class MinDeletion {
    public static void main(String[] args) {
        System.out.println(minDeletion(new int[]{1, 1, 2, 3, 5}));
        System.out.println(minDeletion(new int[]{1, 1, 2, 2, 3, 3}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/minimum-deletions-to-make-array-beautiful/solution/tan-xin-by-wen-rou-yi-dao-123-d8yk/"></a>
     *
     * @param nums
     * @return
     */
    public static int minDeletion(int[] nums) {
        int result = 0;
        /**
         * 根据题意，数组nums中的元素范围为[0,100000]，假设要匹配的前一个数为-1，此时，说明还没有确定数对中的第一个数
         */
        int prev = -1;

        for (int num : nums) {
            if (prev == -1) {
                /**
                 * 找到数对中的第一个数，数组nums中剩余数字中的下一个数不能和这个数字相同
                 */
                prev = num;
            } else if (num == prev) {
                /**
                 * 如果当前数字和数对中的第一个数字相同，就将当前数字删除
                 */
                result++;
            } else {
                /**
                 * 找到一个两数不等的数对，将prev重置为-1，继续后面的计算
                 */
                prev = -1;
            }
        }
        return prev == -1 ? result : result + 1;
    }
}
