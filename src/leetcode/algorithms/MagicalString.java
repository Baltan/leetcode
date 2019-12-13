package leetcode.algorithms;

/**
 * Description: 481. Magical String
 *
 * @author Baltan
 * @date 2019-12-13 10:14
 */
public class MagicalString {
    public static void main(String[] args) {
        System.out.println(magicalString(6));
        System.out.println(magicalString(5000));
        System.out.println(magicalString(10000));
        System.out.println(magicalString(100000));
    }

    public static int magicalString(int n) {
        int result = 0;
        /**
         * 初始化神奇字符串的前3位
         */
        StringBuilder builder = new StringBuilder("122");
        /**
         * index索引处数字的值表示某一次迭代需要追加的数字的个数
         */
        int index = 2;
        /**
         * 某一次迭代需要追加的数字
         */
        int addNum = 1;

        while (builder.length() < n) {
            /**
             * 在字符串后追加count个addNum
             */
            int count = builder.charAt(index) - '0';

            for (int i = 0; i < count; i++) {
                builder.append(addNum);
            }
            /**
             * 这一轮追加的数字是1，下一轮就追加2；这一轮追加的数字是2，下一轮就追加1
             */
            addNum = 3 - addNum;
            index++;
        }
        /**
         * 计数
         */
        for (int i = 0; i < n; i++) {
            if (builder.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }
}
