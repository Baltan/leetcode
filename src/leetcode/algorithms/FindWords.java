package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;

/**
 * Description: 500. Keyboard Row
 *
 * @author Baltan
 * @date 2017/12/29 10:16
 */
public class FindWords {
    public static void main(String[] args) {
        OutputUtils.print1DStringArray(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}));
        OutputUtils.print1DStringArray(findWords(new String[]{"abdfs", "cccd", "a", "qwwewm"}));
    }

    public static String[] findWords(String[] words) {
        ArrayList<String> al = new ArrayList<>();
        String[] keyboardArr = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String keyboardRow = null;
            boolean flag = true;
            for (int j = 0; j < keyboardArr.length; j++) {
                keyboardRow = keyboardArr[j];
                if (keyboardRow.contains(word.substring(0, 1).toLowerCase())) {
                    break;
                }
            }
            for (int k = 1; k < word.length(); k++) {
                if (!keyboardRow.contains(word.substring(k, k + 1).toLowerCase())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                al.add(word);
            }
        }
        return al.toArray(new String[0]);
    }
}
