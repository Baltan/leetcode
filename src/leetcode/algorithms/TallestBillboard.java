package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 956. Tallest Billboard
 *
 * @author Baltan
 * @date 2024/10/26 17:58
 */
public class TallestBillboard {
    public static void main(String[] args) {
        System.out.println(tallestBillboard(new int[]{102, 101, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100}));
        System.out.println(tallestBillboard(new int[]{1, 2, 3, 6}));
        System.out.println(tallestBillboard(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(tallestBillboard(new int[]{1, 2}));
    }

    public static int tallestBillboard(int[] rods) {
        int length = rods.length;
        int sum = 0;
        int maxStatus = (1 << length) - 1;
        int[] bitCounts = new int[maxStatus + 1];

        for (int rod : rods) {
            sum += rod;
        }
        List<Integer>[] conditions = new List[sum + 1];

        for (int i = 1; i <= maxStatus; i++) {
            int j = i;
            int index = 0;
            int height = 0;
            int bitCount = 0;

            while (j > 0) {
                int bit = j & 1;

                if (bit == 1) {
                    height += rods[index];
                    bitCount++;
                }
                j >>= 1;
                index++;
            }

            if (conditions[height] == null) {
                conditions[height] = new ArrayList<>();
            }
            bitCounts[i] = bitCount;
            conditions[height].add(i);
        }

        for (int i = sum; i > 0; i--) {
            if (conditions[i] != null && conditions[i].size() > 1) {
                for (int j = 0; j < conditions[i].size(); j++) {
                    for (int k = j + 1; k < conditions[i].size(); k++) {
                        int conditionJ = conditions[i].get(j);
                        int conditionK = conditions[i].get(k);

                        if (bitCounts[conditionJ] + bitCounts[conditionK] == Integer.bitCount(conditionJ | conditionK)) {
                            return i;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
