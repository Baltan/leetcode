package leetcode.algorithms;

import java.util.ArrayList;

/**
 * Description:Keyboard Row
 *
 * @author Baltan
 * @date 2017/12/29 10:16
 */
public class FindWords {
    public static void main(String[] args) {
        String[] wordArr = findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        String[] wordArr1 = findWords(new String[]{"abdfs", "cccd", "a", "qwwewm"});
        for (int i = 0; i < wordArr1.length; i++) {
            System.out.print(wordArr1[i] + "\t");
        }
        System.out.println();
    }

    public static String[] findWords(String[] words) {
        ArrayList<String> al = new ArrayList<String>();
        int count = 0;
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
                count++;
                al.add(word);
            }
        }
        return (String[]) al.toArray(new String[0]);
    }
}
