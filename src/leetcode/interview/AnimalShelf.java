package leetcode.interview;

import leetcode.util.OutputUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 面试题 03.06. 动物收容所
 *
 * @author Baltan
 * @date 2020-03-13 15:50
 */
public class AnimalShelf {
    /**
     * 依次保存加入收容所的所有的猫，队列中每个元素为一个二元数组arr，arr[0]为猫的编号，arr[1]为猫加入收容
     * 所的序号
     */
    private Queue<int[]> cats;
    /**
     * 依次保存加入收容所的所有的狗，队列中每个元素为一个二元数组arr，arr[0]为狗的编号，arr[1]为狗加入收容
     * 所的序号
     */
    private Queue<int[]> dogs;
    /**
     * 动物加入收容所的序号，序号越小，加入收容所的时间越早
     */
    private int index;

    public AnimalShelf() {
        this.cats = new LinkedList<>();
        this.dogs = new LinkedList<>();
        this.index = 0;
    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            cats.offer(new int[]{animal[0], index++});
        } else {
            dogs.offer(new int[]{animal[0], index++});
        }
    }

    public int[] dequeueAny() {
        if (cats.isEmpty() && dogs.isEmpty()) {
            return new int[]{-1, -1};
        } else if (cats.isEmpty()) {
            return new int[]{dogs.poll()[0], 1};
        } else if (dogs.isEmpty()) {
            return new int[]{cats.poll()[0], 0};
        } else {
            if (cats.peek()[1] < dogs.peek()[1]) {
                return new int[]{cats.poll()[0], 0};
            } else {
                return new int[]{dogs.poll()[0], 1};
            }
        }
    }

    public int[] dequeueDog() {
        if (dogs.isEmpty()) {
            return new int[]{-1, -1};
        }
        return new int[]{dogs.poll()[0], 1};
    }

    public int[] dequeueCat() {
        if (cats.isEmpty()) {
            return new int[]{-1, -1};
        }
        return new int[]{cats.poll()[0], 0};
    }

    public static void main(String[] args) {
        AnimalShelf animalShelf1 = new AnimalShelf();
        animalShelf1.enqueue(new int[]{0, 0});
        animalShelf1.enqueue(new int[]{1, 0});
        OutputUtils.print1DIntegerArray(animalShelf1.dequeueCat());
        OutputUtils.print1DIntegerArray(animalShelf1.dequeueDog());
        OutputUtils.print1DIntegerArray(animalShelf1.dequeueAny());

        System.out.println("-------------------------------");

        AnimalShelf animalShelf2 = new AnimalShelf();
        animalShelf2.enqueue(new int[]{0, 0});
        animalShelf2.enqueue(new int[]{1, 0});
        animalShelf2.enqueue(new int[]{2, 1});
        OutputUtils.print1DIntegerArray(animalShelf2.dequeueDog());
        OutputUtils.print1DIntegerArray(animalShelf2.dequeueCat());
        OutputUtils.print1DIntegerArray(animalShelf2.dequeueAny());
    }
}
