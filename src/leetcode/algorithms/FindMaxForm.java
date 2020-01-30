package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 474. Ones and Zeroes
 *
 * @author Baltan
 * @date 2020-01-30 13:10
 */
public class FindMaxForm {
    public static int result;

    public static void main(String[] args) {
        String[] strs1 = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs1, 5, 3));

        String[] strs2 = {"10", "0", "1"};
        System.out.println(findMaxForm(strs2, 1, 1));

        String[] strs3 =
                {"0", "11", "1000", "01", "0", "101", "1", "1", "1", "0", "0", "0", "0", "1", "0", "0110101",
                        "0", "11", "01", "00", "01111", "0011", "1", "1000", "0", "11101", "1", "0", "10",
                        "0111"};
        System.out.println(findMaxForm(strs3, 9, 80));

        String[] strs4 =
                {"11", "11", "0", "0", "10", "1", "1", "0", "11", "1", "0", "111", "11111000", "0", "11",
                        "000", "1", "1", "0", "00", "1", "101", "001", "000", "0", "00", "0011", "0",
                        "10000"};
        System.out.println(findMaxForm(strs4, 90, 66));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        result = 0;
        int count = 0;
        int length = strs.length;
        int[][] counts = new int[length][2];

        for (int i = 0; i < length; i++) {
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    counts[i][0]++;
                } else {
                    counts[i][1]++;
                }
            }
        }

        Arrays.sort(counts, (c1, c2) -> {
            if (c1[0] == c2[0]) {
                return c1[1] - c2[1];
            } else {
                return c1[0] - c2[0];
            }
        });

        dfs(counts, m, n, 0, count);
        return result;
    }

    public static void dfs(int[][] counts, int m, int n, int start, int count) {
        for (int i = start; i < counts.length; i++) {
            if (counts[i][0] <= m && counts[i][1] <= n) {
                count++;
                result = Math.max(result, count);
                dfs(counts, m - counts[i][0], n - counts[i][1], i + 1, count);
                count--;
            } else if (m < counts[i][0]) {
                return;
            }
        }
    }
}
