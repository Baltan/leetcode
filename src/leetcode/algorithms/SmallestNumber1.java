package leetcode.algorithms;

/**
 * Description: 2375. Construct Smallest Number From DI String
 *
 * @author Baltan
 * @date 2023/1/5 09:20
 */
public class SmallestNumber1 {
    public static void main(String[] args) {
        System.out.println(smallestNumber("IIIDIDDD"));
        System.out.println(smallestNumber("DDD"));
    }

    public static String smallestNumber(String pattern) {
        char[] charArray = pattern.toCharArray();
        int length = charArray.length;
        StringBuilder num = new StringBuilder();
        num.append(1);
        /**
         * 下一个要插入字符串num中的数字
         */
        int digit = 2;

        for (int i = 0; i < length; i++) {
            if (charArray[i] == 'I') {
                num.append(digit++);
            } else {
                int j = i;
                /**
                 * 找到这段降序的子串开始的位置，即charArray[i]前的最后一个"I"的位置，假设charArray[j]为所查询的"I"，则num[j+1]应该为
                 * 一个极大值，将digit放在num[j+1]处即可
                 */
                while (j >= 0 && charArray[j] == 'D') {
                    j--;
                }
                num.insert(j + 1, digit++);
            }
        }
        return num.toString();
    }
}
