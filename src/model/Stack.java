
package model;





public class Stack<T> {


    private Node<T> node;
    private Node<T> leader;




    public Node peek() {

        if(leader==null){

            System.out.println("");

        }

        return leader;
    }



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


    public boolean isEmpty() {


        if(leader == null) {
            return true;
        }
        return false;

    }



}








