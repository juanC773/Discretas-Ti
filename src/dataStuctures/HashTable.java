package dataStuctures;


import java.util.LinkedList;

public class HashTable<K, V> implements IHashTable<K,V>{
    private int capacity; // capacidad de la tabla hash

    public int getCapacity() {
        return capacity;
    }


    private LinkedList<Entry<K, V>>[] table;     // arreglo de listas enlazadas para manejar colisiones

    // Constructor para inicializar la tabla hash con una capacidad dada
    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<Entry<K, V>>();
        }
    }

    // Función hash para obtener el índice en la tabla hash a partir de una llave
    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    // Método para agregar un par llave-valor a la tabla hash
    public void insert(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> list = table[index];
        for (Entry<K, V> entry : list) {
            if (entry.getKey().equals(key)) {
                entry.value = value;
                return;
            }
        }
        list.add(new Entry<K, V>(key, value));
    }



    // Método para obtener el valor asociado a una llave en la tabla hash
    public V get(K key)  {
        int index = hash(key);
        LinkedList<Entry<K, V>> list = table[index];
        for (Entry<K, V> entry : list) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    // Método para eliminar una entrada de la tabla hash a partir de una llave
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> list = table[index];
        for (Entry<K, V> entry : list) {
            if (entry.getKey().equals(key)) {
                list.remove(entry);
                return;
            }
        }

    }


}

