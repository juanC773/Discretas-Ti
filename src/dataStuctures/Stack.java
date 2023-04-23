package dataStuctures;

import dataStuctures.Node;

public class Stack<T> implements StackInterface<T>{


    private Node<T> node;
    private Node<T> leader;


    /**
     * name: peek
     * @return return the first in the stack
     */
    public Node peek() {

        if(leader==null){

            System.out.println("");

        }

        return leader;
    }


    /**
     * name: push
     * add an element in the stack
     * @param key value of the item
     */
    public void push(T key) {

        if(isEmpty()){
            Node<T> nodeToAdd = new Node<>(key);
            leader = nodeToAdd;
        }
        else {
            Node<T> nodeToAdd = new Node<>(key);
            Node<T> temp = peek();
            temp.setPrevious(nodeToAdd);
            nodeToAdd.setNext(temp);
            leader = nodeToAdd;
        }

    }

    /**
     * name:pop
     * @return return the first in the stack and delete the item
     */
    public Node<T> pop() {

        Node<T> first = peek();

        if (first == null) {
            System.out.println("Todos los pasajeros han salido del avión");
        }
        else {
            Node<T> nextPop = first.getNext();
            leader = nextPop;
            if(nextPop != null) {
                nextPop.setPrevious(null);
            }
        }
        return first;
    }


    /**
     * name:isEmpty
      Returns whether the queue is empty or not.
     @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {


        if(leader == null) {
            return true;
        }
        return false;

    }



}









