package leetcode.algorithms;

import java.util.*;

/**
 * Description: 126. Word Ladder II
 *
 * @author Baltan
 * @date 2019-12-21 12:51
 */
public class FindLadders {
    public static void main(String[] args) {
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(findLadders("hit", "cog", wordList1));

        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println(findLadders("hit", "cog", wordList2));

        List<String> wordList3 =
                Arrays.asList("kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay",
                        "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die",
                        "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid",
                        "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag",
                        "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw",
                        "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy",
                        "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry",
                        "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed",
                        "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap",
                        "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax",
                        "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm",
                        "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew",
                        "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron",
                        "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but",
                        "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew",
                        "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib",
                        "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev",
                        "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin",
                        "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus",
                        "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six",
                        "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap",
                        "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue",
                        "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec",
                        "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw",
                        "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow",
                        "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum",
                        "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet",
                        "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur",
                        "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw",
                        "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our",
                        "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui",
                        "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug",
                        "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay",
                        "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim",
                        "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw",
                        "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid",
                        "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub",
                        "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban",
                        "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net",
                        "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic",
                        "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism",
                        "err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa",
                        "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh",
                        "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut",
                        "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape",
                        "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref",
                        "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win",
                        "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob",
                        "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox",
                        "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten",
                        "mob");
        System.out.println(findLadders("cet", "ism", wordList3));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new LinkedList<>();
        /**
         * 单词字典所有单词的集合
         */
        Set<String> wordSet = new HashSet<>(wordList);
        /**
         * 如果单词字典集合中不包含endWord，显然无法完成单词接龙
         */
        if (!wordSet.contains(endWord)) {
            return result;
        }
        /**
         * 每个单词可以接的下一个单词的集合
         */
        Map<String, Set<String>> transformMap = new HashMap<>();
        /**
         * a-z小写字母表
         */
        String[] alphabet = new String[26];
        Queue<List<String>> queue = new LinkedList<>();
        /**
         * 是否找到了单词接龙转换序列
         */
        boolean findShortest = false;
        /**
         * 当前已经使用过的单词的集合，每一轮循环都不使用前面循环已经接过的单词，否则到该单词为止，这轮
         * 循环过后的单词序列的长度一定大于前面循环的单词序列的长度，必然不满足最短转换序列的要求
         */
        Set<String> isUsed = new HashSet<>();

        for (int i = 0; i < 26; i++) {
            alphabet[i] = String.valueOf((char) (i + 'a'));
        }
        /**
         * 查找beginWord可以接的下一个单词的集合
         */
        findNextWords(beginWord, wordSet, transformMap, alphabet, endWord);
        /**
         * 查找单词字典集合中每个单词可以接的下一个单词的集合
         */
        for (String word : wordList) {
            findNextWords(word, wordSet, transformMap, alphabet, endWord);
        }
        /**
         * 新建一个单词转化序列，先将beginWord加入到序列中
         */
        List<String> transformList = new ArrayList<>();
        transformList.add(beginWord);
        queue.offer(transformList);
        /**
         * 将beginWord标记为已经使用过的单词，接下去查找单词序列的过程中不再使用该单词
         */
        isUsed.add(beginWord);
        /**
         * 每一轮循环会将队列中所有单词序列都接上一个单词，直到接到endWord为止
         */
        while (!queue.isEmpty()) {
            int size = queue.size();
            /**
             * 这轮循环接的所有单词的集合，对于同一轮循环中的单词是可以重复使用的，例如：
             * cet-cat-can-ian-inn
             * cet-cot-con-ion-inn
             * 以上两个序列在第四轮循环中都接上了"inn"
             */
            Set<String> usedWords = new HashSet<>();
            /**
             * 逐一讨论当前队列中的所有长度相同的单词序列
             */
            for (int i = 0; i < size; i++) {
                List<String> list = queue.poll();
                /**
                 * 当前单词序列的最后一个单词
                 */
                String last = list.get(list.size() - 1);
                /**
                 * 最后一个单词可以接的下一个单词的集合
                 */
                Set<String> transformedWords = transformMap.get(last);
                /**
                 * 如果在这轮循环中前面已经有某个单词序列找到了单词接龙转换序列，如果当前单词序列后面
                 * 不能接endWord，则当前单词序列的长度就不会是最短的，不需要再讨论这个单词序列
                 */
                if (findShortest && !transformedWords.contains(endWord)) {
                    continue;
                }
                /**
                 * 如果最后一个单词可以接endWord，则直接接endWord，这可以保证是一个最短单词接龙转换
                 * 序列
                 */
                if (transformedWords.contains(endWord)) {
                    list.add(endWord);
                    result.add(list);
                    /**
                     * 标记已经找到了一个最短单词接龙转换序列，这样该轮循环之后再添加单词的单词序列
                     * 长度一定超过这个最短单词接龙转换序列的长度，所以不需要再继续添加单词讨论了
                     */
                    findShortest = true;
                } else {
                    /**
                     * 如果最后一个单词不能接endWord，尝试在还没有使用过单词字典集合找一个单词接上，
                     * 将新的单词序列加入队列中
                     */
                    for (String transformedWord : transformedWords) {
                        if (isUsed.contains(transformedWord)) {
                            continue;
                        }

                        List<String> list1 = new ArrayList<>(list);
                        list1.add(transformedWord);
                        queue.offer(list1);
                        /**
                         * 将接上的单词加入这轮循环接的所有单词的集合
                         */
                        usedWords.add(transformedWord);
                    }
                }
            }
            /**
             * 将这轮循环接的所有单词的集合加入到当前已经使用过的单词的集合中
             */
            isUsed.addAll(usedWords);
            /**
             * 如果这轮循环已经找到过最短转换序列，则直接返回结果
             */
            if (findShortest) {
                return result;
            }
        }
        return result;
    }

    /**
     * 查找每个单词可以接的下一个单词的集合
     *
     * @param word
     * @param wordSet
     * @param transformMap
     * @param alphabet
     * @param endWord
     */
    public static void findNextWords(String word, Set<String> wordSet,
                                     Map<String, Set<String>> transformMap, String[] alphabet,
                                     String endWord) {
        if (Objects.equals(word, endWord)) {
            return;
        }
        /**
         * 当前单词可以接的下一个单词的集合
         */
        Set<String> set = new HashSet<>();
        int length = word.length();
        int differenceCount = 0;
        /**
         * 当前单词和endWord有几个字母不同
         */
        for (int i = 0; i < length; i++) {
            if (word.charAt(i) != endWord.charAt(i)) {
                differenceCount++;
            }
        }
        /**
         * 如果当前单词和endWord只有一个字母不同，则当前单词下一个单词可以接endWord，对于当前单词来说，
         * 直接接endWord肯定是最短转换序列，不用再尝试接其他单词
         */
        if (differenceCount == 1) {
            set.add(endWord);
            transformMap.put(word, set);
            return;
        }
        /**
         * 变化当前单词中的任意一个字母，如果单词字典集合中有这个变化后的单词，则当前单词下一个单词可以
         * 接这个变化后的单词
         */
        for (int i = 0; i < length; i++) {
            for (String letter : alphabet) {
                /**
                 * 变化一个字母后的单词（也可能和当前单词相同）
                 */
                String transformedWord = word.substring(0, i) + letter + word.substring(i + 1);

                if (!Objects.equals(word, transformedWord) && wordSet.contains(transformedWord)) {
                    set.add(transformedWord);
                }
            }
        }
        transformMap.put(word, set);
    }
}
