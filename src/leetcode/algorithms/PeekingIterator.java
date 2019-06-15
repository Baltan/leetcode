package leetcode.algorithms;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Description: 284. Peeking Iterator
 *
 * @author Baltan
 * @date 2019-06-15 09:26
 */
public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer temp;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        temp = null;
    }

    public Integer peek() {
        if (temp == null) {
            if (!iterator.hasNext()) {
                return null;
            }
            temp = iterator.next();
        }
        return temp;
    }

    @Override
    public Integer next() {
        if (temp != null) {
            Integer value = temp;
            temp = null;
            return value;
        } else {
            if (!iterator.hasNext()) {
                return null;
            }
            return iterator.next();
        }
    }

    @Override
    public boolean hasNext() {
        if (temp != null) {
            return true;
        }
        return iterator.hasNext();
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        Iterator<Integer> iterator1 = list1.iterator();
        PeekingIterator peekingIterator1 = new PeekingIterator(iterator1);
        System.out.println(peekingIterator1.peek());
        System.out.println(peekingIterator1.next());
        System.out.println(peekingIterator1.peek());
        System.out.println(peekingIterator1.next());
        System.out.println(peekingIterator1.peek());
        System.out.println(peekingIterator1.peek());
        System.out.println(peekingIterator1.next());
        System.out.println(peekingIterator1.hasNext());
        System.out.println(peekingIterator1.peek());
        System.out.println(peekingIterator1.next());

        System.out.println("------------------------");

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);
        Iterator<Integer> iterator2 = list2.iterator();
        PeekingIterator peekingIterator2 = new PeekingIterator(iterator2);
        System.out.println(peekingIterator2.hasNext());
        System.out.println(peekingIterator2.peek());
        System.out.println(peekingIterator2.peek());
        System.out.println(peekingIterator2.next());
        System.out.println(peekingIterator2.next());
        System.out.println(peekingIterator2.peek());
        System.out.println(peekingIterator2.peek());
        System.out.println(peekingIterator2.next());
        System.out.println(peekingIterator2.hasNext());
        System.out.println(peekingIterator2.peek());
        System.out.println(peekingIterator2.hasNext());
        System.out.println(peekingIterator2.next());
        System.out.println(peekingIterator2.hasNext());
    }
}
