package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 60. Permutation Sequence
 *
 * @author Baltan
 * @date 2018/9/19 10:10
 */
public class GetPermutation {
    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation(4, 9));
        System.out.println(getPermutation(1, 1));
        System.out.println(getPermutation(2, 2));
    }

    public static String getPermutation(int n, int k) {
        StringBuilder builder = new StringBuilder(n);
        /**
         * 将[1,n]这n个数升序保存
         */
        List<Integer> list = new ArrayList<>(n);
        /**
         * 剩余的数字可以产生的排列总数
         */
        int total = 1;

        for (int i = 1; i <= n; i++) {
            list.add(i);
            total *= i;
        }

        while (!list.isEmpty()) {
            /**
             * 以每个数字打头，分别可以产生的排列总数
             */
            int per = total / list.size();
            /**
             * 所有排列情况按照升序排列后，第k个排列开头的数字在list中的索引位置，因为题目给出的k是1-based的，
             * 所以需要将k减去1再做计算
             */
            int index = (k - 1) / per;
            builder.append(list.get(index));
            /**
             * 移除已经使用过的数字
             */
            list.remove(index);
            /**
             * 接下去要获得剩下的数字的所有排列情况中的第k-per*index种排列
             */
            k -= per * index;
            /**
             * 对于剩下的数字而言，共有total种排列情况
             */
            total = per;
        }
        return builder.toString();
    }
}
