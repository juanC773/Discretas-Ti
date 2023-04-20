package model;
public class Node<T> {
    private T key;
    private Node<T> previous;
    private Node<T> next;

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next)
    {
        this.next = next;
    }

    public Node(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public void add(Node<T> e){
        e.setNext(this);
    }
    public int size(){
        Node<T> current = this;
        int cont = 1;
        while(current.getNext()!=null){
            cont++;
            current = current.getNext();
        }
        return cont;
    }


}
