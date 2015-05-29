package org.justforfun.projecteuler;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, 
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * @author Satriya
 */
public class Problem1 {
    private static final int N = 1000;
    private static final int NUM_3 = 3;
    private static final int NUM_5 = 5;
    
    public static void main(String[] args) {    
        int sum = 0;
        
        int multiples_3 = 0;
        while (multiples_3 < N - NUM_3) {
            multiples_3 += NUM_3;
            if (multiples_3%5 != 0) {
                sum += multiples_3;
            }
        }
        
        int multiples_5 = 0;
        while (multiples_5 < N - NUM_5) {
            multiples_5 += NUM_5;
            sum += multiples_5;            
        }
        
        System.out.println(sum);
    }
}
