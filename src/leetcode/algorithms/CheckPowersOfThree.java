package leetcode.algorithms;

/**
 * Description: 1780. Check if Number is a Sum of Powers of Three
 *
 * @author Baltan
 * @date 2022/7/9 13:51
 */
public class CheckPowersOfThree {
    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(12));
        System.out.println(checkPowersOfThree(91));
        System.out.println(checkPowersOfThree(21));
    }

    public static boolean checkPowersOfThree(int n) {
        /**
         * 根据题意n∈[1,10000000]，初始化这个范围内所有3的幂，按照升序排列
         */
        int[] powerOfThreeArray =
                {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969};
        /**
         * isVisited[i]表示在计算n的和时，powerOfThreeArray[i]是否已被使用过
         */
        boolean[] isVisited = new boolean[powerOfThreeArray.length];
        int hi = powerOfThreeArray.length - 1;
        /**
         * 每次计算，都在剩余的3的幂中，查找小于等于n的最大值，因为如果不选这个最大值，前面的所有3的幂之和一定小于n
         */
        while (n > 0) {
            int lo = 0;
            /**
             * 在powerOfThreeArray[lo]……powerOfThreeArray[hi]中二分查找小于等于n的最大值
             */
            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;

                if (powerOfThreeArray[mid] > n) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                }
            }
            /**
             * isVisited[lo]之前已被使用过，不能再次被使用
             */
            if (isVisited[lo]) {
                break;
            }
            n -= powerOfThreeArray[lo];
            isVisited[lo] = true;
            /**
             * powerOfThreeArray[lo]已被使用，下一次循环要从小于powerOfThreeArray[lo]的3的幂中查找小于等于n的最大值
             */
            hi = lo - 1;
        }
        return n == 0;
    }
}
