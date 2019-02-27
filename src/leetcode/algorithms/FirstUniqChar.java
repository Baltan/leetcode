package leetcode.algorithms;

/**
 * Description:First Unique Character in a String
 *
 * @author Baltan
 * @date 2018/1/3 09:49
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("abccba"));
    }

    public static int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            String currentLetter = s.substring(i, i + 1);
            int firstIndex = s.indexOf(currentLetter);
            int lastIndex = s.lastIndexOf(currentLetter);
            if (firstIndex == lastIndex) {
                return i;
            }
        }
        return -1;
    }
}
