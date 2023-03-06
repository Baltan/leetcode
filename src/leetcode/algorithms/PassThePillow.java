package leetcode.algorithms;

/**
 * Description: 2582. Pass the Pillow
 *
 * @author Baltan
 * @date 2023/3/5 19:52
 */
public class PassThePillow {
    public static void main(String[] args) {
        System.out.println(passThePillow(4, 5));
        System.out.println(passThePillow(3, 2));
    }

    public static int passThePillow(int n, int time) {
        /**
         * 将每n-1次传递看成一轮，例如：
         * 1、2、3、……、n-1、n
         * n、n-1、n-2、……、2、1
         * 1、2、3、……、n-1、n
         * n、n-1、n-2、……、2、1
         * ……
         */
        int roundCount = time / (n - 1);
        /**
         * 最后一轮传递的次数
         */
        int remainder = time - roundCount * (n - 1);
        /**
         * 如果之前已经经历过偶数个完整的轮次，则最后一轮传递为从1到n，否则为从n到1
         */
        return roundCount % 2 == 0 ? remainder + 1 : n - remainder;
    }
}
