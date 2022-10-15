public class MyStack<T> {
    private T[] stack;
    private int top;
    private int capacity;

    public MyStack(int capacity) {
        stack = (T[]) new Object[capacity];
        this.capacity = capacity;
        top = -1;
    }

    public void push(T value) {
        if (stack[top + 1] == null) {
            stack[++top] = value;
        }
    }

    public void remove(int index) {
        stack[index] = null;
    }

    public void remove(int index, int rearrange) {
        switch (rearrange) {
            case 0:
                stack[index] = null;
                break;
            case 1:
                stack[index] = null;
                rearrange();
                LIFO();
        }
    }

    private void rearrange() {
        for (int i = 0; i < stack.length - 1; i++) {
            for (int j = i + 1; j < stack.length; j++) {
                if (stack[i] == null) {
                    stack[i] = stack[j];
                    stack[j] = null;
                }
            }
        }
    }

    public void clear() {
        for (Object elem : stack) {
            elem = null;
            top = -1;
        }

    }

    public int size() {
        return top;
    }

    public Object peek() {
        return stack[top];
    }

    public T pop() {
        LIFO();
        T first = stack[top - 1];
        stack[top - 1] = null;
        rearrange();
        return first;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void printStackWithoutNull() {
        for (Object elem : stack) {
            if (elem != null) {
                System.out.println(elem);
            }
        }
    }

    public void printStackWithNull() {
        for (Object elem : stack) {
            System.out.println(elem);
        }
    }

    public void LIFO() {
        int indexer = 0;
        for (int i = 0; i < stack.length; i++) {
            if (stack[i] != null) {
                indexer++;
            }
        }
        top = indexer;
    }
}
