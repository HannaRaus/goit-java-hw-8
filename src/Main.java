public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Milk");
        list.add("Bread");
        list.add("Orange");
        list.add("Cheese");
        list.add("Apple");

        System.out.println("MyLinkedList after add:");
        System.out.println(list);
        System.out.println("Size - " + list.size());
        System.out.println();

        list.remove(2);
        System.out.println("MyLinkedList after remove:");
        System.out.println(list);
        System.out.println("Size - " + list.size());
        System.out.println();

        System.out.println("Element to get - " + list.get(1));
        System.out.println("MyLinkedList after get:");
        System.out.println(list);
        System.out.println("Size - " + list.size());
        System.out.println();

        list.clear();
        System.out.println("MyLinkedList after clear:");
        System.out.println(list);
        System.out.println("Size - " + list.size());

        System.out.println("----------------------------------------------");

        MyStack<String> stack = new MyStack<>();
        stack.push("Milk");
        stack.push("Bread");
        stack.push("Orange");
        stack.push("Cheese");
        stack.push("Apple");

        System.out.println("MyStack after push:");
        System.out.println(stack);
        System.out.println("Size - " + stack.size());
        System.out.println();

        stack.remove(2);
        System.out.println("MyStack after remove:");
        System.out.println(stack);
        System.out.println("Size - " + stack.size());
        System.out.println();

        System.out.println("Element to peek - " + stack.peek());
        System.out.println("MyStack after peek:");
        System.out.println(stack);
        System.out.println("Size - " + stack.size());
        System.out.println();

        System.out.println("Element to pop - " + stack.pop());
        System.out.println("MyStack after pop:");
        System.out.println(stack);
        System.out.println("Size - " + stack.size());
        System.out.println();

        stack.clear();
        System.out.println("MyStack after clear:");
        System.out.println(stack);
        System.out.println("Size - " + stack.size());


    }

}
