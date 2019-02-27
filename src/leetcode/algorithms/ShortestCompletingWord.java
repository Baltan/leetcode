package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:Shortest Completing Word
 *
 * @author Baltan
 * @date 2018/1/11 16:28
 */
public class ShortestCompletingWord {
    public static void main(String[] args) {
        System.out.println(shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
        System.out.println(shortestCompletingWord("1", new String[]{"looks", "pest", "stew", "show"}));
        System.out.println(shortestCompletingWord("w", new String[]{"looks", "pest", "stew", "show"}));
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        List<String> licencePlateList = new ArrayList<>();
        String regExp = "[a-zA-Z]{1}";
        String letter;
        //题目中假设words[i]的长度为[1,15]
        String completingWord = "aaaaaaaaaaaaaaaa";
        for (int i = 0; i < licensePlate.length(); i++) {
            if ((letter = licensePlate.substring(i, i + 1)).matches(regExp)) {
                licencePlateList.add(letter.toLowerCase());
            }
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (licencePlateList.size() == 0) {
                if (word.length() < completingWord.length()) {
                    completingWord = word;
                }
            } else {
                for (int j = 0; j < licencePlateList.size(); j++) {
                    int index = word.indexOf(licencePlateList.get(j));
                    if (index == -1) {
                        break;
                    } else {
                        word = word.substring(0, index) + word.substring(index + 1);
                    }
                    if (j == licencePlateList.size() - 1 && words[i].length() < completingWord.length()) {
                        completingWord = words[i];
                    }
                }
            }
        }
        return completingWord;
    }
}
