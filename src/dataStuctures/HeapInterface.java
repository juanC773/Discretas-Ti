package dataStuctures;

public interface HeapInterface<T extends Comparable<T>> {

    /**
     * Agrega un elemento al Heap
     *
     * @param value El valor que se agregará al Heap
     * @throws IllegalStateException si el Heap está lleno
     */
    void add(T value);

    /**
     * Remueve y devuelve el elemento con el valor máximo en el Heap
     *
     * @return El valor máximo en el Heap o null si el Heap está vacío
     */
    T poll();

    /**
     * Retorna el tamaño actual del Heap
     *
     * @return El tamaño actual del Heap
     */
    int size();
}

