public class MyStack<E> extends MyLinkedList<E> {

    public void push(E element) {
        super.add(element);
    }

    public E peek() {
        return first.item;
    }

    public E pop() {
        E temp = first.item;
        remove(0);
        return temp;
    }

}
