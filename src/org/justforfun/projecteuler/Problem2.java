package org.justforfun.projecteuler;

/**
 * Each new term in the Fibonacci sequence is generated by adding the previous 
 * two terms. By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values do not 
 * exceed four million, find the sum of the even-valued terms.
 * 
 * @author Satriya
 */
public class Problem2 {
    private static final int N = 4000000;
    
    public static void main(String[] args) {
        int fNumA = 0;
        int fNumB = 1;
        int evSum = 0;
        
        while(fNumB < N){
            if (fNumB%2 == 0) {
                evSum += fNumB; 
            }
            fNumB += fNumA;
            fNumA = fNumB - fNumA;
        }
        
        System.out.println(evSum);
    }
}