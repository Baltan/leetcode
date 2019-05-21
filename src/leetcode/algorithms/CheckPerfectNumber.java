package leetcode.algorithms;

/**
 * Description: 507. Perfect Number
 *
 * @author Baltan
 * @date 2018/1/8 09:40
 */
public class CheckPerfectNumber {
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
        System.out.println(checkPerfectNumber(6));
        System.out.println(checkPerfectNumber(15));
        System.out.println(checkPerfectNumber(99999997));
        System.out.println(checkPerfectNumber(1));
        System.out.println(checkPerfectNumber(2));
    }

    public static boolean checkPerfectNumber(int num) {
        double divisorSum = 1;
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0 && i != Math.sqrt(num)) {
                divisorSum = divisorSum + i + num / i;
            } else if (num % i == 0 && i != Math.sqrt(num)) {
                divisorSum += i;
            }
        }
        if (divisorSum == num) {
            return true;
        } else {
            return false;
        }
    }
}
