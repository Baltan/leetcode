package leetcode.algorithms;

/**
 * Description: 1781. Sum of Beauty of All Substrings
 *
 * @author Baltan
 * @date 2022/7/9 13:25
 */
public class BeautySum {
    public static void main(String[] args) {
        System.out.println(beautySum("aabcb"));
        System.out.println(beautySum("aabcbaa"));
    }

    public static int beautySum(String s) {
        int result = 0;
        int length = s.length();
        /**
         * 因为字符串s只由小写字母构成，所有共可能有26种字符
         */
        int letterCount = 26;
        char[] charArray = s.toCharArray();
        /**
         * prefixSum[i]表示子串s.substring(0,i)中每种字符出现的个数
         */
        int[][] prefixSum = new int[length + 1][letterCount];
        prefixSum[0] = new int[letterCount];
        /**
         * 计算子串s.substring(0,1)……s.substring(0,length)中，每个字串中每种字符出现的个数
         */
        for (int i = 0; i < length; i++) {
            prefixSum[i + 1] = prefixSum[i].clone();
            /**
             * 当前子串比前一个子串增加了字符charArray[i]
             */
            prefixSum[i + 1][charArray[i] - 'a']++;
        }
        /**
         * i表示子串的第一个字符在s中的索引位置，j表示子串的最后一个字符在s中的索引位置，因为长度为1或2的子串的"美丽值"一定为0，
         * 所以只需从长度为3的子串开始计算起
         */
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 2; j < length; j++) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                /**
                 * 子串s.substring(0,i)中每种字符出现的个数
                 */
                int[] x = prefixSum[i];
                /**
                 * 子串s.substring(0,j+1)中每种字符出现的个数
                 */
                int[] y = prefixSum[j + 1];
                /**
                 * 通过计算y和x的前缀和之差即可得到子串s.substring(i,j+1)中每种字符出现的个数
                 */
                for (int k = 0; k < letterCount; k++) {
                    /**
                     * 子串s.substring(i,j+1)中第k个小写字母出现的次数
                     */
                    int count = y[k] - x[k];

                    if (count > 0 && count < min) {
                        min = count;
                    }

                    if (count > max) {
                        max = count;
                    }
                }
                result += (max - min);
            }
        }
        return result;
    }
}
