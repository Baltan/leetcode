package leetcode.algorithms;

/**
 * Description: 1234. Replace the Substring for Balanced String
 *
 * @author Baltan
 * @date 2020-01-19 13:24
 */
public class BalancedString {
    public static void main(String[] args) {
        System.out.println(balancedString("QWER"));
        System.out.println(balancedString("QQWE"));
        System.out.println(balancedString("QQQW"));
        System.out.println(balancedString("QQQQ"));
        System.out.println(balancedString("WWEQERQWQWWRWWERQWEQ"));

        final int LEN = 100000;
        StringBuilder builder = new StringBuilder(LEN);
        for (int i = 0; i < LEN; i++) {
            builder.append("Q");
        }
        System.out.println(balancedString(builder.toString()));
    }

    public static int balancedString(String s) {
        int result = Integer.MAX_VALUE;
        int qCount = 0;
        int wCount = 0;
        int eCount = 0;
        int rCount = 0;
        int length = s.length();
        /**
         * 最后得到的平衡字符串中每个字母应该出现的次数
         */
        int average = length / 4;
        int leftIndex = 0;
        /**
         * 统计字符串s中每种字母出现的次数
         */
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (c == 'Q') {
                qCount++;
            } else if (c == 'W') {
                wCount++;
            } else if (c == 'E') {
                eCount++;
            } else {
                rCount++;
            }
        }
        /**
         * 滑动窗口计算子串的最小长度
         */
        for (int rightIndex = 0; rightIndex < length; rightIndex++) {
            char c = s.charAt(rightIndex);
            /**
             * 将窗口外的字母减掉右端点的字母
             */
            if (c == 'Q') {
                qCount--;
            } else if (c == 'W') {
                wCount--;
            } else if (c == 'E') {
                eCount--;
            } else {
                rCount--;
            }
            /**
             * 如果除去索引为[leftIndex,rightIndex]的字母，窗口外的每种字母数量都不大于average个，
             * 则替换子串s.substring(leftIndex,rightIndex+1)即可
             */
            while (qCount <= average && wCount <= average && eCount <= average && rCount <= average) {
                result = Math.min(result, rightIndex - leftIndex + 1);
                /**
                 * 如果当前窗口的长度已经为0了，无法再向右移动左端点了，退出当前循环后，将右端点右移
                 * 后继续计算
                 */
                if (rightIndex - leftIndex + 1 == 0) {
                    break;
                }
                /**
                 * 因为接下去要左移左端点缩小窗口，所以窗口外的字母要加上当前左端点的字母
                 */
                c = s.charAt(leftIndex);

                if (c == 'Q') {
                    qCount++;
                } else if (c == 'W') {
                    wCount++;
                } else if (c == 'E') {
                    eCount++;
                } else {
                    rCount++;
                }
                /**
                 * 将左端点右移
                 */
                leftIndex++;
            }
        }
        return result;
    }
}
