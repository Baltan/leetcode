package leetcode.algorithms;

/**
 * Description:Find Smallest Letter Greater Than Target
 *
 * @author Baltan
 * @date 2017/12/31 14:15
 */
public class NextGreatestLetter {
    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if (target + 0 < letters[i] + 0) {
                return letters[i];
            }
        }
        return letters[0];
    }
}
