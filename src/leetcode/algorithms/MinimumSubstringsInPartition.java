package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3144. Minimum Substring Partition of Equal Character Frequency
 *
 * @author Baltan
 * @date 2024/5/15 22:09
 */
public class MinimumSubstringsInPartition {
    public static void main(String[] args) {
        System.out.println(minimumSubstringsInPartition("abc"));
        System.out.println(minimumSubstringsInPartition("c"));
        System.out.println(minimumSubstringsInPartition("hhqmqzavccbsjkfpijrpdjkmgcpyomborudbbfyeokkelzznstufyppndilajgxxhusslzvnwhfitqtsstjqclxqvkykovhzyyqfksmnhhtpdabfjrfflmqoakaackcchgzhrppmvpnunuzhoouftiqwdbxbemtzwkrqqkspwypxwzavvgelkxsgkipoottveturyicswfdemvpfegdclnjccqkgouzcdfvpstnjxzdukwctysagimjissinxkohfyapuuavvnssqzcynoixegzkuvphadbaedwkgpxaoohgmfoqmvfbbywinngwctrighefrnbllggbjfeslbfwzuktwvocbmokicwvpotpvbytlxajtidumtocerdqrrtvjawgikwkqnnfgbsczshswuvvnnmmjssrulcxattfgklzklfrahvbcdetxohipslfbifkmiljvbvpffeiymidgsaxkjvynjaaqkymyyejjyyxucuyehrnzzqwolgylytlviedicxxavsmytdyscdczhmpydzvwaeziczvolrzossqazqtccygbyunsxxwzxnsfboazgfcefmqggcgwhlaatfgatfkffgywldlmoubqlcstwwkepecxxrsgawwxpxmdvifiecopozvooomhbqmrsdraajwybdhnmrzfgnemzqnxvaedhvhexjlvkllzrtgcgnkkopnytjktjffndpqlpepqqxyjikcyfwaocbjcjlzybxemollniwuucqpshkkqwawyyuqligbzanssbsfwnckkkjfurvpxqcdauvrykrqlnpwacgxivlgppdqqkijjvyycwlxzxcgxudboopuehittsiknnlssspefgcvvctzhajjmkyyykkqlpynaconuuumzycvlrkgukuuwpleedpwtmsjfkbdmyubjuhoajcymrzeytmnkkoqgnsltpczzofvivpuogrunnnxkmyhbuuwvvvgnbvnvvlggnug"));
        System.out.println(minimumSubstringsInPartition("fabccddg"));
        System.out.println(minimumSubstringsInPartition("abababaccddb"));
    }

    public static int minimumSubstringsInPartition(String s) {
        int result = Integer.MAX_VALUE;
        int length = s.length();
        /**
         * isBalanced[i][j]表示子串s.substring(i,j)是否是平衡字符串
         */
        boolean[][] isBalanced = new boolean[length + 1][length + 1];
        /**
         * prefixes[i]表示子串s.substring(0,i)最少可以分割成的平衡字符串的个数
         */
        int[] prefixes = new int[length + 1];
        /**
         * suffixes[i]表示子串s.substring(i,length)最少可以分割成的平衡字符串的个数
         */
        int[] suffixes = new int[length + 1];
        Arrays.fill(prefixes, Integer.MAX_VALUE);
        Arrays.fill(suffixes, Integer.MAX_VALUE);
        prefixes[1] = 1;
        suffixes[length - 1] = 1;

        for (int i = 0; i < length; i++) {
            /**
             * counts[0]-counts[25]依次表示子串s.substring(i,j)中字符a-z的个数
             */
            int[] counts = new int[26];

            for (int j = i + 1; j <= length; j++) {
                counts[s.charAt(j - 1) - 'a']++;

                if (isBalanced(counts)) {
                    isBalanced[i][j] = true;
                }
            }
        }
        /**
         *  字符串s本身就是平衡字符串
         */
        if (isBalanced[0][length]) {
            return 1;
        }
        /**
         * 对字符串s的所有前缀子串s.substring(0,i)进行分割计算
         */
        for (int i = 2; i <= length; i++) {
            /**
             * 前缀子串s.substring(0,i)本身就是平衡字符串
             */
            if (isBalanced[0][i]) {
                prefixes[i] = 1;
                continue;
            }

            for (int j = 1; j < i; j++) {
                if (isBalanced[j][i]) {
                    prefixes[i] = Math.min(prefixes[i], prefixes[j] + 1);
                }
            }
        }
        /**
         * 对字符串s的所有后缀子串s.substring(i,length)进行分割计算
         */
        for (int i = length - 2; i >= 0; i--) {
            /**
             * 后缀子串s.substring(i,length)本身就是平衡字符串
             */
            if (isBalanced[i][length]) {
                suffixes[i] = 1;
                continue;
            }

            for (int j = i + 1; j < length; j++) {
                if (isBalanced[i][j]) {
                    suffixes[i] = Math.min(suffixes[i], suffixes[j] + 1);
                }
            }
        }
        /**
         * 将字符串s分成首尾两个子串，计算最少可以分割成的平衡字符串的个数
         */
        for (int i = 1; i < length; i++) {
            result = Integer.min(result, prefixes[i] + suffixes[i]);
        }
        return result;
    }

    /**
     * 判断一个字符串是否是平衡字符串
     *
     * @param counts counts[0]-counts[25]依次表示字符串中字符a-z的个数
     * @return
     */
    public static boolean isBalanced(int[] counts) {
        /**
         * 遍历过程中第一个出现次数不为0的字符的个数，作为后面其他字符比较的基准
         */
        int count = -1;

        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0 && count == -1) {
                count = counts[i];
            } else if (counts[i] > 0 && counts[i] != count) {
                return false;
            }
        }
        return true;
    }
}
