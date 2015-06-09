package org.justforfun.datastructure.stack;

/**
 * Stack implementation using single linked list.
 * @author Satriya
 * @param <T>
 */
public class Stack<T> {
    private Node first;
    
    public Stack() {
        first = null;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void push(T item) {
        Node node = first;
        first = new Node(item);
        first.next = node;
    }
    
    public T pop() {
        if (isEmpty()) {
            System.err.println("Stack is empty. Nothing to pop!");
            return null;
        } else {
            T item = (T) first.item;
            first = first.next;
            return item;
        }
    }
    
    public void print() {
        if (isEmpty()) {
            System.err.println("Stack is empty. Nothing to print!");
        } else {
            Node node = first;
            StringBuilder out = new StringBuilder();
            while (node != null) {
                out.append(node.item);
                out.append(" ");
                node = node.next;
            }
            System.out.println("Stack: " + out);
        }
    }
    
    private class Node<T> {
        protected T item;
        protected Node next;
        
        /**
         * Construct a single element with specified value and null references.
         * @param item 
         */
        protected Node(T item) {
            this.item = item;
            next = null;
        }
    }
}