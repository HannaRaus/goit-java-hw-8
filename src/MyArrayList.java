
import java.util.Arrays;

public class MyArrayList<E> {

    private final int DEFAULT_SIZE = 5;
    private E[] elements = (E[]) new Object[DEFAULT_SIZE];
    private int size = 0;

    public void add(E element) {
        if (size == elements.length) {
            resize(elements.length * 2);
        }
        elements[size++] = element;
    }

    public E get(int index) {
        try {
            return (E) elements[index];
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Елемент не знайдено");
            return null;
        }
    }

    public void remove(int index) {
        if (index > size) {
            System.out.println("Елемент не знайдено");
        } else {
            for (int i = index; i < size; i++) {
                elements[i] = elements[i + 1];
            }
            elements[size] = null;
            size--;
            checkIfTooLong();
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    private void resize(int newSize) {
        E[] temp = Arrays.copyOf(elements, newSize);
        elements = temp;
    }

    private void checkIfTooLong() {
        if (elements.length > DEFAULT_SIZE && size < elements.length / 4) {
            resize(elements.length / 2);
        }
    }

}
