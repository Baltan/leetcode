package leetcode.algorithms;

/**
 * Description: 3163. String Compression III
 *
 * @author baltan
 * @date 2024/5/30 09:20
 */
public class CompressedString {
    public static void main(String[] args) {
        System.out.println(compressedString("abcde"));
        System.out.println(compressedString("aaaaaaaaaaaaaabb"));
    }

    public static String compressedString(String word) {
        StringBuilder builder = new StringBuilder();
        char[] charArray = word.toCharArray();
        /**
         * 前一个字符
         */
        char prev = charArray[0];
        /**
         * 字符已重复的次数
         */
        int count = 1;

        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] != prev || count == 9) {
                builder.append(count).append(prev);
                /**
                 * 重新开始对新字符计数
                 */
                prev = charArray[i];
                count = 1;
            } else {
                count++;
            }
        }
        builder.append(count).append(prev);
        return builder.toString();
    }
}
