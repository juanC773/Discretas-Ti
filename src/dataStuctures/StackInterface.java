package dataStuctures;


public interface StackInterface<T> {

    /**
     Returns the top element of the stack without removing it.
     @return the top element of the stack, or null if the stack is empty
     */
    Node<T> peek();

    /**
     Inserts the specified element into the top of the stack.
     @param key the element to push onto the stack
     */
    void push(T key);
    /**

     Removes and returns the top element of the stack.
     @return the top element of the stack, or null if the stack is empty
     */
    Node<T> pop();

    /**
     Checks if the stack is empty.
     @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();
}