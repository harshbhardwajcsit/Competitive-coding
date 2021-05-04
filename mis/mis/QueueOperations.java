package mis;

import java.util.HashMap;
import java.util.Map;

public class QueueOperations<T> extends BuggyQueue<T> {

    public static void main(String[] args) {
        QueueOperations<Integer> operations = new QueueOperations<Integer>();
        operations.enqueue(1);
        operations.enqueue(2);
        operations.enqueue(3);
        operations.enqueue(4);

        System.out.println(operations.first() + " " + operations.last());
    }

}

class LinkedListNode<T> {
    private T value;
    private LinkedListNode<T> next;

    public LinkedListNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }
}

class BuggyQueue<T> {

    final Map<T, Integer> frequencyMap = new HashMap<>();

    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int size;

    // puts an element in the LinkedList at the end
    public void enqueue(T t) {
        this.size++;
        LinkedListNode<T> newNode = new LinkedListNode<>(t);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        this.tail.setNext(newNode);
        this.tail = newNode;

        frequencyMap.put(t, frequencyMap.getOrDefault(t, 1));
    }

    // returns the element that was removed from the front
    public T dequeue() {
        //safety check in case queue is already empty
        this.size--;
        LinkedListNode<T> previousHead = this.head;
        this.head = this.head.getNext();
        previousHead.setNext(null);
        T removeElement = previousHead.getValue();

        if (frequencyMap.containsKey(removeElement)) {
            if ((frequencyMap.get(removeElement) - 1) == 0) {
                frequencyMap.remove(removeElement);
            } else {
                frequencyMap.put(removeElement, frequencyMap.get(removeElement) - 1);

            }
        }

        return removeElement;
    }

    // returns the first element in the queue.
    public T first() {
        return this.head.getValue();
    }

    // returns the last element in the queue.
    public T last() {
        return this.tail.getValue();
    }

    public boolean isEmpty() {
        return this.size > 0;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
