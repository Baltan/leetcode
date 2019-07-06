package leetcode.algorithms;

import java.util.*;

/**
 * Description: 398. Random Pick Index
 *
 * @author Baltan
 * @date 2019-07-05 22:55
 */
public class Solution5 {
    private Random rand;
    private int[] nums;

    public Solution5(int[] nums) {
        this.rand = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int result = 0;
        int count = 0;
        int randomNum;
        int length = nums.length;

        /**
         * 假设target在数组中的索引依次为：m,n,p……
         * (1)i==m时，count==1,randomNum为0的可能性是1，result为m的可能性为1
         * (2)i==n时，count==2,randomNum为0的可能性是1/2，不为0的可能性是1-1/2，
         *    result为n的可能性为1/2，result仍旧为m的可能性为(1-1/2)*1=1/2
         * (3)i==p时，count==3,randomNum为0的可能性是1/3，不为0的可能性是1-1/3，
         *    result为p的可能性为1/3，result仍旧为n或m的可能性为(1-1/3)*1/2=1/3
         * ……
         * 以此类推保证每个值被取到的可能性相等
         */
        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                count++;
                randomNum = rand.nextInt(count);

                if (randomNum == 0) {
                    result = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        Solution5 solution = new Solution5(nums);
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(1));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(2));
        System.out.println(solution.pick(3));
    }
}
