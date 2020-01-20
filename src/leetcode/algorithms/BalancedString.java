package leetcode.algorithms;

/**
 * Description: 1234. Replace the Substring for Balanced String
 *
 * @author Baltan
 * @date 2020-01-19 13:24
 */
public class BalancedString {
    public static void main(String[] args) {
        System.out.println(balancedString("QWER"));
        System.out.println(balancedString("QQWE"));
        System.out.println(balancedString("QQQW"));
        System.out.println(balancedString("QQQQ"));
        System.out.println(balancedString("WWEQERQWQWWRWWERQWEQ"));

        StringBuilder builder = new StringBuilder(100000);
        for (int i = 0; i < 100000; i++) {
            builder.append("Q");
        }
        System.out.println(balancedString(builder.toString()));
    }

    public static int balancedString(String s) {
        int result = Integer.MAX_VALUE;
        int qCount = 0;
        int wCount = 0;
        int eCount = 0;
        int rCount = 0;
        int length = s.length();
        int average = length / 4;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (c == 'Q') {
                qCount++;
            } else if (c == 'W') {
                wCount++;
            } else if (c == 'E') {
                eCount++;
            } else {
                rCount++;
            }
        }

        for (int i = 0; i < length; i++) {
            int substringQCount = 0;
            int substringWCount = 0;
            int substringECount = 0;
            int substringRCount = 0;
            int substringLength = 0;
            int index = i;

            while (index < length && (qCount - substringQCount > average ||
                    wCount - substringWCount > average || eCount - substringECount > average ||
                    rCount - substringRCount > average)) {
                char c = s.charAt(index);

                if (c == 'Q') {
                    substringQCount++;
                } else if (c == 'W') {
                    substringWCount++;
                } else if (c == 'E') {
                    substringECount++;
                } else {
                    substringRCount++;
                }

                index++;
                substringLength++;
            }

            if (qCount - substringQCount <= average && wCount - substringWCount <= average &&
                    eCount - substringECount <= average && rCount - substringRCount <= average) {
                result = Math.min(result, substringLength);
            }
        }
        return result;
    }
}
