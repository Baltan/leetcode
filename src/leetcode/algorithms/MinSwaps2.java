package leetcode.algorithms;

/**
 * Description: 1963. Minimum Number of Swaps to Make the String Balanced
 *
 * @author Baltan
 * @date 2022/1/30 14:38
 */
public class MinSwaps2 {
    public static void main(String[] args) {
        System.out.println(minSwaps("][]["));
        System.out.println(minSwaps("]]][[["));
        System.out.println(minSwaps("[]"));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/solution/go-tan-xin-by-endlesscheng-7h9n/"></a>
     *
     * @param s
     * @return
     */
    public static int minSwaps(String s) {
        int result = 0;
        /**
         * 每逢"["将value加1，每逢"]"将value减1
         */
        int value = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                value++;
            } else if (value > 0) {
                /**
                 * 前面存在多余的"["，当前"]"抵消一个"["
                 */
                value--;
            } else {
                /**
                 * 前面没有多余的"["可以抵消当前"]"，需要把后面的"["和当前"]"交换
                 */
                result++;
                value++;
            }
        }
        return result;
    }
}
