import java.util.Arrays;

public class MyLinkedList<E> {
    private int size;
    MyNode<E> first;
    MyNode<E> last;

    public void add(E element) {
        MyNode<E> temp = last;
        MyNode<E> newNode = new MyNode<>(temp, element, null);
        last = newNode;
        if (temp == null) {
            first = newNode;
        } else {
            temp.next = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        checkIndex(index);
        return findNodeByIndex(index).item;
    }

    public E remove(int index) {
        checkIndex(index);
        return unlink(findNodeByIndex(index));
    }

    public void clear() {
        for (MyNode<E> element = first; element != null; ) {
            MyNode<E> temp = element.next;
            element.item = null;
            element.next = null;
            element.prev = null;
            element = temp;
        }
        first = last = null;
        size = 0;
    }

    E unlink(MyNode<E> elementToDelete) {
        final E element = elementToDelete.item;
        final MyNode<E> next = elementToDelete.next;
        final MyNode<E> prev = elementToDelete.prev;

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            elementToDelete.next = null;
        }

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            elementToDelete.prev = null;
        }

        elementToDelete.item = null;
        size--;
        return element;

    }

    MyNode<E> findNodeByIndex(int index) {
        MyNode<E> target = first;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        return target;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private E[] toArray() {
        Object[] nodes = new Object[size];
        int i = 0;
        for (MyNode<E> x = first; x != null; x = x.next, i++) {
            nodes[i] = x.item;
        }
        return (E[]) nodes;
    }

    private void checkIndex(int index) {
        if (!ifIndexIsCorrect(index)) {
            throw new IndexOutOfBoundsException("Елемент не знайдено");
        }

    }

    private boolean ifIndexIsCorrect(int index) {
        return index >= 0 && index < size;
    }

    class MyNode<E> {
        E item;
        MyNode<E> next;
        MyNode<E> prev;

        MyNode(MyNode<E> prev, E element, MyNode<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
