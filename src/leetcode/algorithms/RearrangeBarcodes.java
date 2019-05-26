package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1054. Distant Barcodes
 *
 * @author Baltan
 * @date 2019-05-26 16:52
 */
public class RearrangeBarcodes {
    public static void main(String[] args) {
        int[] barcodes1 = {1, 1, 1, 2, 2, 2};
        OutputUtils.print1DIntegerArray(rearrangeBarcodes(barcodes1));

        int[] barcodes2 = {1, 1, 1, 1, 2, 2, 3, 3};
        OutputUtils.print1DIntegerArray(rearrangeBarcodes(barcodes2));

        int[] barcodes3 = {3, 3, 3, 4, 4, 4, 4};
        OutputUtils.print1DIntegerArray(rearrangeBarcodes(barcodes3));

        int[] barcodes4 = {1};
        OutputUtils.print1DIntegerArray(rearrangeBarcodes(barcodes4));
    }

    public static int[] rearrangeBarcodes(int[] barcodes) {
        int length = barcodes.length;
        int[] result = new int[length];
        Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }

        for (int key : map.keySet()) {
            queue.offer(new int[]{key, map.get(key)});
        }

        for (int i = 0; i < length; i++) {
            int[] arr = queue.poll();
            if (i == 0 || arr[0] != result[i - 1]) {
                result[i] = arr[0];
                arr[1]--;
                if (arr[1] > 0) {
                    queue.offer(arr);
                }
            } else {
                int[] arr1 = queue.poll();
                result[i] = arr1[0];
                arr1[1]--;
                if (arr1[1] > 0) {
                    queue.offer(arr1);
                }
                queue.offer(arr);
            }
        }
        return result;
    }
}
