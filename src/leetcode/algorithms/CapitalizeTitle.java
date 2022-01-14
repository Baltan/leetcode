package leetcode.algorithms;

/**
 * Description: 2129. Capitalize the Title
 *
 * @author Baltan
 * @date 2022/1/14 09:08
 */
public class CapitalizeTitle {
    public static void main(String[] args) {
        System.out.println(capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(capitalizeTitle("First leTTeR of EACH Word"));
        System.out.println(capitalizeTitle("i lOve leetcode"));
    }

    public static String capitalizeTitle(String title) {
        StringBuilder builder = new StringBuilder();
        String[] words = title.split(" ");
        int count = words.length;

        for (int i = 0; i < count; i++) {
            String word = words[i];

            if (word.length() <= 2) {
                /**
                 * 所有字母转小写
                 */
                builder.append(word.toLowerCase())
                        .append(" ");
            } else {
                /**
                 * 首字母大写，其余字母转小写
                 */
                builder.append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        /**
         * 删除最后一个单词后面多余的空格
         */
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
