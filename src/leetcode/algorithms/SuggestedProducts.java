package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1268. Search Suggestions System
 *
 * @author Baltan
 * @date 2019-11-27 09:14
 */
public class SuggestedProducts {
    public static void main(String[] args) {
        String[] products1 = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord1 = "mouse";
        System.out.println(suggestedProducts(products1, searchWord1));

        String[] products2 = {"havana"};
        String searchWord2 = "havana";
        System.out.println(suggestedProducts(products2, searchWord2));

        String[] products3 = {"bags", "baggage", "banner", "box", "cloths"};
        String searchWord3 = "bags";
        System.out.println(suggestedProducts(products3, searchWord3));

        String[] products4 = {"havana"};
        String searchWord4 = "tatiana";
        System.out.println(suggestedProducts(products4, searchWord4));
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new LinkedList<>();
        /**
         * 搜索单词的第一个字母
         */
        char firstChar = searchWord.charAt(0);
        /**
         * 可能的可推荐产品
         */
        List<String> filteredProducts = new LinkedList<>();
        int length = searchWord.length();
        /**
         * 查找所有第一个字母和搜索单词的第一个字母相同的产品，所有可能被推荐的产品都在这些产品中产生
         */
        for (String product : products) {
            if (!product.isEmpty() && product.charAt(0) == firstChar) {
                filteredProducts.add(product);
            }
        }

        for (int i = 1; i <= length; i++) {
            /**
             * 当前搜索被推荐的产品列表
             */
            List<String> currentResult = new LinkedList<>();
            /**
             * 所有匹配当前搜索输入的产品列表，当下一轮搜索再输入一个搜索字母后，可能被推荐的产品都在这些产品中产生
             */
            List<String> possibleProducts = new LinkedList<>();
            /**
             * 当前搜索输入的字符串，被推荐产品的前缀和该字符串匹配
             */
            String prefix = searchWord.substring(0, i);
            /**
             * 被推荐的第一个产品
             */
            String first = null;
            /**
             * 被推荐的第二个产品
             */
            String second = null;
            /**
             * 被推荐的第三个产品
             */
            String third = null;

            for (String filteredProduct : filteredProducts) {
                /**
                 * 如果产品的前缀和搜索字符串匹配，该产品可能被推荐
                 */
                if (filteredProduct.startsWith(prefix)) {
                    possibleProducts.add(filteredProduct);
                    /**
                     * 调整推荐的产品列表
                     */
                    if (first == null) {
                        first = filteredProduct;
                    } else if (first != null && second == null) {
                        if (filteredProduct.compareTo(first) < 0) {
                            second = first;
                            first = filteredProduct;
                        } else {
                            second = filteredProduct;
                        }
                    } else if (first != null && second != null && third == null) {
                        if (filteredProduct.compareTo(first) < 0) {
                            third = second;
                            second = first;
                            first = filteredProduct;
                        } else if (filteredProduct.compareTo(second) < 0) {
                            third = second;
                            second = filteredProduct;
                        } else {
                            third = filteredProduct;
                        }
                    } else {
                        if (filteredProduct.compareTo(first) < 0) {
                            third = second;
                            second = first;
                            first = filteredProduct;
                        } else if (filteredProduct.compareTo(second) < 0) {
                            third = second;
                            second = filteredProduct;
                        } else if (filteredProduct.compareTo(third) < 0) {
                            third = filteredProduct;
                        }
                    }
                }
            }
            /**
             * 将推荐的产品加入当前搜索推荐的产品列表中
             */
            if (first != null) {
                currentResult.add(first);
            }

            if (second != null) {
                currentResult.add(second);
            }

            if (third != null) {
                currentResult.add(third);
            }

            result.add(currentResult);
            filteredProducts = possibleProducts;
        }
        return result;
    }
}
