package leetcode.algorithms;

/**
 * Description: 2833. Furthest Point From Origin
 *
 * @author baltan
 * @date 2023/8/29 09:27
 */
public class FurthestDistanceFromOrigin {
    public static void main(String[] args) {
        System.out.println(furthestDistanceFromOrigin("L_RL__R"));
        System.out.println(furthestDistanceFromOrigin("_R__LL_"));
        System.out.println(furthestDistanceFromOrigin("_______"));
    }

    public static int furthestDistanceFromOrigin(String moves) {
        /**
         * 字符串中'L'的个数
         */
        int leftCount = 0;
        /**
         * 字符串中'R'的个数
         */
        int rightCount = 0;
        /**
         * 字符串中'_'的个数
         */
        int randomCount = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                leftCount++;
            } else if (c == 'R') {
                rightCount++;
            } else {
                randomCount++;
            }
        }
        /**
         * 将所有的'_'都当做'L'和'R'中较多的那一个
         */
        return Math.abs(leftCount - rightCount) + randomCount;
    }
}
