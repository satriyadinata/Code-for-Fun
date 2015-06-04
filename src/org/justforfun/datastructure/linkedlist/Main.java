package org.justforfun.datastructure.linkedlist;

/**
 *
 * @author Satriya
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        
        list.add(14, 4);
        list.print();
    }
}