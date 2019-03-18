package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: Reveal Cards In Increasing Order
 *
 * @author Baltan
 * @date 2019-03-18 15:40
 */
public class DeckRevealedIncreasing {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7}));
        OutputUtils.print1DIntegerArray(deckRevealedIncreasing(new int[]{17}));
        OutputUtils.print1DIntegerArray(deckRevealedIncreasing(new int[]{17, 13, 11}));
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        int length = deck.length;
        LinkedList<Integer> initDeck = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(length);
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            initDeck.add(deck[i]);
            list.add(deck[i]);
        }
        /**
         * temp存储所有操作结束后纸牌的排序
         */
        while (!initDeck.isEmpty()) {
            temp.add(initDeck.poll());
            Integer value = initDeck.poll();
            if (value != null) {
                initDeck.addLast(value);
            }
        }
        Arrays.sort(deck);
        for (int i = 0; i < length; i++) {
            /**
             * 操作结束后某张纸牌在初始时的位置
             */
            int position = list.indexOf(temp.get(i));
            result[position] = deck[i];
        }
        return result;
    }
}
