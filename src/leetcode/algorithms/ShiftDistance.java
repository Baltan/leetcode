package leetcode.algorithms;

/**
 * Description: 3361. Shift Distance Between Two Strings
 *
 * @author Baltan
 * @date 2024/11/24 19:53
 */
public class ShiftDistance {
    public static void main(String[] args) {
        int[] nextCost1 = {100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] previousCost1 = {1, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(shiftDistance("abab", "baba", nextCost1, previousCost1));

        int[] nextCost2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] previousCost2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(shiftDistance("leet", "code", nextCost2, previousCost2));
    }

    public static long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        long result = 0L;
        /**
         * 数组nextCost的前缀和数组
         */
        long[] nextPrefixSums = new long[27];
        /**
         * 数组previousCost的前缀和数组
         */
        long[] previousPrefixSums = new long[27];

        for (int i = 0; i < 26; i++) {
            nextPrefixSums[i + 1] = nextPrefixSums[i] + nextCost[i];
            previousPrefixSums[i + 1] = previousPrefixSums[i] + previousCost[i];
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                continue;
            }
            int start = s.charAt(i) - 'a';
            int end = t.charAt(i) - 'a';
            /**
             * 通过操作1将字符s[i]变为t[i]
             */
            long nextTotal = start < end ? nextPrefixSums[end] - nextPrefixSums[start] : nextPrefixSums[26] - (nextPrefixSums[start] - nextPrefixSums[end]);
            /**
             * 通过操作2将字符s[i]变为t[i]
             */
            long previousTotal = start > end ? previousPrefixSums[start + 1] - previousPrefixSums[end + 1] :
                    previousPrefixSums[26] - (previousPrefixSums[end + 1] - previousPrefixSums[start + 1]);
            result += Math.min(nextTotal, previousTotal);
        }
        return result;
    }
}
