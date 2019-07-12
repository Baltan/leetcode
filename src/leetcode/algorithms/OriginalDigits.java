package leetcode.algorithms;

/**
 * Description: 423. Reconstruct Original Digits from English
 *
 * @author Baltan
 * @date 2019-07-12 11:38
 */
public class OriginalDigits {
    public static void main(String[] args) {
        System.out.println(originalDigits("owoztneoer"));
        System.out.println(originalDigits("fviefuro"));
    }

    public static String originalDigits(String s) {
        StringBuilder builder = new StringBuilder();
        int[] letterCount = new int[26];
        int[] numCount = new int[10];
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            letterCount[c - 'a']++;
        }

        int zCount = letterCount['z' - 'a'];
        numCount[0] = zCount;
        letterCount['z' - 'a'] -= zCount;
        letterCount['e' - 'a'] -= zCount;
        letterCount['r' - 'a'] -= zCount;
        letterCount['o' - 'a'] -= zCount;

        int wCount = letterCount['w' - 'a'];
        numCount[2] = wCount;
        letterCount['t' - 'a'] -= wCount;
        letterCount['w' - 'a'] -= wCount;
        letterCount['o' - 'a'] -= wCount;

        int xCount = letterCount['x' - 'a'];
        numCount[6] = xCount;
        letterCount['s' - 'a'] -= xCount;
        letterCount['i' - 'a'] -= xCount;
        letterCount['x' - 'a'] -= xCount;

        int sCount = letterCount['s' - 'a'];
        numCount[7] = sCount;
        letterCount['s' - 'a'] -= sCount;
        letterCount['e' - 'a'] -= sCount * 2;
        letterCount['v' - 'a'] -= sCount;
        letterCount['n' - 'a'] -= sCount;

        int vCount = letterCount['v' - 'a'];
        numCount[5] = vCount;
        letterCount['f' - 'a'] -= vCount;
        letterCount['i' - 'a'] -= vCount;
        letterCount['v' - 'a'] -= vCount;
        letterCount['e' - 'a'] -= vCount;

        int fCount = letterCount['f' - 'a'];
        numCount[4] = fCount;
        letterCount['f' - 'a'] -= fCount;
        letterCount['o' - 'a'] -= fCount;
        letterCount['u' - 'a'] -= fCount;
        letterCount['r' - 'a'] -= fCount;

        int oCount = letterCount['o' - 'a'];
        numCount[1] = oCount;
        letterCount['o' - 'a'] -= oCount;
        letterCount['n' - 'a'] -= oCount;
        letterCount['e' - 'a'] -= oCount;

        int gCount = letterCount['g' - 'a'];
        numCount[8] = gCount;
        letterCount['e' - 'a'] -= gCount;
        letterCount['i' - 'a'] -= gCount;
        letterCount['g' - 'a'] -= gCount;
        letterCount['h' - 'a'] -= gCount;
        letterCount['t' - 'a'] -= gCount;

        int tCount = letterCount['t' - 'a'];
        numCount[3] = tCount;
        letterCount['t' - 'a'] -= tCount;
        letterCount['h' - 'a'] -= tCount;
        letterCount['r' - 'a'] -= tCount;
        letterCount['e' - 'a'] -= tCount * 2;

        int eCount = letterCount['e' - 'a'];
        numCount[9] = eCount;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < numCount[i]; j++) {
                builder.append(i);
            }
        }
        return builder.toString();
    }
}
