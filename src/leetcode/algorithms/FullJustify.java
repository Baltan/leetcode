package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 68. Text Justification
 *
 * @author Baltan
 * @date 2018/9/21 16:38
 */
public class FullJustify {
    public static void main(String[] args) {
        System.out.println(
                fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(
                fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        System.out.println(
                fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to",
                        "explain",
                        "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
        System.out.println(
                fullJustify(new String[]{"ask", "not", "what", "your", "country", "can", "do", "for", "you",
                        "ask", "what", "you", "can", "do", "for", "your", "country"}, 16));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int length = words.length;
        int startIndex = 0;
        int currentLength;
        int currentTotalWordsLength = 0;
        int i;
        for (i = 0; i < length; i++) {
            currentTotalWordsLength = currentTotalWordsLength + words[i].length();
            currentLength = currentTotalWordsLength + i - startIndex;
            if (currentLength > maxWidth) {
                StringBuilder sb = new StringBuilder(maxWidth);
                int totalWordsLength = currentTotalWordsLength - words[i].length();
                int totalBlankLength = maxWidth - totalWordsLength;
                int blankNum = i - 1 - startIndex;
                if (blankNum == 0) {
                    sb.append(words[startIndex]);
                    int blankLength = maxWidth - words[startIndex].length();
                    for (int j = 0; j < blankLength; j++) {
                        sb.append(" ");
                    }
                } else {
                    int averageBlankLength = totalBlankLength / blankNum;
                    String shortBlank = "";
                    for (int j = 0; j < averageBlankLength; j++) {
                        shortBlank += " ";
                    }
                    String longBlank = shortBlank + " ";
                    int restBlankLength = totalBlankLength - averageBlankLength * blankNum;
                    for (int j = 0; j < restBlankLength; j++) {
                        sb.append(words[startIndex + j]).append(longBlank);
                    }
                    for (int j = restBlankLength; j < i - 1 - startIndex; j++) {
                        sb.append(words[startIndex + j]).append(shortBlank);
                    }
                    sb.append(words[i - 1]);
                }
                startIndex = i;
                currentTotalWordsLength = 0;
                i--;
                res.add(sb.toString());
            }
        }
        if (currentTotalWordsLength != 0) {
            int blankLength = maxWidth;
            StringBuilder sb = new StringBuilder(maxWidth);
            for (int j = startIndex; j < length - 1; j++) {
                sb.append(words[j]).append(" ");
                blankLength = blankLength - words[j].length() - 1;
            }
            sb.append(words[length - 1]);
            blankLength -= words[length - 1].length();
            for (int j = 0; j < blankLength; j++) {
                sb.append(" ");
            }
            res.add(sb.toString());
        }
        return res;
    }
}
