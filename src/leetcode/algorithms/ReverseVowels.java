package leetcode.algorithms;

/**
 * Description:Reverse Vowels of a String
 *
 * @author Baltan
 * @date 2017/11/24 14:15
 */
public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("y"));
    }

    public static String reverseVowels(String s) {
        if ("".equals(s) || s.length() == 1) {
            return s;
        }
        String[] sArr = s.split("");
        int head = 0;
        int end = sArr.length - 1;
        while (head < end) {
            String headLetter = sArr[head];
            String endLetter = sArr[end];
            boolean headFlag =
                    "a".equalsIgnoreCase(headLetter) || "e".equalsIgnoreCase(headLetter) || "i".equalsIgnoreCase(headLetter) ||
                            "o".equalsIgnoreCase(headLetter) || "u".equalsIgnoreCase(headLetter);
            boolean endFlag =
                    "a".equalsIgnoreCase(endLetter) || "e".equalsIgnoreCase(endLetter) || "i".equalsIgnoreCase(endLetter) ||
                            "o".equalsIgnoreCase(endLetter) || "u".equalsIgnoreCase(endLetter);
            if (headFlag == false) {
                head++;
            }
            if (endFlag == false) {
                end--;
            }
            if (headFlag && endFlag) {
                String temp = sArr[head];
                sArr[head] = sArr[end];
                sArr[end] = temp;
                head++;
                end--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : sArr) {
            sb.append(str);
        }
        return sb.toString();
    }
}
