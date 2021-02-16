public class MyStack<E> extends ConnectedList<E> {

    public void push(E element) {
        super.add(element);
    }

    public E peek() {
        return last.item;
    }

    public E pop() {
        E temp = last.item;
        remove(0);
        return temp;
    }
}
