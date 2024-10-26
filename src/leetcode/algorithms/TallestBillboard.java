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
        System.out.println(tallestBillboard(new int[]{1, 2, 3, 6}));
        System.out.println(tallestBillboard(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(tallestBillboard(new int[]{1, 2}));
    }

    public static int tallestBillboard(int[] rods) {
        int result = 0;
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

            if (height <= result) {
                continue;
            }

            if (conditions[height] != null) {
                for (int status : conditions[height]) {
                    if (bitCounts[status] + bitCount == Integer.bitCount(status | i)) {
                        result = Math.max(result, height);
                        break;
                    }
                }
            } else {
                conditions[height] = new ArrayList<>();
            }
            bitCounts[i] = bitCount;
            conditions[height].add(i);
        }
        return result;
    }
}
