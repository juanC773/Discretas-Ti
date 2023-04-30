package dataStuctures;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    public Queue case1(){
        Queue<String> queue = new Queue<>();
        return queue;
    }
    public Queue case2(){
        Queue<String> queue = new Queue<>();
        queue.enqueue("Element");
        return queue;
    }
    //Test for empty Queue
    @Test
    public void testIsEmpty(){
        boolean flag = false;
        Queue<String> queue = case1();
        if(queue.isEmpty()){
            flag = true;
        }
        assertTrue(flag);
    }
    @Test
    public void testIsNotEmpty(){
        boolean flag = false;
        Queue<String> queue = case1();
        queue.enqueue("Element");
        if(!queue.isEmpty()){
            flag = true;
        }
        assertTrue(flag);
    }
    @Test
    public void testDequeueElement(){
        boolean flag = false;
        Queue<String> queue = case2();
        queue.dequeue();
        if(queue.isEmpty()){
            flag = true;
        }
        assertTrue(flag);
    }
    @Test
    public void testEnqueueElement(){
        boolean flag = false;
        Queue<String> queue = case2();
        queue.enqueue("Element2");
        try{
            String message1 = queue.dequeue();
            String message2 = queue.dequeue();
            if(message1.equals("Element") && message2.equals("Element2")){
                flag = true;
            }
        }catch(Exception ex){
            flag = false;
        }
        assertTrue(flag);
    }

}