package leetcode.algorithms;

/**
 * Description: 537. Complex Number Multiplication
 *
 * @author Baltan
 * @date 2018/1/10 17:33
 */
public class ComplexNumberMultiply {
    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
    }

    public static String complexNumberMultiply(String a, String b) {
        int aIntPart = Integer.valueOf(a.split("\\+")[0]);
        int aComPart = Integer.valueOf(a.split("\\+")[1].split("i")[0]);
        int bIntPart = Integer.valueOf(b.split("\\+")[0]);
        int bComPart = Integer.valueOf(b.split("\\+")[1].split("i")[0]);
        int intPart = aIntPart * bIntPart - aComPart * bComPart;
        int comPart = aIntPart * bComPart + bIntPart * aComPart;
        StringBuilder sb = new StringBuilder();
        sb.append(intPart).append("+").append(comPart).append("i");
        return sb.toString();
    }
}
