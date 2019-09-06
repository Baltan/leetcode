package leetcode.algorithms;

import leetcode.entity.SolBase;

/**
 * Description: 470. Implement Rand10() Using Rand7()
 *
 * @author Baltan
 * @date 2019-09-06 11:28
 */
public class Solution8 extends SolBase {
    public int rand10() {
        int randNum1 = 7;
        int randNum2 = 7;
        /**
         * 先从[1,6]中获取一个随机数randNum1
         */
        while (randNum1 == 7) {
            randNum1 = rand7();
        }
        /**
         * 再从[1,5]中获取一个随机数randNum2
         */
        while (randNum2 > 5) {
            randNum2 = rand7();
        }

        if ((randNum1 & 1) == 1) {
            return randNum2;
        } else {
            return 5 + randNum2;
        }
    }

    public static void main(String[] args) {
        Solution8 solution81 = new Solution8();
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
        System.out.println(solution81.rand10());
    }
}
