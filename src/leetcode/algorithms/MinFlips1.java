package leetcode.algorithms;

/**
 * Description: 1529. Bulb Switcher IV
 *
 * @author Baltan
 * @date 2020-07-31 22:11
 * @see BulbSwitch
 * @see BulbSwitch1
 * @see FlipLights
 * @see NumTimesAllBlue
 */
public class MinFlips1 {
    public static void main(String[] args) {
        System.out.println(minFlips("10111"));
        System.out.println(minFlips("101"));
        System.out.println(minFlips("00000"));
        System.out.println(minFlips("001011101"));
        System.out.println(minFlips("1"));
    }

    public static int minFlips(String target) {
        int result = 0;
        char[] charArray = target.toCharArray();
        /**
         * 因为前面的某个灯泡操作后会影响后面所有灯泡的状态，所以从第0个灯泡开始操作。如果第0个灯泡最后变为1，则需要
         * 在第0个灯泡处进行一次操作，此时后面所有的灯泡状态也都变化了。轮到判断某个灯泡i是否需要操作时，此时它已被
         * 操作了result次，如果它最终变为1，则这个灯泡一共需要被操作奇数次，如果result是偶数，则在这个灯泡处需要进
         * 行一次操作，同理，如果它最终变为0，则这个灯泡一共需要被操作偶数次，如果result是奇数，则在这个灯泡处需要
         * 进行一次操作
         */
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            if ((c == '1' && result % 2 == 0) || (c == '0' && result % 2 == 1)) {
                result++;
            }
        }
        return result;
    }
}
