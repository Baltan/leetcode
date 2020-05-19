package leetcode.algorithms;

/**
 * Description: 680. Valid Palindrome II
 *
 * @author Baltan
 * @date 2017/11/27 09:45
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(validPalindrome(""));
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abcba"));
        System.out.println(validPalindrome("abccdba"));
        System.out.println(validPalindrome("abcdba"));
        System.out.println(validPalindrome("abccda"));
        System.out.println(validPalindrome("ebcbbececabbacecbbcbe"));
        System.out.println(validPalindrome(
                "ngzodrdohhqilovouwqrbpgqvlplsnfzueemmjtqnizodigfzeuuezfgidozinqtjmmeeuzfnslpvqgpbrqwuovoliqhhodirdozgn"));
        System.out.println(validPalindrome(
                "cfspebsyoopuglxzfvwnkkpxkisdgsldluyhmjmqdxzvblnkloodjkpclvvldwehipxnckxhtrpckrnlxkgdxbwucerhinobosdkfthuswjuwviehzuqgtdmvgnpmgqibbairiaabiggbqcpqlzgpibzqechjvczxwuyecuurdabnpehkudjqnujuaklrmxxipiinrziqxihergsamiaymhacykjagpwuhdcakwipzphhwysugnnibimbggbmibinngusywhhpzpiwkacduhuwpgajkycahmyaimasgrehixqizrniipixxmrlkaujunqjdukhepnbadruuceyuwxzcvjhceqzbipgzlqpcqbggibaairiabbiqgmpngvmdtgquzheivwujwsuhtfkdsobonihrecuwbxdgkxlnrkcprthixkcnxpihewdlvvlcpkjdoolknlbvzxdqmjmhyuldlsgdsikxpkknwvfzxlgupooysbepsfc"));
    }

    public static boolean validPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int lo = 0;
        int hi = charArray.length - 1;

        while (lo < hi) {
            /**
             * 当charArray[lo]和charArray[hi]不相等时，删除其中一个，s剩下的部分为回文字符串就符合要求
             */
            if (charArray[lo] != charArray[hi]) {
                String s1 = s.substring(0, lo) + s.substring(lo + 1, charArray.length);
                String s2 = s.substring(0, hi) + s.substring(hi + 1, charArray.length);
                return isPalindrome(s1) || isPalindrome(s2);
            }
            lo++;
            hi--;
        }
        return true;
    }

    /**
     * 判断字符串s是否回文字符串
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int lo = 0;
        int hi = charArray.length - 1;

        while (lo < hi) {
            if (charArray[lo] != charArray[hi]) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
