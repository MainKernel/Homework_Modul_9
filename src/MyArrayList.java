import Interfaces.MyCollection;

public class MyArrayList<T> implements MyCollection<T> {
    private final int INITIALSIZE = 8;
    private final int CUTRATE = 4;
    private Object[] array = new Object[INITIALSIZE];
    private int indexer = 0;

    @Override
    public void add(T value) {
        if (indexer == array.length - 1) {
            resize(array.length + CUTRATE);
            array[indexer++] = value;
        } else {
            array[indexer] = value;
            indexer++;
        }
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < indexer; i++) {
            array[i] = null;
        }

        if (array.length > INITIALSIZE && indexer < array.length / CUTRATE)
            resize(array.length / 2);
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                array[i] = null;
            }
        }
        indexer = 0;
        resize(INITIALSIZE);
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < array.length; i++) {
            size++;
        }
        return size;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    private void resize(int lenght) {
        Object[] newArray = new Object[lenght];
        System.arraycopy(array, 0, newArray, 0, indexer);
        array = newArray;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object o : array) {
            result.append(o).append(" ");
        }
        return result.toString().trim();
    }
}
