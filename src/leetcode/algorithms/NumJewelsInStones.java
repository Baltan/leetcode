package leetcode.algorithms;

/**
 * Description: 771. Jewels and Stones
 *
 * @author Baltan
 * @date 2018/7/30 08:45
 */
public class NumJewelsInStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
        System.out.println(numJewelsInStones("", "ZZ"));
        System.out.println(numJewelsInStones("aA", ""));
        System.out.println(numJewelsInStones("", ""));
    }

    public static int numJewelsInStones(String J, String S) {
        char jLetter;
        char sLetter;
        int num = 0;
        for (int i = 0; i < J.length(); i++) {
            jLetter = J.charAt(i);
            for (int j = 0; j < S.length(); j++) {
                sLetter = S.charAt(j);
                if (jLetter == sLetter) {
                    num++;
                }
            }
        }
        return num;
    }
}
