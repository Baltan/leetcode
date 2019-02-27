package leetcode.algorithms;

/**
 * Description:Nth Digit
 *
 * @author Baltan
 * @date 2018/1/8 16:38
 */
public class FindNthDigit {
    public static void main(String[] args) {
        System.out.println(findNthDigit(3));
        System.out.println(findNthDigit(11));
        System.out.println(findNthDigit(10));
        System.out.println(findNthDigit(100));
    }

    public static int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }
        int loopNum = 1;
        while (n > 9 * Math.pow(10, loopNum - 1) * loopNum) {
            n = (int) (n - 9 * Math.pow(10, loopNum - 1) * loopNum);
            //循环结束后，结果为loopNum位数序列中的第n位
            loopNum++;
        }
        int initialNum = (int) Math.pow(10, loopNum - 1);
        int distance = n % loopNum == 0 ? n / loopNum - 1 : n / loopNum;
        int currentNum = initialNum + distance;
        //currentNum的第n个数字
        n = n - distance * loopNum;
        return (int) (currentNum % Math.pow(10, loopNum + 1 - n) / Math.pow(10, loopNum - n));
    }
}
