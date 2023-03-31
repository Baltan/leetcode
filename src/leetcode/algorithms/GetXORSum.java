package leetcode.algorithms;

/**
 * Description: 1835. Find XOR Sum of All Pairs Bitwise AND
 *
 * @author Baltan
 * @date 2023/3/26 19:48
 */
public class GetXORSum {
    public static void main(String[] args) {
        System.out.println(getXORSum(new int[]{1, 2, 3}, new int[]{6, 5}));
        System.out.println(getXORSum(new int[]{12}, new int[]{4}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/find-xor-sum-of-all-pairs-bitwise-and/solutions/728813/python-yi-xing-by-endlesscheng-007b/"></a>
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static int getXORSum(int[] arr1, int[] arr2) {
        /**
         * 数组arr1中所有元素按位异或的结果
         */
        int xor1 = 0;
        /**
         * 数组arr2中所有元素按位异或的结果
         */
        int xor2 = 0;

        for (int num1 : arr1) {
            xor1 ^= num1;
        }

        for (int num2 : arr2) {
            xor2 ^= num2;
        }
        /**
         * 假设arr1=[x1,x2]，arr2=[y1,y2]，则所求结果为：
         * (x1&y1)^(x1&y2)^(x2&y1)^(x2&y2)
         * =[x1&(y1^y2)]^[x2&(y1^y2)]
         * =(x1^x2)&(y1^y2)
         */
        return xor1 & xor2;
    }
}
