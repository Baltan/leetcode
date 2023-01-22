package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Description: 2353. Design a Food Rating System
 *
 * @author Baltan
 * @date 2023/1/15 15:20
 */
public class FoodRatings {
    /**
     * 食物 -> 食物评分
     */
    private Map<String, Integer> foodRatingMap;
    /**
     * 食物 -> 烹饪方式
     */
    private Map<String, String> foodCuisineMap;
    /**
     * 烹饪方式 -> {食物评分 -> 食物集合}，每种烹饪方式下的食物评分按照降序排列，每个食物评分下的食物集合按照字典顺序升序排列
     */
    private Map<String, TreeMap<Integer, TreeSet<String>>> cuisineMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        foodRatingMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        cuisineMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            /**
             * 食物food的评分
             */
            foodRatingMap.put(food, rating);
            /**
             * 食物food的烹饪方式
             */
            foodCuisineMap.put(food, cuisine);
            /**
             * cuisine烹饪方式下得分为rating的食物集合
             */
            TreeMap<Integer, TreeSet<String>> ratingMap = cuisineMap.computeIfAbsent(cuisines[i], x -> new TreeMap<>((rating1, rating2) -> rating2 - rating1));
            TreeSet<String> foodSet = ratingMap.computeIfAbsent(ratings[i], x -> new TreeSet<>(String::compareTo));
            foodSet.add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        int oldRating = foodRatingMap.get(food);

        if (oldRating == newRating) {
            return;
        }
        /**
         * 更新食物food的评分
         */
        foodRatingMap.put(food, newRating);
        String cuisine = foodCuisineMap.get(food);
        /**
         * 烹饪方式cuisine下所有得分的食物集合
         */
        Map<Integer, TreeSet<String>> ratingMap = cuisineMap.get(cuisine);
        /**
         * 烹饪方式cuisine下得分为oldRating的食物集合
         */
        TreeSet<String> oldFoodSet = ratingMap.get(oldRating);

        if (oldFoodSet.size() == 1) {
            /**
             * 烹饪方式cuisine下没有得分为oldRating的食物了
             */
            ratingMap.remove(oldRating);
        } else {
            oldFoodSet.remove(food);
        }
        /**
         * 烹饪方式cuisine下得分为newRating的食物集合
         */
        TreeSet<String> newFoodSet = ratingMap.computeIfAbsent(newRating, x -> new TreeSet<>(String::compareTo));
        newFoodSet.add(food);
    }

    public String highestRated(String cuisine) {
        /**
         * 烹饪方式cuisine下的最高得分的食物集合中字典顺序最小的食物
         */
        return cuisineMap.get(cuisine).firstEntry().getValue().first();
    }

    public static void main(String[] args) {
        FoodRatings foodRatings1 = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"}, new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});
        System.out.println(foodRatings1.highestRated("korean"));
        System.out.println(foodRatings1.highestRated("japanese"));
        foodRatings1.changeRating("sushi", 16);
        System.out.println(foodRatings1.highestRated("japanese"));
        foodRatings1.changeRating("ramen", 16);
        System.out.println(foodRatings1.highestRated("japanese"));
    }
}
