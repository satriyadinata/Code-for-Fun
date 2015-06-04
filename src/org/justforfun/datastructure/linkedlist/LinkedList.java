package org.justforfun.datastructure.linkedlist;

/**
 * Doubly-linked list implementation of the List and Deque concepts.
 * @author Satriya
 * @param <T>
 */
public class LinkedList<T> {
    private Element first;
    private Element last;
    private int size;
    
    /**
     * Construct an empty list.
     */
    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }
    
    /**
     * Appends the specified element to the end of this list.
     * 
     * @param object
     */
    public void add(T object) {
        Element element = new Element(object);
        
        if (this.isEmpty()) {
            first = last = element;
        } else {
            element.setPrev(last);
            last.setNext(element);
            last = element;
        }
        
        size++;
    }
    
    /**
     * Inserts the specified element at the specified position in this list.
     * @param object
     * @param index 
     */
    public void add(T object, int index) {
        Element element = new Element(object);
        
        if (index > size-1 || index < 0) {
            System.err.println("Index out of bound!!");
        } else {
            if (this.isEmpty() && index == 0) {
                first = last = element;
            } else {
                Element head = first;
                head = this.getElement(index);
                
                if (this.isFirst(head)) {
                    first = element;
                    element.setNext(head);
                    head.setPrev(element);
                } else {
                    element.setPrev(head.getPrev());
                    head.getPrev().setNext(element);
                    element.setNext(head);
                    head.setPrev(element);
                }                
            }
            
            size++;
        }
    }
    
    /**
     * Retrieves and removes the head (first element) of this list.
     */
    public void remove() {
        if (this.isEmpty()) {
            System.err.println("Index out of bound!!");
        } else {
            Element head = last;
            head.getPrev().setNext(null);
            last = last.getPrev();
            head.delinked();
            
            size--;
        }
    }
    
    /**
     * Removes the element at the specified position in this list.
     * @param index 
     */
    public void remove(int index) {
        if (this.isEmpty() || index > size-1 || index < 0) {
            System.err.println("Index out of bound!!");
        } else {
            Element head = this.getElement(index);
            
            if (this.isFirst(head)) {
                first = head.getNext();
            } else {
                head.getPrev().setNext(head.getNext());
            }
            
            if (this.isLast(head)) {
                last = head.getPrev();
            } else {
                head.getNext().setPrev(head.getPrev());
            }
            
            head.delinked();
            size--;
        }
    }
    
    /**
     * Return <code>true</code> if the list is empty, otherwise it returns <code>false</code>.
     * @return 
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns the element at the specified position in this list.
     * @param index
     * @return 
     */
    private Element getElement(int index) {
        Element head = first;
        for (int i = 0; i < index; i++) {
            head = head.getNext();
        }
        
        return head;
    }
    
    /**
     * Returns the value or any <code>object</code> at the specified position in this list.
     * @param index
     * @return 
     */
    public T getValue(int index) {
        Element head = first;
        for (int i = 0; i < index; i++) {
            head = head.getNext();
        }
        
        return (T) head.getValue();
    }
    
    /**
     * Modify the value or any <code>object</code> at the specified position in this list.
     * @param index
     * @return 
     */
    public T setValue(int index) {
        Element head = first;
        for (int i = 0; i < index; i++) {
            head = head.getNext();
        }
        
        return (T) head.getValue();
    }
    
    /**
     * Return <code>true</code> if specified element is the first element in the list, 
     * otherwise it returns <code>false</code>.
     * @param element
     * @return 
     */
    private boolean isFirst(Element element) {
        return element == first;
    }
    
    /**
     * Return <code>true</code> if specified element is the last element in the list, 
     * otherwise it returns <code>false</code>.
     * @param element
     * @return 
     */
    private boolean isLast(Element element) {
        return element == last;
    }
    
    /**
     * Print out the entire list elements.
     */
    public void print() {
        Element head = first;
        for (int i = 0; i < size; i++) {
            System.out.println(head.getValue());
            head = head.getNext();
        }
    }
}