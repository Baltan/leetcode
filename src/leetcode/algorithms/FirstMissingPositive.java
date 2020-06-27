package leetcode.algorithms;

/**
 * Description: 41. First Missing Positive
 *
 * @author Baltan
 * @date 2018/9/4 14:53
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(firstMissingPositive(new int[]{1, 2, 3, 4}));
        System.out.println(firstMissingPositive(new int[]{1, 2, 3, 5}));
        System.out.println(firstMissingPositive(new int[]{1000}));
        System.out.println(firstMissingPositive(new int[]{0}));
        System.out.println(firstMissingPositive(new int[]{1, 1}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/"></a>
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        int index = 0;
        int length = nums.length;
        /**
         * 尝试将nums中值在[1,length]范围内的元素i都放在索引i-1位置上
         */
        while (index < length) {
            int curr = nums[index];

            if (curr != index + 1 && curr > 0 && curr <= length && curr != nums[curr - 1]) {
                /**
                 * 把当前元素curr放到nums[curr-1]位置上，把nums[curr-1]放到curr所在的nums[index]位置上，即交换
                 * nums[index]和nums[curr-1]
                 */
                int temp = nums[curr - 1];
                nums[curr - 1] = curr;
                nums[index] = temp;
            } else {
                index++;
            }
        }
        /**
         * 从前向后遍历nums，如果找到某个索引位置i上的元素不是i+1，直接返回i+1即可
         */
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        /**
         * 如果上面循环中没有找到符合条件的元素，则说明所求最小正整数不在[1,length]范围内，即length+1
         */
        return length + 1;
    }
}
