package leetcode.algorithms;

import leetcode.entity.NestedInteger;
import leetcode.entity.NestedIntegerImpl;

import java.util.*;

/**
 * Description: 341. Flatten Nested List Iterator
 *
 * @author Baltan
 * @date 2019-06-25 09:39
 */
public class NestedIterator implements Iterator<Integer> {
    private Queue<Integer> queue;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.queue = new LinkedList<>();

        queue.addAll(flattenNestedList(nestedList));
    }

    private List flattenNestedList(List<NestedInteger> nestedList) {
        List<Integer> list = new LinkedList<>();

        if (nestedList != null) {
            for (NestedInteger element : nestedList) {
                if (element.isInteger()) {
                    list.add(element.getInteger());
                } else {
                    list.addAll(flattenNestedList(element.getList()));
                }
            }
        }
        return list;
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {
        List<NestedInteger> nestedList1 =
                Arrays.asList(new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(1),
                        new NestedIntegerImpl(1))), new NestedIntegerImpl(2),
                        new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(1),
                                new NestedIntegerImpl(1))));
        NestedIterator it1 = new NestedIterator(nestedList1);
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        System.out.println("-----------------------");

        List<NestedInteger> nestedList2 = Arrays.asList(new NestedIntegerImpl(1),
                new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(4)
                        , new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(6))))));
        NestedIterator it2 = new NestedIterator(nestedList2);
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
    }
}
