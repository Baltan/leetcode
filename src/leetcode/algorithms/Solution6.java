package leetcode.algorithms;

import java.util.Random;

/**
 * Description: 528. Random Pick with Weight
 *
 * @author Baltan
 * @date 2019-07-24 21:36
 */
public class Solution6 {
    private int[][] arr;
    private Random rand;
    private int max;

    public Solution6(int[] w) {
        this.rand = new Random();
        this.arr = new int[w.length][2];
        arr[0] = new int[]{0, w[0]};
        /**
         * arr中索引i的元素为一个长度为2的数组，且arr[i][1]-arr[i][0]和w[i]的值相等，
         * 且除第一个元素外，arr[i][0]=arr[i-1][1]+1。
         * 这样随机产生一个整数，该整数落到arr的某个索引为i的元素区间的概率和这个区间的长度，即w[i]成正比
         */
        for (int i = 1, length = w.length; i < length; i++) {
            arr[i] = new int[]{arr[i - 1][1], arr[i - 1][1] + w[i]};
        }

        this.max = arr[w.length - 1][1];
    }

    public int pickIndex() {
        int randomNum = rand.nextInt(max);
        int lo = 0;
        int hi = arr.length - 1;
        /**
         * 二分查找产生的随机数应该位于哪一个区间，改区间的索引即为所求值
         */
        while (true) {
            int mid = (lo + hi) / 2;

            if (randomNum >= arr[mid][0] && randomNum < arr[mid][1]) {
                return mid;
            } else if (randomNum == arr[mid][1]) {
                return mid + 1;
            } else if (randomNum == arr[mid][0] - 1) {
                return mid - 1;
            } else if (randomNum > arr[mid][1]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] w1 = {1};
        Solution6 solution61 = new Solution6(w1);
        System.out.println(solution61.pickIndex());
        System.out.println(solution61.pickIndex());
        System.out.println(solution61.pickIndex());
        System.out.println(solution61.pickIndex());
        System.out.println(solution61.pickIndex());
        System.out.println(solution61.pickIndex());
        System.out.println(solution61.pickIndex());

        System.out.println("------------");

        int[] w2 = {1, 3};
        Solution6 solution62 = new Solution6(w2);
        System.out.println(solution62.pickIndex());
        System.out.println(solution62.pickIndex());
        System.out.println(solution62.pickIndex());
        System.out.println(solution62.pickIndex());
        System.out.println(solution62.pickIndex());
        System.out.println(solution62.pickIndex());
        System.out.println(solution62.pickIndex());
        System.out.println(solution62.pickIndex());
        System.out.println(solution62.pickIndex());
        System.out.println(solution62.pickIndex());
        System.out.println(solution62.pickIndex());
        System.out.println(solution62.pickIndex());
        System.out.println(solution62.pickIndex());

        System.out.println("------------");

        int[] w3 = {1, 3, 1};
        Solution6 solution63 = new Solution6(w3);
        System.out.println(solution63.pickIndex());
        System.out.println(solution63.pickIndex());
        System.out.println(solution63.pickIndex());
        System.out.println(solution63.pickIndex());
        System.out.println(solution63.pickIndex());
        System.out.println(solution63.pickIndex());
        System.out.println(solution63.pickIndex());
        System.out.println(solution63.pickIndex());
        System.out.println(solution63.pickIndex());
        System.out.println(solution63.pickIndex());
        System.out.println(solution63.pickIndex());
        System.out.println(solution63.pickIndex());
        System.out.println(solution63.pickIndex());
    }
}
