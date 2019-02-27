package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Description:Ransom Note
 * @author Baltan
 *
 * @date 2017/11/23 16:17
 */
public class CanConstruct {
    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
        System.out.println(canConstruct("", ""));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if ((magazine == null || "".equals(magazine.trim())) && (ransomNote != null && !"".equals(ransomNote.trim()))) {
            return false;
        }
        String[] magazineArr = magazine.split("");
        ArrayList<String> magazineList = new ArrayList(magazineArr.length);
        Collections.addAll(magazineList, magazineArr);
        for (int i = 0; i < ransomNote.length(); i++) {
            String curr = ransomNote.substring(i, i + 1);
            Iterator iterator = magazineList.iterator();
            boolean flag = false;
            while (iterator.hasNext()) {
                if (iterator.next().equals(curr)) {
                    iterator.remove();
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
