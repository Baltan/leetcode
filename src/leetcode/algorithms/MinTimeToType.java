package leetcode.algorithms;

/**
 * Description: 1974. Minimum Time to Type Word Using Special Typewriter
 *
 * @author Baltan
 * @date 2022/1/23 13:25
 */
public class MinTimeToType {
    public static void main(String[] args) {
        System.out.println(minTimeToType("abc"));
        System.out.println(minTimeToType("bza"));
        System.out.println(minTimeToType("zjpc"));
    }

    public static int minTimeToType(String word) {
        int result = 0;
        /**
         * 移动指针前指针所在的字符
         */
        char currPos = 'a';

        for (char c : word.toCharArray()) {
            /**
             * 顺时针移动指针最少需要的秒数
             */
            int clockwiseSteps = c >= currPos ? c - currPos : 26 - (currPos - c);
            /**
             * 逆时针移动指针最少需要的秒数
             */
            int counterclockwiseSteps = c <= currPos ? currPos - c : 26 - (c - currPos);
            /**
             * 加上移动指针最少需要的秒数和打印字符的1秒
             */
            result = result + Math.min(clockwiseSteps, counterclockwiseSteps) + 1;
            /**
             * 更新指针最终停留的字符，作为打印下一个字符移动指针前所在的字符
             */
            currPos = c;
        }
        return result;
    }
}
