package model;
public class Hash<T> {
    private final int size = 11;
    private Node[] table;
    public Hash(){
        table = new Node[size];
    }
    private int hash(Passenger k){
        return Integer.parseInt(k.getNatId()) % size;
    }
    public void insert(Passenger k){
        int hash = hash(k);
        if(table[hash] != null){
            Node node = new Node(k);
            table[hash].add(node);
            table[hash] = node;
        }else{
            table[hash] = new Node(k);
        }
    }

}