package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1418. Display Table of Food Orders in a Restaurant
 *
 * @author Baltan
 * @date 2020-05-05 11:01
 */
public class DisplayTable {
    public static void main(String[] args) {
        List<List<String>> orders1 = Arrays.asList(Arrays.asList("David", "3", "Ceviche"), Arrays.asList(
                "Corina", "10", "Beef Burrito"),
                Arrays.asList("David", "3", "Fried Chicken"), Arrays.asList("Carla", "5", "Water"),
                Arrays.asList("Carla", "5", "Ceviche"), Arrays.asList("Rous", "3", "Ceviche"));
        System.out.println(displayTable(orders1));

        List<List<String>> orders2 =
                Arrays.asList(Arrays.asList("James", "12", "Fried Chicken"), Arrays.asList(
                        "Ratesh", "12", "Fried " +
                                "Chicken"), Arrays.asList("Amadeus", "12", "Fried Chicken"),
                        Arrays.asList("Adam", "1", "Canadian Waffles"),
                        Arrays.asList("Brianna", "1", "Canadian Waffles"));
        System.out.println(displayTable(orders2));

        List<List<String>> orders3 = Arrays.asList(Arrays.asList("Laura", "2", "Bean Burrito"), Arrays.asList(
                "Jhon", "2", "Beef Burrito"),
                Arrays.asList("Melissa", "2", "Soda"));
        System.out.println(displayTable(orders3));
    }

    public static List<List<String>> displayTable(List<List<String>> orders) {
        /**
         * 保存所有餐品名称的集合，集合中元素按照餐品名称升序排列
         */
        Set<String> foodSet = new TreeSet<>();
        /**
         * 保存所有桌号的的集合，集合中元素按照桌号的数字值升序排列
         */
        Set<Integer> tableNumberSet = new TreeSet<>();
        /**
         * 桌号 -> {餐品名称 -> 该桌点的该餐品的总数量}
         */
        Map<Integer, Map<String, Integer>> orderMap = new HashMap<>();

        for (List<String> order : orders) {
            String food = order.get(2);
            int tableNumber = Integer.valueOf(order.get(1));
            foodSet.add(food);
            tableNumberSet.add(tableNumber);
            orderMap.putIfAbsent(tableNumber, new HashMap<>());
            orderMap.get(tableNumber).put(food, orderMap.get(tableNumber).getOrDefault(food, 0) + 1);
        }
        /**
         * result的行数为桌数+1（第一行餐品行）
         */
        List<List<String>> result = new ArrayList<>(tableNumberSet.size() + 1);
        /**
         * 每一行的列数为餐品数+1（第一列桌号列）
         */
        List<String> firstRow = new ArrayList<>(foodSet.size() + 1);
        firstRow.add("Table");

        for (String food : foodSet) {
            firstRow.add(food);
        }

        result.add(firstRow);

        for (int tableNumber : tableNumberSet) {
            /**
             * 餐品名称 -> 该桌点的该餐品的总数量
             */
            Map<String, Integer> foodMap = orderMap.get(tableNumber);
            List<String> row = new ArrayList<>(foodSet.size() + 1);
            row.add(String.valueOf(tableNumber));

            for (String food : foodSet) {
                /**
                 * 如果该桌没有点过food餐品，数量记做0
                 */
                row.add(String.valueOf(foodMap.getOrDefault(food, 0)));
            }
            result.add(row);
        }
        return result;
    }
}
