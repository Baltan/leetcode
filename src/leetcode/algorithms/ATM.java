package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2241. Design an ATM Machine
 *
 * @author Baltan
 * @date 2022/4/17 19:24
 */
public class ATM {
    /**
     * 可选的面值
     */
    private int[] denominationArray;
    /**
     * 每种面值的张数
     */
    private long[] totalCount;
    /**
     * 无法完成取款时返回数组
     */
    private int[] impossible;


    public ATM() {
        denominationArray = new int[]{20, 50, 100, 200, 500};
        totalCount = new long[denominationArray.length];
        impossible = new int[]{-1};
    }

    public void deposit(int[] banknotesCount) {
        /**
         * 每种面值金额增加相应张数
         */
        for (int i = 0; i < denominationArray.length; i++) {
            totalCount[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        if (amount % 10 != 0) {
            return impossible;
        }

        int[] result = new int[denominationArray.length];
        /**
         * 从大面值金额开始向小面值金额完成取款
         */
        for (int i = denominationArray.length - 1; i >= 0; i--) {
            /**
             * 当前面额要全款的张数
             */
            result[i] = (int) Math.min(totalCount[i], amount / denominationArray[i]);
            totalCount[i] -= result[i];
            amount -= result[i] * denominationArray[i];
        }

        if (amount == 0) {
            return result;
        } else {
            /**
             * 剩下的总额不为0时，说明不能完成取款，将之前各面额的取款张数加回去
             */
            for (int i = 0; i < denominationArray.length; i++) {
                totalCount[i] += result[i];
            }
            return impossible;
        }
    }

    public static void main(String[] args) {
        ATM atm1 = new ATM();
        atm1.deposit(new int[]{0, 0, 1, 2, 1});
        OutputUtils.print1DIntegerArray(atm1.withdraw(600));
        atm1.deposit(new int[]{0, 1, 0, 1, 1});
        OutputUtils.print1DIntegerArray(atm1.withdraw(600));
        OutputUtils.print1DIntegerArray(atm1.withdraw(550));
    }
}
