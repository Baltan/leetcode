package leetcode.algorithms;

/**
 * Description: 557. Reverse Words in a String III
 * @author Baltan
 *
 * @date 2017/11/17 14:26
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s1 = "Let's take LeetCode contest";
        System.out.println(reverseWords(s1));
    }

    public static String reverseWords(String s) {
        String[] sArr = s.split("\\s");
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < sArr.length; i++) {
            int length = sArr[i].length();
            StringBuilder sb = new StringBuilder();
            for (int j = sArr[i].length() - 1; j >= 0; j--) {
                sb.append(sArr[i].substring(j, j + 1));
            }
            str.append(sb + " ");
        }
        return str.deleteCharAt(str.length() - 1).toString();
    }
}
