package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 942. DI String Match
 *
 * @author Baltan
 * @date 2019-03-13 09:47
 */
public class DiStringMatch {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(diStringMatch("IDID"));
        OutputUtils.print1DIntegerArray(diStringMatch("III"));
        OutputUtils.print1DIntegerArray(diStringMatch("DDI"));
    }

    public static int[] diStringMatch(String S) {
        int length = S.length();
        int[] result = new int[length + 1];
        int lo = 0;
        int hi = length;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == 'I') {
                result[i] = lo;
                lo++;
            } else {
                result[i] = hi;
                hi--;
            }
        }
        result[length] = lo;
        return result;
    }
}
