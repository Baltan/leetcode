package leetcode.algorithms;

/**
 * Description: 443. String Compression
 *
 * @author Baltan
 * @date 2017/11/24 15:23
 */
public class Compress {
    public static void main(String[] args) {
        char[] chars1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] chars2 = {'a'};
        char[] chars3 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(chars1));
        System.out.println(compress(chars2));
        System.out.println(compress(chars3));
    }

    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        int currLength = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                currLength++;
            } else {
                if (currLength == 1) {
                    sb.append(chars[i - 1]);
                } else {
                    sb.append(chars[i - 1]).append(currLength);
                }
                currLength = 1;
            }
            if (i == chars.length - 1) {
                if (currLength == 1) {
                    sb.append(chars[i]);
                } else {
                    sb.append(chars[i]).append(currLength);
                }
            }
        }
        char[] newChars = sb.toString().toCharArray();
        for (int i = 0; i < newChars.length; i++) {
            chars[i] = newChars[i];
        }
        return sb.toString().length();
    }
}
