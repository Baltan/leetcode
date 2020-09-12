package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1567. Maximum Length of Subarray With Positive Product
 *
 * @author Baltan
 * @date 2020-09-06 22:23
 */
public class GetMaxLen {
    public static void main(String[] args) {
        System.out.println(getMaxLen(new int[]{1, -2, -3, 4}));
        System.out.println(getMaxLen(new int[]{0, 1, -2, -3, -4}));
        System.out.println(getMaxLen(new int[]{-1, -2, -3, 0, 1}));
        System.out.println(getMaxLen(new int[]{-1, 2}));
        System.out.println(getMaxLen(new int[]{1, 2, 3, 5, -6, 4, 0, 10}));
    }

    public static int getMaxLen(int[] nums) {
        int result = 0;
        int length = nums.length;
        /**
         * nums中前一个"0"出现的索引位置
         */
        int prevZeroIndex = -1;
        /**
         * 保存nums遍历过程中所有负数的索引位置
         */
        List<Integer> negativeIndexList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                /**
                 * 在nums.subarray(prevZeroIndex,i)这个子数组中（不包括nums[prevZeroIndex]和nums[i]）如
                 * 果负数出现的次数为偶数次，则这个子数组的乘积就为正数，子数组的长度为i-prevZeroIndex-1；如
                 * 果负数出现的次数为奇数次，则这个子数组中不包含第一个负数或者不包含最后一个负数的子数组的乘积
                 * 就为正数，两个子数组的长度分别为i-negativeIndexList.get(0)-1和
                 * negativeIndexList.get(negativeIndexList.size()-1)-prevZeroIndex-1，两个长度取较大值
                 */
                if (negativeIndexList.size() % 2 == 0) {
                    result = Math.max(result, i - prevZeroIndex - 1);
                    /**
                     * 标记当前索引位置为"0"出现的索引位置
                     */
                    prevZeroIndex = i;
                    /**
                     * 清空negativeIndexList，当前位置之后重新开始记录负数的索引位置
                     */
                    negativeIndexList.clear();
                } else {
                    result = Math.max(result, i - negativeIndexList.get(0) - 1);
                    result = Math.max(result,
                            negativeIndexList.get(negativeIndexList.size() - 1) - prevZeroIndex - 1);
                    /**
                     * 标记当前索引位置为"0"出现的索引位置
                     */
                    prevZeroIndex = i;
                    /**
                     * 清空negativeIndexList，当前位置之后重新开始记录负数的索引位置
                     */
                    negativeIndexList.clear();
                }
            } else if (nums[i] < 0) {
                negativeIndexList.add(i);
            }
        }
        /**
         * 对数组nums的最后一部分子数组再做一次判断，即假设nums[length]位置为"0"
         */
        if (negativeIndexList.size() % 2 == 0) {
            result = Math.max(result, length - prevZeroIndex - 1);
            negativeIndexList.clear();
        } else {
            result = Math.max(result, length - negativeIndexList.get(0) - 1);
            result = Math.max(result,
                    negativeIndexList.get(negativeIndexList.size() - 1) - prevZeroIndex - 1);
            negativeIndexList.clear();
        }
        return result;
    }
}
