package leetcode.algorithms;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 229. Majority Element II
 *
 * @author Baltan
 * @date 2020-03-23 10:36
 * @see MajorityElement1
 */
public class MajorityElement2 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
    }

    /**
     * Boyer-Moore 投票算法
     * 参考：
     * <a href="https://leetcode-cn.com/problems/majority-element-ii/solution/169ti-sheng-ji-ban-xiang-jie-zhu-xing-jie-shi-tong/"></a>
     *
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> result = new LinkedList<>();
        /**
         * 候选人1和候选人2是所有候选者中得票最多的两人
         */
        int candidate1 = 0;
        int candidate2 = 0;
        /**
         * 候选人1的得票数，可以理解为候选人1比其他人领先的票数
         */
        int count1 = 0;
        /**
         * 候选人2的得票数，可以理解为候选人2比其他人领先的票数
         */
        int count2 = 0;
        /**
         * 遍历所有投票：
         * 1、如果当前投票给候选人1，将候选人1的得票数加1
         * 2、如果当前投票给候选人2，将候选人2的得票数加1
         * 3、如果当前投票既不给候选人1，也不给候选人2
         *    1)、如果此时候选人1的得票数为0，将候选人1换成当前得票人，将当前得票人的得票数加1
         *    2)、如果此时候选人2的得票数为0，将候选人2换成当前得票人，将当前得票人的得票数加1
         *    3)、如果此时候选人1和候选人2的得票数都不为0，将两人的得票数减1
         */
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else {
                if (count1 == 0) {
                    candidate1 = num;
                    count1++;
                } else if (count2 == 0) {
                    candidate2 = num;
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        /**
         * 重新计算候选人1和候选人2的得票数，判断是否符合题目要求
         */
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }

        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }
        return result;
    }
}
