package leetcode.algorithms;

/**
 * Description: 1539. Kth Missing Positive Number
 *
 * @author Baltan
 * @date 2022/10/27 16:57
 * @see FindKthPositive
 */
public class FindKthPositive1 {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        System.out.println(findKthPositive(new int[]{1, 2, 3, 4}, 2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/kth-missing-positive-number/solutions/1925252/-by-1105389168-50t5/"></a>
     *
     * @param arr
     * @param k
     * @return
     */
    public static int findKthPositive(int[] arr, int k) {
        /**
         * 此时说明[1,k]这部分数字全部缺失，第k个缺失的数字就是k
         */
        if (arr[0] > k) {
            return k;
        }
        int length = arr.length;
        /**
         * 对于每个arr[i]而言，arr[i]-i-1代表了[1,arr[i]]这部分数字中缺失的数字的个数，如果在[1,arr[length-1]]这部分数字中缺失的数字个
         * 数不足k个，则第k个缺失的数字就是arr[length-1]+(k-(arr[length-1]-(length-1)-1))=k+length
         */
        if (arr[length - 1] - length < k) {
            return k + length;
        }
        int lo = 0;
        int hi = length - 1;
        /**
         * 二分查找使得arr[i]-i-1>=k的最小的i
         */
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int missingCount = arr[mid] - mid - 1;

            if (missingCount < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        /**
         * 第k个缺失的数字就是arr[lo-1]+(k-(arr[lo-1]-(lo-1)-1))=lo+k
         */
        return lo + k;
    }
}
