package dataStuctures;


public interface StackInterface<T> {






    Node<T> peek();


    void push(T key);

    Node<T> pop();
    boolean isEmpty();




}
