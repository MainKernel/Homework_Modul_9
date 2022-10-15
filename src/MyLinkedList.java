import Interfaces.MyCollection;
import Interfaces.MyIterator;

public class MyLinkedList<T> implements MyCollection<T> {
    private Node<T> head = null;

    private class Node<T> {
        public T value;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public class Iter implements MyIterator {
        public int index = 0;

        @Override
        public boolean hasNext() {
            if (index < size()) {
                return true;
            }
            return false;
        }

        @Override
        public void remove() {
            MyLinkedList.this.remove(size() - 1);

        }

        public Object next() {
            Object o = get(index++);
            return o;
        }
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public void add(T value) {
        if (isEmpty()) {
            head = new Node<T>(value);
        } else {
            Node<T> p = head;
            Node<T> node = new Node<T>(value);
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
            node.next = null;
        }
    }

    @Override
    public void remove(int index) {
        if (isEmpty()) {
            return;
        }
        if (index < 0 || index > size()) {
            return;
        }
        Node<T> p = head, p1 = null;
        int i = -1;
        while (p != null) {
            i++;
            if (i == index) {
                if (p1 == null) {
                    head = head.next;
                } else {
                    p1.next = p.next;
                }
            }
            p1 = p;
            p = p.next;
        }
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public int size() {
        Node<T> p;
        int size = 0;
        for (p = head; p != null; p = p.next) {
            size++;
        }
        return size;
    }

    @Override
    public T get(int index) {
        int i = -1;
        if (isEmpty()) {
            return null;
        }
        if (index < 0 || index > size()) {
            return null;
        }
        Node<T> p = head;
        while (p != null) {
            i++;
            if (i == index) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    public void printLinkList() {
        Node<T> n;
        for (n = head; n != null; n = n.next) {
            if (n.next != null) {
                System.out.print(n.value + " >>> ");
            } else {
                System.out.print(n.value);
            }
        }
        System.out.println();
    }
}
