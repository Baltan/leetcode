package leetcode.algorithms;

/**
 * Description: 2075. Decode the Slanted Ciphertext
 *
 * @author Baltan
 * @date 2021/11/15 22:57
 */
public class DecodeCiphertext {
    public static void main(String[] args) {
        System.out.println(decodeCiphertext("ch   ie   pr", 3));
        System.out.println(decodeCiphertext("iveo    eed   l te   olc", 4));
        System.out.println(decodeCiphertext("coding", 1));
        System.out.println(decodeCiphertext(" b  ac", 2));
        System.out.println(decodeCiphertext("", 5));
    }

    public static String decodeCiphertext(String encodedText, int rows) {
        StringBuilder builder = new StringBuilder();
        int length = encodedText.length();
        int cols = length / rows;
        /**
         * 加密字符串中的字母个数
         */
        int letterCount = 0;
        char[] charArray = encodedText.toCharArray();

        for (char c : charArray) {
            if (c != ' ') {
                letterCount++;
            }
        }
        /**
         * 从第一行的每个字母依次向右下方遍历，知道把letterCount个字母都找到为止
         */
        for (int i = 0; i < cols; i++) {
            int index = i;

            while (index < length) {
                builder.append(charArray[index]);

                if (charArray[index] != ' ') {
                    letterCount--;
                    /**
                     * 已找到所有字母，剩余如果还有字符都为' '，不考虑
                     */
                    if (letterCount == 0) {
                        return builder.toString();
                    }
                }
                /**
                 * 右下方字符在加密字符串中的索引
                 */
                index += (cols + 1);
            }
        }
        return builder.toString();
    }
}
