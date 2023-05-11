package leetcode.algorithms;

/**
 * Description: 2663. Lexicographically Smallest Beautiful String
 *
 * @author Baltan
 * @date 2023/5/7 21:39
 */
public class SmallestBeautifulString {
    public static void main(String[] args) {
        System.out.println(smallestBeautifulString("abdc", 4));
        System.out.println(smallestBeautifulString("abcz", 26));
        System.out.println(smallestBeautifulString("dc", 4));
    }

    public static String smallestBeautifulString(String s, int k) {
        int[] t = s.chars().map(x -> x - 'a').toArray();
        int last = t.length - 1;

        while (true) {
            boolean flag = increase(t, k, last);

            if (!flag) {
                return "";
            }

            if (isBeautiful(t)) {
                char[] chars = new char[t.length];

                for (int i = 0; i < t.length; i++) {
                    chars[i] = (char) (t[i] + 'a');
                }
                return new String(chars);
            }
        }
    }

    public static boolean increase(int[] t, int k, int index) {
        if (index < 0) {
            return false;
        }
        t[index]++;

        if (t[index] < k) {
            return true;
        }
        t[index] = 0;
        return increase(t, k, index - 1);
    }

    public static boolean isBeautiful(int[] t) {
        for (int i = t.length - 1; i >= 1; i--) {
            if ((i - 2 >= 0 && t[i] == t[i - 2]) || t[i] == t[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
