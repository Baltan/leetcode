package leetcode.algorithms;

/**
 * Description: 848. Shifting Letters
 *
 * @author Baltan
 * @date 2019-09-11 09:34
 */
public class ShiftingLetters {
    public static void main(String[] args) {
        String S1 = "abc";
        int[] shifts1 = {3, 5, 9};
        System.out.println(shiftingLetters(S1, shifts1));


        String S2 = "abcdefghijklmnopqrstuvwxyz";
        int[] shifts2 = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        System.out.println(shiftingLetters(S2, shifts2));
    }

    public static String shiftingLetters(String S, int[] shifts) {
        int length = S.length();
        /**
         * 记录当前字母需要移动的总位数（对26取模）
         */
        int count = 0;
        char[] sArray = S.toCharArray();
        /**
         * 从数组最后向前遍历，对应的字母进行移位操作，累加移位总位数（对26取模）
         */
        for (int i = length - 1; i >= 0; i--) {
            count = (count + shifts[i]) % 26;
            /**
             * 判断字母进行移位操作后是否超出'z'，否则需要从'a'开始继续移位
             */
            sArray[i] = (char) (sArray[i] + count > 'z' ? sArray[i] + count - 26 : sArray[i] + count);
        }
        return new String(sArray);
    }
}
