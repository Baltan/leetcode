package leetcode.algorithms;

/**
 * Description: 374. Guess Number Higher or Lower
 *
 * @author Baltan
 * @date 2018/8/9 16:15
 * @see GetMoneyAmount
 */
public class GuessNumber {
    public static void main(String[] args) {

    }

    public static int guessNumber(int n) {
        int low = 1;
        int high = n;
        int mid;
        int response;
        while (low <= high) {
            mid = low + (high - low) / 2;
            response = guess(mid);
            if (response == -1) {
                high = mid - 1;
            } else if (response == 1) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return 0;
    }

    /**
     * The guess API is defined in the parent class GuessGame.
     *
     * @param num, your guess
     * @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
     * int guess(int num);
     */
    public static int guess(int num) {
        return 0;
    }
}
