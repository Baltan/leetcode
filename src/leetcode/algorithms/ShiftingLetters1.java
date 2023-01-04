package leetcode.algorithms;

/**
 * Description: 2381. Shifting Letters II
 *
 * @author Baltan
 * @date 2023/1/3 09:51
 */
public class ShiftingLetters1 {
    public static void main(String[] args) {
        String s1 = "abc";
        int[][] shifts1 = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
        System.out.println(shiftingLetters(s1, shifts1));

        String s2 = "dztz";
        int[][] shifts2 = {{0, 0, 0}, {1, 1, 1}};
        System.out.println(shiftingLetters(s2, shifts2));
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        /**
         * 差分数组
         */
        int[] diffs = new int[length];
        /**
         * 遍历过程中当前字符的累计向后移位位数
         */
        int totalOffset = 0;

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int offset = shift[2] == 1 ? 1 : -1;
            diffs[start] += offset;

            if (end + 1 < length) {
                diffs[(end + 1)] -= offset;
            }
        }

        for (int i = 0; i < length; i++) {
            /**
             * 字符charArray[i]向后移位总位数
             */
            totalOffset += diffs[i];
            /**
             * 考虑循环的情况（'z'变成'a'），向后移位totalOffset位实际相当于向后移位actualOffset位
             */
            int actualOffset = (totalOffset % 26 + 26) % 26;
            /**
             * charArray[i]-'a'表示字符charArray[i]相对字符'a'的偏移量
             * (charArray[i]-'a'+actualOffset)%26表示字符charArray[i]向后移位后相对字符'a'的偏移量
             */
            charArray[i] = (char) ((charArray[i] - 'a' + actualOffset) % 26 + 'a');
        }
        return new String(charArray);
    }
}
