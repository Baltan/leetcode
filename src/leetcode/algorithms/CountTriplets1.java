package leetcode.algorithms;

/**
 * Description: 1442. Count Triplets That Can Form Two Arrays of Equal XOR
 *
 * @author Baltan
 * @date 2020-05-11 22:47
 */
public class CountTriplets1 {
    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{2, 3, 1, 6, 7}));
        System.out.println(countTriplets(new int[]{1, 1, 1, 1, 1}));
        System.out.println(countTriplets(new int[]{2, 3}));
        System.out.println(countTriplets(new int[]{1, 3, 5, 7, 9}));
        System.out.println(countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/solution/on2-jian-ji-jie-fa-by-roaringwind/"></a>
     *
     * @param arr
     * @return
     */
    public static int countTriplets(int[] arr) {
        int result = 0;
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            int value = arr[i];

            for (int j = i + 1; j < length; j++) {
                value ^= arr[j];
                /**
                 * 当a^b=arr[i]^arr[i+1]^……^arr[j-1]^arr[j]^arr[j+1]^……^arr[k]=0时，可以使得a==b，
                 * 此时共有k-i种分组方式
                 */
                if (value == 0) {
                    result += (j - i);
                }
            }
        }
        return result;
    }
}
