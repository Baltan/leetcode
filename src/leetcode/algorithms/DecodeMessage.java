package leetcode.algorithms;

/**
 * Description: 2325. Decode the Message
 *
 * @author Baltan
 * @date 2023/2/15 10:55
 */
public class DecodeMessage {
    public static void main(String[] args) {
        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        System.out.println(decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }

    public static String decodeMessage(String key, String message) {
        /**
         * replacement[0]-replacement[25]依次代表密文中的字符a-z对应的明文字符
         */
        char[] replacement = new char[26];
        /**
         * isVisited[0]-isVisited[25]依次代表字符a-z是否已在密文中出现过
         */
        boolean[] isVisited = new boolean[26];
        /**
         * 某个密文字符对应的明文字符
         */
        char clearText = 'a';
        char[] charArray = message.toCharArray();

        for (char c : key.toCharArray()) {
            if (c != ' ' && !isVisited[c - 'a']) {
                replacement[c - 'a'] = clearText++;
                isVisited[c - 'a'] = true;
            }
        }
        /**
         * 将所有密文字符替换成明文字符
         */
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ') {
                charArray[i] = replacement[charArray[i] - 'a'];
            }
        }
        return new String(charArray);
    }
}
