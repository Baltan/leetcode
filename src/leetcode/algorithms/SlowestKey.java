package leetcode.algorithms;

/**
 * Description: 1629. Slowest Key
 *
 * @author Baltan
 * @date 2022/9/25 14:20
 */
public class SlowestKey {
    public static void main(String[] args) {
        System.out.println(slowestKey(new int[]{9, 29, 49, 50}, "cbcd"));
        System.out.println(slowestKey(new int[]{12, 23, 36, 46, 62}, "spuda"));
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] charArray = keysPressed.toCharArray();
        int length = charArray.length;
        char result = charArray[0];
        int time = releaseTimes[0];

        for (int i = 1; i < length; i++) {
            /**
             * 当前按键的持续时间
             */
            int currentTime = releaseTimes[i] - releaseTimes[i - 1];

            if (currentTime > time || (currentTime == time && charArray[i] > result)) {
                result = charArray[i];
                time = currentTime;
            }
        }
        return result;
    }
}
