package leetcode.algorithms;

/**
 * Description: 299. Bulls and Cows
 *
 * @author Baltan
 * @date 2019-06-18 09:55
 */
public class GetHint {
    public static void main(String[] args) {
        System.out.println(getHint("", ""));
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
    }

    public static String getHint(String secret, String guess) {
        if (secret == null || guess == null || secret.length() == 0) {
            return "0A0B";
        }

        int bullsNum = 0;
        int cowsNum = 0;
        int length = secret.length();
        char[] secretArray = secret.toCharArray();
        char[] guessArray = guess.toCharArray();

        for (int i = 0; i < length; i++) {
            if (secretArray[i] == guessArray[i]) {
                bullsNum++;
                secretArray[i] = '*';
                guessArray[i] = '*';
            }
        }

        int[] secretNum = new int[10];
        int[] guessNum = new int[10];

        for (int i = 0; i < length; i++) {
            char secretChar = secretArray[i];
            char guessChar = guessArray[i];

            if (secretChar >= '0' && secretChar <= '9') {
                secretNum[secretChar - '0']++;
            }
            if (guessChar >= '0' && guessChar <= '9') {
                guessNum[guessChar - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cowsNum += Math.min(secretNum[i], guessNum[i]);
        }
        return bullsNum + "A" + cowsNum + "B";
    }
}
