package leetcode.algorithms;

/**
 * Description: 2810. Faulty Keyboard
 *
 * @author Baltan
 * @date 2023/8/13 23:32
 */
public class FinalString {
    public static void main(String[] args) {
        System.out.println(finalString("string"));
        System.out.println(finalString("poiinter"));
    }

    public static String finalString(String s) {
        StringBuilder builder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == 'i') {
                /**
                 * 翻转已输入的字符串
                 */
                builder.reverse();
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
