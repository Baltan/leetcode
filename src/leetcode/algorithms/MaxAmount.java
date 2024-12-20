package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3387. Maximize Amount After Two Days of Conversions
 *
 * @author Baltan
 * @date 2024/12/18 22:52
 */
public class MaxAmount {
    public static void main(String[] args) {
        String initialCurrency1 = "EUR";
        List<List<String>> pairs11 = List.of(List.of("EUR", "USD"), List.of("USD", "JPY"));
        double[] rates11 = {2.0, 3.0};
        List<List<String>> pairs12 = List.of(List.of("JPY", "USD"), List.of("USD", "CHF"), List.of("CHF", "EUR"));
        double[] rates12 = {4.0, 5.0, 6.0};
        System.out.println(maxAmount(initialCurrency1, pairs11, rates11, pairs12, rates12));

        String initialCurrency2 = "NGN";
        List<List<String>> pairs21 = List.of(List.of("NGN", "EUR"));
        double[] rates21 = {9.0};
        List<List<String>> pairs22 = List.of(List.of("NGN", "EUR"));
        double[] rates22 = {6.0};
        System.out.println(maxAmount(initialCurrency2, pairs21, rates21, pairs22, rates22));

        String initialCurrency3 = "USD";
        List<List<String>> pairs31 = List.of(List.of("USD", "EUR"));
        double[] rates31 = {1.0};
        List<List<String>> pairs32 = List.of(List.of("EUR", "JPY"));
        double[] rates32 = {10.0};
        System.out.println(maxAmount(initialCurrency3, pairs31, rates31, pairs32, rates32));
    }

    public static double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        /**
         * 货币类型x -> 可以获得的x类型货币的最大数额
         */
        Map<String, Double> currencyAmount = new HashMap<>();
        /**
         * 初始时持有一单位initialCurrency类型货币
         */
        currencyAmount.put(initialCurrency, 1.0);
        /**
         * 第一天兑换操作
         */
        convert(currencyAmount, pairs1, rates1);
        /**
         * 第二天兑换操作
         */
        convert(currencyAmount, pairs2, rates2);
        return currencyAmount.get(initialCurrency);
    }

    /**
     * 进行一天的兑换操作
     *
     * @param currencyAmount 保存一天之内每种货币可以获得的最大数额
     * @param pairs
     * @param rates
     */
    public static void convert(Map<String, Double> currencyAmount, List<List<String>> pairs, double[] rates) {
        /**
         * 初始货币类型 -> { 目标货币类型 -> 初始货币类型可以兑换目标货币类型的数额 }
         */
        Map<String, Map<String, Double>> conversionMap = new HashMap<>();
        /**
         * 保存不同的货币类型
         */
        Queue<String> queue = new LinkedList<>();
        /**
         * 货币类型 -> 该类货币是否已在队列queue中，避免同类型货币重复入队
         */
        Map<String, Boolean> inQueue = new HashMap<>();
        /**
         * 将初始时可能持有的货币类型入队
         */
        for (String currency : currencyAmount.keySet()) {
            queue.offer(currency);
            inQueue.put(currency, Boolean.TRUE);
        }

        for (int i = 0; i < pairs.size(); i++) {
            List<String> pair = pairs.get(i);
            /**
             * 一单位pair.getFirst()类型货币，可以兑换为rates[i]单位pair.getLast()类型货币
             */
            conversionMap.computeIfAbsent(pair.getFirst(), x -> new HashMap<>()).put(pair.getLast(), rates[i]);
            /**
             * 一单位pair.getLast()类型货币，可以兑换为1/rates[i]单位pair.getFirst()类型货币
             */
            conversionMap.computeIfAbsent(pair.getLast(), x -> new HashMap<>()).put(pair.getFirst(), 1.0 / rates[i]);
        }

        while (!queue.isEmpty()) {
            String from = queue.poll();
            inQueue.put(from, Boolean.FALSE);
            /**
             * from类型货币可以兑换的其他货币类型以及对应数额
             */
            Map<String, Double> toMap = conversionMap.get(from);

            if (toMap == null) {
                continue;
            }

            for (Map.Entry<String, Double> entry : toMap.entrySet()) {
                String to = entry.getKey();
                /**
                 * 可以将所有from类型货币兑换为amount单位的to类型货币
                 */
                Double amount = currencyAmount.get(from) * entry.getValue();

                if (amount > currencyAmount.getOrDefault(to, 0.0)) {
                    /**
                     * 更新当天可以获得的to类型货币的最大数额
                     */
                    currencyAmount.put(to, amount);

                    if (!inQueue.getOrDefault(to, Boolean.FALSE)) {
                        /**
                         * to类型货币入队，继续用to类型货币兑换其他类型货币
                         */
                        queue.offer(to);
                        inQueue.put(to, Boolean.TRUE);
                    }
                }
            }
        }
    }
}
