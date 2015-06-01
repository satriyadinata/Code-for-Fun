package org.justforfun.projecteuler;

import java.util.ArrayList;
import java.util.List;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 
 * 1 to 10 without any remainder. What is the smallest positive number that is 
 * evenly divisible by all of the numbers from 1 to 20?
 * 
 * @author Satriya
 */
public class Problem5 {
    private static final int PRIME_LIMIT = 20;
    
    public static void main(String[] args) {
        boolean search = true;
        int num = 1;
        
        while (search) {
            search = false;
            for (int i = PRIME_LIMIT; i > 1; i--) {
                if (num%i != 0) {
                    search = true;
                    num++;
                    break;
                }
            }
        }
        
        System.out.println(num);
    }
}