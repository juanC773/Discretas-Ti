package dataStuctures;
/**

 The Queue class is an implementation of the QueuesInterface interface.

 It allows storing and accessing elements in FIFO (first in, first out) order.

 @param <T> the type of object that will be stored in the queue.
 */
public class Queue<T> implements QueuesInterface<T> {

    private Node<T> firstInQueue;
    private Node<T> lastInQueue;
    private int size;

    /**

     Adds the specified item to the end of the queue.
     @param item the item to add to the queue.
     */
    public void enqueue(T item) {
        if (isEmpty()) {
            Node<T> node = new Node<>(item);
            firstInQueue = node;
            lastInQueue = node;
        } else {
            Node<T> nodeToAdd = new Node<>(item);
            lastInQueue.setNext(nodeToAdd);
            nodeToAdd.setPrevious(lastInQueue);
            lastInQueue = nodeToAdd;
        }
        size++;
    }
    /**

     Removes and returns the first item in the queue.

     @return the first item in the queue, or null if the queue is empty.
     */
    public T dequeue() {
        Node<T> first = getFirstInQueue();

        if (first == null) {
            return null;
        } else {
            Node<T> tempNextOfTheFirst = first.getNext();
            if (tempNextOfTheFirst != null) {
                tempNextOfTheFirst.setPrevious(null);
            }
            firstInQueue = tempNextOfTheFirst;
        }

        size--;
        return first.getKey();
    }

    /**
     * name:isEmpty
     Returns whether the queue is empty or not.
     @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return firstInQueue == null;
    }

    public Node<T> getFirstInQueue() {
        return firstInQueue;
    }
    /**
     * name:size
     Returns the size of the queue.
     @return the size of the queue.
     */
    public int size() {
        return size;
    }
}
