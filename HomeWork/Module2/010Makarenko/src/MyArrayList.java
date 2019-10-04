import java.util.Dictionary;

public class MyArrayList<T> {
    private final int N = 10;
    private int capacity = N;
    private int size = 0;
    private T[] array;

    public MyArrayList()
    {
        array = (T[]) new Object[capacity];
    }

    public MyArrayList(int capacity)
    {
        capacity = this.capacity;
        array = (T[]) new Object[capacity];
    }

    public int size()
    {
        return size;
    }

    public void add(T obj)
    {
        if (size < capacity)
            array[size++] = obj;
        else
        {
            capacity = capacity * 3 / 2;
            T[] temp = array;
            array = (T[]) new Object[capacity];
            System.arraycopy(temp, 0, array, 0, temp.length);
            array[size++] = obj;
        }
    }

    public void remove(int index)
    {
        size--;
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        if (size == capacity * 2 / 3)
        {
            T[] temp = array;
            capacity = size;
            array = (T[]) new Object[capacity];
            System.arraycopy(temp, 0, array, 0, capacity);
        }
    }

    public void clear()
    {
        array = (T[]) new Object[N];
        capacity = N;
    }

    public Object get(int index) { return array[index]; }

    public boolean contains(T obj)
    {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(obj))
                return true;
        }
        return false;
    }
}
