public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.put(1, "milk");
        myHashMap.put(2, "bread");
        myHashMap.put(33, "butter");
        myHashMap.put(34, "cheese");
        myHashMap.put(49, "orange");
        myHashMap.put(4, "333");
        System.out.println("After add elements:");
        System.out.println(myHashMap + " size - " + myHashMap.size());

        myHashMap.put(1, "apple");
        myHashMap.put(34, "111");
        myHashMap.put(33, "pine");
        System.out.println();
        System.out.println("After add elements with same key:");
        System.out.println(myHashMap + " size - " + myHashMap.size());

        System.out.println();
        System.out.println("Element to get:");
        System.out.println(myHashMap.get(33));

        int index = 49;
        System.out.println();
        System.out.println("After remove - " + myHashMap.get(index));
        myHashMap.remove(index);
        System.out.println(myHashMap + " size - " + myHashMap.size());
        System.out.println();

        myHashMap.clear();
        System.out.println("Map after clear - " + myHashMap + " size - " + myHashMap.size());


    }

}
