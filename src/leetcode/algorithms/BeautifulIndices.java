package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 3006. Find Beautiful Indices in the Given Array I
 *
 * @author baltan
 * @date 2024/1/15 09:52
 */
public class BeautifulIndices {
    public static void main(String[] args) {
        System.out.println(beautifulIndices("bavgoc", "ba", "c", 6));
        System.out.println(beautifulIndices("isawsquirrelnearmysquirrelhouseohmy", "my", "squirrel", 15));
        System.out.println(beautifulIndices("abcd", "a", "a", 4));
    }

    public static List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> result = new ArrayList<>();
        /**
         * 从小到大记录所有满足条件的索引j
         */
        List<Integer> jList = new ArrayList<>();
        outer:
        for (int i = 0; i <= s.length() - b.length(); i++) {
            /**
             * 判断字符串b是否是子串s.substring(i)的前缀子串
             */
            for (int j = 0; j < b.length(); j++) {
                if (s.charAt(i + j) != b.charAt(j)) {
                    continue outer;
                }
            }
            jList.add(i);
        }
        outer:
        for (int i = 0; i <= s.length() - a.length(); i++) {
            /**
             * 判断字符串a是否是子串s.substring(i)的前缀子串
             */
            for (int j = 0; j < a.length(); j++) {
                if (s.charAt(i + j) != a.charAt(j)) {
                    continue outer;
                }
            }
            /**
             * 存在满足条件的索引j，使得|i-j|<=k
             */
            if (binarySearch(jList, i - k, i + k)) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 在数组jList中二分查找是否存在某个元素∈[lowerLimit,upperLimit]
     *
     * @param jList
     * @param lowerLimit
     * @param upperLimit
     * @return
     */
    public static boolean binarySearch(List<Integer> jList, int lowerLimit, int upperLimit) {
        int lo = 0;
        int hi = jList.size() - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (jList.get(mid) > upperLimit) {
                hi = mid - 1;
            } else if (jList.get(mid) < lowerLimit) {
                lo = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
