package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1169. Invalid Transactions
 *
 * @author Baltan
 * @date 2019-08-26 09:00
 */
public class InvalidTransactions {
    public static void main(String[] args) {
        String[] transactions1 = {"alice,20,800,mtv", "alice,50,100,beijing"};
        System.out.println(invalidTransactions(transactions1));

        String[] transactions2 = {"alice,20,800,mtv", "alice,50,1200,mtv"};
        System.out.println(invalidTransactions(transactions2));

        String[] transactions3 = {"alice,20,800,mtv", "bob,50,1200,mtv"};
        System.out.println(invalidTransactions(transactions3));

        String[] transactions4 = {"alex,676,260,bangkok", "bob,656,1366,bangkok", "alex,393,616,bangkok",
                "bob,820,990,amsterdam", "alex,596,1390,amsterdam"};
        System.out.println(invalidTransactions(transactions4));
    }

    public static List<String> invalidTransactions(String[] transactions) {
        List<String> result = new LinkedList<>();
        Map<String, List<String[]>> map = new HashMap<>();
        /**
         * 将不同名字的交易放到map中对应的list中
         */
        for (String transaction : transactions) {
            String[] transactionInfo = transaction.split(",");
            map.putIfAbsent(transactionInfo[0], new ArrayList<>());
            map.get(transactionInfo[0]).add(transactionInfo);
        }
        /**
         * 对每一个同名交易list按照发生时间递增进行排序
         */
        map.forEach((String name, List<String[]> transactionInfoList) -> Collections
                .sort(transactionInfoList, Comparator.comparingInt((x) -> Integer.valueOf(x[1]))));
        /**
         * 对每一笔交易是否是无效的进行判定
         */
        for (List<String[]> transactionInfoList : map.values()) {
            int size = transactionInfoList.size();

            outer:
            for (int i = 0; i < size; i++) {
                String[] transactionInfo = transactionInfoList.get(i);
                /**
                 * 如果交易金额大于1000则交易无效
                 */
                if (Integer.valueOf(transactionInfo[2]) > 1000) {
                    result.add(stringArray2String(transactionInfo));
                } else {
                    /**
                     * 如果60分钟之内在其他城市发生过同名交易则交易无效，查找过去60分钟内是否在其他城市发生过同名交易
                     */
                    for (int j = i - 1; j >= 0; j--) {
                        String[] otherTransactionInfo = transactionInfoList.get(j);

                        if (!Objects.equals(transactionInfo[3], otherTransactionInfo[3]) &&
                                Integer.valueOf(transactionInfo[1]) -
                                        Integer.valueOf(otherTransactionInfo[1]) <= 60) {
                            result.add(stringArray2String(transactionInfo));
                            continue outer;
                        }
                    }
                    /**
                     * 如果60分钟之内在其他城市发生过同名交易则交易无效，查找未来60分钟内是否在其他城市发生过同名交易
                     */
                    for (int j = i + 1; j < size; j++) {
                        String[] otherTransactionInfo = transactionInfoList.get(j);

                        if (!Objects.equals(transactionInfo[3], otherTransactionInfo[3]) &&
                                Integer.valueOf(otherTransactionInfo[1]) -
                                        Integer.valueOf(transactionInfo[1]) <= 60) {
                            result.add(stringArray2String(transactionInfo));
                            continue outer;
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 将字符串数组用","相连拼接成字符串
     *
     * @param array
     * @return
     */
    public static String stringArray2String(String[] array) {
        StringBuilder builder = new StringBuilder();

        for (String s : array) {
            builder.append(",").append(s);
        }
        return builder.substring(1);
    }
}
