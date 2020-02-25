package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 898. Bitwise ORs of Subarrays
 *
 * @author Baltan
 * @date 2020-02-25 12:01
 */
public class SubarrayBitwiseORs {
    public static void main(String[] args) {
        System.out.println(subarrayBitwiseORs(new int[]{0}));
        System.out.println(subarrayBitwiseORs(new int[]{1, 1, 2}));
        System.out.println(subarrayBitwiseORs(new int[]{1, 2, 4}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/bitwise-ors-of-subarrays/solution/zi-shu-zu-an-wei-huo-cao-zuo-by-leetcode/"></a>
     *
     * @param A
     * @return
     */
    public static int subarrayBitwiseORs(int[] A) {
        /**
         * 所有子数组或运算结果的集合
         */
        Set<Integer> set = new HashSet<>();
        /**
         * 保存前一轮循环中的所有或运算结果的集合
         */
        Set<Integer> prevSet = new HashSet<>();
        int length = A.length;
        /**
         * 每一次循环计算以A[i]结尾的所有子数组中的元素的或运算结果，只需将前一轮循环中的所有
         * 或运算的结果和A[i]依次进行或运算即可
         */
        for (int i = 0; i < length; i++) {
            /**
             * 以A[i]结尾的所有子数组中的元素的或运算结果
             */
            Set<Integer> currSet = new HashSet<>();
            currSet.add(A[i]);

            for (int value : prevSet) {
                currSet.add(value | A[i]);
            }
            set.addAll(currSet);
            prevSet = currSet;
        }
        return set.size();
    }
}
