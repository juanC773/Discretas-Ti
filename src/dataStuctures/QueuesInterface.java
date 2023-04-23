package dataStuctures;

public interface QueuesInterface<T> {

    /**
     Adds an element to the back of the queue.
     @param item the element to add
     */
    void enqueue(T item);

    /**
     Removes and returns the element at the front of the queue.
     @return the element at the front of the queue, or null if the queue is empty
     */
    T dequeue();

    /**
     Returns true if the queue is empty, false otherwise.
     @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     Returns the number of elements in the queue.
     @return the number of elements in the queue
     */
    int size();
}

