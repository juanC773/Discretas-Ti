package dataStuctures;
public class Queue<T> implements QueuesInterface<T> {

    private Node<T> firstInQueue;
    private Node<T> lastInQueue;
    private int size;

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

    public boolean isEmpty() {

        if(firstInQueue!=null){
            return false;
        }else {
            return true;
        }
    }

    public Node<T> getFirstInQueue() {
        return firstInQueue;
    }

    public int size() {
        return size;
    }
}
