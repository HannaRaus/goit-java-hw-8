import java.util.Arrays;

public class MyQueue<E> {
    private static final Object[] EMPTY_DATA = new Object[0];
    private int counter = 0;
    private E[] queue = (E[]) EMPTY_DATA;

    public void add(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        queue = Arrays.copyOf(queue, queue.length + 1);
        queue[counter] = element;
        counter++;
    }

    public void remove(int index) {
        if (index > queue.length) {
            System.out.println("Елемент не знайдено");
        } else {
            if (queue.length - 1 - index >= 0) {
                System.arraycopy(queue, index + 1, queue, index, queue.length - 1 - index);
            }
            queue = Arrays.copyOf(queue, queue.length - 1);
        }
    }

    public E peek() {
        return (E) queue[0];
    }

    public E poll() {
        E firstElement = (E) queue[0];
        remove(0);
        return firstElement;
    }

    public int size() {
        return queue.length;
    }

    public void clear() {
        counter = 0;
        queue = (E[]) EMPTY_DATA;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
