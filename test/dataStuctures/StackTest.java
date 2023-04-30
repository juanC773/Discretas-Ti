package dataStuctures;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    public Stack case1(){
        Stack<String> stack = new Stack<>();
        return stack;
    }
    public Stack case2(){
        Stack<String> stack = new Stack<>();
        stack.push("Element");
        return stack;
    }
    //Test for empty stack
    @Test
    public void testIsEmpty(){
        boolean flag = false;
        Stack<String> stack = case1();
        if(stack.isEmpty()){
            flag = true;
        }
        assertTrue(flag);
    }
    @Test
    public void testIsNotEmpty(){
        boolean flag = true;
        Stack<String> stack = case1();
        stack.push("Element");
        if(stack.isEmpty()){
            flag = false;
        }
        assertTrue(flag);
    }
    @Test
    public void testPopElement(){
        boolean flag = false;
        Stack<String> stack = case2();
        stack.pop();
        if(stack.isEmpty()){
            flag = true;
        }
        assertTrue(flag);
    }
    @Test
    public void testPeekElement(){
        boolean flag = false;
        Stack<String> stack = case1();
        stack.push("Element");
        if(stack.peek().getKey().equals("Element")){
            flag = true;
        }
        assertTrue(flag);
    }

}
