import java.lang.reflect.Array;

public class MyArrayList {
    private final int N = 10;
    private int capacity = N;
    private int size = 0;
    private Object[] array;

    public MyArrayList()
    {
        array = new Object[capacity];
    }

    public MyArrayList(int capacity)
    {
        capacity = this.capacity;
        array = new Object[capacity];
    }

    public int size()
    {
        return size;
    }

    public void add(Object obj)
    {
        if (size < capacity)
            array[size++] = obj;
        else
        {
            capacity = capacity * 3 / 2;
            Object[] temp = array;
            array = new Object[capacity];
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
            Object[] temp = array;
            capacity = size;
            array = new Object[capacity];
            System.arraycopy(temp, 0, array, 0, capacity);
        }
    }

    public void clear()
    {
        array = new Object[N];
        capacity = N;
    }

    public Object get(int index)
    {
        return array[index];
    }

    public boolean contains(Object obj)
    {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(obj))
                return true;
        }
        return false;
    }
}
