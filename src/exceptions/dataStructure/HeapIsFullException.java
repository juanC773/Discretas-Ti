package exceptions.dataStructure;



public class HeapIsFullException extends RuntimeException{
    public HeapIsFullException(){
        super("The heap is full.");
    }
}
