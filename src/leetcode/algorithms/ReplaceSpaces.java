package leetcode.algorithms;

/**
 * Description: 面试题 01.03. URL化
 *
 * @author Baltan
 * @date 2020-03-10 15:03
 */
public class ReplaceSpaces {
    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith    ", 13));
        System.out.println(replaceSpaces("               ", 5));
    }

    public static String replaceSpaces(String S, int length) {
        /**
         * S中空格的个数
         */
        int spaceCount = length;

        for (int i = 0; i < length; i++) {
            if (Character.isAlphabetic(S.charAt(i))) {
                spaceCount--;
            }
        }
        /**
         * 因为每个空格转化为"%20"后多出两个字符，所以转化后的字符数组长度为length+spaceCount*2
         */
        char[] charArray = new char[length + spaceCount * 2];
        int index = 0;
        /**
         * 逐一填充字符数组，如果遇到空格，就在数组连续三位上填上'%'、'2'、'0'
         */
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);

            if (Character.isAlphabetic(c)) {
                charArray[index++] = c;
            } else {
                charArray[index++] = '%';
                charArray[index++] = '2';
                charArray[index++] = '0';
            }
        }
        return new String(charArray);
    }
}
