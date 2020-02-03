package leetcode.algorithms;

import java.util.Stack;

/**
 * Description: 388. Longest Absolute File Path
 *
 * @author Baltan
 * @date 2020-02-03 15:44
 */
public class LengthLongestPath {
    public static void main(String[] args) {
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(
                lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2" +
                        "\n\t\t\tfile2.ext"));
    }

    public static int lengthLongestPath(String input) {
        /**
         * 当input末尾是文件名时，保证这个文件名可以被处理到
         */
        input = input + '\n';
        int result = 0;
        int length = input.length();
        /**
         * 保存各级名称的长度
         */
        Stack<Integer> stack = new Stack<>();
        /**
         * 处理到某一个名称时的绝对路径的长度
         */
        int pathLength = 0;
        /**
         * 当前一级名称的长度
         */
        int dirLength = 0;
        /**
         * 当前一级名称的缩进长度
         */
        int tabLength = 0;
        /**
         * 当前名称是否为文件名
         */
        boolean isFile = false;

        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);

            if (c == '\n') {
                /**
                 * 将栈顶的那些不是当前文件夹或文件的父文件夹的路径名称删除
                 */
                while (stack.size() > tabLength) {
                    pathLength -= stack.pop();
                }

                stack.push(dirLength);
                /**
                 * 当前一级名称的长度计入当前处理到的绝对路径的长度
                 */
                pathLength += dirLength;
                /**
                 * 如果当前一级名称是文件名，则已经得到了一个文件的绝对路径，更新result
                 */
                if (isFile) {
                    result = Math.max(result, pathLength + stack.size() - 1);
                }

                dirLength = 0;
                tabLength = 0;
                isFile = false;
            } else if (c == '\t') {
                tabLength++;
            } else {
                dirLength++;
                /**
                 * 如果遇到了"."，说明当前一级名称是文件名
                 */
                if (c == '.') {
                    isFile = true;
                }
            }
        }
        return result;
    }
}