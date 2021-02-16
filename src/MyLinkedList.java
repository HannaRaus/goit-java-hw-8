import java.util.Arrays;

public class MyLinkedList<E> extends ConnectedList<E> {

    public E get(int index) {
        checkIndex(index);
        return findNodeByIndex(index).item;
    }

}
