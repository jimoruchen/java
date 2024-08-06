package test;

import java.util.Arrays;

public class MyList {
    private int[] arr;
    private int capacity = 10;
    private int size = 0;
    private int extendRatio = 2;

    public MyList() {
        arr = new int[capacity];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public void extendRatio() {
        arr = Arrays.copyOf(arr, capacity() * extendRatio);
        capacity = arr.length;
    }
    public int get(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("索引越界");
        return arr[index];
    }

    public void set(int index, int num) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("索引越界");
        arr[index] = num;
    }

    public void add(int num) {
        if(size == capacity())
            extendRatio();
        arr[size] = num;
        size++;
    }

    public int remove(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("索引越界");
        int num = arr[index];
        for(int i = index; i < size - 1; i++)
            arr[i] = arr[i + 1];
        size--;
        return num;
    }

    public void insert(int index, int num) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("索引越界");
        if(size == capacity())
            extendRatio();
        for(int j = size - 1; j >= index; j--)
            arr[j + 1] = arr[j];
        arr[index] = num;
        size++;
    }

    public int[] toArray() {
        int size = size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = get(i);
        return arr;
    }
}
