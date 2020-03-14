package leetcode.interview;

/**
 * Description: 面试题 05.01. 插入
 *
 * @author Baltan
 * @date 2020-03-14 21:11
 */
public class InsertBits {
    public static void main(String[] args) {
        System.out.println(insertBits(0b10000000000, 0b10011, 2, 6));
        System.out.println(insertBits(0b0, 0b1111, 0, 4));
    }

    public static int insertBits(int N, int M, int i, int j) {
        /**
         * 取N的二进制表示的最后i位
         * 例如：N=0b10000000000，M=0b10011，i=2，j=6，得到tail=0b11&0b10000000000=0b00
         */
        int tail = (int) (Math.pow(2, i) - 1) & N;
        /**
         * 将N的二进制表示的最后j+1位移除
         * 得到N=0b1000
         */
        N >>= (j + 1);
        /**
         * 将N的二进制表示最后加上j-i+1个0
         * 得到N=0b100000000
         */
        N <<= (j - i + 1);
        /**
         * 将N的最后j-i+1个0替换成M的二进制表示
         * 得到N=0b100000000^0b10011=0b100010011
         */
        N ^= M;
        /**
         * 将N最后再加上i个0
         * 得到N=0b10001001100
         */
        N <<= i;
        /**
         * 将N最后i个0替换成tail
         * 得到N=0b10001001100^0b00=0b10001001100
         */
        N ^= tail;
        return N;
    }
}
