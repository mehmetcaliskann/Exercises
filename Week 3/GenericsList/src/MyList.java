import java.util.Arrays;

public class MyList<T> {
    private Object[] data;
    private int size;

    public MyList() {
        data = new Object[10];
        size = 0;
    }

    public MyList(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) data[index];
    }

    public boolean add(T item) {
        if (size == data.length) {
            // Expand the array
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size] = item;
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }
}
