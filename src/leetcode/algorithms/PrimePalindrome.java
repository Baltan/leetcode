package leetcode.algorithms;

/**
 * Description: 866. Prime Palindrome
 *
 * @author Baltan
 * @date 2020-02-21 12:24
 */
public class PrimePalindrome {
    public static void main(String[] args) {
        System.out.println(primePalindrome(1));
        System.out.println(primePalindrome(6));
        System.out.println(primePalindrome(8));
        System.out.println(primePalindrome(13));
        System.out.println(primePalindrome(464));
        System.out.println(primePalindrome(53542));
        System.out.println(primePalindrome(6445));
        System.out.println(primePalindrome(22545345));
        System.out.println(primePalindrome(67687));
    }

    public static int primePalindrome(int N) {
        /**
         * N的位数
         */
        int length = 0;
        int copyN = N;
        /**
         * 计算N的位数
         */
        while (copyN > 0) {
            length++;
            copyN /= 10;
        }
        /**
         * 从length位数开始从小到大判断每个回文数字是不是素数，直到找到一个素数为止
         */
        for (int i = length; ; i++) {
            if ((i & 1) == 1) {
                /**
                 * 如果回文数位数是奇数，回文数的前半部分长度，例如回文数为123404321，前半部分
                 * 长度就是4
                 */
                int halfLength = i / 2;
                /**
                 * 回文数前半部分最小值，例如前半部分长度为4，则最小值就是1000
                 */
                int halfMin = (int) Math.pow(10, halfLength - 1);
                /**
                 * 回文数前半部分最大值，例如前半部分长度为4，则最大值就是9999
                 */
                int halfMax = (int) Math.pow(10, halfLength) - 1;
                /**
                 * 回文数正中间数字最小值
                 */
                int midMin = 0;
                /**
                 * 回文数正中间数字最大值
                 */
                int midMax = 9;
                /**
                 * 从小到大计算回文数
                 */
                for (int j = halfMin; j <= halfMax; j++) {
                    int sum = 0;
                    int exponent = halfLength + 1;
                    int temp = halfLength * 2;
                    int copyJ = j;
                    /**
                     * 例如j=123，则sum=3*(10^4+10^2)+2*(10^5+10^1)+1*(10^6+10^0)
                     */
                    while (copyJ > 0) {
                        int remainder = copyJ % 10;
                        sum += remainder * Math.pow(10, exponent);
                        sum += remainder * Math.pow(10, temp - exponent);
                        exponent++;
                        copyJ /= 10;
                    }
                    /**
                     * 回文数再加上正中间的数字
                     */
                    for (int k = midMin; k <= midMax; k++) {
                        int value = (int) (sum + k * Math.pow(10, halfLength));

                        if (value >= N && isPrime(value)) {
                            return value;
                        }
                    }
                }
            } else {
                /**
                 * 如果回文数位数是奇数，回文数的前半部分长度，例如回文数为12344321，前半部分
                 * 长度就是4
                 */
                int halfLength = i / 2;
                /**
                 * 回文数前半部分最小值，例如前半部分长度为4，则最小值就是1000
                 */
                int halfMin = (int) Math.pow(10, halfLength - 1);
                /**
                 * 回文数前半部分最大值，例如前半部分长度为4，则最大值就是9999
                 */
                int halfMax = (int) Math.pow(10, halfLength) - 1;
                /**
                 * 从小到大计算回文数
                 */
                for (int j = halfMin; j <= halfMax; j++) {
                    int sum = 0;
                    int exponent = halfLength;
                    int temp = halfLength * 2 - 1;
                    int copyJ = j;
                    /**
                     * 例如j=123，则sum=3*(10^3+10^2)+2*(10^4+10^1)+1*(10^5+10^0)
                     */
                    while (copyJ > 0) {
                        int remainder = copyJ % 10;
                        sum += remainder * Math.pow(10, exponent);
                        sum += remainder * Math.pow(10, temp - exponent);
                        exponent++;
                        copyJ /= 10;
                    }

                    if (sum >= N && isPrime(sum)) {
                        return sum;
                    }
                }
            }
        }
    }

    /**
     * 判断num是不是素数
     *
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        int threshold = (int) Math.floor(Math.sqrt(num));

        for (int i = 2; i <= threshold; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
