package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1994. The Number of Good Subsets
 *
 * @author Baltan
 * @date 2023/2/24 23:01
 * @see SquareFreeSubsets
 */
public class NumberOfGoodSubsets {
    public static void main(String[] args) {
        System.out.println(numberOfGoodSubsets(new int[]{1, 2, 3, 4}));
        System.out.println(numberOfGoodSubsets(new int[]{4, 2, 3, 15}));
        System.out.println(numberOfGoodSubsets(new int[]{28, 16, 26, 30, 6, 27, 16, 25, 30, 24, 8, 18, 21, 24, 28, 8, 30, 5, 17, 21, 5, 7, 26, 27, 4, 22, 7, 20, 13, 14, 4, 16, 7, 19, 17, 13, 11, 19, 12, 4, 24, 29, 17, 5, 26, 23, 19}));
        System.out.println(numberOfGoodSubsets(new int[]{2, 9, 23, 13, 21, 12, 8, 19, 26, 4, 13, 19, 27, 25, 20, 30, 1, 11, 12, 4, 28, 30, 25, 29, 4, 24, 3, 24, 4, 3, 12, 22, 24, 30, 14, 15, 14, 4, 21, 22, 24, 15, 19, 9, 16, 19, 16, 13, 30, 1, 14, 2, 17, 14, 28, 11, 14, 19, 11, 22, 11}));
    }

    public static int numberOfGoodSubsets(int[] nums) {
        int mod = 1000000007;
        /**
         * 假设一个数如果可以表示为一个或多个互不相同的质数的乘积，则称这个数为"好数"。counts[i]表示数组nums中"好数"i的个数，根据题意，
         * nums[i]∈[1,30]
         */
        int[] counts = new int[31];
        /**
         * [1,30]中的所有质数
         */
        int[] primeNums = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        /**
         * 好子集中所有元素的乘积含有的质因数情况 -> 情况数
         */
        Map<Integer, Long> productCounts = new HashMap<>();

        for (int num : nums) {
            /**
             * 非"好数"肯定不会出现在好子集中，所以直接忽略
             */
            if (counts[num] > 0 || isSquareFree(num)) {
                counts[num]++;
            }
        }
        /**
         * 说明数组nums中的所有元素都是1，不能构成任何好子集
         */
        if (counts[1] == nums.length) {
            return 0;
        }
        /**
         * 考虑数组nums中所有不为1的元素
         */
        for (int i = 2; i <= 30; i++) {
            if (counts[i] == 0) {
                continue;
            }
            int status = getStatus(i, primeNums);
            int count = counts[i];
            /**
             * 此处不能直接{@code productCounts.put(status,count)}，因为之前可能已经出现过status的情况，不能被覆盖。
             * 例如：nums=[2,3,6]，则当循环到6时，status为0b110，而之前循环过程中已经出现了[2,3]这样的status为0b110的情况
             */
            productCounts.put(status, productCounts.getOrDefault(status, 0L) + count);
            /**
             * 临时保存数字i和之前已经得到的好子集组合得到的新的好子集的情况
             */
            Map<Integer, Long> temp = new HashMap<>();

            for (Map.Entry<Integer, Long> entry : productCounts.entrySet()) {
                int productStatus = entry.getKey();
                long productCount = entry.getValue();

                if (isCoprime(status, productStatus)) {
                    /**
                     * 新的好子集中所有元素的乘积含有质因数的情况
                     */
                    int mergeStatus = status | productStatus;
                    /**
                     * 此前肯定没有得到过mergeStatus的情况，可以直接保存新的组合数count*productCount
                     */
                    temp.put(mergeStatus, (count * productCount) % mod);
                }
            }
            /**
             * 合并新得到的好子集的情况
             */
            for (Map.Entry<Integer, Long> entry : temp.entrySet()) {
                int mergeStatus = entry.getKey();
                long mergeCount = entry.getValue();
                productCounts.put(mergeStatus, (productCounts.getOrDefault(mergeStatus, 0L) + mergeCount) % mod);
            }
        }
        long result = 0L;
        long allOnes = allOnes(counts[1], mod);

        for (Long count : productCounts.values()) {
            /**
             * 如果数组nums中有allOnes个1，则每个无平方子集还可以增加[0,allOnes]个1，情况总数为：allOnes+1
             */
            result = (result + (count * allOnes) % mod) % mod;
        }
        return (int) result;
    }

    /**
     * 在x个1中选择[0,x]个1，可以构成的子集（包括空集）的情况数
     *
     * @param x
     * @param mod
     * @return
     */
    public static long allOnes(int x, int mod) {
        long result = 1L;
        /**
         * 可以选择0、1、2、……、x个1，情况总数为：xC0+xC2+……+xCx=2^x
         */
        for (int i = 0; i < x; i++) {
            result = (result * 2) % mod;
        }
        return result;
    }

    /**
     * 通过两个数含有的质因数的情况判断它们是否是互质的
     *
     * @param statusX
     * @param statusY
     * @return
     */
    public static boolean isCoprime(int statusX, int statusY) {
        /**
         * 如果两数互质，则它们不含有同样的质因数，说明每一个二进制位上，至多只有其中一个数为1
         */
        return (statusX & statusY) == 0;
    }

    /**
     * 计算数字num的所有质因数的情况，如果num含有质因数2，则status二进制值从低到高第2位为1；如果num含有质因数3，则status二进制值从低到高第3
     * 位为1；以此类推……
     *
     * @param num
     * @param primeNums
     * @return
     */
    public static int getStatus(int num, int[] primeNums) {
        int status = 0;

        for (int primeNum : primeNums) {
            while (num % primeNum == 0) {
                status |= (1 << (primeNum - 1));
                num /= primeNum;
            }
        }
        return status;
    }

    /**
     * 判断数字num是否是"好数"
     *
     * @param num
     * @return
     */
    public static boolean isSquareFree(int num) {
        /**
         * 根据题意num∈[1,30]
         */
        for (int i = 2; i <= 5; i++) {
            if (num % (i * i) == 0) {
                return false;
            }
        }
        return true;
    }
}
