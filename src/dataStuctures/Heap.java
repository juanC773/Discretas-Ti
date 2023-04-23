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

    public void add(T value) throws HeapIsFullException {
        if (heapSize == heapArray.length) {
            throw new HeapIsFullException();
        }

        heapArray[heapSize] = value;
        heapSize++;
        siftUp(heapSize - 1);
    }

    public T poll() {
        if (heapSize == 0) {
            throw new UsePollWithoutElementsException();
        }

        T rootValue = heapArray[0];
        heapSize--;
        heapArray[0] = heapArray[heapSize];
        siftDown(0);
        return rootValue;
    }

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

    private void swap(int index1, int index2) {
        T temp = heapArray[index1];
        heapArray[index1] = heapArray[index2];
        heapArray[index2] = temp;
    }


    public int size() {
        return heapArray.length;
    }




}




