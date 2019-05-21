package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 884. Uncommon Words from Two Sentences
 *
 * @author Baltan
 * @date 2018/8/15 10:39
 */
public class UncommonFromSentences {
    public static void main(String[] args) {
        OutputUtils.print1DStringArray(uncommonFromSentences("this apple is sweet", "this apple is sour"));
        OutputUtils.print1DStringArray(uncommonFromSentences("apple apple", "banana"));
        OutputUtils.print1DStringArray(uncommonFromSentences("d b zu d t", "udb zu ap"));
        OutputUtils.print1DStringArray(uncommonFromSentences("op vu kux dn jsenj hbdez hbdez nbenh z op dxmqd " +
                "op", "kux wnx wnx wbi jsenj nlgfn vu f vu fvxas dn op tb"));
    }

    public static String[] uncommonFromSentences(String A, String B) {
        List<String> list = new ArrayList<>();

        String[] aArray = A.split(" ");
        String[] bArray = B.split(" ");

        for (String str : aArray) {
            if (Arrays.stream(aArray).filter(s -> str.equals(s)).count() == 1 && Arrays.stream(bArray)
                    .noneMatch(s -> s.equals(str))) {
                list.add(str);
            }
        }
        for (String str : bArray) {
            if (Arrays.stream(bArray).filter(s -> str.equals(s)).count() == 1 && Arrays.stream(aArray)
                    .noneMatch(s -> s.equals(str))) {
                list.add(str);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
