package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1487. Making File Names Unique
 *
 * @author Baltan
 * @date 2020-06-22 21:47
 */
public class GetFolderNames {
    public static void main(String[] args) {
        OutputUtils.print1DStringArray(getFolderNames(new String[]{"pes", "fifa", "gta", "pes(2019)"}));
        OutputUtils.print1DStringArray(getFolderNames(new String[]{"gta", "gta(1)", "gta", "avalon"}));
        OutputUtils.print1DStringArray(getFolderNames(
                new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"}));
        OutputUtils.print1DStringArray(getFolderNames(new String[]{"wano", "wano", "wano", "wano"}));
        OutputUtils
                .print1DStringArray(getFolderNames(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/making-file-names-unique/solution/java-dai-zhu-shi-mapbao-liu-wen-jian-chu-xian-de-c/"></a>
     *
     * @param names
     * @return
     */
    public static String[] getFolderNames(String[] names) {
        int length = names.length;
        String[] result = new String[length];
        /**
         * 文件名 -> 该文件名的文件的个数
         */
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            String name = names[i];

            if (!map.containsKey(name)) {
                /**
                 * 标记文件名为name的文件出现一次
                 */
                map.put(name, 1);
                result[i] = name;
            } else {
                /**
                 * 文件名为name的文件已经出现的次数
                 */
                int count = map.get(names[i]);
                /**
                 * 因为文件名为name的文件已经出现了count次，所以该文件的命名至少为name(count)，依次判断
                 * name(count)、name(count+1)、name(count+2)……这些文件名是否被占用，直到找到未被占用
                 * 的那个为止
                 */
                while (map.containsKey(names[i] + "(" + count + ")")) {
                    count++;
                }
                /**
                 * 标记文件名为name(x)的文件出现一次
                 */
                map.put(names[i] + "(" + count + ")", 1);
                /**
                 * 标记文件名为name的文件出现次数增加一次
                 */
                map.put(names[i], map.get(names[i]) + 1);
                result[i] = names[i] + "(" + count + ")";
            }
        }
        return result;
    }
}
