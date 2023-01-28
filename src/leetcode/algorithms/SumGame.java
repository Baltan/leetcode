package leetcode.algorithms;

/**
 * Description: 1927. Sum Game
 *
 * @author Baltan
 * @date 2023/1/27 17:14
 */
public class SumGame {
    public static void main(String[] args) {
        System.out.println(sumGame("5023"));
        System.out.println(sumGame("25??"));
        System.out.println(sumGame("?3295???"));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/sum-game/solutions/869354/shu-xue-jie-fa-by-newhar-fqjs/"></a>
     *
     * @param num
     * @return
     */
    public static boolean sumGame(String num) {
        /**
         * 字符串num中前一半数字的和
         */
        double leftSum = 0d;
        /**
         * 字符串num中后一半数字的和
         */
        double rightSum = 0d;
        /**
         * 字符串num中问号的个数
         */
        int count = 0;
        char[] charArray = num.toCharArray();
        int length = charArray.length;
        int halfLength = length / 2;

        for (int i = 0; i < halfLength; i++) {
            if (charArray[i] == '?') {
                leftSum += 4.5;
                count++;
            } else {
                leftSum += charArray[i] - '0';
            }
        }

        for (int i = halfLength; i < length; i++) {
            if (charArray[i] == '?') {
                rightSum += 4.5;
                count++;
            } else {
                rightSum += charArray[i] - '0';
            }
        }
        /**
         * 当问号个数为奇数时，最后一个问号由Alice赋值，她总是可以令leftSum不等于rightSum，所以一定可以获胜
         */
        if (count % 2 != 0) {
            return true;
        }
        /**
         * 初始时将每个问号都看做数字4.5参与计算，假设初始时leftSum和rightSum之差为diff。每次操作两人可以令diff最多增加4.5（将前一半的某个
         * 问号修改为9或将后一半的某个问号修改为0），令diff最多减少4.5（将前一半的某个问号修改为0或将后一半的某个问号修改为9）。如果初始时diff
         * 大于0，则每次Alice操作总是令diff增加4.5，而Bob每次操作最多令diff减少4.5，所以无法令diff最终变为0。如果初始时diff小于0，则每次
         * Alice操作总是令diff减少4.5，而Bob每次操作最多令diff增加4.5，同样无法令diff最终变为0。如果初始时diff等于0，则每次Alice操作不论
         * 令diff变化多少，Bob总是可以接着令diff变回为0
         */
        return leftSum != rightSum;
    }
}
