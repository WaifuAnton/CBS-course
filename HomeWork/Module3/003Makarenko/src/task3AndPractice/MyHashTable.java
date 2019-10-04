package task3AndPractice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MyHashTable<K, V> {
    private Set<K> keys;
    private LinkedList<V> values;
    private int size;
    private int capacity = 3;
    private MyEntry[] entries;
    private Object[] hashes;

    public MyHashTable() {
        keys = new HashSet<>();
        values = new LinkedList<>();
        entries = new MyEntry[capacity];
    }

    public MyHashTable(int capacity) {
        keys = new HashSet<>(capacity);
        values = new LinkedList<>();
        entries = new MyEntry[capacity];
        this.capacity = capacity;
    }

    private int calculateHash(K key) {
        int result = key.hashCode() % capacity;
        result = result < 0 ? result + capacity : result;
        return result;
    }

    public int size() {
        return size;
    }

    public V put(K key, V value) {
        int hash = calculateHash(key);
        if (size == capacity)
        {
            MyEntry[] tmp = entries;
            capacity = capacity * 3 / 2 + 1;
            entries = new MyEntry[capacity];
            System.arraycopy(tmp, 0, entries, 0, size);
        }
        entries[hash] = new MyEntry(key, value);
        size++;
        return value;
    }

    public V remove(Object key) {
        int hash = calculateHash((K) key);
        V value = (V) entries[hash].getValue();
        entries[hash] = null;
        size--;
        return value;
    }

    public V replace(K key, V value) {
        int hash = calculateHash(key);
        entries[hash] = new MyEntry(key, value);
        return (V) entries[hash].getValue();
    }
}

class MyEntry {
    private Object key;
    private Object value;

    MyEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
