package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3514. Number of Unique XOR Triplets II
 *
 * @author baltan
 * @date 2025/4/25 11:33
 * @see UniqueXorTriplets
 */
public class UniqueXorTriplets1 {
    public static void main(String[] args) {
        System.out.println(uniqueXorTriplets(new int[]{1, 3}));
        System.out.println(uniqueXorTriplets(new int[]{6, 7, 8, 9}));
    }

    public static int uniqueXorTriplets(int[] nums) {
        int result = 0;
        int length = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        /**
         * 假设数组中最大元素max的二进制值的的位数为k，显然数组中任意两个元素按位异或值的位数也不大于k，得到二元组异或值的范围为[1,maxXor]
         */
        int maxXor = (1 << (32 - Integer.numberOfLeadingZeros(max))) - 1;
        /**
         * isVisited[i]表示数组nums中是否存在任意两个数字按位异或的值为i
         */
        boolean[] isVisited = new boolean[maxXor + 1];
        /**
         * 任意数字和自己按位异或的值为0
         */
        isVisited[0] = true;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                isVisited[nums[i] ^ nums[j]] = true;
            }
        }
        /**
         * 如果nums[i]^nums[j]^nums[k]=xor，则nums[k]^xor=nums[i]^nums[j]，枚举所有可能的nums[k]^xor，判断结果是否在isVisited中
         * 存在即可
         */
        for (int i = 0; i <= maxXor; i++) {
            for (int num : nums) {
                if (isVisited[num ^ i]) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
