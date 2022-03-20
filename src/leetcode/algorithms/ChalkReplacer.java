package leetcode.algorithms;

/**
 * Description: 1894. Find the Student that Will Replace the Chalk
 *
 * @author Baltan
 * @date 2022/3/20 12:26
 */
public class ChalkReplacer {
    public static void main(String[] args) {
        System.out.println(chalkReplacer(new int[]{5, 1, 5}, 22));
        System.out.println(chalkReplacer(new int[]{3, 4, 1, 2}, 25));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        /**
         * 完成一轮问题回答需要的粉笔总数
         */
        long sum = 0L;

        for (int num : chalk) {
            sum += num;
        }
        /**
         * 完成若干轮问题回答后剩余的粉笔总数
         */
        k = (int) (k % sum);
        /**
         * 逐一判断到谁回答问题时，粉笔数量不足
         */
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
        }
        return -1;
    }
}
