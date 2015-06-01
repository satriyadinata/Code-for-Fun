/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.justforfun.projecteuler;

/**
 *
 * @author Satriya
 */
public class Problem7 {
    private static final int N = 10001;
    
    public static void main(String[] args) {
        int count = 1;
        int prime = 0;
        
        for (int i=3; count<N; i++) {
            if (isPrime(i)) {
                prime = i;
                count++;
            }
        }
        
        System.out.println(prime);
    }
    
    private static boolean isPrime(long n) {
        if (n%2 == 0) 
            return false;

        for(int i=3; i*i<=n; i+=2) {
            if(n%i == 0)
                return false;
        }
        return true;
    }
}
