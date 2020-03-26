package leetcode.algorithms;

/**
 * Description: 914. X of a Kind in a Deck of Cards
 *
 * @author Baltan
 * @date 2019-03-17 08:58
 * @see HasGroupsSizeX
 */
public class HasGroupsSizeX1 {
    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(hasGroupsSizeX(new int[]{1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 2, 2}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2}));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        /**
         * count[i]表示deck中i出现的次数
         */
        int[] count = new int[10000];
        /**
         * deck中出现次数最少的那个元素的出现次数
         */
        int minCount = Integer.MAX_VALUE;

        for (int value : deck) {
            count[value]++;
        }

        for (int value : count) {
            if (value != 0) {
                minCount = Math.min(minCount, value);
            }
        }

        if (minCount == 1) {
            return false;
        }

        int gcd = minCount;
        /**
         * 计算deck中所有出现过的元素的出现次数的最大公约数
         */
        for (int value : count) {
            if (value != 0) {
                /**
                 * 当前已经遍历过的元素的最大公约数
                 */
                gcd = gcd(gcd, value);
                /**
                 * 如果当前遍历过的元素的最大公约数为1，则后面的元素不需要再计算最大公约数了
                 */
                if (gcd == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 求i和j的最大公约数
     *
     * @param i
     * @param j
     * @return
     */
    public static int gcd(int i, int j) {
        int max = Math.max(i, j);
        int min = Math.min(i, j);

        while (max % min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        return min;
    }
}
