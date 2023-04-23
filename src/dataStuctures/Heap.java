package dataStuctures;



import exceptions.dataStructure.HeapIsFullException;
import exceptions.dataStructure.UsePollWithoutElementsException;

import java.util.Objects;

public class Heap<T extends Comparable<T>> implements HeapInterface<T>{
    private T[] heapArray;
    private int heapSize;

    public Heap(int capacity) {
        heapArray = (T[]) new Comparable[capacity];
        heapSize = 0;
    }


    /**
     * name:add
     Adds an item to the heap.
     @param value the generic value to add to the heap.
     @throws HeapIsFullException if the heap size is equal to the length of the heap array.
     */
    public void add(T value) throws HeapIsFullException {
        if (heapSize == heapArray.length) {
            throw new HeapIsFullException();
        }

        heapArray[heapSize] = value;
        heapSize++;
        siftUp(heapSize - 1);
    }


    /**
     * name:poll
     Retrieves and removes the element from the root of the heap.
     @return the root element of the heap, or null if the heap is empty.
     */
    public T poll() {
        if (heapSize == 0) {
            return null;
        }

        T rootValue = heapArray[0];
        heapSize--;
        heapArray[0] = heapArray[heapSize];
        siftDown(0);
        return rootValue;
    }

    /**
     * name: siftUp
     * Moves an element up on the heap to maintain the heap property.
     * @param index the position of the element in the heap array.
     */
    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heapArray[index].compareTo(heapArray[parentIndex]) <= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    /**
     * name: siftDowm
     *Moves an item down the heap to maintain the heap property.
     *@param index the position of the element in the heap array.
     */
    private void siftDown(int index) {
        while (index * 2 + 1 < heapSize) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            int largerChildIndex = leftChildIndex;
            if (rightChildIndex < heapSize && heapArray[rightChildIndex].compareTo(heapArray[leftChildIndex]) > 0) {
                largerChildIndex = rightChildIndex;
            }
            if (heapArray[index].compareTo(heapArray[largerChildIndex]) >= 0) {
                break;
            }
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    /**
     * name: swap
     *  change two items in the heap array.
     @param index1 the position of the first element to swap.
     @param index2 the position of the second element to swap.
     */
    private void swap(int index1, int index2) {
        T temp = heapArray[index1];
        heapArray[index1] = heapArray[index2];
        heapArray[index2] = temp;
    }


    /**
     * name: size
     * @return the size of the heap
     */
    public int size() {
        return heapArray.length;
    }




}




