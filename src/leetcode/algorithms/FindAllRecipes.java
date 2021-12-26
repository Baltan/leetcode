package leetcode.algorithms;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description: 2115. Find All Possible Recipes from Given Supplies
 *
 * @author Baltan
 * @date 2021/12/26 14:45
 */
public class FindAllRecipes {
    public static void main(String[] args) {
        String[] recipes1 = {"bread"};
        List<List<String>> ingredients1 = Arrays.asList(
                Arrays.asList("yeast", "flour")
        );
        String[] supplies1 = {"yeast", "flour", "corn"};
        System.out.println(findAllRecipes(recipes1, ingredients1, supplies1));

        String[] recipes2 = {"bread", "sandwich"};
        List<List<String>> ingredients2 = Arrays.asList(
                Arrays.asList("yeast", "flour"),
                Arrays.asList("bread", "meat")
        );
        String[] supplies2 = {"yeast", "flour", "meat"};
        System.out.println(findAllRecipes(recipes2, ingredients2, supplies2));

        String[] recipes3 = {"bread", "sandwich", "burger"};
        List<List<String>> ingredients3 = Arrays.asList(
                Arrays.asList("yeast", "flour"),
                Arrays.asList("bread", "meat"),
                Arrays.asList("sandwich", "meat", "bread")
        );
        String[] supplies3 = {"yeast", "flour", "meat"};
        System.out.println(findAllRecipes(recipes3, ingredients3, supplies3));

        String[] recipes4 = {"bread"};
        List<List<String>> ingredients4 = Arrays.asList(
                Arrays.asList("yeast", "flour")
        );
        String[] supplies4 = {"yeast"};
        System.out.println(findAllRecipes(recipes4, ingredients4, supplies4));
    }

    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients,
                                              String[] supplies) {
        List<String> result = new ArrayList<>();
        /**
         * 已拥有的原材料集合
         */
        Set<String> supplySet = Arrays.stream(supplies).collect(Collectors.toSet());
        /**
         * 每道菜需要的原材料集合
         */
        List<Set<String>> ingredientSetList = ingredients.stream()
                .map(ingredient -> ingredient.stream().collect(Collectors.toSet()))
                .collect(Collectors.toList());
        /**
         * 剩余还未做出的菜
         */
        int leftCount = recipes.length;
        /**
         * isCreated[i]表示第i道菜是否已被做出
         */
        boolean[] isCreated = new boolean[leftCount];
        /**
         * 标记每一轮判断是否有新的菜被做出，如果有新的菜被做出，可能会使得其他菜也能被做出，需要继续判断
         */
        boolean changed = true;

        while (changed && leftCount > 0) {
            /**
             * 当前这轮判断还没有新的菜被做出
             */
            changed = false;

            for (int i = 0; i < ingredientSetList.size(); i++) {
                /**
                 * 已被做出的菜不需要重复判断
                 */
                if (isCreated[i]) {
                    continue;
                }
                /**
                 * 如果需要完成当前这道菜还需要的原材料
                 */
                Set<String> ingredientSet = ingredientSetList.get(i);
                Iterator<String> it = ingredientSet.iterator();
                /**
                 * 如果需要的原材料我们已经拥有了，就删除
                 */
                while (it.hasNext()) {
                    String str = it.next();

                    if (supplySet.contains(str)) {
                        it.remove();
                    }
                }
                /**
                 * 如果当前这道菜所需要的所有原材料我们都拥有了，就可以做出这道菜了，同时这道菜也被加入我们拥有的原材料中，用于
                 * 判断是否能做出其他的才
                 */
                if (ingredientSet.isEmpty()) {
                    supplySet.add(recipes[i]);
                    result.add(recipes[i]);
                    isCreated[i] = true;
                    changed = true;
                }
            }
        }
        return result;
    }
}
