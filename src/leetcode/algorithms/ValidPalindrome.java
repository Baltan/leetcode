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
        int start = 0;
        int end = s.length() - 1;
        int unmatchedNum = 0;
        while (start < end) {
            if (s.substring(start, start + 1).equals(s.substring(end, end + 1))) {
                start++;
                end--;
            } else if (!s.substring(start, start + 1).equals(s.substring(end, end + 1))) {
                if (s.substring(start, start + 1).equals(s.substring(end - 1, end)) &&
                        !s.substring(start + 1, start + 2).equals(s.substring(end, end + 1))) {
                    unmatchedNum++;
                    if (unmatchedNum > 1) {
                        return false;
                    }
                    end--;
                } else if (!s.substring(start, start + 1).equals(s.substring(end - 1, end)) &&
                        s.substring(start + 1, start + 2).equals(s.substring(end, end + 1))) {
                    unmatchedNum++;
                    if (unmatchedNum > 1) {
                        return false;
                    }
                    start++;
                } else if (s.substring(start, start + 1).equals(s.substring(end - 1, end)) &&
                        s.substring(start + 1, start + 2).equals(s.substring(end, end + 1))) {
                    unmatchedNum++;
                    if (unmatchedNum > 1) {
                        return false;
                    }
                    String s1 = s.substring(start + 1, end + 1);
                    String s2 = s.substring(start, end);
                    StringBuilder sb1 = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    for (int i = s1.length() - 1; i >= 0; i--) {
                        sb1.append(s1, i, i + 1);
                        sb2.append(s2, i, i + 1);
                    }
                    if (s1.equals(sb1.toString()) || s2.equals(sb2.toString())) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
