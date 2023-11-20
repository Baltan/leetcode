package leetcode.algorithms;

/**
 * Description: 2938. Separate Black and White Balls
 *
 * @author baltan
 * @date 2023/11/20 09:27
 */
public class MinimumSteps {
    public static void main(String[] args) {
        System.out.println(minimumSteps("101"));
        System.out.println(minimumSteps("100"));
        System.out.println(minimumSteps("0111"));
    }

    public static long minimumSteps(String s) {
        long result = 0L;
        /**
         * 白球最终的索引位置
         */
        int target = 0;
        char[] charArray = s.toCharArray();
        /**
         * 将所有白球依次向左移动到索引值为[0,x]的这些位置
         */
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '0') {
                /**
                 * 白球s[i]移动到s[target]所在位置需要的操作次数
                 */
                result += i - target;
                target++;
            }
        }
        return result;
    }
}
