package leetcode.algorithms;

/**
 * Description: 45. Jump Game II
 *
 * @author Baltan
 * @date 2018/9/17 10:24
 */
public class Jump {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{0}));
        System.out.println(jump(new int[]{2, 1}));
        System.out.println(jump(new int[]{1, 2, 1, 1, 1}));
        System.out.println(jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}));
    }

    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int stepNum = 0;
        /**
         * 之前可以到达的最远位置
         */
        int prevMaxIndex = 0;
        /**
         * 当前可以到达的最远位置
         */
        int currMaxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            /**
             * 如果当前位置超出之前可以到达的最远位置，则肯定要多走一步
             */
            if (i > prevMaxIndex) {
                stepNum++;
                prevMaxIndex = currMaxIndex;
            }
            /**
             * 更新当前可以到达的最远位置
             */
            currMaxIndex = Math.max(currMaxIndex, i + nums[i]);
        }
        return stepNum;
    }
}
