package leetcode.algorithms;

/**
 * Description: 3106. Lexicographically Smallest String After Operations With Constraint
 *
 * @author Baltan
 * @date 2024/4/7 21:35
 */
public class GetSmallestString1 {
    public static void main(String[] args) {
        System.out.println(getSmallestString("zbbz", 3));
        System.out.println(getSmallestString("xaxcd", 4));
        System.out.println(getSmallestString("lol", 0));
    }

    public static String getSmallestString(String s, int k) {
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            /**
             * 当前字母charArray[i]和字母a的距离
             */
            int distance = Math.min(charArray[i] - 'a', 26 - (charArray[i] - 'a'));
            /**
             * 如果能够令当前字符变为'a'，就变为'a'，否则就变为可能的字典顺序最小的字母charArray[i]-k
             */
            if (distance <= k) {
                charArray[i] = 'a';
                k -= distance;
            } else {
                charArray[i] -= k;
                break;
            }
        }
        return new String(charArray);
    }
}
