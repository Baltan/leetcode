package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1239. Maximum Length of a Concatenated String with Unique Characters
 *
 * @author Baltan
 * @date 2019-10-27 12:34
 */
public class MaxLength {
    public static void main(String[] args) {
        List<String> arr1 = Arrays.asList("un", "iq", "ue");
        System.out.println(maxLength(arr1));

        List<String> arr2 = Arrays.asList("cha", "r", "act", "ers");
        System.out.println(maxLength(arr2));

        List<String> arr3 = Arrays.asList("abcdefghijklmnopqrstuvwxyz");
        System.out.println(maxLength(arr3));

        List<String> arr4 = Arrays.asList("abc", "acb", "bac", "bca");
        System.out.println(maxLength(arr4));

        List<String> arr5 =
                Arrays.asList("ab", "ba", "cd", "dc", "ef", "fe", "gh", "hg", "ij", "ji", "kl", "lk", "mn",
                        "nm", "op", "po");
        System.out.println(maxLength(arr5));

        List<String> arr6 =
                Arrays.asList("zog", "nvwsuikgndmfexxgjtkb", "nxko");
        System.out.println(maxLength(arr6));

        List<String> arr7 =
                Arrays.asList("deuklayqjihxpgo", "lcomsnaxdvierqguj", "whvpqlmfzndjgaurs", "xvtgmiufcza",
                        "uiobvacwdk", "z", "bdkrhgfcyqv", "dkpixtzauqoefc", "ngitfmskpoh", "rovazpbckmlx",
                        "xrwbjzdieqkm", "k");
        System.out.println(maxLength(arr7));
    }

    public static int maxLength(List<String> arr) {
        int result = 0;
        int size = arr.size();
        /**
         * 数组第i个元素保存到索引i-1个单词为止的所有搭配
         */
        List<Set<Character>>[] posibilities = new List[size + 1];
        /**
         * 初始化状态，这样对于第一个单词，也存在了"到当前单词的前一个单词为止，所有可能的搭配"
         */
        posibilities[0] = new LinkedList<>();
        posibilities[0].add(new HashSet<>());

        for (int i = 0; i < size; i++) {
            /**
             * 到当前单词为止，所有可能的搭配
             */
            List<Set<Character>> currPosibilities = new LinkedList<>(posibilities[i]);
            /**
             * 到当前单词的前一个单词为止，所有可能的搭配
             */
            List<Set<Character>> prevPosibilities = posibilities[i];
            String word = arr.get(i);
            /**
             * 如果当前单词中含有重复的字母，则到当前单词为止，所有可能的搭配和到当前单词的前一个单词为止，所有可能的
             * 搭配是一样的，直接可以对下一个单词进行处理
             */
            if (isDuplicated(word)) {
                posibilities[i + 1] = currPosibilities;
                continue;
            }
            /**
             * 对于到当前单词的前一个单词为止，所有可能的搭配和当前单词进行组合，如果搭配在一起仍旧没有重复的字母，则
             * 可以将新的搭配将入到当前单词为止，所有可能的搭配中
             */
            outer:
            for (Set<Character> characters : prevPosibilities) {
                Set<Character> set = new HashSet<>(characters);

                for (char c : word.toCharArray()) {
                    /**
                     * 如果之前某一种搭配和当前单词有重复的字母，直接对之前的下一种搭配和当前单词进行判断
                     */
                    if (set.contains(c)) {
                        continue outer;
                    }
                    set.add(c);
                }
                /**
                 * 将新出现的搭配加入到当前单词为止，所有可能的搭配中
                 */
                currPosibilities.add(set);
                /**
                 * 对于新出现的搭配，判断是否包含有更多的不重复的字母
                 */
                result = Math.max(result, set.size());
            }
            posibilities[i + 1] = currPosibilities;
        }
        return result;
    }

    /**
     * 判断当前单词中是否含有重复的字母
     *
     * @param word
     * @return
     */
    public static boolean isDuplicated(String word) {
        Set<Character> set = new HashSet<>();

        for (char c : word.toCharArray()) {
            set.add(c);
        }
        return set.size() < word.length();
    }
}
