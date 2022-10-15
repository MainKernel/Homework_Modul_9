import Interfaces.MyCollection;

public class MyCollectionTest {
    public static void main(String[] args) {
        System.out.println("---------------------------------MyArrayList test ------------------------------");
        MyCollection<Integer> test = new MyArrayList<Integer>();
        test.add(1);
        test.add(30);
        test.add(1);
        test.add(8);
        test.add(10);
        test.add(10);
        test.add(10);
        test.add(10);
        test.add(10);
        test.add(10);
        test.add(10);
        test.add(10);
        test.add(10);
        test.add(10);
        test.add(10);
        test.add(10);

        // Should be 1 30 1 8 10 10 10 10 10 10 10 10 10 10 10 10 null null null null
        System.out.println(test);

        // Should be 20
        System.out.println(test.size());

        // Should be 10
        test.clear();

        // Should be null null null null null null null null
        System.out.println(test);

        // Should be 8
        System.out.println(test.size());


        System.out.println("---------------------------------MyLinkedList test ------------------------------");

        MyLinkedList<String> list = new MyLinkedList<String>();
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        //Should be 5 >>> 6 >>> 7 >>> 8
        list.printLinkList();

        list.remove(2);
        //Should be 5 >>> 6 >>> 8
        list.printLinkList();

        list.clear();
        //Should be clear
        list.printLinkList();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        //Should be 5
        System.out.println("list.size() = " + list.size());


        System.out.println("---------------------------------MyQueue test ------------------------------");

        MyQueue<Integer> queue = new MyQueue<Integer>(10);
        queue.add(10);
        queue.add(9);
        queue.add(3);
        queue.add(8);
        queue.add(92);
        queue.add(92);

        System.out.println("queue.index = " + queue.getIndex());

        //Should be 10, 9, 3, 8, 92, 92
        queue.printQueueWithoutNull();
        System.out.println("queue.index = " + queue.getIndex());
        System.out.println("\nRemoving element at index 3\n");
        queue.remove(3);

        //Should be 10, 9, 3, null, 92, 92, null, null, null, null
        queue.printQueueWithNull();
        //Removing 10 from queue
        queue.remove(0,1);
        //Getting first element from queue, remove method rearrange elements by default be 9
        System.out.println("queue.peek() = " + queue.peek());

        queue.remove(0, 0);
        //Should be null
        System.out.println("queue.peek() = " + queue.peek());
        queue.rearrange();
        queue.printQueueWithNull();
        //Should be 3
        System.out.println("queue.poll() = " + queue.poll());
        //Should be 92, 92, null, null....
        queue.printQueueWithNull();

        System.out.println("---------------------------------MyStack test ------------------------------");
        MyStack <Integer> stack = new MyStack <Integer>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        //Should be 1, 2, 3, 4, 5, 6, 7
        stack.printStackWithoutNull();

        stack.remove(2);
        //Should be 1, 2, 4, 5, 6, 7
        stack.printStackWithoutNull();

        System.out.println("stack.peek() = " + stack.peek());
        stack.remove(4,1);

        //Should be 1,2,4,6,7
        stack.printStackWithNull();

        System.out.println("stack.pop() = " + stack.pop());

        stack.printStackWithoutNull();


        System.out.println("---------------------------------MyHashMap test ------------------------------");
        MyHashMap<Integer, String> myHashMap = new MyHashMap<Integer, String>();

        myHashMap.put(131, "Large Backpack");
        myHashMap.put(152, "Rocky Sword");
        myHashMap.put(163, "Lather Chest Plate");
        myHashMap.put(120, "Wooden Shield");
        myHashMap.put(175, "Lather Boots");

        // 0.0 it's finally work
        System.out.println("myHashMap.get(131) = " + myHashMap.get(131));
        System.out.println("myHashMap.get(152) = " + myHashMap.get(152));
        System.out.println("myHashMap.get(163) = " + myHashMap.get(163));
        System.out.println("myHashMap.get(120) = " + myHashMap.get(120));
        System.out.println("myHashMap.get(175) = " + myHashMap.get(175));
    }
}

