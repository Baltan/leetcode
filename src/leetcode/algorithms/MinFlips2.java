package leetcode.algorithms;

/**
 * Description: 1888. Minimum Number of Flips to Make the Binary String Alternating
 *
 * @author Baltan
 * @date 2022/5/3 12:19
 */
public class MinFlips2 {
    public static void main(String[] args) {
        System.out.println(minFlips("111000"));
        System.out.println(minFlips("010"));
        System.out.println(minFlips("1110"));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/solution/minimum-number-of-flips-by-ikaruga-lu32/"></a>
     *
     * @param s
     * @return
     */
    public static int minFlips(String s) {
        int result;
        int length = s.length();
        /**
         * 考虑类型1的操作可以让字符串s首尾相接，也就是说可以构成一个以s的任意字符开头的长度为length的字符串，在该字符串的基础上
         * 进行类型2的操作，最终得到一个交替字符串。所以将s自身先复制一遍拼接到最后，便于后面的计算
         */
        s = s + s;
        char[] charArray = s.toCharArray();
        /**
         * 当前长度为length的子串得到一个交替字符串需要类型2翻转操作的次数
         */
        int flipCount = 0;
        /**
         * 为了保证当前子串是交替字符串，当前字符的目标值，设定以s[0]打头，长度为length的子串构成的交替字符串为"010101……"
         */
        char targetValue = '0';
        /**
         * isFlipped[i]表示charArray[i]是否进行过类型2翻转操作
         */
        boolean[] isFlipped = new boolean[charArray.length];
        /**
         * 假设最终要让以s[0]打头，长度为length的子串构成的交替字符串为"010101……"
         */
        for (int i = 0; i < length; i++) {
            /**
             * 如果当前字符和目标值不服，就要进行类型2翻转操作
             */
            if (charArray[i] != targetValue) {
                flipCount++;
                isFlipped[i] = true;
            }
            /**
             * 设定下一个字符的目标值
             */
            targetValue = targetValue == '0' ? '1' : '0';
        }
        /**
         * flipCount为当前子串最终构成"010101……"交替字符串的类型2翻转操作次数，length-flipCount为当前子串最终构成
         * "101010……"交替字符串的类型2翻转操作次数，两者取较小值
         */
        result = Math.min(flipCount, length - flipCount);
        /**
         * 通过长度为length的滑动窗口逐一判断子串构成交替字符串"010101……"或"101010……"需要类型2翻转操作的次数，每次窗口右移一
         * 个位置，即取出头部字符charArray[i-length]，加上尾部字符charArray[i]
         */
        for (int i = length; i < charArray.length; i++) {
            if (charArray[i] != targetValue) {
                flipCount++;
                isFlipped[i] = true;
            }
            /**
             * 如果头部字符之前已经是被翻转过的，需要将这次类型2翻转操作的次数扣除
             */
            if (isFlipped[i - length]) {
                flipCount--;
            }
            targetValue = targetValue == '0' ? '1' : '0';
            /**
             * 当前子串构成两种交替字符串需要类型2翻转操作的次数分别为flipCount和length-flipCount
             */
            result = Math.min(result, flipCount);
            result = Math.min(result, length - flipCount);
        }
        return result;
    }
}
