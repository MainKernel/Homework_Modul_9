package Interfaces;

public interface Deque<T> {
    public void add(T value);

    public void remove(int index);

    public void clear();

    public int size();

    public T peek();

    public T poll();

    public boolean isFull();

    public boolean isEmpty();
}
