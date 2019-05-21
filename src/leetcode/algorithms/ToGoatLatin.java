package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 824. Goat Latin
 *
 * @author Baltan
 * @date 2018/7/31 15:50
 */
public class ToGoatLatin {
    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
        System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

    public static String toGoatLatin(String S) {
        List<Character> vowelList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        String[] array = S.split(" ");
        String str;
        StringBuilder sb;
        for (int i = 0; i < array.length; i++) {
            str = array[i];
            sb = new StringBuilder(str);
            if (vowelList.contains(str.charAt(0))) {
                sb.append("ma");
            } else {
                sb.append(str.charAt(0)).deleteCharAt(0).append("ma");
            }
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            array[i] = sb.toString();
        }

        StringBuilder newSb = new StringBuilder(array[0]);

        for (int i = 1; i < array.length; i++) {
            newSb.append(" ").append(array[i]);
        }
        return newSb.toString();
    }
}
