package leetcode.algorithms;

/**
 * Description: 838. Push Dominoes
 *
 * @author Baltan
 * @date 2019-12-22 17:38
 */
public class PushDominoes {
    public static void main(String[] args) {
        System.out.println(pushDominoes(".L.R...LR..L.."));
        System.out.println(pushDominoes("RR.L"));
        System.out.println(pushDominoes("R.R.L"));
    }

    public static String pushDominoes(String dominoes) {
        char[] charArray = dominoes.toCharArray();
        int length = charArray.length;
        /**
         * 每一段骨牌左边受力的骨牌的位置
         */
        int leftCharIndex = 0;
        /**
         * 每一段骨牌左边受力的骨牌被推倒的方向
         */
        char leftChar = charArray[leftCharIndex];
        /**
         * 每一段骨牌右边受力的骨牌的位置
         */
        int rightCharIndex;
        /**
         * 每一段骨牌右边受力的骨牌被推倒的方向
         */
        char rightChar;
        /**
         * 找到最左边受力的骨牌
         */
        for (int i = 0; i < length; i++) {
            if (charArray[i] != '.') {
                leftCharIndex = i;
                leftChar = charArray[i];
                break;
            }
        }
        /**
         * 如果最左边受力的骨牌是向左推的，则这张骨牌左边所有的骨牌都会向左倒
         */
        if (leftChar == 'L') {
            for (int i = leftCharIndex - 1; i >= 0; i--) {
                charArray[i] = 'L';
            }
        }
        /**
         * 对每一段连续的不受力骨牌逐一处理
         */
        for (int i = leftCharIndex + 1; i < length; i++) {
            /**
             * 先找到这段骨牌右边受力的骨牌
             */
            if (charArray[i] != '.') {
                rightCharIndex = i;
                rightChar = charArray[i];
                /**
                 * 如果这段骨牌右边受力的骨牌和左边受力的骨牌都是向左推，则这段骨牌都会向左倒；如果这
                 * 段骨牌右边受力的骨牌和左边受力的骨牌都是向右推，则这段骨牌都会向右倒；如果这段骨牌
                 * 左边受力的骨牌是向右推，右边受力的骨牌是向左推，则这段骨牌会从左右两边分别向中间倒，
                 * 如果正中间是一张骨牌，则这张骨牌不会倒
                 */
                if (leftChar == 'L' && rightChar == 'L') {
                    for (int j = leftCharIndex + 1; j < rightCharIndex; j++) {
                        charArray[j] = 'L';
                    }
                } else if (leftChar == 'R' && rightChar == 'L') {
                    int lo = leftCharIndex + 1;
                    int hi = rightCharIndex - 1;

                    while (lo < hi) {
                        charArray[lo] = 'R';
                        charArray[hi] = 'L';
                        lo++;
                        hi--;
                    }
                } else if (leftChar == 'R' && rightChar == 'R') {
                    for (int j = leftCharIndex + 1; j < rightCharIndex; j++) {
                        charArray[j] = 'R';
                    }
                }
                /**
                 * 这段骨牌右边受力的骨牌也是下一段骨牌左边受力的骨牌
                 */
                leftChar = rightChar;
                leftCharIndex = rightCharIndex;
            }
        }
        /**
         * 如果最右边受力的骨牌是向右推的，则这张骨牌右边所有的骨牌都会向右倒
         */
        if (leftChar == 'R') {
            for (int i = leftCharIndex + 1; i < length; i++) {
                charArray[i] = 'R';
            }
        }
        return new String(charArray);
    }
}
