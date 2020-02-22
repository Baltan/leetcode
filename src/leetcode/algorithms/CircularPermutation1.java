package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1238. Circular Permutation in Binary Representation
 *
 * @author Baltan
 * @date 2020-02-21 17:32
 * @see GrayCode
 * @see CircularPermutation
 */
public class CircularPermutation1 {
    public static void main(String[] args) {
        System.out.println(circularPermutation(2, 3));
        System.out.println(circularPermutation(3, 2));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/circular-permutation-in-binary-representation/solution/c-yi-ci-xun-huan-zhi-jie-qiu-jie-wei-yun-suan-by-h/"></a>
     */
    public static List<Integer> circularPermutation(int n, int start) {
        LinkedList<Integer> result = new LinkedList<>();
        /**
         * 循环码排列最大值
         */
        int max = (int) (Math.pow(2, n) - 1);

        for (int i = 0; i <= max; i++) {
            /**
             *      十进制数    二进制数    二进制格雷码    十进制格雷码
             *         0         000          000            0
             *         1         001          001            1
             *         2         010          011            3
             *         3         011          010            2
             *         4         100          110            6
             *         5         101          111            7
             *         6         110          101            5
             *         7         111          100            4
             *
             *  十进制数i对应的格雷码十进制值为i^(i>>1)
             */
            result.add(i ^ (i >> 1));
        }
        /**
         * 将头部的格雷码不断移到尾部，直到头部的数字为start为止
         */
        while (result.getFirst() != start) {
            result.offerLast(result.pollFirst());
        }
        return result;
    }
}
