import Interfaces.Deque;

public class MyQueue<T> implements Deque<T> {
    private Object[] queue;
    private int maxSize;
    private int index;
    private int front;
    private int rear;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new Object[maxSize];
        rear = -1;
        front = 0;
        index = 0;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public void add(T value) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queue[++rear] = value;
        index++;
    }

    @Override
    public void remove(int index) {
        queue[index] = null;
        index--;
        rearrange();
    }

    public void remove(int index, int rearrange) {
        switch (rearrange) {
            case 0:
                queue[index] = null;
                break;
            case 1:
                queue[index] = null;
                rearrange();
                break;
            default:
                System.out.println("Bad option, choice 1 to rearrange queue and 0 to leave queue untouched");
        }
    }


    @Override
    public void clear() {
        for (int i = 0; i < queue.length; i++) {
            queue[i] = null;
        }
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public T peek() {
        return (T) queue[0];
    }

    @Override
    public T poll() {
        rearrange();
        if (queue[0] != null) {
            T temp = (T) queue[0];
            queue[0] = null;
            index--;
            rearrange();
            return temp;
        }
        return null;
    }

    @Override
    public boolean isFull() {
        return (index == maxSize - 1);
    }

    @Override
    public boolean isEmpty() {
        return (index == 0);
    }

    public void rearrange() {
        for (int i = 0; i < queue.length - 1; i++) {
            for (int j = i + 1; j < queue.length; j++) {
                if (queue[i] == null) {
                    queue[i] = queue[j];
                    queue[j] = null;
                }
            }
        }
    }

    public void printQueueWithoutNull() {
        for (int i = 0; i < queue.length; i++) {
            if (i < queue.length - 1 && queue[i] != null) {
                System.out.println(queue[i] + "");
            } else if (queue[i] != null) {
                System.out.println(queue[i]);
            }
        }
    }

    public void printQueueWithNull() {
        for (Object elem : queue) {
            System.out.println(elem + " ");
        }
    }
}
