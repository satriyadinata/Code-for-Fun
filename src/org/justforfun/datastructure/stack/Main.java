package org.justforfun.datastructure.stack;

/**
 * Test class for Stack.
 * @author Satriya
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        stack.push(5);
        stack.print();
        stack.push(9);
        stack.print();
        stack.push(6);
        stack.print();
        
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
    }
}
