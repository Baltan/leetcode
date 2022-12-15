package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2433. Find The Original Array of Prefix Xor
 *
 * @author Baltan
 * @date 2022/12/11 12:51
 */
public class FindArray {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(findArray(new int[]{5, 2, 0, 3, 1}));
        OutputUtils.print1DIntegerArray(findArray(new int[]{13}));
    }

    public static int[] findArray(int[] pref) {
        int length = pref.length;
        int[] result = new int[length];
        result[0] = pref[0];

        for (int i = 1; i < length; i++) {
            /**
             * 如果a^b=c，则b^c=a且a^c=b。
             * 因为pref[i]=arr[0]^arr[1]^……^arr[i]，所以arr[i]=pref[i]^(arr[0]^arr[1]^……^arr[i-1])=pref[i]^pref[i-1]
             */
            result[i] = pref[i - 1] ^ pref[i];
        }
        return result;
    }
}
