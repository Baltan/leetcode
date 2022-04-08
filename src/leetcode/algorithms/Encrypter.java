package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2227. Encrypt and Decrypt Strings
 *
 * @author Baltan
 * @date 2022/4/7 19:34
 * @see
 * <a href="https://leetcode-cn.com/problems/encrypt-and-decrypt-strings/solution/by-endlesscheng-sm8h/"></a>
 */
public class Encrypter {
    /**
     * keys[i] -> values[i]，即keys中的每个字符和values中的每个两位字符串的一一映射关系
     */
    private Map<Character, String> kvMapping;
    /**
     * dictionary中的字符串加密后得到的密文s -> 该密文出现的次数，该密文出现几次，就说明密文解密后可以得到几个不同的
     * dictionary中的明文
     */
    private Map<String, Integer> encryptedDictionaryCountMap;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        kvMapping = new HashMap<>();
        encryptedDictionaryCountMap = new HashMap<>();

        for (int i = 0; i < keys.length; i++) {
            kvMapping.put(keys[i], values[i]);
        }

        for (String word : dictionary) {
            String encryptedWord = encrypt(word);

            if (Objects.isNull(encryptedWord)) {
                continue;
            }
            encryptedDictionaryCountMap.put(encryptedWord,
                    encryptedDictionaryCountMap.getOrDefault(encryptedWord, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        StringBuilder builder = new StringBuilder(word1.length() * 2);

        for (char c : word1.toCharArray()) {
            /**
             * 如果数组keys中没有字符c，则字符c无法映射到values中的某个两位字符串，word1也无法完成加密
             */
            if (!kvMapping.containsKey(c)) {
                return null;
            }
            builder.append(kvMapping.get(c));
        }
        return builder.toString();
    }

    public int decrypt(String word2) {
        return encryptedDictionaryCountMap.getOrDefault(word2, 0);
    }

    public static void main(String[] args) {
        char[] keys1 = {'a', 'b', 'c', 'd'};
        String[] values1 = {"ei", "zf", "ei", "am"};
        String[] dictionary1 = {"abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"};
        Encrypter encrypter1 = new Encrypter(keys1, values1, dictionary1);
        System.out.println(encrypter1.encrypt("abcd"));
        System.out.println(encrypter1.decrypt("eizfeiam"));

        System.out.println("------------------------------");

        char[] keys2 = {'a'};
        String[] values2 = {"pq"};
        String[] dictionary2 = {"aa", "x"};
        Encrypter encrypter2 = new Encrypter(keys2, values2, dictionary2);
        System.out.println(encrypter2.decrypt("null"));
    }
}
