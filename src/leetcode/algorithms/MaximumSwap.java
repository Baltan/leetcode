package leetcode.algorithms;

/**
 * Description: 670. Maximum Swap
 *
 * @author Baltan
 * @date 2019-10-19 15:31
 */
public class MaximumSwap {
    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
        System.out.println(maximumSwap(9973));
        System.out.println(maximumSwap(100));
        System.out.println(maximumSwap(10203));
    }

    public static int maximumSwap(int num) {
        int result = num;
        String origin = String.valueOf(num);
        int length = origin.length();
        /**
         * 枚举每一种可能的交换方式，保存交换后得到的最大数字
         */
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                char c1 = origin.charAt(i);
                char c2 = origin.charAt(j);
                String str = origin.substring(0, i) + c2 + origin.substring(i + 1, j) + c1 +
                        origin.substring(j + 1);
                int value = Integer.valueOf(str);
                result = Math.max(result, value);
            }
        }
        return result;
    }
}
