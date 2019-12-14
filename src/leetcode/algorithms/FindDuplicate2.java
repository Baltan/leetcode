package leetcode.algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Description: 609. Find Duplicate File in System
 *
 * @author Baltan
 * @date 2019-12-14 11:17
 */
public class FindDuplicate2 {
    public static void main(String[] args) {
        String[] paths1 = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)",
                "root 4.txt(efgh)"};
        System.out.println(findDuplicate(paths1));

        String[] paths2 =
                {"root/a 1.txt(abcd) 2.txt(efsfgh)", "root/c 3.txt(abdfcd)", "root/c/d 4.txt(efggdfh)"};
        System.out.println(findDuplicate(paths2));
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new LinkedList<>();
        /**
         * 文件内容到文件全路径的映射
         */
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] infos = path.split(" ");
            /**
             * 文件路径
             */
            String filePath = infos[0];
            /**
             * 文件数
             */
            int fileCount = infos.length - 1;

            for (int i = 1; i <= fileCount; i++) {
                /**
                 * 左边括号的索引位置，即文件名和文件内容的分界位置
                 */
                int bracketIndex = infos[i].indexOf("(");
                /**
                 * 文件名
                 */
                String fileName = infos[i].substring(0, bracketIndex);
                /**
                 * 文件内容
                 */
                String fileContent = infos[i].substring(bracketIndex);
                map.putIfAbsent(fileContent, new LinkedList<>());
                /**
                 * 将相同文件内容的文件全路径放在一起
                 */
                map.get(fileContent).add(filePath + "/" + fileName);
            }
        }

        for (List<String> value : map.values()) {
            /**
             * 同一内容的文件至少有两个才将他们算作一组重复的文件
             */
            if (value.size() > 1) {
                result.add(value);
            }
        }
        return result;
    }
}
