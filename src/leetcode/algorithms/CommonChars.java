package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: Find Common Characters
 *
 * @author Baltan
 * @date 2019-03-13 11:06
 */
public class CommonChars {
    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(commonChars(new String[]{"cool", "lock", "cook"}));
    }

    public static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        int[] arr = new int[26];
        Arrays.fill(arr, Integer.MAX_VALUE);

        for (String a : A) {
            int[] book = new int[26];
            int strLength = a.length();
            for (int i = 0; i < strLength; i++) {
                book[a.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                arr[i] = arr[i] < book[i] ? arr[i] : book[i];
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result;
    }
}