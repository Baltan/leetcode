package leetcode.algorithms;

/**
 * Description: 273. Integer to English Words
 *
 * @author Baltan
 * @date 2019-06-14 09:00
 */
public class NumberToWords {
    public static void main(String[] args) {
        System.out.println(numberToWords(123));
        System.out.println(numberToWords(12345));
        System.out.println(numberToWords(1234567));
        System.out.println(numberToWords(1234567891));
        System.out.println(numberToWords(2147483647));
        System.out.println(numberToWords(2000000000));
        System.out.println(numberToWords(1100000000));
        System.out.println(numberToWords(1210003123));
        System.out.println(numberToWords(1000023000));
        System.out.println(numberToWords(1000000001));
        System.out.println(numberToWords(1200022001));
        System.out.println(numberToWords(1010101010));
    }

    public static String numberToWords(int num) {
        String[] arr1 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] arr2 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen"};
        String[] arr3 =
                {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] arr4 = {"", "Thousand", "Million", "Billion"};


        if (num >= 0 && num < 10) {
            return arr1[num];
        } else if (num >= 10 && num < 20) {
            return arr2[num - 10];
        } else if (num >= 20 && num < 100) {
            if (num % 10 == 0) {
                return arr3[num / 10];
            } else {
                return arr3[num / 10] + " " + arr1[num % 10];
            }
        } else if (num >= 100 && num < 1000) {
            if (num % 100 == 0) {
                return arr1[num / 100] + " Hundred";
            } else {
                return arr1[num / 100] + " Hundred " + numberToWords(num % 100);
            }
        } else {
            int q;

            if ((q = num / 1000000000) >= 1 && q <= 9 && num % 1000000000 == 0) {
                return arr1[q] + " " + arr4[3];
            } else if ((q = num / 1000000) >= 1 && q <= 9 && num % 1000000 == 0) {
                return arr1[q] + " " + arr4[2];
            } else if ((q = num / 1000) >= 1 && q <= 9 && num % 1000 == 0) {
                return arr1[q] + " " + arr4[1];
            }

            StringBuilder builder = new StringBuilder();
            int x;
            int i = 0;

            while (num > 0) {
                x = num % 1000;

                if (x != 0) {
                    builder.insert(0, numberToWords(x) + " " + arr4[i] + " ");
                }
                i++;
                num /= 1000;
            }
            return builder.toString().trim();
        }
    }
}
