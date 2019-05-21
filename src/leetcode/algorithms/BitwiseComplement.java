package leetcode.algorithms;

/**
 * Description: 1009. Complement of Base 10 Integer
 *
 * @author Baltan
 * @date 2019-03-18 10:17
 */
public class BitwiseComplement {
    public static void main(String[] args) {
        System.out.println(bitwiseComplement(5));
        System.out.println(bitwiseComplement(7));
        System.out.println(bitwiseComplement(10));
        System.out.println(bitwiseComplement(0));
        System.out.println(bitwiseComplement(4));
        System.out.println(bitwiseComplement(1));
        System.out.println(bitwiseComplement(16));
    }

    public static int bitwiseComplement(int N) {
        int binaryBitNum = 1;

        while (Math.pow(2, binaryBitNum) <= N) {
            binaryBitNum++;
        }

        return (int) (Math.pow(2, binaryBitNum) - 1 - N);
    }
}
