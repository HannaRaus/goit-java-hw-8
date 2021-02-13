import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<K, V> {
    private final int INITIAL_CAPACITY = 16;
    private OneWayNode<K, V>[] buckets;
    private int size;
    private float threshold;


    private class OneWayNode<K, V> {
        private K key;
        private V value;
        OneWayNode<K, V> next;

        public OneWayNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final void setValue(V newValue) {
            value = newValue;
        }

        public boolean hasNext() {
            return next != null;
        }

        @Override
        public final boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            OneWayNode<?, ?> that = (OneWayNode<?, ?>) o;
            return Objects.equals(key, that.key);
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key);
        }
    }


    public MyHashMap() {
        buckets = new OneWayNode[INITIAL_CAPACITY];
        threshold = buckets.length * 0.75f;
    }

    private int getIndex(K key) {
        int hash = 31;
        hash = hash * 17 + Math.abs(key.hashCode());
        return hash % buckets.length;
    }

    public void put(K key, V value) {
        if (size > threshold) {
            resize();
        }
        OneWayNode<K, V> newElement = new OneWayNode<>(key, value);
        int index = getIndex(newElement.getKey());

        if (buckets[index] == null) {
            buckets[index] = newElement;
            size++;
        } else {
            if (buckets[index].equals(newElement)) {
                buckets[index].setValue(newElement.getValue());
            } else {
                OneWayNode<K, V> element = buckets[index];
                while (element.next != null) {
                    if (element.next.getKey().equals(key)) {
                        element.next.setValue(newElement.getValue());
                        return;
                    }
                    element = element.next;
                }
                element.next = newElement;
                size++;
            }
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        OneWayNode<K, V> element = buckets[index];
        try {
            if (element.getKey().equals(key)) {
                return element.getValue();
            } else {
                while (element.hasNext()) {
                    if (element.next.getKey().equals(key)) {
                        return element.next.getValue();
                    }
                    element = element.next;
                }
            }
        } catch (NullPointerException exception) {
            System.out.println("Елемент не знайдено");
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            System.out.println("Елемент не знайдено");
        } else {
            if (buckets[index].getKey().equals(key)) {
                buckets[index] = buckets[index].next;
                size--;
            } else {
                OneWayNode<K, V> element = buckets[index];
                while (element.hasNext()) {
                    if (element.next.getKey().equals(key)) {
                        element.next = element.next.next;
                        size--;
                        break;
                    }
                    element = element.next;
                }
            }
        }
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String result = "";

        for (OneWayNode<K, V> pair : buckets) {
            if (pair != null) {
                result += "index=" + getIndex((K) pair) + " { " + pair.getKey() + " = " + pair.getValue() + "}";
                while (pair.next != null) {
                    result += " { " + pair.next.getKey() + " = " + pair.next.getValue() + "}";
                    pair = pair.next;
                }
                result += "\n";
            }
        }
        result += "Capacity - " + buckets.length;
        return result;
    }

    private void resize() {
        OneWayNode<K, V>[] temp = Arrays.copyOf(buckets, buckets.length * 2);
        buckets = temp;
        threshold = buckets.length * 0.75f;
    }
}
