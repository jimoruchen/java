package test;

import java.util.ArrayList;

public class ArrayStack {
    private ArrayList<Integer> stack;

    public ArrayStack() {
        stack = new ArrayList<>();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(int value) {
        stack.add(value);
    }

    public int peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return stack.get(size() - 1);
    }

    public int pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return stack.remove(size() - 1);
    }

    public Object[] toArray() {
        return stack.toArray();
    }
}
