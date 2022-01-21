package leetcode.algorithms;

/**
 * Description: 1980. Find Unique Binary String
 *
 * @author Baltan
 * @date 2022/1/21 10:19
 * @see FindDifferentBinaryString
 */
public class FindDifferentBinaryString1 {
    public static void main(String[] args) {
        System.out.println(findDifferentBinaryString(new String[]{"01", "10"}));
        System.out.println(findDifferentBinaryString(new String[]{"00", "01"}));
        System.out.println(findDifferentBinaryString(new String[]{"111", "011", "001"}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/find-unique-binary-string/solution/kang-tuo-dui-jiao-xian-by-seedjyh-wr2s/"></a>
     *
     * @param nums
     * @return
     */
    public static String findDifferentBinaryString(String[] nums) {
        int length = nums.length;
        char[] charArray = new char[length];
        /**
         * 康托尔对角线
         * charArray的第i个字符总是和nums中的第i个字符串的第i个字符不同，从而保证charArray和nums中的所有二进制字符串都不同
         */
        for (int i = 0; i < length; i++) {
            charArray[i] = nums[i].charAt(i) == '0' ? '1' : '0';
        }
        return new String(charArray);
    }
}
