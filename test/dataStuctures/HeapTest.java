package dataStuctures;


import exceptions.dataStructure.HeapIsFullException;
import exceptions.dataStructure.UsePollWithoutElementsException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class HeapTest {


    //setups
    public Heap setup1(){

        Heap heap=new Heap<>(3);
        return heap;
    }

    public Heap setup2(){

        Heap heap=new Heap<>(3);
        heap.add(5);
        return heap;
    }

    public Heap setupSwap(){

        Heap heap=new Heap<>(4);
        heap.add(5);
        heap.add(1);
        heap.add(2);
        heap.add(9);

        return heap;
    }



    //Test of add
    @Test
    public void addElementsToHeapTest(){

        boolean pass=false;
        //arrange
        Heap heap=setup1();


        heap.add(1);

        //Act
        if(heap.poll().equals(1)){
            pass=true;
        }

        //Assert
        assertTrue(pass);


    }


    @Test
    public void addElementsToMoreOfTheCapacityOfTheHeapTest() throws HeapIsFullException {

        boolean pass=true;
        //Arrange
        Heap heap=setup1();


        try{
            heap.add(1);
            heap.add(3);
            heap.add(8);
            heap.add(6);
        }catch (HeapIsFullException ex){
            ex.printStackTrace();
            pass=false;
        }

        assertFalse(pass);
    }


    //Test of poll

    @Test
    public void usePollTest(){

        boolean pass=false;

        //arrange
        Heap heap=setup2();

        if(heap.poll().equals(5)){
            pass=true;
        }


        assertTrue(pass);

    }


    /**
     *

     public void useIncorrectlyTheMethodPollTest() throws UsePollWithoutElementsException {

     boolean pass=true;
     //Arrange
     Heap heap=setup2();

     //Act
     try {
     heap.poll();
     heap.poll();
     }catch (UsePollWithoutElementsException ex){
     ex.printStackTrace();
     pass=false;
     }

     ///Assert
     assertFalse(pass);
     }

      */






    //Test of size

    @Test
    public void correctlySizeMethodTest(){

        boolean pass=false;
        //Arrange
        Heap heap=setup1();

        if(heap.size()==3){
            pass=true;
        }
        assertTrue(pass);
    }


    //Test swap

    @Test
    public void swapMethodTest(){

        boolean pass=false;

        //Arrange
        Heap heap=setupSwap();

        //Act
        if(heap.poll().equals(9)){
            pass=true;
        }

        //Assert
        assertTrue(pass);

    }




}
