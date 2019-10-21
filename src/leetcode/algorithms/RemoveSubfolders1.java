package leetcode.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1233. Remove Sub-Folders from the Filesystem
 *
 * @author Baltan
 * @date 2019-10-21 09:25
 */
public class RemoveSubfolders1 {
    public static void main(String[] args) {
        String[] folder1 = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        System.out.println(removeSubfolders(folder1));

        String[] folder2 = {"/a/b", "/a", "/c/d/e", "/c/d", "/c/f"};
        System.out.println(removeSubfolders(folder2));

        String[] folder3 = {"/a", "/a/b/c", "/a/b/d"};
        System.out.println(removeSubfolders(folder3));

        String[] folder4 = {"/a/b/c", "/a/b/d", "/a/b/ca"};
        System.out.println(removeSubfolders(folder4));

        String[] folder5 = {"/abc"};
        System.out.println(removeSubfolders(folder5));
    }

    public static List<String> removeSubfolders(String[] folder) {
        List<String> result = new LinkedList<>();
        int length = folder.length;
        /**
         * 任意初始化一个父文件夹路径，只要排序后的第一个文件夹路径不以该父文件夹路径开头即可
         */
        String parentFolder = "0";
        /**
         * 将所有文件夹路径按照字典顺序升序排列
         */
        Arrays.sort(folder);

        for (int i = 0; i < length; i++) {
            /**
             * 遍历所有文件夹路径，如果当前文件夹路径不以当前父文件夹路径开头,说明当前文件夹的父文件夹不存在，将当前
             * 文件夹作为后面循环的父文件夹
             */
            if (!folder[i].startsWith(parentFolder)) {
                result.add(folder[i]);
                /**
                 * 必须加"/"，否则"/a/b/ca"会被作为"/a/b/c"的子文件夹
                 */
                parentFolder = folder[i] + "/";
            }
        }
        return result;
    }
}
