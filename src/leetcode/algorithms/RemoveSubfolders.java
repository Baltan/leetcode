package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1233. Remove Sub-Folders from the Filesystem
 *
 * @author Baltan
 * @date 2019-10-21 09:25
 */
public class RemoveSubfolders {
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
        Node root = new Node("", new HashMap<>(), true);
        /**
         * 将所有路径创建为一颗树
         */
        for (String path : folder) {
            Node currentNode = root;
            String[] folderNames = path.split("/");

            for (String folderName : folderNames) {
                if (!Objects.equals(folderName, "")) {
                    if (!currentNode.children.containsKey(folderName)) {
                        /**
                         * 如果当前父文件夹中没有该文件夹名的子文件夹，就在当前父文件夹中记录该子文件夹
                         */
                        Node node = new Node(folderName, new HashMap<>(), false);
                        currentNode.children.put(folderName, node);
                        /**
                         * 标记当前父文件夹有子文件夹
                         */
                        currentNode.hasChild = true;
                        /**
                         * 将该子文件夹作为后面文件夹的父文件夹（如果后面还有文件夹的话）
                         */
                        currentNode = node;
                    } else {
                        /**
                         * 如果当前父文件夹中有该文件夹名的子文件夹，将该子文件夹作为后面文件夹的父文件夹（如果后面
                         * 还有文件夹的话）
                         */
                        currentNode = currentNode.children.get(folderName);
                        /**
                         * 如果该子文件夹没有子文件夹，退出当前循环（当前路径后面的文件夹都为该子文件夹的子文件夹）
                         */
                        if (!currentNode.hasChild) {
                            break;
                        }
                    }
                }
            }
            currentNode.hasChild = false;
        }

        for (Node child : root.children.values()) {
            result.addAll(parseTree(child));
        }
        return result;
    }

    /**
     * 将树转化为路径形式的字符串集合
     *
     * @param root
     * @return
     */
    public static List<String> parseTree(Node root) {
        List<String> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        String rootFolder = "/" + root.value;
        /**
         * 如果根文件夹没有子文件夹，将根文件夹路径加入结果集，否则递归处理根文件夹的子文件夹
         */
        if (!root.hasChild) {
            result.add(rootFolder);
        } else {
            for (Node child : root.children.values()) {
                if (child != null) {
                    List<String> subfolderList = parseTree(child);

                    for (String subfolder : subfolderList) {
                        result.add(rootFolder + subfolder);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 文件夹节点
     */
    private static class Node {
        /**
         * 文件夹名称
         */
        String value;
        /**
         * 子文件夹名称到对应的子文件夹的映射
         */
        Map<String, Node> children;
        /**
         * 是否有子文件夹
         */
        boolean hasChild;

        public Node(String value, Map<String, Node> children, boolean hasChild) {
            this.value = value;
            this.children = children;
            this.hasChild = hasChild;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", children=" + children +
                    ", hasChild=" + hasChild +
                    '}';
        }
    }
}
