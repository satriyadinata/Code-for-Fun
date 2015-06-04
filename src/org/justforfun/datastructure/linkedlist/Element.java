package org.justforfun.datastructure.linkedlist;

/**
 * Double-linked element implementation.
 * @author Satriya
 * @param <T>
 */
public class Element<T> {
    private Element prev;
    private Element next;
    private T object;
    
    /**
     * Construct a single element with specified value and <code>null</code> references.
     * @param value 
     */
    protected Element(T value) {
        prev = null;
        next = null;
        this.object = value;
    }
    
    /**
     * Return previous element linked with this element.
     * @return 
     */
    protected Element getPrev() {
        return prev;
    }
    
    /**
     * Set up previous element linked with this element. 
     * @param prev
     */
    protected void setPrev(Element prev) {
        this.prev = prev;
    }
    
    /**
     * Return next element linked with this element.
     * @return 
     */
    protected Element getNext() {
        return next;
    }
    
    /**
     * Set up the next element linked with this element. 
     * @param next
     */
    protected void setNext(Element next) {
        this.next = next;
    }
    
    /**
     * Returns the value or any <code>object</code> of the element.
     * @return 
     */
    public T getValue() {
        return object;
    }
    
    /**
     * Modify the value or any <code>object</code> of the element.
     * @param value
     */
    public void setValue(T value) {
        this.object = value;
    }
    
    /**
     * Delinked or deque an element completely from a particular list enabling
     * Java garbage collector to deallocate the memory spaces.
     */
    protected void delinked() {
        setPrev(null);
        setNext(null);
        object = null;
    }
}