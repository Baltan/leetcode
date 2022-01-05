package leetcode.algorithms;

/**
 * Description: 2126. Destroying Asteroids
 *
 * @author Baltan
 * @date 2022/1/5 09:11
 * @see AsteroidsDestroyed
 */
public class AsteroidsDestroyed1 {
    public static void main(String[] args) {
        System.out.println(asteroidsDestroyed(10, new int[]{3, 9, 19, 5, 21}));
        System.out.println(asteroidsDestroyed(5, new int[]{4, 9, 23, 4}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/destroying-asteroids/solution/xian-xing-shi-jian-suan-fa-by-hqztrue-vr3u/"></a>
     *
     * @param mass
     * @param asteroids
     * @return
     */
    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        /**
         * 当前行星质量
         */
        long total = mass;
        /**
         * 题目规定的小行星最大质量
         */
        int max = 100000;
        /**
         * 定义一系列桶，第i（0-based）个桶保存质量在[2^1,2^(i+1))范围内的小行星，需要桶的总数量
         */
        int bucketCount = (int) (Math.log(max) / Math.log(2)) + 1;
        /**
         * sumArray[i]表示第i个桶中所有小行星的质量
         */
        long[] sumArray = new long[bucketCount];
        /**
         * minArray[i]表示第i个桶中质量最小的小行星的质量
         */
        int[] minArray = new int[bucketCount];

        for (int asteroid : asteroids) {
            /**
             * 当前小行星所属桶的索引
             */
            int bucketIndex = (int) (Math.log(asteroid) / Math.log(2));
            /**
             * 如果桶中还没有小行星，则当前小行星的质量就是桶中质量最小的小行星的质量，否则更新桶中质量最小的小行星的质量
             */
            if (minArray[bucketIndex] == 0) {
                minArray[bucketIndex] = asteroid;
            } else {
                minArray[bucketIndex] = Math.min(minArray[bucketIndex], asteroid);
            }
            sumArray[bucketIndex] += asteroid;
        }
        /**
         * 从小到大逐一判断桶，如果当前桶中的最小质量小行星的质量min大于当前行星质量total，则行星被摧毁，直接返回false；
         * 否则摧毁质量最小的小行星后，行星质量为：min + total = 2^i + total > 2^i + 2^i = 2 ^ (i+1) = max，即
         * 摧毁质量最小的小行星后，行星质量total大于桶中质量最大的小行星的质量，则桶中所有的小行星都能被摧毁，可以直接将
         * 所有小行星的质量都加到行星质量中
         */
        for (int i = 0; i < bucketCount; i++) {
            if (total < minArray[i]) {
                return false;
            }
            total += sumArray[i];
        }
        return true;
    }
}
