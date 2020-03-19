package leetcode.interview;

import java.util.Objects;

/**
 * Description: 面试题 10.05. 稀疏数组搜索
 *
 * @author Baltan
 * @date 2020-03-19 12:47
 */
public class FindString {
    public static void main(String[] args) {
        String[] words1 = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(findString(words1, "ta"));

        String[] words2 = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(findString(words2, "ball"));

        String[] words3 = {"DirNnILhARNS hOYIFB", "SM ", "YSPBaovrZBS", "evMMBOf", "mCrS", "oRJfjw gwuo",
                "xOpSEXvfI"};
        System.out.println(findString(words3, "mCrS"));
    }

    public static int findString(String[] words, String s) {
        int lo = 0;
        int hi = words.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (Objects.equals(words[mid], s)) {
                return mid;
            } else if (Objects.equals(words[mid], "")) {
                /**
                 * 如果words[mid]是""，从words[mid+1]开始向右查找，直到找到第一个非空字符串或者不再有
                 * 字符串为止
                 */
                int i = mid + 1;

                while (i < words.length) {
                    if (Objects.equals(words[i], s)) {
                        return i;
                    } else if (!Objects.equals(words[i], "")) {
                        /**
                         * 找到了一个非空字符串，如果s大于这个字符串，说明s可能在这个字符串右边；如果s
                         * 小于这个字符串，因为words[mid]-words[i-1]都为""，说明s可能在words[mid]
                         * 左边
                         */
                        if (s.compareTo(words[i]) > 0) {
                            lo = i + 1;
                        } else {
                            hi = mid - 1;
                        }
                        break;
                    } else {
                        i++;
                    }
                }
                /**
                 * 如果words[mid]右边没有非空字符串，说明s可能在words[mid]左边
                 */
                if (i == words.length) {
                    hi = mid - 1;
                }
            } else if (s.compareTo(words[mid]) > 0) {
                /**
                 * 如果s是非空字符串，并且s大于words[mid]，说明s可能在words[mid]右边
                 */
                lo = mid + 1;
            } else {
                /**
                 * 如果s是非空字符串，并且s小于words[mid]，说明s可能在words[mid]左边
                 */
                hi = mid - 1;
            }
        }
        return -1;
    }
}
